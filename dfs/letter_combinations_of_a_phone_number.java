public class Solution {
	/*
	1)	charAt get char variable, so get function needs char input argument
	2)	StringBuffer toString() would return a new String
	 */
    public ArrayList<String> letterCombinations(String digits) {
        ArrayList<String> arr = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        dfs(arr, digits, sb, 0);
        return arr;
    }

    public void dfs(ArrayList<String> arr, String digits, StringBuffer sb, int pos) {
    	if(pos == digits.length()) {
    		arr.add(sb.toString());
    		return;
    	}
    	String s = get(digits.charAt(pos));
    	for(int i=0; i<s.length(); i++) {
    		sb.append(s.charAt(i));
    		dfs(arr, digits, sb, pos+1);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }

    public String get(char num) {
    	String s;
    	switch(num) {
    		case '2':	s = "abc";	break;
    		case '3':	s = "def";	break;
    		case '4':	s = "ghi";	break;
    		case '5':	s = "jkl";	break;
    		case '6':	s = "mno";	break;
    		case '7':	s = "pqrs";	break;
    		case '8':	s = "tuv";	break;
    		case '9':	s = "wxyz";	break;
    		default:s = "";	break;
    	}
    	return s;
    }
}