#include <iostream>
#include <stdio.h>
#include <math.h>

int main() {
    // int
    printf("%d\n", 1 + 2);
    printf("%d\n", 3 - 4);
    printf("%d\n", 5 * 6);
    printf("%d\n", 8 / 4);
    printf("%d\n", 8 / 5);

    // float
    printf("%.1f\n", 8.0 / 5.0);
    printf("%.2f\n", 8.0 / 5.0);
    printf("%.1f\n", 8 / 5);
    std::cout << (8 / 5) << std::endl;
    printf("%d\n", 8.0 / 5.0);

    //
    printf("%.8f\n", 1 + 2 * sqrt(3) / (5 - 0.1));
    return 0;
}