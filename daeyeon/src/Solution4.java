public class Solution4 {
    public int[][] solution(int[][] arr1, int[][] arr2) {

        int[][] answer = getResultSizeArray(arr1,arr2);

        for (int i=0;i< arr1.length;i++){ //arr1의 행
            for(int k=0; k<arr2[0].length;k++) { //arr2의 열 개수
                int sum = 0;
                for (int j = 0; j < arr1[0].length; j++) { //arr1의 열
                    sum += arr1[i][j] * arr2[j][k];
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

/**
 * ## 과정
 * 1. 결과를 저장할 배열 생성 (m x n , n x k = m x k 크기의 결과 행렬)
 * 2. 중첩 반복문을 사용
 * 3. n번 반복하여 A i번재 행 계산
 * 4. n번 반복후 다음행(i+1) 계산
 * 5. 결과 return
 */
