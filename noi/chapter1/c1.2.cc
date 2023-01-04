#include <iostream>
#include <stdio.h>
#include <math.h>

int main() {
    int a, b;
    scanf("%d%d", &a, &b);
    // scanf("%d%d", a, b); // Segmentation fault (core dumped)
    printf("%d\n", a + b);
    return 0;
}