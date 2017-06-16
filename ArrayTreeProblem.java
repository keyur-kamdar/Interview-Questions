/*
e.g:
         1
       1   2
      1  2  3
     1 -2  3  4
     
output:
    minimum sum from root to leaf (1+1+1-2)
*/
import java.lang.Math; 

public class Main
{
    public static void main(String[] args)
    {
        int[][] t = new int[][]{{1},{1,2},{1,2,3},{1,2,3,4}};
        Main m = new Main();
        System.out.println("Min Value: " + m.getMin(t));
    }
    public int getMin(int[][] t){
    
        if(t.length==0){
     	    return 0; 
        }
        int[][] m = new int[t.length][];
        for(int i=0;i<m.length;i++){
            m[i] = new int[i+1]; 
        }
        m[0][0] = t[0][0];
        for(int i=1;i<t.length;i++){
            m[i][0] = m[i-1][0] + t[i][0];   
        }
        for(int i=1;i<t.length;i++){
            m[i][m[i].length-1] = m[i-1][m[i-1].length-1] + t[i][t[i].length-1]; 
        }
        int min = Integer.MAX_VALUE;
   
        for(int i=1;i<t.length;i++){
          for(int j=1;j<t[i].length-1;j++){
            m[i][j] = Math.min(m[i-1][j-1] + t[i][j], m[i-1][j] + t[i][j]);
            if(m[i][j] < min){
                min=m[i][j]; 
            }
          }
        }
        return min;
    } 
}
