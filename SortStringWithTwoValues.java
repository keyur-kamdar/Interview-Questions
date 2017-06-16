// Class name must be "Main"

// e.g. ["a","b","a","b","a"]
// output: ["a", "a", "a", "b", "b"]

import java.util.*;

public class Main {
     public static void main(String[] args) {
         String[] str = new String[]{"a", "b", "a", "b", "a"};
         Main m = new Main();
         m.sort(str, "a", "b");
         for(int i =0;i<str.length;i++){
             System.out.println(str[i]);             
         }
     }
    
    public void sort(String[] str, String min, String max){
     
        int i = 0;
        int j = str.length-1;
        
        while(i<j){
            String l = str[i];
            String r = str[j];
            if(l.compareTo(r) < 0){
                i++;
                j--;
            }else if(l.compareTo(r) > 0){
                String temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                
                i++;
                j--;
            }else if(r.compareTo(min) == 0) {
                i++;
            }else{
                i++; 
            }
        }
    }
}
