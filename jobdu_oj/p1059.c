#include <stdio.h>
// 题目描述: 设a、b、c均是0到9之间的数字，abc、bcc是两个三位数，且有：abc+bcc=532。求满足条件的所有a、b、c的值。
int main(int argc, char* argv[]) {
  int a = 1;
  int b = 1;
  int c = 0;
  while (a <= 6) {
    while (b <= 6) {
      b++;
      printf("%d %d\n", a, b);
    }
    a++;
  }
  /*
  for (; a <= 6; a++) {
    printf("%d\n", a);
    for (; b <= 6; b++) {
      printf("%d %d\n", a, b);
      
      for (; c <= 9; c++) {
        int value = (a + b) * 100 + (b + c) * 10 + c + c;
        printf("%d %d %d %d\n", a, b, c , value);
        if (value == 532) {
          printf("%d %d %d\n", a, b, c);
        }
      }
    }
  }
  */
  return 0;
}
