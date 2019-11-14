//
//  SecondViewController.h
//  FirstIosApp
//
//  Created by Paweł Bąk on 04/11/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN
@class SecondViewController;
@protocol SecondViewControllerDelegate <NSObject>

-(void) addItemViewController:(SecondViewController *)controller didFinishEnteringItem:(NSString *)item;

@end

@interface SecondViewController : UIViewController

@property (nonatomic, weak) IBOutlet UITextField * modifiedSurnameTextField;
@property (nonatomic, weak) id <SecondViewControllerDelegate> delegate;
@property (nonatomic, weak) IBOutlet UIButton * button;

@property NSString * surname;

-(IBAction) goBack;

@end

NS_ASSUME_NONNULL_END
