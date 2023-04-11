#include "vending_machine.h"
#include <iostream>

Vending_machine::Vending_machine()
{

}

Vending_machine::Vending_machine(std::istream& is)
{
    Item item;
    
    while (is >> item) 
    {
        items.push_back(item);
    }
}

void Vending_machine::add(std::string name, int price) 
{
    Item item(name, price);
    items.push_back(item);
}

void Vending_machine::buy(int index) 
{
    std::cout << "#### Buying " << items[index] << std::endl;
    //items.erase(items.begin() + index);
}

std::ostream& operator<<(std::ostream& os, const Vending_machine& vm) 
{
    os << "======================" << std::endl;
    os << "Welcome to UTA Vending" << std::endl;
    os << "======================" << std::endl;
    
    for (int j = 0; j < vm.items.size(); ++j) 
    {
        os << j << ") " << vm.items[j] << std::endl;
    }

    return os;
}
