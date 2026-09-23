import java.util.*;

class ArrayUtils {
    public static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static <T> void printArray(T[] array) {
        for (T item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}

class Student implements Comparable<Student> {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + "(" + score + ")";
    }
}

public class Solution {
    public static void main(String[] args) {
        Integer[] a = {5, 1, 3, 2};
        String[] b = {"Java", "C++", "Python"};
        Student[] c = {
                new Student("Lan", 8.5),
                new Student("An", 9.0),
                new Student("Binh", 7.8)
        };

        ArrayUtils.sort(a);
        ArrayUtils.sort(b);
        ArrayUtils.sort(c);

        ArrayUtils.printArray(a);
        ArrayUtils.printArray(b);
        ArrayUtils.printArray(c);
    }
}