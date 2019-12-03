//
//  ViewController.h
//  Hardware Resources
//
//  Created by Paweł Bąk on 02/12/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController

@property (nonatomic, weak) IBOutlet UILabel *gestureLabel;

- (IBAction)tapGesture:(UITapGestureRecognizer *)sender;
- (IBAction)pinchGesture:(UIPinchGestureRecognizer *)sender;
- (IBAction)swipeGesture:(UISwipeGestureRecognizer *)sender;
- (IBAction)longPressGesture:(UILongPressGestureRecognizer *)sender;

- (void)viewDidLoad;
- (void)motionEnded:(UIEventSubtype)motion withEvent:(UIEvent *)event;
- (BOOL)canBecomeFirstResponder;

@end

