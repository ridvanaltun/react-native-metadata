#import "Metadata.h"

@implementation Metadata

RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport {
    NSString *iosVersion = [[UIDevice currentDevice] systemVersion];
    NSString *infoDeviceName = [[UIDevice currentDevice] name];

    return @{
        @"version": [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleVersion"],
        @"shortVersion": [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleShortVersionString"],
        @"bundleIdentifier": [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleIdentifier"],
        @"bundleName": [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleName"],
    };
}

@end
