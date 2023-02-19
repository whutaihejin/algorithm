#include <stdio.h>

#include "graph.h"

int main() {
  std::vector<rp::AdjListGraph::Node> nodes{
      {1, {2, 4}},
      {2, {5}},
      {3, {6, 5}},
      {4, {2}},
      {5, {4}},
      {6, {6}}};
  rp::AdjListGraph graph(nodes);
  graph.Print();

  // transpose
  std::vector<rp::AdjListGraph::Node> trans_nodes(nodes.size() + 1);
  for (auto& node : nodes) {
    for (auto& to : node.adj) {
      auto& target = trans_nodes[to];
      target.idx = to;
      target.adj.push_back(node.idx);
    }
  }
  rp::AdjListGraph trans_graph(trans_nodes);
  trans_graph.Print();

  // matrix graph
  rp::AdjMatrixGraph matrix_graph = rp::GraphConvertor::Convert(graph);
  matrix_graph.Print();

  // transponse
  auto& matrix = matrix_graph.GetMatrix();
  int32_t limit = matrix.size();
  std::vector<std::vector<int32_t>> copy(limit, std::vector<int32_t>(limit, 0));
  for (size_t i = 0; i < limit; ++i) {
    for (size_t j = 0; j < limit; ++j) {
      if (matrix[i][j] == 1) {
        copy[j][i] = 1;
      }
    }
  }
  rp::AdjMatrixGraph trans_matrix_graph(copy);
  trans_matrix_graph.Print();
  return 0;
}