#include <stdio.h>

#include "graph.h"

int main() {
  // construct by nodes
  std::vector<rp::AdjListGraph::Node> nodes{
      {1, {2, 3}},
      {2, {1, 4, 5}},
      {3, {1, 6, 7}},
      {4, {2}},
      {5, {2}},
      {6, {3}},
      {7, {3}}};
  rp::AdjListGraph graph(nodes);
  graph.Print();

  auto matrix_graph = rp::GraphConvertor::Convert(graph);
  matrix_graph.Print();
  return 0;
}