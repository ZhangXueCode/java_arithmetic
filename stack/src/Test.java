import java.util.HashMap;
import java.util.Stack;

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
    //基本计算器Ⅱ
    public int calculate(String ss) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        char[] s = ss.toCharArray();
        int i = 0,n = s.length;
        while (i < n) {
            if(s[i] == ' ') {
                i++;
            } else if (s[i] >= '0' && s[i] <= '9') {
                int tmp = 0;
                while (i < n && s[i] >= '0' && s[i] <= '9') {
                    tmp *= 10;
                    tmp += s[i] - '0';
                    i++;
                }
                if(op == '+') {
                    stack.push(tmp);
                } else if (op == '-') {
                    stack.push(-tmp);
                } else if (op == '*') {
                    int a = stack.pop();
                    stack.push(a * tmp);
                } else if (op == '/') {
                    int a = stack.pop();
                    stack.push(a / tmp);
                }
            }else {
                if(s[i] == '-' || s[i] == '+' || s[i] == '*' || s[i] == '/') {
                    op = s[i];
                    i++;
                }
            }
        }
        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.pop();
        }
        return ret;
    }
    //字符串解码
    public  String decodeString(String ss) {
        Stack<Integer> st1 = new Stack<>();
        Stack<StringBuilder> st2 = new Stack<>();
        st2.push(new StringBuilder());
        char[] s = ss.toCharArray();
        int n = s.length;
        int i = 0;
        while (i < n) {
            if(s[i] >= '1' && s[i] <= '9') {
                int tmp = 0;
                while (i < n && s[i] >= '1' && s[i] <= '9') {
                    tmp *= 10;
                    tmp += s[i] - '0';
                    i++;
                }
                st1.push(tmp);
            } else if (s[i] == '[') {
                i++;
                StringBuilder stringBuilder = new StringBuilder();
                while (i < n && s[i] >= 'a' && s[i] <= 'z') {
                    stringBuilder.append(s[i]);
                    i++;
                }
                st2.push(stringBuilder);
            } else if (s[i] == ']') {
                int a = st1.pop();
                StringBuilder stringBuilder = new StringBuilder();
                StringBuilder b = st2.pop();
                while (a-- > 0) {
                    stringBuilder.append(b);
                }
                st2.push(stringBuilder);
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                while (i < n && s[i] >= 'a' && s[i] <= 'z') {
                    stringBuilder.append(s[i]);
                    i++;
                }
                st2.peek().append(stringBuilder);
            }
        }
        return st2.pop().toString();

    }




}

