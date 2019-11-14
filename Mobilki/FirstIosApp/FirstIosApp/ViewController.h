//
//  ViewController.h
//  FirstIosApp
//
//  Created by Paweł Bąk on 04/11/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "SecondViewController.h"

@interface ViewController : UIViewController <SecondViewControllerDelegate>

@property (nonatomic, weak) IBOutlet UILabel *messageLabel;
@property (nonatomic, weak) IBOutlet UITextField *inputField;
@property (nonatomic, weak) IBOutlet UITextField *surnameField;

-(IBAction) enter;
-(void) prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender;

@end

