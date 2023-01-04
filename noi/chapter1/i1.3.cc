#include <stdio.h>

int main() {
    int a, b, t;
    scanf("%d%d", &a, &b);
    printf("%d %d\n", b, a);
    // swap
    t = a;
    a = b;
    b = t;
    printf("%d %d\n", a, b);
    return 0;
}