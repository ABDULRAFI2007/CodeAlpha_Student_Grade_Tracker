import java.util.Scanner;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class StudentGradeTracker {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numstudents = sc.nextInt();
        sc.nextLine();

        double totalmarks = 0;

        ArrayList<String> studentsname = new ArrayList<>();
        ArrayList<String> rollnumbersList = new ArrayList<>();
        ArrayList<Integer> grades = new ArrayList<>();
        ArrayList<String> resultStatus = new ArrayList<>();
        ArrayList<String> gradeLetter = new ArrayList<>();

        Set<String> rollnumbersSet = new HashSet<>();

        while (grades.size() < numstudents) {

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            if (!name.matches("[a-zA-Z]+")) {
                System.out.println("Invalid name. Use alphabets only.");
                continue;
            }

            System.out.print("Enter Roll Number: ");
            String rollnum = sc.nextLine();

            if (rollnumbersSet.contains(rollnum)) {
                System.out.println("Duplicate roll number. Enter a unique one.");
                continue;
            }

            System.out.print("Enter Student Marks (0 to 100): ");
            int mark = sc.nextInt();
            sc.nextLine();

            if (mark < 0 || mark > 100) {
                System.out.println("Invalid marks. Enter between 0 to 100.");
                continue;
            }

            String result = (mark >= 35) ? "Pass" : "Fail";

            String grade;
            if (mark >= 90) {
                grade = "A+";
            } else if (mark >= 75) {
                grade = "A";
            } else if (mark >= 60) {
                grade = "B";
            } else if (mark >= 50) {
                grade = "C";
            } else if (mark >= 35) {
                grade = "D";
            } else {
                grade = "Fail";
            }

            studentsname.add(name);
            rollnumbersList.add(rollnum);
            rollnumbersSet.add(rollnum);
            grades.add(mark);
            resultStatus.add(result);
            gradeLetter.add(grade);

            totalmarks += mark;
        }

        System.out.println("Class Statistics");
        System.out.println("Highest Mark : " + Collections.max(grades));
        System.out.println("Lowest Mark  : " + Collections.min(grades));
        System.out.println("Average Mark : " + (totalmarks / grades.size()));

        System.out.println("Student Summary Report");
        System.out.println("Name\tRoll No\tMarks\tResult\tGrade");

        for (int i = 0; i < studentsname.size(); i++) {
            System.out.println(
                studentsname.get(i) + "\t" +
                rollnumbersList.get(i) + "\t" +
                grades.get(i) + "\t" +
                resultStatus.get(i) + "\t" +
                gradeLetter.get(i)
            );
        }

        sc.close();
    }
}
