//
//  PBWIBiurko.h
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import "PBWIBiurko.h"
#import "PBWIZasob.h"

@interface PBWIBiurko : PBWIZasob {
}
@property(readonly) int wysokosc;
@property(readonly) int szerokosc;
@property(readonly) int dlugosc;

-(id) initWithParams: (int)wys :(int)szer :(int)dl;
-(NSString *) opisZasobu;


@end
