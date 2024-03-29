#include <iostream>
#include <exception>
#include <string.h>
#include <iomanip>
#include "item.h"


    Item::Item(std::string name, int price)
        : name(name), price(price)
    {
        
        if (price < 0)
        {
            throw std::runtime_error("invlaid price");
        }
    }

    std::string Item::to_string(){
        return name + " ($" + std::to_string(price * .01) + ")\n";
    }