import java.util.HashMap;

public class Test {
    //删除字符中所有相邻重复元素
    public String removeDuplicates(String s) {
        StringBuilder a = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(a.isEmpty()) {
                a.append(c);
                continue;
            }
            if(c == a.charAt(a.length() - 1)) {
                a.deleteCharAt(a.length() - 1);
            }else {
                a.append(c);
            }
        }
        return a.toString();
    }
    //比较含退格的字符串
    public boolean backspaceCompare(String s, String t) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != '#') {
                s1.append(c);
            }else {
                if(!s1.isEmpty()) {
                    s1.deleteCharAt(s1.length() - 1);
                }
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(c != '#') {
                s2.append(c);
            }else {
                if(!s2.isEmpty()) {
                    s2.deleteCharAt(s2.length() - 1);
                }
            }
        }
        return s1.toString().equals(s2.toString());

    }



}

