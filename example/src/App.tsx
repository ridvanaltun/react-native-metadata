import React from 'react';

import { StyleSheet, View, Text, Platform } from 'react-native';
import Metadata from 'react-native-metadata';

export default function App() {
  const isIOS = Platform.OS === 'ios';

  const {
    signingSignature,
    version,
    shortVersion,
    packageName,
    bundleIdentifier,
    bundleName,
  } = Metadata;

  return (
    <View style={styles.container}>
      <View>
        <Text style={styles.title}>Signing Signature:</Text>
        <Text>{isIOS ? '-' : signingSignature}</Text>

        <Text style={styles.title}>Version:</Text>
        <Text>{shortVersion}</Text>

        <Text style={styles.title}>Version Code:</Text>
        <Text>{version}</Text>

        <Text style={styles.title}>Package Name:</Text>
        <Text>{isIOS ? '-' : packageName}</Text>

        <Text style={styles.title}>Bundle Identifier:</Text>
        <Text>{isIOS ? bundleIdentifier : '-'}</Text>

        <Text style={styles.title}>Bundle Name:</Text>
        <Text>{isIOS ? bundleName : '-'}</Text>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
  title: {
    fontWeight: 'bold',
    marginTop: 20,
    marginBottom: 5,
  },
});
