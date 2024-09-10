import java.util.Map;

public class Solution12 {
    public int solution(String s) {
        Map<String,String> number = Map.of(
                "0", "zero",
                "1", "one",
                "2", "two",
                "3", "three",
                "4", "four",
                "5", "five",
                "6", "six",
                "7", "seven",
                "8", "eight",
                "9", "nine"
        );
        for (String i : number.keySet()) {
            s = s.replace(number.get(i),i);
        }
        return Integer.parseInt(s);
    }
}
