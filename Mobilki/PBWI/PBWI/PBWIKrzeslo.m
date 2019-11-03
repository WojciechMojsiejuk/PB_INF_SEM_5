//
//  PBWIKrzeslo.m
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import "PBWIKrzeslo.h"
#import "PBWIZasob.h"

@implementation PBWIKrzeslo

@synthesize obicie = _obicie;

-(NSString *) opisZasobu{
    return [NSString stringWithFormat:@"Krzeslo obite %@ o kolorze: %@", _obicie, self.kolor];
}

@end
