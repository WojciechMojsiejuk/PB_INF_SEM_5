//
//  DetailShoppingViewController.h
//  Shopping List
//
//  Created by Paweł Bąk on 10/01/2020.
//  Copyright © 2020 Paweł Bąk. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>
#import "ShoppingViewController.h"

NS_ASSUME_NONNULL_BEGIN

@interface DetailShoppingViewController : UIViewController

@property (weak, nonatomic) IBOutlet UITextField *productTextField;
@property (weak, nonatomic) IBOutlet UITextField *numberTextField;
@property (weak, nonatomic) IBOutlet UITextField *typeTextField;
- (IBAction)cancel:(id)sender;
- (IBAction)save:(id)sender;

@end

NS_ASSUME_NONNULL_END
