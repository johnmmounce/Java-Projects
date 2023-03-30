#include <iostream>
#include <string.h>
#include <vector>

int main(int argc, char *argv[])
{
    std::string previousArg;
    std::vector<std::string> args;
    std::string currentArg;

    for (int i = 1; i < argc; i++)
    {
        currentArg = argv[i];

        if (currentArg != previousArg)
        {
            args.push_back(currentArg);
            std::cout << currentArg << " ";
        }
        previousArg = currentArg;
    }
    std::cout << std::endl;
    return 0;
}