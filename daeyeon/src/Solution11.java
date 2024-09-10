public class Solution11 {
    boolean solution(String s) {
        s = s.toLowerCase();
        return isSamePY(s);
    }

    private boolean isSamePY(String s) {
        boolean answer = true;
        int count = countPY(s);
        if(count != 0) answer =false;
        return answer;
    }

    public int countPY(String s){
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='p')
                count++;
            else if(s.charAt(i)=='y')
                count--;
        }
        return count;
    }
}
