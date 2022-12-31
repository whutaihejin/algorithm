#include <iostream>
#include <assert.h>
#include <memory>
// 问题描述： 给出一个单链表，对其进行反转
// 算法，研发的基础！
// 最近一直在刷算法题目，其中一个心得体会就是大道至简;
// 无论是简单还是很难的题目，自己写出来的代码总是那么冗余；
// 反观大牛，他们总能深刻分析出问题的本质，给出简短而有力的代码；
// 还是多练习，多积累，多看大牛的代码然后反思，做出相应的总结；
// 趁着自己还年轻多学一些东西!
class Node {
  public:
    Node(): key_(0), next_(NULL) {}
    Node(int key, Node* next): key_(key), next_(next) {}
    int key_;
    Node* next_;
};

std::ostream& operator<<(std::ostream& out, Node& node) {
  out << node.key_;
  return out;
}

void link_show(Node* l) {
  if (l == NULL) return;
  while (l->next_) {
    std::cout << *l << "->";
    l = l->next_;
  }
  std::cout << *l << std::endl;
}

void destory(Node* l) {
  while (l) {
    Node* q = l;
    l = l->next_;
    delete q;
  }
}

Node* array_to_link(int* nums, int size) {
  std::auto_ptr<Node> dummy(new Node());
  Node* tail = dummy.get();
  int* limit = nums + size;
  while (nums < limit) {
    Node* node = new Node(*nums, NULL);
    tail->next_ = node;
    tail = node;
    nums++;
  }
  return dummy->next_;
}
// 反转方法1: 插入法
// 思想：新建一个伪节点，然后遍历所有节点依次将其插入到伪节点后面，最后返回伪节点的后一个节点即为新的头节点
Node* f1(Node* head) {
  std::auto_ptr<Node> dummy(new Node);
  while (head) {
    Node* p = head;
    head = head->next_;
    p->next_ = dummy->next_;
    dummy->next_ = p;
  }
  return dummy->next_;
}

// 反转方法2: 三指针法
// 思想：维护三个指针，依次调整中间指针的next，直到调整所有节点
Node* f2(Node* head) {
  Node* prev = NULL;
  Node* curr = head;
  while (curr) {
    Node* next = curr->next_;
    curr->next_ = prev;
    prev = curr;
    curr = next;
  }
  return prev;
}

Node* doF3(Node* head) {
  if (head->next_ == NULL) {
    return head;
  } else {
    Node* new_head = doF3(head->next_);
    head->next_->next_ = head;
    head->next_ = NULL;
    return new_head;
  }
}

// 反转方法3: 递归法
// 思想：递归调整每个节点的指针, 注意每个节点维护的信息, 一定要理解head->next_->next_ = head 这就话的含义, 以及为什么要调整head->next_ = NULL！
Node* f3(Node* head) {
  if (head == NULL) return head;
  return doF3(head);
}

Node* reverse(Node* head) {
  return f3(head);
}

void test1() {
  Node* head = NULL;
  Node* new_head = reverse(head);
  assert(new_head == NULL);
}

void test2() {
  Node* head = new Node(1, NULL);
  Node* new_head = reverse(head);
  assert(new_head == head);
  destory(head);
}

void test3() {
  int arr[] = {5, 4, 3, 2, 1};
  Node* head = array_to_link(arr, sizeof(arr) / sizeof(arr[0]));
  link_show(head);
  Node* new_head = reverse(head);
  link_show(new_head);
  destory(new_head);
}

int main(int argc, char* argv[]) {
  test1();
  test2();
  test3();
  return 0;
}
