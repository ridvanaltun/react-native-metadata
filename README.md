# react-native-metadata

[![npm version](https://img.shields.io/npm/v/react-native-metadata.svg)](https://npmjs.com/package/react-native-metadata)
[![npm downloads](https://img.shields.io/npm/dt/react-native-metadata.svg)](https://npmjs.com/package/react-native-metadata)
[![CircleCI](https://circleci.com/gh/ridvanaltun/react-native-metadata/tree/master.svg?style=shield)](https://circleci.com/gh/ridvanaltun/react-native-metadata/tree/master)
[![license](https://img.shields.io/npm/l/react-native-metadata.svg)](https://github.com/ridvanaltun/react-native-metadata/blob/master/LICENSE)

> Ability to retrieve app metadata.

## Installation

```sh
npm install react-native-metadata

# install pods for ios
npx pod-install ios
```

Autolinking takes care of the rest.

## Usage

```js
import Metadata from 'react-native-metadata';

// ...

const {
  signingSignature,
  version,
  shortVersion,
  packageName,
  bundleIdentifier,
  bundleName,
} = Metadata;
```

## Example

| Android                                                   |                        iOS                        |
| --------------------------------------------------------- | :-----------------------------------------------: |
| <img src="./docs/android.png" alt="Android" width="250"/> | <img src="./docs/ios.png" alt="iOS" width="250"/> |

## Contributing

See the [contributing guide](CONTRIBUTING.md) to learn how to contribute to the repository and the development workflow.

## License

MIT
