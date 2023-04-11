#include "vending_machine.h"
#include <iostream>

int main() 
{
  Vending_machine vm;

  vm.add("Peanut butter crackers", 165);
  vm.add("Oreos", 184);

  std::cout << vm.menu() << std::endl;

  vm.buy(1);

  return 0;
}
