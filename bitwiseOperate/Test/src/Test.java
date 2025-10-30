public class Test {
    //判断字符是否唯一
    public boolean isUnique(String astr) {
        int bitMap = 0;
        for (int i = 0; i < astr.length(); i++) {
            int x = astr.charAt(i) - 'a';
            if(((bitMap >> x) & 1) == 1) {
                return false;
            }
            bitMap |= 1 << x;
        }
        return true;
    }
}
