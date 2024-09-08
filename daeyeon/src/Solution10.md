[//]: # (문제 풀이 템플릿)
# Problem 💻 : 이진 변환 반복하기 - Level2
https://school.programmers.co.kr/learn/courses/30/lessons/70129
## 문제
0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

1. x의 모든 0을 제거합니다.\
2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.\

예를 들어, x = "0111010"이라면, x에 이진 변환을 가하면 x = "0111010" -> "1111" -> "100" 이 됩니다.

0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.
## 제한사항
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다
## 입출력
s = "110010101001" 
result = [3,8]

s = "01110"
result = [3,3]

s = "1111111"
result = [4,1]


# Approach 1 
## 과정
1. 0을 찾는다.
2. 개수를 기록한다. 0을 삭제한다.
3. 2진수로 변환한다.
## 수도코드
```
roop = 0;
zeronCount = 0

while(s.equals("1"){
    int countZero(String s)
    String deleteZero(String s)
    Integer.pareseInt(s,2);
}
```
## 틀린 이유
없음

# 이것만은 기억하자💡
없음

# Reference 📄
- [문자열에서 특정 문자 개수 구하는 3방법](https://hianna.tistory.com/540)
- [문자열에서 특정 문자 개수 구하는 방법 using stream](https://adjh54.tistory.com/173)

