//Hash test
import java.util.*;

class HashTest{
	public static void main(String[] args){
		// int a = Random.randInt(20);
		// List<Integer> a = new ArrayList<Integer>();
		// for(int i=0; i<a; i++){
		// 	a.put(Random.randInt(5));
		// }

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('a', 5);
		map.put('a', 7);
		map.put('b', 3);
		map.put('b', 4);

		System.out.println(String.format("a -> %d, b -> %d", map.get('a'), map.get('b')));
	}
}