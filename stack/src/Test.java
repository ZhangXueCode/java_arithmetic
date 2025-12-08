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
}
