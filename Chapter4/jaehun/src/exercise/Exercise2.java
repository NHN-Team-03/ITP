package Chapter4.jaehun.src.exercise;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        int value = 0;
        int hexInt;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter: ");
        
        String str = scanner.nextLine();
        for(int i = 0; i < str.length(); i++) {
            hexInt = hexValue(str.charAt(i));

            if(hexInt == -1) {
                throw new IllegalArgumentException();
            }
            value = value * 16 + hexInt;
        }

        System.out.println(value);

        scanner.close();
    }

    public static int hexValue(char hexChar) {
        int hexInt = 0;
        switch(hexChar) {
            case 'A':
                hexInt = 10;
                break;
            case 'B':
                hexInt = 11;
                break;
            case 'C':
                hexInt = 12;
                break;
            case 'D':
                hexInt = 13;
                break;
            case 'E':
                hexInt = 14;
                break;
            case 'F':
                hexInt = 15;
                break;
            default:
                try{
                    hexInt = Integer.parseInt(Character.toString(hexChar));
                } catch(NumberFormatException exception) {
                    return -1;
                }

        }

        return hexInt;
    }
}
