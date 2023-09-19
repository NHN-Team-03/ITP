package exercise;

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

        sort(array, count);
    }

    private static void sort(double[] array, int count) {
        double[] sortArray = new double[count];

        for(int i = 0; i < sortArray.length; i++) {
            sortArray[i] = array[i];
        }

        int checkSize = sortArray.length;

        while (checkSize > 0) {
            checkSize--;

            int maxValuePoint = checkSize;

            for(int i = 0; i < checkSize; i++) {
                if(sortArray[i] > sortArray[maxValuePoint]) {
                    maxValuePoint = i;
                }
            }

            double temp = sortArray[checkSize];
            sortArray[checkSize] = sortArray[maxValuePoint];
            sortArray[maxValuePoint] = temp;
        }

        for(int i = 0; i < sortArray.length; i++) {
            if(i % 10 == 0) {
                System.out.println();
            } 
            System.out.print(sortArray[i] + " ");
        }
    }

}
