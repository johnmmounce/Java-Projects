#include <iostream>
#include <exception>
#include <string.h>
#include "item.h"


    Item::Item(std::string name, int price)
        : name(name), price(price)
    {
        float price_double = static_cast<float>(price);
        price_double = price_double * .1;
        if (price < 0)
        {
            throw std::runtime_error("invlaid price");
        }
    }

    std::string Item::to_string(){
        return name + " ($" + std::to_string(price) + ")\n";
    }