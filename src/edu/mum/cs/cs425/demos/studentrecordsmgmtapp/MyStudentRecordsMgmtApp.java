package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student("110001", "Dave", 1951, 11, 18));
        students.add(new Student("110002", "Anna", 1990, 12, 7));
        students.add(new Student("110003", "Erica", 1974, 1, 31));
        students.add(new Student("110004", "Carlos", 2009, 8, 22));
        students.add(new Student("110005", "Bob", 1990, 3, 5));

        System.out.println("--1--");
        printListOfStudents(students);

        System.out.println("--2--");
        getListOfPlatinumAlumniStudents(students);

        List<Integer> integerList = new ArrayList<>();
        integerList.add(5);
        integerList.add(7);
        integerList.add(35);
        integerList.add(2);
        integerList.add(4);
        System.out.println("--3--");
        printHelloWorld(integerList);

        System.out.println("--4--");
        System.out.println("The second biggest is: " + findSecondBiggest(integerList));
    }

    public static void printListOfStudents(List<Student> input) {
        List<Student> students = input
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .collect(Collectors.toList());
        students.forEach(student -> {
            System.out.println(student.getName());
        });
    }

    public static void getListOfPlatinumAlumniStudents(List<Student> input) {
        List<Student> students = input
                .stream()
                .filter(s -> Math.abs(ChronoUnit.YEARS.between(LocalDate.now(), s.getDateOfAdmission())) >= 30)
                .sorted((o1, o2) -> o2.getDateOfAdmission().compareTo(o1.getDateOfAdmission()))
                .collect(Collectors.toList());
        students.forEach(student -> {
            System.out.println(student.getName());
        });
    }

    public static void printHelloWorld(List<Integer> integersList) {
        for (Integer i : integersList) {
            if (i % 5 == 0 && i % 7 == 0) {
                System.out.println("HelloWorld");
            } else if (i % 5 == 0) {
                System.out.println("Hello");
            } else if (i % 7 == 0) {
                System.out.println("World");
            }
        }
    }

    public static int findSecondBiggest(List<Integer> integersList) {
        int largest = integersList.get(0);
        int secondLargest = integersList.get(0);
        for (int i = 0; i < integersList.size(); i++) {
            if (integersList.get(i) > largest) {
                secondLargest = largest;
                largest = integersList.get(i);
            } else if (integersList.get(i) > secondLargest) {
                secondLargest = integersList.get(i);
            }
        }
        return secondLargest;
    }
}
