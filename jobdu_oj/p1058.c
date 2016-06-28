#include <stdio.h>
int main(int argc, char* argv[]) {
  char buf[5];
  while (scanf("%s", buf) == 1) {
    printf("%c%c%c%c\n", buf[3], buf[2], buf[1], buf[0]);
  }
  return 0;
}
