import java.util.ArrayList;
import java.util.List;

public class Solution15 {
    public int[] solution(int[][] arr) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        int n = arr.length;
        result = press(arr, n, 0, 0, result);
        answer = countZeroOne(result);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(i+" : " + answer[i]);
        }
        return answer;
    }

    public List<Integer> press(int[][] arr, int n, int startY, int startX, List<Integer> result){
        for (int i = 0; i < startY+n; i++) {
            for (int j = 0; j < startX+n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");

        // 종료조건
        if(isElementsSame(arr,startY,startX, n)){
            result.add(arr[startY][startX]);
            return result;
        }
        if(n == 1){
            result.add(arr[startY][startX]);
        }

        // 4등분
        press(arr, n/2, startY,startX, result);
        press(arr, n/2, startY+n/2,startX, result);
        press(arr, n/2, startY,startX+n/2, result);
        press(arr, n/2, startY+n/2,startX+n/2, result);
        return result;
    }

    public boolean isElementsSame(int[][] arr, int startY,int startX, int n){
        int start = arr[startY][startX];
        for (int i = startY; i < startY+n; i++) {
            for (int j = startX; j < startX+n; j++) {
                if(start != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    public int[] countZeroOne(List<Integer> compressList){
        int[] answer = new int[2];
        for (Integer i : compressList) {
            if(i == 0){
                answer[0]++;
            }else{
                answer[1]++;
            }
        }
        return answer;
    }
}

/**
 * - 상태 = (n)
 * - 종료조건 = 2^n x 2^n 정사각형 모든 숫자가 같음 or n=0일 경우 종료
 * - press(n-1, 출발점, result)
 */