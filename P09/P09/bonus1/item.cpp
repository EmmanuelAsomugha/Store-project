#include <iostream>
#include <exception>
#include "item.h"

Item::Item()
{
    
}

Item::Item(std::string name, int price) 
    : _name{name}, _price{price} 
{
    if (price < 0) 
    {
        throw std::runtime_error("Price can't be negative");
    }
}

std::ostream& operator<<(std::ostream& os, const Item& item) 
{
    os << item._name << " ($" << item._price / 100 << "." << item._price % 100 << ")";

    return os;
}

std::istream& operator>>(std::istream& is, Item& item) 
{
    std::getline(is >> std::ws, item._name);
    std::string priceS;
    std::getline(is >> std::ws, priceS);
    item._price = std::stoi(priceS);

    return is;
}
