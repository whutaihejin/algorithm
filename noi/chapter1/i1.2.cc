#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);
    // printf("%d%d%d\n", n % 10, (n / 10) % 10, n / 100);
    int r = (n % 10) * 100 + ((n / 10) % 10) * 10 + n / 100;
    printf("%d\n", r);
    printf("%03d\n", r);
    return 0;
}