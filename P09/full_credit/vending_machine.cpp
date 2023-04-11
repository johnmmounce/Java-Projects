#include <iostream>
#include <string>
#include <vector>
#include <iomanip>
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
        std::cout << "#### Buying " << items[index].to_string() << std::endl;
        return 0;
    }
    std::string Vending_Machine::menu()
    {
        std::string menu = "     MENU     \n";
        for (int i = 0; i < items.size(); i++)
        {
            menu += items[i].to_string();
        }
        std::cout << std::fixed << std::setprecision(2) <<  menu << std::endl;
        return menu;
    }