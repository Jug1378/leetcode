/*
tricky method using LinkedHashMap
 */
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class LRUCache<K,V> extends LinkedHashMap<K,V> {

	private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public boolean removeEldestEntry(Map.Entry<K,V> eldest) {
    	return size > this.capacity;
    }
}

/*
implement the basic method from bottom
 */
public class LRUCache {
	private class Node {
		Node prev;
		Node next;
		int key;
		int value;
		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	private int capacity;
	private Node head = null;
	private Node end = null;
	private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			Node n = map.get(key);
			//refresh the list
			detach(n);
			attach(n);
			return n.value;
		}
		else
			return -1;
	}

	public void set(int key, int value) {
		if(map.containsKey(key)) {
			Node n = map.get(key);
			n.value = value;
			detach(n);
			attach(n);
		}
		else {
			if(map.size() < capacity) {
				Node n = new Node(key, value);
				attach(n);
				map.put(key, n);
			}
			else {
				map.remove(end.key);
				detach(end);
				Node n = new Node(key, value);
				attach(n);
				map.put(key, n);
			}
		}
	}

	//detach the given node from the list
	public void detach(Node n) {
		Node prev = n.prev;
		Node next = n.next;
		if(prev != null)
			prev.next = next;
		else
			head = next;

		if(next != null)
			next.prev = prev;
		else
			end = prev;
	}

	//attach the given node to the begin of the list
	public void attach(Node n) {
		n.next = head;
		n.prev = null;
		if(head != null)
			head.prev = n;
		head = n;
		if(end == null)
			end = n;
	}
}