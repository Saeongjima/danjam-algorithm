import java.util.ArrayList;
import java.util.List;

public class Solution17 {

    private static final char[] alphabets = {'A', 'E', 'I', 'O', 'U'};

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        generate("", words);
        return words.indexOf(word);
    }
    public void generate(String word, List<String> words){
        words.add(word);

        if(word.length() == 5) return;
        for (char alphabet : alphabets) {
            generate(word+alphabet, words);
        }
    }
}
