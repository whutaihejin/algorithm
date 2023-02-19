#include <stdio.h>

#include "graph.h"

int main() {
  // construct by edges
  std::vector<rp::Edge> edges{
      {1, 2},
      {1, 5},
      {2, 1},
      {2, 5},
      {2, 3},
      {2, 4},
      {3, 2},
      {3, 4},
      {4, 2},
      {4, 5},
      {4, 3},
      {5, 4},
      {5, 1},
      {5, 2}};

  rp::AdjListGraph graph(edges);
  graph.Print();

  printf("======\n");
  // construct by nodes
  std::vector<rp::AdjListGraph::Node> all_nodes{
      {1, {2, 5}},
      {2, {1, 5, 3, 4}},
      {3, {2, 4}},
      {4, {2, 5, 3}},
      {5, {4, 1, 2}}};
  rp::AdjListGraph graph2(all_nodes);
  graph2.Print();

  auto& nodes = graph.GetNodes();
  // out degree
  for (auto& node : nodes) {
    printf("node %d outdegree %d\n", node.idx, node.adj.size());
  }

  // in degree
  std::vector<int32_t> indegree(nodes.size());
  for (auto& node : nodes) {
    for (auto& to : node.adj) {
      indegree[to]++;
    }
  }
  for (size_t i = 0; i < indegree.size(); ++i) {
    printf("node %d indegree %d\n", i, indegree[i]);
  }

  return 0;
}