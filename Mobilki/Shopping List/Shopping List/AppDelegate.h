//
//  AppDelegate.h
//  Shopping List
//
//  Created by Paweł Bąk on 10/01/2020.
//  Copyright © 2020 Paweł Bąk. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <CoreData/CoreData.h>

@interface AppDelegate : UIResponder <UIApplicationDelegate>

@property (readonly, strong) NSPersistentContainer *persistentContainer;

- (void)saveContext;


@end

