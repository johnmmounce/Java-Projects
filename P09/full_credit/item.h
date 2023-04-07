#ifndef __ITEM_H
#define __ITEM_H
#include <iostream>
#include <exception>

class Item
{
public:
    Item(std::string name, int price);

    std::string to_string();

private:
    std::string name;
    int price;
};

#endif