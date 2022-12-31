#include <iostream>
#include <stack>

int longestValidParentheses(std::string s) {
  std::stack<char> stk;
  unsigned int counter = 0;
  for (int i = 0; i < s.size(); i++) {
    char ch = s[i];
    if (ch == '(') {
      stk.push(ch);
    } else {
      if (!stk.empty() && stk.top() == '(') {
        counter++;
        stk.pop();
      } else {
        stk.push(ch);
      }
    }
  }
  return (counter << 1);
}

int main(int argc, char* argv[]) {
  std::string str = "(()";
  std::cout << str << " " << longestValidParentheses(str) << std::endl;
  str = ")()())";
  std::cout << str << " " << longestValidParentheses(str) << std::endl;
  return 0;
}
