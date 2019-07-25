import java.io.*;
import java.util.*;

public class DDRP3 {
  static ArrayList<Integer> adjList[];  
  
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] line = br.readLine().split(" ");
    int N = Integer.parseInt(line[0]);
    int M = Integer.parseInt(line[1]);
    adjList = (ArrayList<Integer>[]) new ArrayList[N];
    for (int i=0; i<N; i++){
      adjList[i] = new ArrayList<Integer>();
    }
    
    for(int i=0;i<M; i++){
      line = br.readLine().split(" ");
      int x = Integer.parseInt(line[0]);
      int y = Integer.parseInt(line[1]);
      x--;
      y--;
      adjList[x].add(y);
      adjList[y].add(x);
    }
    line = br.readLine().split(" ");
    int x = Integer.parseInt(line[0]);
    int y = Integer.parseInt(line[1]);
    x--;
    y--;
    int S = x;
    int T = y;
    
    int[] distance = new int[N];
    for(int i=0; i<N; i++){
      distance[i] = -1;
    }
    distance[S] = 0;
    
    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(S);
    
    while(!queue.isEmpty()){
      int currentPoint = queue.poll();
      for(int i:adjList[currentPoint]){
        if(distance[i]==-1){
          distance[i] = distance[currentPoint]+1;
          queue.add(i);
          }
      }
    }
    System.out.println(M-distance[T]);
  }
}