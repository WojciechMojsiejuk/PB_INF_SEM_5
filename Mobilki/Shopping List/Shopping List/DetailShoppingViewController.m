//
//  DetailShoppingViewController.m
//  Shopping List
//
//  Created by Paweł Bąk on 10/01/2020.
//  Copyright © 2020 Paweł Bąk. All rights reserved.
//

#import "DetailShoppingViewController.h"

@interface DetailShoppingViewController ()

@property (nonatomic) NSManagedObjectContext *context;
@property (nonatomic, weak) AppDelegate *delegate;

@end

@implementation DetailShoppingViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    [self managedObjectContext];
    // Do any additional setup after loading the view.
}

- (IBAction)cancel:(id)sender {
    [self dismissViewControllerAnimated:YES completion:nil];
}
- (IBAction)save:(id)sender {
    //Utworzenie nowego obiektu
    NSManagedObject *newList = [NSEntityDescription insertNewObjectForEntityForName:@"ShoppingList" inManagedObjectContext:self.context];
    [newList setValue:self.productTextField.text forKey:@"product"];
    [newList setValue:self.numberTextField.text forKey:@"number"];
    [newList setValue:self.typeTextField.text forKey:@"type"];
    NSError *error = nil;
    // Zapisanie obiektu
    if (![self.context save:&error]) {
        NSLog(@"Can't Save! %@ %@", error, [error localizedDescription]);
    }
    [self dismissViewControllerAnimated:YES completion:nil];
}

- (void)managedObjectContext {
    self.context = nil;
    self.delegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
    if ([self.delegate respondsToSelector: @selector(persistentContainer)]) {
        self.context = self.delegate.persistentContainer.viewContext;
    }
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
