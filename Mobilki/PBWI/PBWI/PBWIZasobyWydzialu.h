//
//  PBWIZasobyWydzialu.h
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "PBWIPokoj.h"
#import "PBWIZasob.h"
#import "PBWIBiurko.h"
#import "PBWIKrzeslo.h"

NS_ASSUME_NONNULL_BEGIN

@interface PBWIZasobyWydzialu : NSObject

-(id) init;
-(void) addRoom: (NSString *) number :(PBWIPokoj *) room;
-(void) addToRoom: (NSString *) roomNumber :(PBWIZasob *) resource;
-(void) moveToRoom: (NSString *) fromRoom :(NSString *) toRoom :(PBWIZasob *) resource;
-(void) removeFromRoom: (NSString *) roomNumber :(PBWIZasob *) resource;
-(NSArray*) returnRoomNumbers;
-(NSArray*) returnDesks;
-(NSArray*) returnComputers;
-(NSArray*) returnChairs;

@end

NS_ASSUME_NONNULL_END
