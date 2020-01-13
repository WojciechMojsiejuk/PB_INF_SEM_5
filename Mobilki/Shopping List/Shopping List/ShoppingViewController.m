//
//  ShoppingViewController.m
//  Shopping List
//
//  Created by Paweł Bąk on 10/01/2020.
//  Copyright © 2020 Paweł Bąk. All rights reserved.
//

#import "ShoppingViewController.h"

@interface ShoppingViewController ()

@property (strong) NSMutableArray *lists;
@property (nonatomic) NSManagedObjectContext *context;
@property (nonatomic, weak) AppDelegate *delegate;

@end

@implementation ShoppingViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    [self managedObjectContext];
    // Uncomment the following line to preserve selection between presentations.
    // self.clearsSelectionOnViewWillAppear = NO;
    
    // Uncomment the following line to display an Edit button in the navigation bar for this view controller.
    // self.navigationItem.rightBarButtonItem = self.editButtonItem;
}

- (void)viewDidAppear:(BOOL)animated {
    [super viewDidAppear:animated];
    [self updateData];
}

- (void)managedObjectContext {
    self.context = nil;
    self.delegate = (AppDelegate *)[[UIApplication sharedApplication] delegate];
    if ([self.delegate respondsToSelector: @selector(persistentContainer)]) {
        self.context = self.delegate.persistentContainer.viewContext;
    }
}

- (void)updateData {
    NSLog(@"Przeladowanie");
    NSFetchRequest *fetchRequest = [[NSFetchRequest alloc] initWithEntityName:@"ShoppingList"];
    self.lists = [[self.context executeFetchRequest:fetchRequest error:nil] mutableCopy];
    [self.tableView reloadData];
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.lists.count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    static NSString *CellIdentifier = @"Cell";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:CellIdentifier forIndexPath:indexPath];
//    Ustawienie komórki
    NSManagedObject *list = [self.lists objectAtIndex:indexPath.row];
    [cell.textLabel setText:[NSString stringWithFormat:@"%@ %@", [list valueForKey:@"product"], [list valueForKey:@"number"]]];
    [cell.detailTextLabel setText:[list valueForKey:@"type"]];
    return cell;
}

- (void) tableView: (UITableView *) tableView didSelectRowAtIndexPath: (NSIndexPath *) indexPath {
    NSManagedObject *deleted = [self.lists objectAtIndex:indexPath.row];
    [self.context deleteObject:deleted];
    NSError *error = nil;
    if (![self.context save:&error]) {
        NSLog(@"Can't Delete! %@ %@", error, [error localizedDescription]);
    }
    [self updateData];
}


/*
// Override to support conditional editing of the table view.
- (BOOL)tableView:(UITableView *)tableView canEditRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the specified item to be editable.
    return YES;
}
*/

/*
// Override to support editing the table view.
- (void)tableView:(UITableView *)tableView commitEditingStyle:(UITableViewCellEditingStyle)editingStyle forRowAtIndexPath:(NSIndexPath *)indexPath {
    if (editingStyle == UITableViewCellEditingStyleDelete) {
        // Delete the row from the data source
        [tableView deleteRowsAtIndexPaths:@[indexPath] withRowAnimation:UITableViewRowAnimationFade];
    } else if (editingStyle == UITableViewCellEditingStyleInsert) {
        // Create a new instance of the appropriate class, insert it into the array, and add a new row to the table view
    }   
}
*/

/*
// Override to support rearranging the table view.
- (void)tableView:(UITableView *)tableView moveRowAtIndexPath:(NSIndexPath *)fromIndexPath toIndexPath:(NSIndexPath *)toIndexPath {
}
*/

/*
// Override to support conditional rearranging of the table view.
- (BOOL)tableView:(UITableView *)tableView canMoveRowAtIndexPath:(NSIndexPath *)indexPath {
    // Return NO if you do not want the item to be re-orderable.
    return YES;
}
*/

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/

@end
