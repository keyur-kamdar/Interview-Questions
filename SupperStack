
import java.lang.Math;
import java.util.*;


public class Stack{
  public static void main(String[] args){
    
	SupperStack ss = new SupperStack();
    System.out.println(ss.push(1));
    System.out.println(ss.pop());
    System.out.println(ss.push(3));
    System.out.println(ss.push(4));
    System.out.println(ss.push(5));
    System.out.println(ss.inc(3, 1));
    System.out.println(ss.pop());
    System.out.println(ss.push(9));
  }
}

public class SupperStack{
 	Stack<Node> s = new Stack<Node>();
  	HashMap<Integer, Node> locs = new HashMap<Integer, Node>();
  	Node start, cur;
  
  public int push(int val){
    if(start == null){
      	
      	cur = new Node();
      	cur.value = val;
    }
    else{
      Node n = new Node();
      n.value = val;
      n.next = cur;
      cur = n;
    }
    locs.put(s.size(), cur);
    s.push(cur);
    return cur.value;
  }
  
  public int pop(){
    int result = -1;
    if(s.peek() == null){
    	result = -1;
    }
    else{
    	Node n = s.pop();
      	int loc = s.size();
      	locs.remove(loc);
      	result = n.value;
    }
    return result;
  }
  
  
  public int inc(int e, int l){
    Node loc = locs.get(s.size()-1);
    
    while(loc!= null){
     	  loc.value += e;
      	loc = loc.next;
    }
    
    Node n = s.peek();
    return n.value;
  }
  
}

public class Node{
  int value;
  Node next = null;
  
}
