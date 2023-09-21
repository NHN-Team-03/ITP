package Chapter8.yongjun.src.exercise.exercise2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Exercise2 {
static final BigInteger ONE = new BigInteger("1");
static final BigInteger TWO = new BigInteger("2");
static final BigInteger THREE = new BigInteger("3");
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger n;
        System.out.print("숫자 입력 혹은 엔터");
        String input = scanner.nextLine();
        try {

            if (input.length() == 0) {
                throw new IllegalArgumentException();
            } else {
                n = new BigInteger(input);
                if (n.signum() == 1) {
                    threeAndPlus(n);
                } else {
                    throw new IllegalArgumentException();
                }
            }

        } catch (IllegalArgumentException e) {
            System.out.println("It's wrong number");
        }
    }

    public static void threeAndPlus(BigInteger number){
 
        int count;  // The number of terms in the sequence.
        
        System.out.println("The 3N+1 sequence starting with " + number + " is:");
        
        System.out.println(number.toString());   // Print N as the first term of the sequence
        count = 1;
        
        while ( ! number.equals(ONE) ){   // Compute and print the next term
           if (number.testBit(0) == false) {
                   // N is even.  Divide N by 2.
               number = number.divide(TWO);
           }
           else {
                   // N is odd.  Multiply N by 3, then add 1.
               number = number.multiply(THREE);
               number = number.add(ONE);
           }
           System.out.println(number.toString());
           count++;
        }
  
        System.out.println();
        System.out.println("There were " + count + " terms in the sequence.");
  
    }

}
