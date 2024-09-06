public class Solution6_1 {
    public String solution(String s, int n) {

        String answer = "";
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int base = getBase(c);
            if(base == 0){
                sb.append(c);
                continue;
            }

            int alphabetOrder = getAlphabetOrder(c, base);
            int changedAlphabetOrder = moveAlphabetOrder(alphabetOrder, n);
            char changedC = getChangedC(changedAlphabetOrder, base);
            sb.append(changedC);
        }
        answer = sb.toString();
        return answer;
    }

    int getBase(char c){
        if(Character.isUpperCase(c)){
            return 'A';
        }
        else if(Character.isLowerCase(c)){
            return 'a';
        }
        return 0;
    }

    int getAlphabetOrder(char c, int base){
        return c - base;
    }
    int moveAlphabetOrder(int alphabetOrder, int n){
        return (alphabetOrder + n) % 26;
    }
    char getChangedC(int changedAlphabetOrder, int base){
        return (char)(changedAlphabetOrder + base);
    }
}

