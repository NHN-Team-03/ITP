public class Interest {
    public static void main(String[] args) {
        
        /* Declare the variables. */

        double printciple;
        double rate;
        double interest;

        /* Do the computations. */

        printciple = 17_000;
        rate = 0.027;
        interest = printciple * rate;

        printciple = printciple + interest;

        /* Output the results. */

        System.out.print("The interest earned is $");
        System.out.println(interest);
        System.out.print("The value of the investment after one year is $");
        System.out.println(printciple);
    }
    
}
