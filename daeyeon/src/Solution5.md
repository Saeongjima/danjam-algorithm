[//]: # (문제 풀이 템플릿)
# Problem 💻 : 자연수 뒤집어 배열로 만들기 - Level1
https://school.programmers.co.kr/learn/courses/30/lessons/12932
## 문제
자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요. 예를들어 n이 12345이면 [5,4,3,2,1]을 리턴합니다.
## 제한사항
- n은 10,000,000,000이하인 자연수입니다.

## 입력
n = 12345

## Return
[5,4,3,2,1]

---
# Approach 1 ⭕
## 과정
1. n을 String으로 변환한다.
2. reverse 함수를 사용하여 뒤집는다.
3. String -> int[]로 변환한다.

# 이것만은 기억하자💡
1. StringBuilder의 기대 시간 복잡도는 O(1)이다. \
하지만 일반 String에 계속해서 문자를 추가할경우 기존 문자열을 복사하는 과정이 필요하기 때문에 O(n)의 시간이 소요된다. \
문자열을 추가, 삭제 혹은 변경을 많이할경우 StringBuilder를 활용하자

2. 함수를 활용하지 않아도 간단하게 '0'을 빼주면 해당 문자의 숫자값을 얻을 수 있다.
```java
answer[i]=Character.getNumericValue(c);

char digit = '9';
int digitToInt = digit - '0';
```

# Reference 📄
- [Char배열 to Int 배열](https://www.baeldung.com/java-convert-char-int-array)
- [Java 공식문서](https://docs.oracle.com/javase/8/docs/api/)
