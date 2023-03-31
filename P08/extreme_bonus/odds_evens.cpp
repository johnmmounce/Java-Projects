#include <iostream>
#include <vector>

int main()
{
    int i;
    std::vector<int> vect;

    while (std::cin.good())
    {
        std::cin >> i;
        vect.push_back(i);
        if (std::cin.eof())
        {
            break;
        }
    }
    std::cout << "\nnumber of elements: " << vect.size() - 1 << std::endl;
    std::cout << "elements: ";
    for (int i = 0; i < vect.size() - 1; i++)
    {
        std::cout << vect[i] << " ";
    }
    std::cout << "\neven indices: ";
    for (int i = 0; i < vect.size() - 1; i++)
    {
        if ((vect[i] % 2) == 0)
        {
            std::cout << vect[i] << " ";
        }
    }
    std::cout << "\nodd indices: ";
    for (int i = 0; i < vect.size() - 1; i++)
    {
        if ((vect[i] % 2) == 1)
        {
            std::cout << vect[i] << " ";
        }
    }

    std::cout << std::endl;
    return 0;
}