package Graphs;


import java.util.*;

public class KosarajuAlgo {
  public static void main(String args[]) throws Exception {

    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();

    ArrayList< ArrayList< Integer>> graph = new ArrayList< >();

    for (int i = 0; i < n; i++)
    {
      graph.add(new ArrayList< >());
    }

    for (int i = 0; i < m; i++)
    {
      int src = scn.nextInt();
      int dest = scn.nextInt();

      graph.get(src - 1).add(dest - 1);
    }

    scn.close();
    System.out.println(kosaraju(graph, n));
  }

  public static int kosaraju(ArrayList< ArrayList< Integer>> graph, int N)
  {
    Stack< Integer> stack = new Stack< >();
    boolean[] visited = new boolean[N];

    for (int i = 0; i < N; i++) //random order DFS to get the specific order into the stack
    {
      if (visited[i] == false)
      {
        dfs(graph, visited, i, stack);
      }
    }

    ArrayList< ArrayList< Integer>> newGraph = transpose(graph, N); //to create a new graph with the edges reversed

    visited = new boolean[N];
    int count = 0;

    while (stack.size() > 0)
    {
      int curr = stack.pop();

      if (visited[curr] == false)
      {
        dfs(newGraph, visited, curr);
        count++;
      }
    }

    return count;
  }

  public static void dfs(ArrayList< ArrayList< Integer>> graph, boolean[] visited, int src, Stack< Integer> st)
  {
    visited[src] = true;

    for (int nbr : graph.get(src))
    {
      if (visited[nbr] == false)
      {
        dfs(graph, visited, nbr, st);
      }
    }

    st.push(src);
  }

  public static void dfs(ArrayList< ArrayList< Integer>> graph, boolean[] visited, int src)
  {
    visited[src] = true;

    for (int nbr : graph.get(src))
    {
      if (visited[nbr] == false)
      {
        dfs(graph, visited, nbr);
      }
    }
  }

  public static ArrayList< ArrayList< Integer>> transpose(ArrayList< ArrayList< Integer>> graph, int N)
  {
    ArrayList< ArrayList< Integer>> result = new ArrayList< >();

    for (int i = 0; i < N; i++)
    {
      result.add(new ArrayList< >());
    }

    for (int i = 0; i < N; i++)
    {
      for (int nbr : graph.get(i))
      {
        result.get(nbr).add(i);
      }
    }

    return result;
  }

}
