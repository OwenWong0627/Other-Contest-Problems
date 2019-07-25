import java.io.*;
import java.util.*;

//Adjacency Matrix
//O(n^2) memory
//Adjacency List
//O(e) memory
//Array of List (ArrayLists)
//ArrayList i stores all the nodes that are adjacent to node i

public class DWITE07R2_5 {
  
  static int n,m;
  static boolean[][] adj;
  static boolean[] visited;
  
  static void dfs(int node){
    
    visited[node]=true;
    
    for(int i=0; i<n; i++){
      if(!visited[i] && adj[node][i]){
        dfs(i);
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    for(int test=0; test<5;test++){
      n=sc.nextInt();
      m=sc.nextInt();
      int bridges = 0;
      boolean check = true;

      adj = new boolean[n][n];

      visited = new boolean[n];

      for(int i=0;i<m;++i){
        int x,y;
        x=sc.nextInt();
        y=sc.nextInt();

        x--;
        y--;

        adj[x][y] = true;
        adj[y][x] = true;
      }
      for(int i=0; i<n; i++){
        for (int j=i+1; j<n; j++){
          if (adj[i][j] == true){
            adj[i][j] = false;
            adj[j][i] = false;
            dfs(i);
            for(int a=0; a<n; a++){
              if(!visited[a]){
                check = false;
                break;
              }
            }
            if(!check){
              bridges++;
            }
            Arrays.fill(visited,false);
            check = true;
            adj[i][j] = true;
            adj[j][i] = true;
          }
        }
      }
      System.out.println(bridges);
    }
    }
}
