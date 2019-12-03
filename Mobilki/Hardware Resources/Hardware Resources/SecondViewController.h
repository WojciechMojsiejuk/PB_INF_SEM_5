//
//  SecondViewController.h
//  Hardware Resources
//
//  Created by Paweł Bąk on 03/12/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreLocation/CoreLocation.h>

NS_ASSUME_NONNULL_BEGIN

@interface SecondViewController : UIViewController <CLLocationManagerDelegate>
{
    CLLocationManager *locationManager;
    CLGeocoder *geocoder;
    CLPlacemark *placemark;
}

@property (nonatomic, weak) IBOutlet UILabel *latitudeLabel;
@property (nonatomic, weak) IBOutlet UILabel *longtitudeLabel;
@property (nonatomic, weak) IBOutlet UILabel *adressLabel;

@property (nonatomic, weak) IBOutlet UILabel *latitudeText;
@property (nonatomic, weak) IBOutlet UILabel *longtitudeText;
@property (nonatomic, weak) IBOutlet UILabel *adressText;
@property (nonatomic, weak) IBOutlet UIButton *currentLocationButton;

- (IBAction)getCurrentLocation:(id)sender;

@end

NS_ASSUME_NONNULL_END
