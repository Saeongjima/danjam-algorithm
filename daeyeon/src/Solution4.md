[//]: # (문제 풀이 템플릿)
# Problem 💻 : 행렬의 곱셈
https://school.programmers.co.kr/learn/courses/30/lessons/12949
## 문제
2차원 행렬 arr1과 arr2를 입력받아, arr1에 arr2를 곱한 결과를 반환하는 함수, solution을 완성해주세요.
## 제한사항
- 행렬 arr1, arr2의 행과 열의 길이는 2 이상 100 이하입니다.
- 행렬 arr1, arr2의 원소는 -10 이상 20 이하인 자연수입니다.
- 곱할 수 있는 배열만 주어집니다.## 입력

## 입력
arr1 : [[1, 4], [3, 2], [4, 1]]
arr2 : [[3, 3], [3, 3]]

## 출력
[[15, 15], [15, 15], [15, 15]]

---

# Approach 1 ❌
행렬의 곱샘은 첫번째 행렬은 가로 방향, 두번째 행렬은 세로 방향으로 곱한후 덧셈하는 형식으로 이루어진다. \
<img src="https://velog.velcdn.com/images%2Ftreejy%2Fpost%2Fe1c5ecc5-8a52-4891-aa04-b31db57f85e5%2Fimage.png">
이를 2차원 배열로 나타내 보자 \
A[0][0] X B[0][0] + A[0][1] X B[1][0] = C[0][0]\
A[0][0] X B[0][1] + A[0][1] X B[1][1] = C[0][1]
이런식이다.

## 과정
1. 결과를 저장할 배열 생성 (m x n , n x k = m x k 크기의 결과 행렬)
2. 중첩 반복문을 사용
3. n번 반복하여 A i번재 행 계산
4. n번 반복후 다음행(i+1) 계산
5. 결과 return

## 헷갈렸던 점
- 테스트 3,8,31을 통과 못함

### case 1.
```
{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
{"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
{"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
{"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
```

### 코드
```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = getResultSizeArray(arr1,arr2);

        for (int i=0;i< arr1.length;i++){ //arr1의 행
            for(int k=0; k<arr2[0].length;k++) { //arr2의 열 개수
                int sum = 0;
                for (int j = 0; j < arr1[0].length; j++) { //arr1의 열
                    sum += arr1[i][j] * arr2[k][j];
                }
                answer[i][k] = sum;
            }
        }

        return answer;
    }

    private int[][] getResultSizeArray(int[][] arr1, int[][] arr2){
        int width =  arr1.length;
        int height = arr2[0].length;

        return new int[width][height];
    }
}
```

### 결론
#### 중첩 반복문이 아닌 3중 반복문을 사용
총 연산은 m x n이 아니라 m x k x n이다. 하지만 중첩 반복문만으로도 해결된다고 생각하였다.

#### 행과 열의 잘못된  사용
잘못된 인덱스로 접근했다. j는 arr2의 행, k는 arr2의 열이다. 행이 먼저 1일씩 증가하기때문이다. \
하지만 현재 코드에서는 arr2의 행과 열의 변수가 변했다. 특정상황에서는 정답으로 나왔지만 다른 케이스에서 오답으로 틀렸다.
---

# Approach 2 ⭕
1. 결과를 저장할 배열 생성 (m x n , n x k = m x k 크기의 결과 행렬)
2. 3중 반복문을 사용
3. m번 반복하여 A i번재 행 계산
4. n번 반복하여 B의 k번째 열 계산
5. A의 열개수만큼 j번 반복하여 모두 더한 sum을 구한다음 해당 배열 위치에 저장.
6. 결과 return

# Reference 📄

- [열쇠 소유 여부 체크](https://moonsbeen.tistory.com/358)
- [열쇠 비트 연산 설명](https://gaybee.tistory.com/37)
- [visited 배열 2차원이 안되는 이유](https://yamyam-spaghetti.tistory.com/45)
- [로직 설명](https://evecomcom.tistory.com/32)