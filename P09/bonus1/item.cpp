#include <iostream>
#include <exception>
#include <string.h>
#include "item.h"

    Item::Item()
    : name(""), price(0)
    {
    }
    Item::Item(std::string name, int price)
        : name(name), price(price)
    {
        float price_double = static_cast<float>(price);
        price_double = price_double * .01;
        if (price < 0)
        {
            throw std::runtime_error("invlaid price");
        }
    }
    
    