public class 프로그래머스_평균구하기_java_유다인 {
    class Solution {
        public double solution(int[] arr) {
            double answer = 0;

            for(int a: arr) {
                answer += a;
            }

            return (answer / arr.length);
        }
    }
}
