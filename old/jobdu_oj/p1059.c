#include <stdio.h>
// 题目描述: 设a、b、c均是0到9之间的数字，abc、bcc是两个三位数，且有：abc+bcc=532。求满足条件的所有a、b、c的值。
int main(int argc, char* argv[]) {
  int a = 1;
  int b = 1;
  int c = 0;
  for (; a <= 6; a++) {
    for (b = 1; b <= 6; b++) {
      for (c = 0; c <= 9; c++) {
        int value = (a + b) * 100 + (b + c) * 10 + c + c;
        if (value == 532) {
          printf("%d %d %d\n", a, b, c);
        }
      }
    }
  }
  return 0;
}
