#include <stdio.h>

int main(int argc, char* argv[]) {
  char buf[5];
  while (fgets(buf, sizeof(buf), stdin) != NULL) {
    printf("%s", buf);
  }
  return 0;
}
