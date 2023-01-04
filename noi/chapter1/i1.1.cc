#include <stdio.h>
#include <math.h>

int main() {
    double r, h;
    scanf("%lf%lf", &r, &h); // must be %lf, why?
    // printf("%.3f,%.3f\n", r, h);
    double area = 2 * M_PI * r * (r + h);
    printf("%.3f\n", area);
    printf("%.3lf\n", area);
    return 0;
}