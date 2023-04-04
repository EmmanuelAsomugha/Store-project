
#include <iostream>
#include <vector>

int main() 
{
  std::vector<int> a;
  int x;

  while (std::cin >> x) 
  {
    a.push_back(x);
  }

  std::cout << "Number of elements: " << a.size() << std::endl;

  std::cout << "Elements: ";
  for (auto i = a.begin(); i != a.end(); ++i) 
  {
    std::cout << *i << " ";
  }
  std::cout << std::endl;

  std::cout << "Even indices: ";
  for (int i = 0; i < a.size(); i += 2) 
  {
    std::cout << a[i] << " ";
  }
  std::cout << std::endl;

  std::cout << "Odd  indices: ";
  for (int i = 1; i < a.size(); i += 2) 
  {
    std::cout << a[i] << " ";
  }
  std::cout << std::endl;

  return 0;
}
