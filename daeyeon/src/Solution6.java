public class Solution6 {
    public String solution(String s, int n) {

        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char changeC = ' ';
            if(c>='A'&&c<='Z'){
                int alphaOrder = c - 'A'; //몇번째 알파벳인지
                int changeAlphaOrder = (alphaOrder + n) % 26;
                changeC = (char)(changeAlphaOrder + 'A');
            }
            else if(c>='a'&&c<='z'){
                int alphaOrder = c - 'a'; //몇번째 알파벳인지
                int changeAlphaOrder = (alphaOrder + n) % 26; //알파벳은 총 26개. 그 이상일 경우 처음 알파벳 순번으로 돌아가게 함.
                changeC = (char)(changeAlphaOrder + 'a');
            }
            sb.append(changeC);
        }
        answer = sb.toString();
        return answer;
    }
}
