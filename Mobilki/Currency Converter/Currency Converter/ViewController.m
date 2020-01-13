//
//  ViewController.m
//  Currency Converter
//
//  Created by Paweł Bąk on 10/01/2020.
//  Copyright © 2020 Paweł Bąk. All rights reserved.
//

#import "ViewController.h"

@interface ViewController ()
{
    NSArray *currencies;
}

@property (strong) UIPickerView *picker1;
@property (strong) UIPickerView *picker2;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    currencies = @[@"PLN", @"EUR", @"USD", @"NOK", @"MXN", @"IDR", @"GBP"];
    self.picker1 = [[UIPickerView alloc] init];
    self.picker1.dataSource = self;
    self.picker1.delegate = self;
    self.sourceCurrency.inputView = self.picker1;
    self.picker2 = [[UIPickerView alloc] init];
    self.picker2.dataSource = self;
    self.picker2.delegate = self;
    self.targetCurrency.inputView = self.picker2;
    // Do any additional setup after loading the view.
}

- (IBAction)calculate:(id)sender {
    NSString *fromCurrency=self.sourceCurrency.text;
    NSString *toCurrency=self.targetCurrency.text;
    NSString *stringUrl = [NSString stringWithFormat:@"https://api.exchangeratesapi.io/latest?base=%@&symbols=%@",fromCurrency, toCurrency];
    NSURL *url = [NSURL URLWithString:stringUrl];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    [NSURLConnection sendAsynchronousRequest:request queue:[NSOperationQueue mainQueue] completionHandler:^(NSURLResponse *response, NSData *data, NSError *connectionError) {
        if (data.length > 0 && connectionError == nil) {
            NSDictionary *dicYourResponse = [NSJSONSerialization JSONObjectWithData:data options:0 error:NULL];
            float one = [[[dicYourResponse objectForKey:@"rates"] objectForKey:self.targetCurrency.text] floatValue];
            float two = [self.value.text floatValue];
            float three = one * two;
            self.result.text = [NSString stringWithFormat:@"%f", three];
        }
    }];
}

- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView {
    return 1;
}

- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component {
    return currencies.count;
}

// delegate methods

- (NSString *)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component{
    return currencies[row];
}

- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component{
    if ([pickerView isEqual:_picker1])
        self.sourceCurrency.text = currencies[row];
    if ([pickerView isEqual:_picker2])
        self.targetCurrency.text = currencies[row];
}


@end
