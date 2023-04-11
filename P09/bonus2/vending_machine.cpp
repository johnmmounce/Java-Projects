#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include "item.h"
#include "vending_machine.h"

    int Vending_Machine::add(std::string name, int price)
    {
        Item newItem = Item(name, price);
        items.push_back(newItem);
        return 0;
    }
    int Vending_Machine::buy(int index)
    {
        std::cout << "#### Buying " << items[index] << std::endl;
        return 0;
    }
    