import java.util.ArrayList;
import java.util.List;

public class Solution18 {

    public int[] solution(int[] answers) {
        int[] answer = {};

        int[][] students = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] studentsScore = new int[3];

        for(int i=0;i<students.length;i++){
            studentsScore[i]=grading(answers, students[i]);
            System.out.println("studentsScore = " + studentsScore[i]);
        }

        List<Integer> highestStudents= getHighestStudents(studentsScore);
        for (Integer highesStudne : highestStudents) {
            System.out.println("highesStudne = " + highesStudne);
        }
        return highestStudents.stream().mapToInt(i->i).toArray();
    }

    private int grading(int[] answers, int[] student){
        int score = 0;
        int index = 0;
        for (int answer : answers) {
            if(answer == student[index])
                score++;
            index++;
            if(index%student.length==0){
                index=0;
            }
        }
        return score;
    }

    private List<Integer> getHighestStudents(int[] studentsScore){
        List<Integer> highestStudents = new ArrayList<>();
        int highestScore=Integer.MIN_VALUE;
        for(int i=0;i<studentsScore.length;i++){
            if(studentsScore[i]>highestScore){
                highestScore = studentsScore[i];
                highestStudents.clear();
                highestStudents.add(i+1);
            }
            else if(studentsScore[i] == highestScore){
                highestStudents.add(i+1);
            }
        }
        return highestStudents;
    }


}
