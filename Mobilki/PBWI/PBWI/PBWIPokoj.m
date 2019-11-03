//
//  PBWIPokoj.m
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import "PBWIPokoj.h"
#import "PBWIZasob.h"

@implementation PBWIPokoj

-(id) init {
    self = [super init];
    if (self) {
        _zasoby=[[NSMutableArray alloc] init];
    }
    return self;
}
-(void) dodajZasob: (PBWIZasob *) zasob {
    [_zasoby addObject:zasob];
}
-(void) usunZasob: (PBWIZasob *) zasob {
    [_zasoby removeObject:zasob];
}
-(NSArray *) pobierzWszystkieZasoby {
    return [_zasoby copy];
}

@end
