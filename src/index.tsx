import { NativeModules } from 'react-native';

type MetadataType = {
  multiply(a: number, b: number): Promise<number>;
};

const { Metadata } = NativeModules;

export default Metadata as MetadataType;
