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
    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        String[] reversed = reverseStudentNames(students);

        // Display array in one line
        System.out.println("Reversed Names: " + Arrays.toString(reversed));
    }
    }

