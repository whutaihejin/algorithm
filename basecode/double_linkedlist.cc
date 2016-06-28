#include <memory>
#include <iostream>
#include <assert.h>
// 问题描述： 反转双向链表
// 清醒吧少年，你自己都没有想清楚的问题，又奈何计算机能够想清楚；
// 写代码之前，一定要自己想清楚了，否则不如不写，写了也是白搭！
struct Node {
  int key;
  Node* prev;
  Node* next;
  explicit Node(): key(0), prev(NULL), next(NULL) {}
  explicit Node(int k): key(k), prev(NULL), next(NULL) {}
};

std::ostream& operator<<(std::ostream& out, const Node& node) {
  out << node.key;
  return out;
}

Node* array_to_double_linkedlist(int* arr, int size) {
  if (arr == NULL || size <= 0) return NULL;
  std::auto_ptr<Node> dummy(new Node);
  Node* tail = dummy.get();
  int* limit = arr + size;
  for (; arr < limit; ++arr) {
    Node* p = new Node(*arr);
    p->next = tail->next;
    p->prev = tail;
    // tail->next->prev = p; // not necessary becase tail->next always NULL
    tail->next = p;
    tail = p;
  }
  dummy->next->prev = NULL;
  return dummy->next;
}

void double_linkedlist_show(Node* head) {
  if (head == NULL) return;
  Node* p = head;
  while (p->next != NULL) {
    std::cout << p->key << "->";
    p = p->next;
  }
  std::cout << p->key << std::endl;
  while (p->prev != NULL) {
    std::cout << p->key << "->";
    p = p->prev;
  }
  std::cout << p->key << std::endl;
}

void double_linkedlist_destroy(Node* head) {
  while (head) {
    Node* p = head;
    head = head->next;
    delete p;
  }
}

// 反转双向链表1： 插入法
// 思想：新建伪头节点，遍历链表节点依次插入到伪头节点之后
Node* f1(Node* head) {
  if (head == NULL) return head;
  std::auto_ptr<Node> dummy(new Node);
  while (head) {
    Node* p = head;
    head = head->next;
    // 依次调整4个指针
    p->next = dummy->next;
    p->prev = dummy.get();
    if (dummy->next != NULL) {
      dummy->next->prev = p;
    }
    dummy->next = p;
  }
  dummy->next->prev = NULL;
  return dummy->next;
}

// 反转双向链表2： 三指针法
// 思想： 维护三个指针，遍历链表依次进行调整
Node* f2(Node* head) {
  Node* prev = NULL;
  Node* curr = head;
  while (curr) {
    prev = curr;
    Node* next = curr->next;
    curr->next = curr->prev;
    curr->prev = next;
    curr = next;
  }
  return prev;
}

// 反转双向链表3: 递归法
// 思想： 递归从最后一个节点向前开始遍历, 探索还有没有更好的方式，大道至简！
Node* doF3(Node* head) {
  if (head->next == NULL) return head;
  Node* new_head = doF3(head->next);
  Node* p = head->next;
  p->prev = p->next;
  p->next = head;
  return new_head;
}

Node* f3(Node* head) {
  if (head == NULL) return head;
  Node* new_head = doF3(head);
  head->prev = head->next;
  head->next = NULL;
  return new_head;
}

Node* reverse(Node* head) {
  //return f1(head);
  //return f2(head);
  return f3(head);
}

void test1() {
  Node* head = array_to_double_linkedlist(NULL, 0);
  assert(head == NULL);
  head = array_to_double_linkedlist(NULL, 1);
  assert(head == NULL);
  int arr[] = {1, 2, 3, 4, 5};
  head = array_to_double_linkedlist(arr, sizeof(arr) / sizeof(arr[0]));
  double_linkedlist_show(head);
  double_linkedlist_destroy(head);
  int arr2[] = {1};
  head = array_to_double_linkedlist(arr, sizeof(arr2) / sizeof(arr2[0]));
  double_linkedlist_show(head);
  double_linkedlist_destroy(head);
  int arr3[] = {1, 2};
  head = array_to_double_linkedlist(arr, sizeof(arr3) / sizeof(arr3[0]));
  double_linkedlist_show(head);
  double_linkedlist_destroy(head);
}

void test2() {
  int arr[] = {1, 2, 3, 4, 5};
  Node* head = array_to_double_linkedlist(arr, sizeof(arr) / sizeof(arr[0]));
  double_linkedlist_show(head);
  Node* new_head = reverse(head);
  double_linkedlist_show(new_head);
  double_linkedlist_destroy(new_head);
}

int main(int argc, char* argv[]) {
  test1();
  test2();
  return 0;
}
