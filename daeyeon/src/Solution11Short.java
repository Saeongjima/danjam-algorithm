public class Solution11Short {
    boolean solution(String s) {
        s = s.toLowerCase();
        return s.chars().filter(e-> 'p' == e).count() == s.chars().filter(e-> 'y'== e).count();
    }
}
