import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 문제 url : https://school.programmers.co.kr/learn/courses/30/lessons/87377?language=java
 * 난이도 : level2
 * 문제이름 : 교점에 별만들기
 */

public class IntersectionStar {
    public static void main(String[] args) {
        long[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        String[] solution = solution(line);
        System.out.println(Arrays.toString(solution));
    }

    private static class Point{
        long x;
        long y;

        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    public static String[] solution(long[][] line) {
        List<Point> meetPoints = new ArrayList<>();
        for(int i =0; i<line.length-1;i++){
            for(int j=i+1; j<line.length;j++){
                long[] line1 = line[i];
                long[] line2 = line[j];
                Point meetPoint = getMeetPoint(line1,line2);
                if(meetPoint ==null) //교점이 정수가 아닌결우
                    continue;
                meetPoints.add(meetPoint);
            }
        }

        //교점의 최대 최소. 출력을 위한 2차원 배열의 크기 및 평행이동을 위함.
        long minX = Long.MAX_VALUE;
        long minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long maxY = Long.MIN_VALUE;

        for (Point meetPoint : meetPoints) {
            if(meetPoint.x < minX)
                minX=meetPoint.x;
            if(meetPoint.x > maxX)
                maxX=meetPoint.x;
            if(meetPoint.y < minY)
                minY=meetPoint.y;
            if(meetPoint.y > maxY)
                maxY=meetPoint.y;
        }

        int height = (int)(maxY-minY+1);
        int width = (int)(maxX-minX+1);

        //출력을 위한 2차원배열 생성
        char[][] arr = new char[height][width];
        for (char[] row : arr) {
            Arrays.fill(row,'.');
        }

        //평행이동 및 헤딩 점을 *로 변환
        for (Point meetPoint : meetPoints) {
            int x=(int)(meetPoint.x-minX);
            int y=(int)(maxY-meetPoint.y);
            arr[y][x]='*';
        }

        String[] board = new String[arr.length];
        for(int i = 0; i<board.length;i++)
            board[i]=new String(arr[i]);
        return board;

    }

    //두 직선의 교점을 구하는 메서드
    private static Point getMeetPoint(long[] line1, long[] line2) {

        long a = line1[0];
        long b = line1[1];
        long e = line1[2];

        long c = line2[0];
        long d = line2[1];
        long f = line2[2];

        try{
            double x = (double)(b*f-e*d)/(a*d-b*c);
            double y = (double)(e*c-a*f)/(a*d-b*c);
            //교차점이 정수일 경우
            if(x==(long)x && y ==(long)y){
                return new Point((long)x,(long)y);
            }
        } catch(ArithmeticException k){
            return null;
        }
        return null;
    }
}
