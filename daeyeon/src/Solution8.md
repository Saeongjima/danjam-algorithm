[//]: # (문제 풀이 템플릿)
# Problem 💻 : 문자열 압축 - Level2
https://school.programmers.co.kr/learn/courses/30/lessons/60057
## 문제
데이터 처리 전문가가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다. 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데, 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여서 표현하는 알고리즘을 공부하고 있습니다.
간단한 예로 "aabbaccc"의 경우 "2a2ba3c"(문자가 반복되지 않아 한번만 나타난 경우 1은 생략함)와 같이 표현할 수 있는데, 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다. 예를 들면, "abcabcdede"와 같은 문자열은 전혀 압축되지 않습니다. "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.

예를 들어, "ababcdcdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만, 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd"로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면 "2ababcdcd"로 표현할 수 있으며, 이때가 가장 짧게 압축하여 표현할 수 있는 방법입니다.

다른 예로, "abcabcdede"와 같은 경우, 문자를 2개 단위로 잘라서 압축하면 "abcabc2de"가 되지만, 3개 단위로 자른다면 "2abcdede"가 되어 3개 단위가 가장 짧은 압축 방법이 됩니다. 이때 3개 단위로 자르고 마지막에 남는 문자열은 그대로 붙여주면 됩니다.

압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요.
## 제한사항
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다
## 입력
"aabbaccc"	-> 2a2ba3c \
"ababcdcdababcdcd" -> 2ababcdcd \
"abcabcdede" -> 2abcdede \
"abcabcabcabcdededededede" -> 2abcabc2dedede \ 
"xababcdcdababcdcd"	 -> x2ababcdcd

## 출력
7
9
8
14
17

# Approach 1 
## 과정
1. 1개,2개,3개...씩 길이를 설정하며 자른다. 
2. 문자열을 비교하며 압축한다.
3. 가장 작았을 때 개수를 저장한다.
3. 자르는 개수가 문자열 전체길이의 반이상으로 넘어갔을때 압축을 종료한다.
```
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String s){
        int minResult = Integer.MAX_VALUE;
        for(int length =1 ;length<=s.length()/2;length++){
            int compressedLength = compress(s,length);
            if(minResult > compressedLength){
                minResult = compressedLength;
            }
        }
        return minResult;
    }

    //압축한 문자열 길이 반환
    private int compress(String s, int length){
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
```
```java
import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(String s){
        int minResult = Integer.MAX_VALUE;
       if(s.length()==1){
          minResult=1;
       }
        for(int length =1 ;length<=s.length()/2;length++){
            int compressedLength = compress(s,length);
            if(minResult > compressedLength){
                minResult = compressedLength;
            }
        }
        return minResult;
    }

    //압축한 문자열 길이 반환
    private int compress(String s, int length){
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
```
## 틀린 이유
예외 케이스인 문자열의 길이가 1개일 때 틀렸었다. 이유는 효율적으로 짜기 위해서 length/2까지만 반복했는데 length가 1이면 한번도 실행 되지 않았다.
그래서 예외로 if문을 통해 하나일경우 minResult=1로 설정하였다.

# 이것만은 기억하자💡
너무 복잡하게 생각하지말자. 문제에 집중하자. 복잡한 로직은 코드도 복잡해진다. 어차피 그렇게 못풀고 못짠다.
