#ifndef __VENDING_MACHINE_H
#define __VENDING_MACHINE_H

#include <iostream>
#include <string>
#include <vector>
#include "item.h"

class Vending_Machine
{
public:

    int add(std::string name, int price);
    int buy(int index);
    std::string menu();

private:
    std::vector<Item> items;
};

#endif