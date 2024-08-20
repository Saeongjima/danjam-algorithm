public class Solution5 {
    public int[] solution(long n){

        StringBuilder sb = new StringBuilder();
        sb.append(n); //n을 StringBuilder로 변환
        String reverseN = sb.reverse().toString(); //뒤집기
        int[] answer = new int[reverseN.length()];

        for (int i = 0; i < reverseN.length(); i++) {
            char c = reverseN.charAt(i); //문자를 가져옴
            answer[i]=Character.getNumericValue(c);
        }

        return answer;
    }
}
