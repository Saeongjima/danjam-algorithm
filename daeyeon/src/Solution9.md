[//]: # (문제 풀이 템플릿)
# Problem 💻 : 3진법 뒤집기 - Level1
https://school.programmers.co.kr/learn/courses/30/lessons/68935
## 문제
자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
## 제한사항
s의 길이는 1 이상 1,000 이하입니다.
s는 알파벳 소문자로만 이루어져 있습니다
## 입출력
n=45	result=7
n=125   result=229

# Approach 1 
## 과정
1. 3진법으로 숫자 변환
2. 문자열의 앞 뒤를 반전시킨다.
3. 문자열을 10진법으로 변환시킨다.

## 수도코드
```
Integer.parseInt(num, 3);
String reverseStrin(str);
Integer.parseInt(str,10);
```
## 틀린 이유
없음

# 이것만은 기억하자💡
없음