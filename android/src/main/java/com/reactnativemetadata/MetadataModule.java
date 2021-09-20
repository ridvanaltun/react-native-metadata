package com.reactnativemetadata;

import androidx.annotation.NonNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import com.google.common.io.BaseEncoding;

import android.content.pm.PackageManager;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = MetadataModule.NAME)
public class MetadataModule extends ReactContextBaseJavaModule {
  public static final String NAME = "Metadata";

  private final ReactApplicationContext reactContext;
  private String packageName = null;
  private String version = null;
  private String versionCode = null;
  private String signingSignature = null;

  public MetadataModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
    try {
      PackageManager pm = reactContext.getPackageManager();
      packageName = reactContext.getPackageName();
      int TURN_OFF_FLAGS = 0; // @see https://stackoverflow.com/a/14636404/7376041
      PackageInfo packageInfo = pm.getPackageInfo(packageName, TURN_OFF_FLAGS);
      version = packageInfo.versionName;
      versionCode = String.valueOf(packageInfo.versionCode);
      // signing signature
      signingSignature = getSignature(pm, packageName);
    } catch (PackageManager.NameNotFoundException e) {
      // ---
    }
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  /**
   * Gets the SHA1 signature, hex encoded for inclusion with Google Cloud Platform API requests
   *
   * @param packageName Identifies the APK whose signature should be extracted.
   * @return a lowercase, hex-encoded
   */
  private static String getSignature(@NonNull PackageManager pm, @NonNull String packageName) {
    try {
      PackageInfo packageInfo = pm.getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
      if (packageInfo == null
        || packageInfo.signatures == null
        || packageInfo.signatures.length == 0
        || packageInfo.signatures[0] == null) {
        return null;
      }
      return signatureDigest(packageInfo.signatures[0]);
    } catch (PackageManager.NameNotFoundException e) {
      return null;
    }
  }

  private static String signatureDigest(Signature sig) {
    byte[] signature = sig.toByteArray();
    try {
      MessageDigest md = MessageDigest.getInstance("SHA1");
      byte[] digest = md.digest(signature);
      return BaseEncoding.base16().lowerCase().encode(digest);
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();
    constants.put("version", versionCode);
    constants.put("shortVersion", version);
    constants.put("packageName", packageName);
    constants.put("signingSignature", signingSignature);
    return constants;
  }
}
