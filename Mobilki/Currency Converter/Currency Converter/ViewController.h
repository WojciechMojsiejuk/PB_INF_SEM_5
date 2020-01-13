//
//  ViewController.h
//  Currency Converter
//
//  Created by Paweł Bąk on 10/01/2020.
//  Copyright © 2020 Paweł Bąk. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController <UIPickerViewDataSource, UIPickerViewDelegate>

@property (weak, nonatomic) IBOutlet UITextField *sourceCurrency;
@property (weak, nonatomic) IBOutlet UITextField *targetCurrency;
@property (weak, nonatomic) IBOutlet UITextField *value;
@property (weak, nonatomic) IBOutlet UITextField *result;

- (IBAction)calculate:(id)sender;

@end

