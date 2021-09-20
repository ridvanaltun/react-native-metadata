import { NativeModules } from 'react-native';

type MetadataType = {
  signingSignature: undefined | string;
  shortVersion: string;
  version: string;
  packageName: undefined | string;
  bundleIdentifier: undefined | string;
  bundleName: undefined | string;
};

const { Metadata } = NativeModules;

export default Metadata as MetadataType;
