//
//  PBWIBiurko.m
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import "PBWIBiurko.h"

@implementation PBWIBiurko

@synthesize wysokosc = _wysokosc;
@synthesize szerokosc = _szerokosc;
@synthesize dlugosc = _dlugosc;

-(id) initWithParams: (int)wys :(int)szer :(int)dl {
    self = [super init];
    if (self) {
        _wysokosc = wys;
        _szerokosc = szer;
        _dlugosc = dl;
    }
    return self;
}
-(NSString *) opisZasobu {
    return [NSString stringWithFormat:@"Biurko o kolorze: %@", self.kolor];
}

@end
