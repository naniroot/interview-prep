import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {

    String s = "narayana";
    String t = "nana";
    
    Trie trie = new Trie();

    add(trie, s);
    add(trie, t);
    
    if(isPresent(trie, "narayana")){
      System.out.println("IT IS PRESENT");
    }
    if(isPresent(trie, "test")){
      // It should not go here
    } else {
      System.out.println("IT IS not PRESENT");
    }
  }
  
  public static void add(Trie curr, String s){
    
    if(s.length() == 0){
      return;
    }
    s = s.toLowerCase();
    char first = s.charAt(0);
    int index = first - 'a';
    s = s.substring(1, s.length());
    List<Trie> currList = curr.trieNodes;
    if(currList.get(index) == null){
      Trie newTrie = new Trie();

      currList.add(index, newTrie);
      if(s.length() == 1){
        newTrie.isEnd = true;
        return;
      }
      add(newTrie, s);
    } else {
      Trie currTrie = currList.get(index);
      if(s.length() == 1){
        currTrie.isEnd = true;
        return;
      }
      add(currTrie, s);
    }
  }
  
  public static boolean isPresent(Trie curr, String s){
    s = s.toLowerCase();
    if(s.length() == 1){
      if(curr.isEnd){
        return true;
      } else{
        return false;
      }
    }
    char first = s.charAt(0);
    int index = first - 'a';
    List<Trie> currList= curr.trieNodes;
    if(currList.get(index) == null){
      return false;
    } else {
      return isPresent(currList.get(index), s.substring(1,s.length()));
    }
    
  }
}


class Trie{
  public List<Trie> trieNodes; 
  public boolean isEnd;
  
  Trie(){
    this.trieNodes = new ArrayList<Trie>();
    this.isEnd = false;
  }
}


