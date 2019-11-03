//
//  PBWIZasobyWydzialu.m
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import "PBWIZasobyWydzialu.h"
#import "PBWIPokoj.h"
#import "PBWIZasob.h"
#import "PBWIBiurko.h"
#import "PBWIKrzeslo.h"
#import "PBWIKomputer.h"

@implementation PBWIZasobyWydzialu{
    NSMutableDictionary *_rooms;
    NSMutableArray *_resources;
}

-(id) init {
    self = [super init];
    if (self) {
        _rooms=[[NSMutableDictionary alloc] init];
        _resources=[[NSMutableArray alloc] init];
    }
    return self;
}
-(void) addRoom: (NSString *) number :(PBWIPokoj *) room {
    [_resources addObjectsFromArray:[room pobierzWszystkieZasoby]];
//    [_rooms setObject:room forKey:number]; // zamiennie z poniższym
    _rooms[number] = room;
}
-(void) addToRoom: (NSString *) roomNumber :(PBWIZasob *) resource {
    [_resources addObject:resource];
    [[_rooms objectForKey:roomNumber] dodajZasob:resource];
}
-(void) moveToRoom: (NSString *) fromRoom :(NSString *) toRoom :(PBWIZasob *) resource {
    [[_rooms objectForKey:fromRoom] usunZasob:resource];
    [[_rooms objectForKey:toRoom] dodajZasob:resource];
}
-(void) removeFromRoom: (NSString *) roomNumber :(PBWIZasob *) resource {
    [[_rooms objectForKey:roomNumber] usunZasob:resource];
    [_resources removeObject:resource];
}
-(NSArray *) returnRoomNumbers {
    return [_rooms allKeys];
}
-(NSArray *) returnDesks {
    NSIndexSet *idxSetOfStrings = [_resources indexesOfObjectsPassingTest:^BOOL(id obj, NSUInteger idx, BOOL *stop) {
        return [obj isKindOfClass:[PBWIBiurko class]];
    }];
    return [_resources objectsAtIndexes:idxSetOfStrings];
}
-(NSArray *) returnChairs {
    NSIndexSet *idxSetOfStrings = [_resources indexesOfObjectsPassingTest:^BOOL(id obj, NSUInteger idx, BOOL *stop) {
        return [obj isKindOfClass:[PBWIKrzeslo class]];
    }];
    return [_resources objectsAtIndexes:idxSetOfStrings];
}
-(NSArray *) returnComputers {
    NSIndexSet *idxSetOfStrings = [_resources indexesOfObjectsPassingTest:^BOOL(id obj, NSUInteger idx, BOOL *stop) {
        return [obj isKindOfClass:[PBWIKomputer class]];
    }];
    return [_resources objectsAtIndexes:idxSetOfStrings];
}

@end
