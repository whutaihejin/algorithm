#include <iostream>
#include <assert.h>
#include <memory>

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

Node* merge(Node* l1, Node*l2) {
  if (l1 == NULL) return l2;
  if (l2 == NULL) return l1;
  Node* dummy = new Node();
  Node* tail = dummy;
  while (l1 != NULL && l2 != NULL) {
    if (l1->key_ <= l2->key_) {
      tail->next_ = l1;
      tail = l1;
      l1 = l1->next_;
    } else {
      tail->next_ = l2;
      tail = l2;
      l2 = l2->next_;
    }
  }
  if (l1 != NULL) tail->next_ = l1;
  if (l2 != NULL) tail->next_ = l2;
  return dummy->next_;
}

Node* find_middle(Node* l) {
  if (l == NULL) return NULL;
  std::auto_ptr<Node> dummy(new Node);
  dummy->next_ = l;
  Node *forward = l, *follow = dummy.get();
  while (forward != NULL) {
    forward = forward->next_;
    if (forward != NULL) {
      forward = forward->next_;
    }
    follow = follow->next_;
  }
  return follow;
}

Node* mergeSort(Node* l) {
  if (l == NULL || l->next_ == NULL) return l;
  Node* middle = find_middle(l);
  Node* l2 = middle->next_;
  middle->next_ = NULL;
  Node* ml1 = mergeSort(l);
  Node* ml2 = mergeSort(l2);
  return merge(ml1, ml2);
}

void test1() {
  Node* l1 = NULL;
  Node* l2 = NULL;
  Node* l = merge(l1, l2);
  assert(l == NULL);
}

void test2() {
  Node* l1 = new Node(1, NULL);
  Node* l2 = NULL;
  Node* l = merge(l1, l2);
  assert(l == l1);
}

void test3() {
  Node* l1 = NULL;
  Node* l2 = new Node(2, NULL);
  Node* l = merge(l1, l2);
  assert(l = l2);
}

void test4() {
  Node* l1 = new Node(2, NULL);
  link_show(l1);
  Node* l2 = new Node(1, NULL);
  link_show(l2);
  Node* l = merge(l1, l2);
  link_show(l);
  assert(l == l2);
}

void test5() {
  int arr[] = {5, 4, 3, 2, 1, -1};
  Node* l = array_to_link(arr, sizeof(arr) / sizeof(arr[0]));
  link_show(l);
}

void test6() {
  int arr1[] = {2, 4, 6, 8};
  int arr2[] = {1, 3, 5, 7};
  Node* l1 = array_to_link(arr1, sizeof(arr1) / sizeof(arr1[0]));
  link_show(l1);
  Node* l2 = array_to_link(arr2, sizeof(arr2) / sizeof(arr2[0]));
  link_show(l2);
  Node* l = merge(l1, l2);
  link_show(l);
}

void test7() {
  int arr[] = {1, 2, 3, 4};
  Node* l = array_to_link(arr, sizeof(arr) / sizeof(arr[0]));
  link_show(l);
  Node* middle = find_middle(l);
  assert(middle->key_ == 2);
}

void test8() {
  int arr[] = {1, 2, 3, 4, 5};
  Node* l = array_to_link(arr, sizeof(arr) / sizeof(arr[0]));
  link_show(l);
  Node* middle = find_middle(l);
  assert(middle->key_ == 3);
}

void test9() {
  int arr[] = {9, 8, 1, 3, 6, 4, 2, 7, 5};
  Node* l = array_to_link(arr, sizeof(arr) / sizeof(arr[0]));
  link_show(l);
  Node* sl = mergeSort(l);
  link_show(sl);
}

int main(int argc, char* argv[]) {
  test1();
  test2();
  test3();
  test4();
  test5();
  test6();
  test7();
  test9();
  return 0;
}
