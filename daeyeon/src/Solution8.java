import java.util.ArrayList;
import java.util.List;

public class Solution8 {
    public int solution(String s){
        int minResult = Integer.MAX_VALUE;

        if(s.length()==1){
            minResult=1;
        }
        for(int length =1 ;length<=s.length()/2;length++){
            int compressedLength = compressed(s,length);
            if(minResult > compressedLength){
                minResult = compressedLength;
            }
        }
        return minResult;
    }

    //압축한 문자열 길이 반환
    private int compressed(String s, int length){
        StringBuilder builder = new StringBuilder();
        List<String> tokens = cuttingString(s,length);
        String last = "";
        int count = 1;
        for (String token : tokens) {
            if(token.equals(last)){
                count++;
            } else{
                if(count>=2)
                    builder.append(count);
                builder.append(last);
                last = token;
                count = 1;
            }
        }
        if(count>=2)
            builder.append(count);
        builder.append(last);
        return builder.length();
    }

    //문자열 자르기
    private List<String> cuttingString(String s, int length){
        List<String> tokens = new ArrayList<>();
        for(int startIndex = 0; startIndex < s.length(); startIndex += length){
            int endIndex = startIndex + length;
            if(endIndex > s.length())
                endIndex = s.length();
            tokens.add(s.substring(startIndex,endIndex));
        }
        return tokens;
    }


}

/**
 * ```
 * minResult=100000;
 * for(i=0;i<length/2;i++){
 *    List cutstring = 2개씩 자르기
 *    result = 0
 *    count = 0
 *    for(;;){
 *       if(뒤에 문자열과 같으면)
 *          count++
 *      else(다르면)
 *          count=0
 *          result += count자릿수 + 자르는 갯수 i
 *    }
 *    if(result<minResult)
 *       minResult=result;
 * }
 * ```
 */