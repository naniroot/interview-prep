/* Trie Data Structure */
import java.util.*;


class TrieNode{
	public Map<Character, TrieNode> nodeMap;
	public boolean isLeaf;
	public char c;
	TrieNode(){
		nodeMap = new HashMap<Character, TrieNode>();
		this.isLeaf = false;
	}
	TrieNode(char c){
		nodeMap = new HashMap<Character, TrieNode>();
		this.isLeaf = false;
		this.c = c;
	}
}


class Trie{
	private TrieNode root;

	Trie(){
		root = new TrieNode();
	}

	public void add(String s){
		TrieNode currNode = root;

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			Map<Character, TrieNode> currMap = currNode.nodeMap;
			if(currMap.containsKey(c)){
				currNode = currMap.get(c);
			} else {
				TrieNode newNode = new TrieNode(c);
				currMap.put(c, newNode);
				currNode = newNode;
			}
		}
		currNode.isLeaf = true;

	}
	public boolean find(String s){
		TrieNode currNode = root;

		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			Map<Character, TrieNode> currMap = currNode.nodeMap;
			if(currMap.containsKey(c)){
				currNode = currMap.get(c);
			} else {
				return false;
			}
		}
		return currNode.isLeaf;
	}
}

class TestTrie{
	public static void main(String s[]){
		Trie trie = new Trie();
		trie.add("narayana");
		trie .add("nana");

		if(trie.find("narayana")){
			System.out.println("Word is present!");
		}
		if(!trie.find("narayan")){
			System.out.println("word is absent");
		}
		
	}
}