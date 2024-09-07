public class Solution9 {
    public int solution(int n) {
        int answer = 0;
        String base3 = Integer.toString(n,3);
        String reverseBase3 = new StringBuilder(base3).reverse().toString();
        answer = Integer.parseInt(reverseBase3,3);
        return answer;
    }

//    String reverseString(String s){
//        StringBuilder builder = new StringBuilder();
//        for (int index = s.length()-1; index >= 0 ; index--) {
//            builder.append(s.charAt(index));
//        }
//        return builder.toString();
//    }

}
