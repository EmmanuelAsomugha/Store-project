#include <iostream>
#include <string>

int main(int argc, char* argv[]) {
  std::string previous_arg = "";  // to keep track of the previous argument
  
  for (int i = 1; i < argc; i++) {  // start from i=1, since argv[0] is the program name
    std::string current_arg = argv[i];  // convert the current argument to a string
    
    if (current_arg != previous_arg) {  // check if the current argument is the same as the previous one
      std::cout << current_arg << " ";  // if not, print it followed by a space
    }
    
    previous_arg = current_arg;  // update the previous argument
  }
  
  std::cout << std::endl;  // print a newline at the end
  return 0;
}

