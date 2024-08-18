public class Solution3 {
    //좌,하,우,상
    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};

    //왼쪽 대각선 상하, 오른쪽 대각선 상하
    private static int [] diagonalX = {-1,-1,1,1};
    private static int[] diagonalY = {-1,1,-1,1};

    //두칸 좌,하,우,상
    private static int[] dx2={-2,0,2,0};
    private static int[] dy2={0,2,0,-2};
    /**
     * 1. 첫번째 자리부터 상,하,좌,우에 P(응시자)가 있는지 확인. 있으면 위반
     * 2. 대각선 상하좌우 방향에 P(응시자)가 있는지 확인. 없으면 통과
     *    - 존재 : 두 응시자 사이에 P이 모두 존재하는지 확인. 두개 모두 파티션이 아니면 위반
     * 3. 5개의 대기실을 반복
     */


    public int[] solution(String[][] places) {
        int[] answer = new int[]{1,1,1,1,1};
        for(int t=0;t<5;t++) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[t][i].charAt(j) != 'P')
                        continue;
                    //상하좌우에 P가 있는지 확인
                    if (!isFollowRuleDXDY(places[t], j, i))
                        answer[t] = 0;

                    //대각선 방향에 P가 있는지 확인
                    if (!isFollowRuleDiagonal(places[t], j, i)) {
                        answer[t] = 0;
                    }

                    //두칸 상하좌우에 P가 있는지 확인
                    if (!isFollowRuleDXDY2(places[t],j,i)){
                        answer[t]=0;
                    }
                }
                if(answer[t]==0)
                    break;
            }
        }
        return answer;
    }

    public boolean isFollowRuleDXDY(String[] places, int x, int y){
        for(int i = 0; i < dx.length; i++){
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            //해당 이동 점이 인덱스를 벗어 났을 경우 확인 안함
            if(moveY < 0 || moveY >= places.length || moveX < 0 || moveX >= places[moveY].length()){
                continue;
            }

            if(places[moveY].charAt(moveX) == 'P'){
                return false;
            }
        }
        return true;
    }

    public boolean isFollowRuleDXDY2(String[] places, int x,int y){
        for(int i = 0; i < dx2.length; i++){
            int moveX = x + dx2[i];
            int moveY = y + dy2[i];

            //해당 이동 점이 인덱스를 벗어 났을 경우 확인 안함
            if(moveY < 0 || moveY >= places.length || moveX < 0 || moveX >= places[moveY].length()){
                continue;
            }

            if(places[moveY].charAt(moveX) == 'P'){
                //한칸 이동한 점이 파티션인지 확인
                int tempX = x +dx[i];
                int tempY = y + dy[i];
                if(places[tempY].charAt(tempX) != 'X')
                    return false;
            }
        }
        return true;
    }

    public boolean isFollowRuleDiagonal(String[] places, int x, int y){
        for(int i =0; i<diagonalX.length;i++){
            int moveX = x + diagonalX[i];
            int moveY = y + diagonalY[i];

            //해당 이동 점이 인덱스를 벗어 났을 경우 확인 안함
            if(moveY < 0 || moveY >= places.length || moveX < 0 || moveX >= places[moveY].length()){
                continue;
            }

            if(places[moveY].charAt(moveX) == 'P'){
                if(places[y].charAt(x+diagonalX[i])!='X')
                    return false;

                if(places[y+diagonalY[i]].charAt(x)!='X')
                    return false;
            }
        }
        return true;
    }
}
