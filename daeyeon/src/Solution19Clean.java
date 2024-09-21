import java.util.ArrayList;
import java.util.List;

public class Solution19Clean {
    public int[] solution(int brown, int yellow) {
        return process(brown,yellow);
    }


    private int[] process(int brown, int yellow){
        int[] answer = new int[2];
        List<int[]> yellowBoxCandidates = getYelloBoxCandidates(yellow);
        for (int[] yellowBoxCandidate : yellowBoxCandidates) {
            int brownBoxCount = getBrownBoxCount(yellowBoxCandidate);
            if(brownBoxCount == brown){
                 answer = getBoxSize(yellowBoxCandidate);
                 break;
            }
        }
        return answer;
    }

    // yellowBox의 가로와 세로 후보군을 구하는 메소드
    private List<int[]> getYelloBoxCandidates(int yellow){
        List<int[]> yellowBoxCandidates = new ArrayList<>();
        for (int i = 1; i <= yellow; i++) {
            if(yellow%i==0){
                int width = yellow/i;
                int height = i;
                if(width < height)
                    break;
                yellowBoxCandidates.add(new int[]{width, height});
            }
        }
        return yellowBoxCandidates;
    }

    // 전체 brown 박스 개수를 구하는 메소드
    private int getBrownBoxCount(int[] yellowBox){
        return (yellowBox[0] + yellowBox[1]) * 2 + 4;
    }

    // 박스의 가로, 세로를 구하는 메소드
    private int[] getBoxSize(int[] yellowBox){
        return new int[]{yellowBox[0] + 2, yellowBox[1] + 2};
    }
}
