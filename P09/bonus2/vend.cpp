#include <iostream>
#include <string>
#include <vector>
#include <fstream>
#include <iomanip>
#include "vending_machine.h"
#include "item.h"

int main() {
    std::string filename = "products.txt";
    std::ifstream openfile(filename);
    if (openfile.is_open()) {
        Vending_Machine vending_machine; 
        vending_machine.vending_machine(openfile);
        openfile.close(); 
        vending_machine.add("snickers", 199);
        vending_machine.add("beef jerky", 899);
        std::cout << std::fixed << std::setprecision(2) << vending_machine;
        int input;
        std:: cout << "pick an item to purchase: ";
        std::cin >> input;
        if( input < 0){
            return -1;
        }
        vending_machine.buy(input);
    } else {
        std::cerr << "Failed to open file: " << filename << std::endl;
    }
    return 0;
}