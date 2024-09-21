public class Solution19 {

    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        return process(brown,yellow);
    }


    private int[] process(int brown, int yellow){
        int height = 0;
        int width = 0;
        int[] result = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if(yellow%i==0){

                width = yellow/i;
                height = i;

                if(width < height)
                    break;
                int calBrown = (width + height) * 2 + 4;
                if(calBrown == brown) {
                    result[0] = width + 2;
                    result[1] = height + 2;
                    break;
                }
            }
        }
        return result;
    }

}

/**
 - yellow의 약수 중 가로, 세로를 구한다. 가로가 세로보다 크다.
 - yellow의 약수를 가지고 brown의 조건을 만족하는지 확인한다.
 - (가로 + 세로) * 2 + 4 == brown
 - 조건을 만족하면 return한다.
 */