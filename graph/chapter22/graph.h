#pragma once

#include <stdio.h>

#include <cstdint>
#include <string>
#include <vector>

namespace rp {

struct Edge {
  int32_t from;
  int32_t to;
};

class AdjListGraph {
 public:
  struct Node {
    int32_t idx;
    std::vector<int32_t> adj;
  };

  AdjListGraph(const std::vector<Node>& node_vec) : nodes_(node_vec) {}

  AdjListGraph(const std::vector<Edge>& edges) {
    for (auto& edge : edges) {
      int32_t limit = nodes_.size();
      if (edge.from >= limit) {
        nodes_.resize(edge.from + 1);
      }
      auto& node = nodes_[edge.from];
      node.idx = edge.from;
      node.adj.push_back(edge.to);
    }
  }

  void Print() const {
    for (auto& node : nodes_) {
      printf("node [%d]:", node.idx);
      std::string sep;
      for (auto& to : node.adj) {
        printf("%s%d", sep.c_str(), to);
        sep = "->";
      }
      printf("\n");
    }
  }

  const std::vector<Node>& GetNodes() const {
    return nodes_;
  }

 private:
  std::vector<Node> nodes_;
};

class AdjMatrixGraph {
 public:
  // construct by edges
  AdjMatrixGraph(const std::vector<Edge>& edges) {
    int32_t size = 0;
    for (auto& edge : edges) {
      size = std::max(size, std::max(edge.from, edge.to));
    }
    matrix_.resize(size + 1);
    for (auto& row : matrix_) {
      row.resize(size + 1);
    }
    for (auto& edge : edges) {
      matrix_[edge.from][edge.to] = 1;
    }
  }

  // construct by matrix
  AdjMatrixGraph(std::vector<std::vector<int32_t>>& matrix) : matrix_(matrix) {}

  void Print() const {
    for (auto& row : matrix_) {
      for (auto& c : row) {
        printf("%d ", c);
      }
      printf("\n");
    }
  }

  const std::vector<std::vector<int32_t>>& GetMatrix() const {
    return matrix_;
  }

 private:
  std::vector<std::vector<int32_t>> matrix_;
};

class GraphConvertor {
 public:
  static AdjMatrixGraph Convert(AdjListGraph& graph) {
    auto& nodes = graph.GetNodes();
    int32_t limit = nodes.size() + 1;
    std::vector<std::vector<int32_t>> matrix(limit, std::vector<int32_t>(limit, 0));
    for (auto& node : nodes) {
      for (auto& to : node.adj) {
        matrix[node.idx][to] = 1;
      }
    }
    return AdjMatrixGraph(matrix);
  }

  static AdjListGraph Convert(AdjMatrixGraph& graph) {
    std::vector<AdjListGraph::Node> nodes;

    auto& matrix = graph.GetMatrix();
    for (size_t i = 0; i < matrix.size(); ++i) {
      for (size_t j = 0; j < matrix[0].size(); ++j) {
        if (matrix[i][j] == 1) {
          nodes.resize(i + 1);
          auto& node = nodes[i];
          node.idx = i;
          node.adj.push_back(j);
        }
      }
    }
    return AdjListGraph(nodes);
  }
};

}  // namespace rp