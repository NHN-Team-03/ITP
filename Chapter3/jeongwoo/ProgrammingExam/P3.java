import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double a = 0.0;
        double b = 0.0;
        double result = 0;
        char op = ' ';

        while(true){
            a = s.nextDouble();
            if(a == 0){
                break;
            }
            op = s.next().charAt(0);
            b = s.nextDouble();

            switch (op){
                case '+':
                    result = a + b;
                    break;
                case '-':
                    result = a + b;
                    break;
                case '*':
                    result = a + b;
                    break;
                case '/':
                    result = a + b;
                    break;
            }
            System.out.println(a + " " + op + " " + b + " = " + result);
        }

        s.close();
    }
}
