package LeetCode100Days;

public class DAY36_Q1700 {

    public int countStudents(int[] students, int[] sandwiches) {

        int n = students.length;
        int count[] = new int[2]; // count[0] = circular, count[1] = square

        // Count number of each type of student
        for (int num : students) {
            count[num]++;
        }

        // Go through each sandwich
        for (int i = 0; i < n; i++) {
            int sand = sandwiches[i];

            // If no student wants this sandwich, stop
            if (count[sand] == 0) {
                return n - i;
            }

            // One student takes this sandwich
            count[sand]--;
        }

        return 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        DAY36_Q1700 obj = new DAY36_Q1700();

        int[] students = {1, 1, 0, 0};
        int[] sandwiches = {0, 1, 0, 1};

        int result = obj.countStudents(students, sandwiches);
        System.out.println("Number of students unable to eat lunch: " + result);
    }
}
