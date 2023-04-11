#ifndef __VENDING_MACHINE_H
#define __VENDING_MACHINE_H

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include "item.h"

class Vending_Machine
{
public:
   
    int vending_machine(std::istream& is){
        while(!is.eof()){
            std::string productName;
            int price;
            is >> productName >> price;
            Item newItem = Item(productName, price);
            items.push_back(newItem);
        }
        return 0;
    };

    int add(std::string name, int price);
    int buy(int index);
    friend std::ostream& operator << (std::ostream& os, const Vending_Machine& vending_machine){
        std::cout << "====================\n";
        std::cout << "        MENU        \n";
        std::cout << "====================\n";\
        for (int i = 0; i < vending_machine.items.size(); i++)
        {
            os << vending_machine.items[i] << std::endl;
        }
        std::cout << std::endl;
        
        return os;
    }

private:
    std::vector<Item> items;
};

#endif