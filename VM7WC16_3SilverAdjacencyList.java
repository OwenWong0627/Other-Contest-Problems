import java.io.*;
import java.util.*;

public class VM7WC16_3SilverAdjacencyList {
  
  static int n,m,a,b;
  static ArrayList<Integer> adjList[];
  static boolean[] visited;
  static boolean reached=false;
  
  static void dfs(int node){
    if(node==b){
      reached=true; 
      return;
    }
    
    visited[node]=true;
    
    for(int i:adjList[node]){
      if(!visited[i]){
        dfs(i); 
      }
    }
  }
  
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    n=sc.nextInt();
    m=sc.nextInt();
    a=sc.nextInt();
    b=sc.nextInt();
    
    adjList=(ArrayList<Integer>[])new ArrayList[n];
    for(int i=0;i<n;++i)
      adjList[i]=new ArrayList<Integer>();
    a--;
    b--;
    
    visited = new boolean[n];
    
    for(int i=0;i<m;++i){
      int x,y;
      x=sc.nextInt();
      y=sc.nextInt();
      
      x--;
      y--;
      
      adjList[x].add(y);
      adjList[y].add(x);
    }
    
    dfs(a);
    if(reached)
      System.out.println("GO SHAHIR!");
    else
      System.out.println("NO SHAHIR!");
  }
}
