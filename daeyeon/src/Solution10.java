public class Solution10 {

    public int[] solution(String s) {
        int[] answer = {};
        int roop = 0;
        int zeroCounts = 0;
        while(s.length() > 1){
            zeroCounts+=countZero(s); //0 개수를 더함
            s = deleteAllZero(s); //문자열에서 모든 0 삭제
            s = Integer.toString(s.length(),2); //문자열의 길이를 2진수로 변환
            roop++;
        }
        answer = new int[]{roop,zeroCounts};
        return answer;
    }

    int countZero(String s){
        return (int)s.chars().filter(i -> (char)i=='0').count();
    }

    String deleteAllZero(String s){
        return s.toString().replaceAll("0", "");
    }
}
/**
 * roop = 0;
 * zeronCount = 0
 *
 * while(s.equals("1"){
 *     int countZero(String s)
 *     String deleteZero(String s)
 *     Integer.pareseInt(s,2);
 * }
 */