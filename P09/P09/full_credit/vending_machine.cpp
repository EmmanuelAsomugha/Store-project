#include "vending_machine.h"
#include <iostream>

void Vending_machine::add(std::string name, int price) 
{
    Item item(name, price);
    items.push_back(item);
}

void Vending_machine::buy(int index) 
{
    std::cout << "#### Buying " << items[index].to_string() << std::endl;
}

std::string Vending_machine::menu() 
{
    std::string b;

    std::cout << "======================" << std::endl;
    std::cout << "Welcome to UTA Vending" << std::endl;
    std::cout << "======================" << std::endl;

    for (int j = 0; j < items.size(); j++) 
    {
        b += std::to_string(j) + ") " + items[j].to_string() + "\n";
    }
    
  return b;
}
