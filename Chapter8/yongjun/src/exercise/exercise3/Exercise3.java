package exercise.exercise3;

public class Exercise3 {


    public static void main(String[] args) {
        RomeToNumber rNumber = new RomeToNumber("MCMXCV");
        RomeToNumber nRome = new RomeToNumber(1995);

        System.out.println(rNumber.toInt());
        System.out.println(nRome.toString());
    }

    
    
}
