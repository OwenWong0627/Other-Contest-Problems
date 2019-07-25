import java.io.*;
import java.util.*;

public class DMOPC13C1P4 {
  public static void main(String[] args) throws IOException{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    for(int tst=0;tst<t;++tst){
      String[] lw=br.readLine().split(" ");
      int l=Integer.parseInt(lw[1]);
      int w=Integer.parseInt(lw[0]);
      char[][] map = new char[l][w];
      int StartX = 0;
      int StartY = 0;
      int EndX = 0;
      int EndY = 0;
      for(int len=0;len<l;++len){
        String line = br.readLine();
        for(int wid=0;wid<w;++wid){
          map[len][wid] = line.charAt(wid);
          if(map[len][wid]=='C'){
            StartX = len;
            StartY = wid;
          }else if(map[len][wid]=='W'){
            EndX = len;
            EndY = wid;
          }
        }
      }
      int[][] distance = new int[l][w];
      for(int i=0; i<l; i++){
        for(int j=0; j<w; j++){
          distance[i][j] = -1;
        }
      }
      distance[StartX][StartY] = 0;
      LinkedList<Integer> queue = new LinkedList<Integer>();
      queue.add(StartX*w+StartY);
      
      int[] move = {1,-1};
      while(!queue.isEmpty()){
        int currentPoint = queue.poll();
        int cPX = currentPoint/w;
        int cPY = currentPoint%w;
        
        for(int i=0; i<2; i++){
          int destX = cPX;
          int destY = cPY + move[i];
          if(!(destY<0||destY>=w||distance[destX][destY]!=-1||map[destX][destY]=='X')){
            distance[destX][destY] = distance[cPX][cPY]+1;
            queue.add(destX*w+destY);
          }
        }
        for(int i=0; i<2; i++){
          int destX = cPX + move[i];
          int destY = cPY;
          if(!(destX<0||destX>=l||distance[destX][destY]!=-1||map[destX][destY]=='X')){
            distance[destX][destY] = distance[cPX][cPY]+1;
            queue.add(destX*w+destY);
          }
        }
    }
    if(distance[EndX][EndY] < 60 && distance[EndX][EndY]>0){
      System.out.println(distance[EndX][EndY]);
    }else{
      System.out.println("#notworth");
    }
  }
}
}