package example;

public class EnumDemo {

    enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
    }

    enum Month {
        JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
    }

    public static void main(String[] args) {

        Day tgif;
        Month libra;

        tgif = Day.FRIDAY;
        libra = Month.OCT;

        System.out.print("My sign is libra, since I was born in ");
        System.out.println(libra);
        System.out.print("That's the ");
        System.out.print(libra.ordinal()); // To get the exact month, do + 1
        System.out.println("-th month of the year.");
        System.out.println("(Counting from 0, of course!)");

        System.out.print("Isn't it nice to get to ");
        System.out.println(tgif); // Output value will be: FRIDAY

        System.out.println(tgif + " is the " + tgif.ordinal() + "-th day of the week.");

    }
}
