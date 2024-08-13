import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        //n 을 10으로 나눠, 한 자리씩 지우면서 더하는 방식
        while(n > 0) {
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }
}