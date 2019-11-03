//
//  PBWIZasob.m
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import "PBWIZasob.h"

@implementation PBWIZasob

@synthesize kolor = _kolor;

-(NSString *) pobierzOpisZasobu {
    return [NSString stringWithFormat:@"Jakis zasob o kolorze: %@", _kolor];
}

@end
