#include "vending_machine.h"
#include <iostream>
#include <fstream>

int main() 
{
  std::ifstream inputfile("products.txt");
  Vending_machine vm(inputfile);

  while(true)
  {
    int i;
    
    std::cout << "\n";
    std::cout << vm << "\n\n";
    std::cout << "Products? ";
    std::cin >> i;

    if(i < 0)
    {
      break;
    }
    vm.buy(i);
  }

  return 0; 
}