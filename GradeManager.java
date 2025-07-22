import java.util.Arrays;

public class GradeManager {
    // Method to reverse student names in an array
    public static String[] reverseStudentNames(String[] names) {
        String[] reversedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            // Use StringBuilder for efficient string reversal
            reversedNames[i] = new StringBuilder(names[i]).reverse().toString();
        }
        return reversedNames;
    }
    // Method to calculate letter grades
    public static char getLetterGrade(int score) {

        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80) {
            return 'B';
        } else if (score >= 70) {
            return 'C';
        } else if (score >= 60) {
            return 'D';
        } else {
            return 'F';
        }


    }
    public static String[] findFailingStudents(String[] names, int[] scores) {
        int count = 0;
        for (int score : scores) {
            if (score < 60) {count++;}
        }
        String[] failingStudents = new String[count];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failingStudents[index++] = names[i];
            }
        }

        return failingStudents;
    }
    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};
        String[] reversed = reverseStudentNames(students);

        // Display array in one line
        System.out.println("Reversed Names: " + Arrays.toString(reversed));
        System.out.println("Student Grades:");
        for (int i = 0; i < students.length; i++) {
            char grade = getLetterGrade(scores[i]);
            System.out.println(students[i] + ": " + scores[i] + " => " + grade);
        }
        String[] failing = findFailingStudents(students, scores);
        System.out.println("\nStudents who need to retake the exam:");
        for (String name : failing) {
            System.out.println(name);
        }




    }
    }

