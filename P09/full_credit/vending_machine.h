#ifndef __VENDING_MACHINE_H
#define __VENDING_MACHINE_H

#include <iostream>
#include <string>
#include <vector>
#include "item.h"

class Vending_Machine
{
public:
    std::vector<Item> items;

    int add(std::string name, int price);
    int buy(int index);
    std::string menu();
};

#endif