//
//  PBWIPokoj.h
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import "PBWIPokoj.h"
#import "PBWIZasob.h"

@interface PBWIPokoj : NSObject {
   @private NSMutableArray * _zasoby;
}

-(id) init;
-(void) dodajZasob: (PBWIZasob *) zasob;
-(void) usunZasob: (PBWIZasob *) zasob;
-(NSArray *) pobierzWszystkieZasoby;
@end
