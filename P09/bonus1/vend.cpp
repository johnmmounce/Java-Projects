#include <iostream>
#include <string>
#include <vector>
#include "vending_machine.h"
#include "item.h"

int main(){
    Vending_Machine vending_machine;
    vending_machine.add("snickers", 199);
    vending_machine.add("beef jerky", 899);
    std::cout << vending_machine;
    vending_machine.buy(1);
    
    return 0;
}