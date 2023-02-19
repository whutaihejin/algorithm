#include <stdio.h>

#include <unordered_map>

#include "graph.h"

int main() {
  std::vector<rp::AdjListGraph::Node> nodes{
      {1, {1, 2, 2, 4}},
      {2, {5}},
      {3, {6, 5}},
      {4, {2}},
      {5, {4}},
      {6, {6}}};
  rp::AdjListGraph graph(nodes);
  graph.Print();

  auto graph_nodes = graph.GetNodes();
  for (auto& node : graph_nodes) {
    std::unordered_map<int32_t, int32_t> kv{{node.idx, 1}};
    auto& adj = node.adj;
    for (auto it = adj.begin(); it != adj.end();) {
      if (kv.find(*it) != kv.end()) {
        it = adj.erase(it);
      } else {
        kv.insert(std::make_pair(*it, 1));
        ++it;
      }
    }
  }

  rp::AdjListGraph fixed_graph(graph_nodes);
  fixed_graph.Print();

  return 0;
}