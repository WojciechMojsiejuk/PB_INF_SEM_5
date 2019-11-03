//
//  main.m
//  PBWI
//
//  Created by Paweł Bąk on 28/10/2019.
//  Copyright © 2019 Paweł Bąk. All rights reserved.
//

#import <objc/objc.h>
#import <objc/Object.h>
#import <Foundation/Foundation.h>
#import "PBWIZasob.h"
#import "PBWIBiurko.h"
#import "PBWIKrzeslo.h"
#import "PBWIPokoj.h"
#import "PBWIKomputer.h"
#import "PBWIZasobyWydzialu.h"


int main()
{
    @autoreleasepool {
        PBWIZasob * zasob = [[PBWIZasob alloc] init];
        [zasob setKolor: @"szary"];
        NSLog(@"Przykladowy zasob: %@", [zasob pobierzOpisZasobu]);
        PBWIBiurko * biurko = [[PBWIBiurko alloc] initWithParams:100 :80 :140];
        [biurko setKolor: @"brazowy"];
        NSLog(@"Przykladowe biurko: %@", [biurko opisZasobu]);
        PBWIKrzeslo * krzeslo = [[PBWIKrzeslo alloc] init];
        [krzeslo setObicie: @"skora"];
        [krzeslo setKolor: @"czarny"];
        NSLog(@"Przykladowe krzeslo: %@", [krzeslo opisZasobu]);
        PBWIKomputer * komputer = [[PBWIKomputer alloc] init];

        PBWIPokoj *pokoj= [[PBWIPokoj alloc] init];
        [pokoj dodajZasob: biurko];
        [pokoj dodajZasob: krzeslo];
        [pokoj usunZasob: biurko];
        
        PBWIPokoj *pokoj1= [[PBWIPokoj alloc] init];
        
        PBWIZasobyWydzialu *resources = [[PBWIZasobyWydzialu alloc] init];
        [resources addRoom:@"211" :pokoj];
        [resources addRoom:@"101" :pokoj1];
        for (PBWIKrzeslo * chair in [resources returnChairs]) {
            NSLog([chair opisZasobu]);
        }
        NSLog([[resources returnRoomNumbers] description]);
        [resources addToRoom:@"101" :komputer];
    }
    return 0;
}
