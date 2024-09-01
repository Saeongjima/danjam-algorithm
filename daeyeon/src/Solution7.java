import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Solution7 {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<String> words = splitSentence(s);
        for (String word : words) {
            String modifiedWord = modifiedUpperLower(word);
            sb.append(modifiedWord);
        }
        answer = sb.toString();
        return answer;
    }

    public List<String> splitSentence(String s) {
        StringTokenizer stringTokenizer = new StringTokenizer(s, " ",true);
        List<String> words = new ArrayList<>();
        while (stringTokenizer.hasMoreTokens()) {
            words.add(stringTokenizer.nextToken());
        }
        return words;
    }

    public String modifiedUpperLower(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                char c = s.charAt(i);
                c = Character.toUpperCase(c);
                sb.append(c);
            } else {
                char c = s.charAt(i);
                c = Character.toLowerCase(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}