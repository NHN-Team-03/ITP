package exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] array = new double[100];

        int count = 0;

        while(true) {
            double value = Double.valueOf(scanner.nextLine());

            if(value == 0 || count == array.length) {
                break;
            }

            array[count++] = value;
        }

        array = Arrays.copyOf(array, count);

        selectionSort(array);
    }

    private static void selectionSort(double[] array) {

        int checkSize = array.length;

        while (checkSize > 0) {
            checkSize--;

            int maxValuePoint = checkSize;

            for(int i = 0; i < checkSize; i++) {
                if(array[i] > array[maxValuePoint]) {
                    maxValuePoint = i;
                }
            }

            double temp = array[checkSize];
            array[checkSize] = array[maxValuePoint];
            array[maxValuePoint] = temp;
        }

        for(int i = 0; i < array.length; i++) {
            if(i % 10 == 0) {
                System.out.println();
            } 
            System.out.print(array[i] + " ");
        }
    }

}
