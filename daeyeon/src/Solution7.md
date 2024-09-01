[//]: # (문제 풀이 템플릿)
# Problem 💻 : 이상한 문자 만들기 - Level1
https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=java
## 문제
- 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 
- 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
- 각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
## 제한사항
- 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
- 첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
## 입력
s="try hello world"

## 출력
"TrY HeLlO WoRlD"

# Approach 1 ❌
## 과정
1. 문자열을 단어 단위로 나눈다.
2. 반복문을 통해 하나의 단어에 접근한다.
3. 해당 단어의 문자 하나씩 반복문을 통해 접근
4. 짝수번째 인덱스는 대문자, 홀수번째 인덱스는 소문자로 변환한다.

```java
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        String[] words = splitSentence(s);
        for (String word : words) {
            String modifiedWord = modifiedUpperLower(word);
            sb.append(modifiedWord).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        answer = sb.toString();
        return answer;
    }

    public String[] splitSentence(String s){
        return s.split(" ");
    }

    public String modifiedUpperLower(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                char c = s.charAt(i);
                c = Character.toUpperCase(c);
                sb.append(c);
            }
            else {
                char c = s.charAt(i);
                c = Character.toLowerCase(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
## 틀린 이유
split는 빈문자열을 토큰으로 인식하는 반면, StringTokenizer는 빈 문자열을 토큰으로 인식하지 않는다.
예를 들어 보자  
String data = "100,,,200,300"; 가 있다고 했을 때 split 결과는 100 '' '' 200 300 총 5개로 나누어진다.
하지만 StringTokenizer를 사용하면 100 200 300 으로 총 3개로 나누어진다.
# Approach 2 ❌⭕
## 과정
1. 문자열을 단어 단위로 나눈다.
2. 반복문을 통해 하나의 단어에 접근한다.
3. 해당 단어의 문자 하나씩 반복문을 통해 접근
4. 짝수번째 인덱스는 대문자, 홀수번째 인덱스는 소문자로 변환한다.


```java
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        List<String> words = splitSentence(s);
        for (String word : words) {
            String modifiedWord = modifiedUpperLower(word);
            sb.append(modifiedWord).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        answer = sb.toString();
        return answer;
    }

    public List<String> splitSentence(String s){
        StringTokenizer stringTokenizer = new StringTokenizer(s," ");
        List<String> words = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens()){
            words.add(stringTokenizer.nextToken());
        }
        return words;
    }

    public String modifiedUpperLower(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(i%2==0){
                char c = s.charAt(i);
                c = Character.toUpperCase(c);
                sb.append(c);
            }
            else {
                char c = s.charAt(i);
                c = Character.toLowerCase(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
```
## 틀린 이유
생각해보니 위에 solution1에서 틀린 이유는 올바르지 못하다. 오히려 공백이 여러개 있다면 포함해야 올바른 풀이이다.
그러므로 해당 풀이는 틀렸다.
결국 문제는 맨 앞, 맨뒤에 붙는 공백에서 문제가 생겼다. 


# Approach 3 ⭕
## 과정
1. 문자열을 단어 단위로 나눈다.
2. 반복문을 통해 하나의 단어에 접근한다.
3. 해당 단어의 문자 하나씩 반복문을 통해 접근
4. 짝수번째 인덱스는 대문자, 홀수번째 인덱스는 소문자로 변환한다.

## 차이점
맨 앞, 맨뒤 공백에서 문제가 생겼다.
StringTokenizer 옵션 중
구분자를 문자열 자르는데에 사용되는 것 뿐만 아니라 토큰으로도 지정할 수도 있다. \
이것을 활용하여 문제를 해결 하였다.
```java
StringTokenizer stringTokenizer = new StringTokenizer(s, " ",true);
```
true시 해당 구분자를 포함. false(디폴트)시 해당 구분자를 미포함

# 이것만은 기억하자💡
추가 클래스 및 메서드를 사용하지 않고도 인덱스를 활요하는 풀이도 존재한다. 상황에 맞게 사용하면 좋을 것 같다.

# Reference 📄
- [split과 StringTokenizer 비교](https://inpa.tistory.com/entry/JAVA-%E2%98%95-Split-StringTokenizer-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%9E%90%EB%A5%B4%EA%B8%B0-%EB%B9%84%EA%B5%90%ED%95%98%EA%B8%B0)

