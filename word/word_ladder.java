public class Solution {
	/*
	bfs
	 */
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	if(dict == null || dict.size() == 0) return 0;
        Queue<String> q1 = new LinkedList<String>();
        Queue<Integer> q2 = new LinkedList<Integer>();
        q1.add(start);
        q2.add(1);
        while(!q1.isEmpty()) {
        	String s = q1.poll();
        	int len = q2.poll();
        	
        	if(s.equals(end))
        		return len;
        	
        	for(int i=0; i<s.length(); i++) {
        		char[] words = s.toCharArray();
        		for(char c ='a'; c <= 'z'; c++) {
        			if(c == words[i])
        				continue;
        			words[i] = c;
        			String str = String.valueOf(words);
        			if(dict.contains(str)) {
        				q1.add(str);
        				q2.add(len+1);
        				dict.remove(str);
        			}
        		}
        	}
        }
        return 0;
    }
}