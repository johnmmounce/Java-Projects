#ifndef __ITEM_H
#define __ITEM_H
#include <iostream>
#include <exception>

class Item
{
public:
    Item();
    Item(std::string name, int price);

    friend std::ostream& operator << (std::ostream& os, const Item& item){
         os << item.name << " ($" << item.price << ")";
        return os;
    }
    friend std::istream& operator >> (std::istream& is, Item& item){
        int price;
        std::string name;
        std::string price_string;

        std::getline(is, name);
        std::getline(is, price_string);
        
        price = std::stoi(price_string);
        item.name = name;
        item.price = price;

        return is;
    }
    
private:
    std::string name;
    int price;
};

#endif