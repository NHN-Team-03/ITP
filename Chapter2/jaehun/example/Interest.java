package Chapter2.jaehun.example;

public class Interest {
    public static void main(String[] args) {
        // Declare the variables.

        double principal;
        double rate;
        double interest;

        // Do the computations.

        principal = 17000;
        rate = 0.027;
        interest = principal * rate;

        // Output the results.

        System.out.print("The interest earned is $");
        System.out.println(interest);
        System.out.print("The value of the investment after one year is $");
        System.out.println(principal);
        
    } // end of main()
} // end of class Interest
