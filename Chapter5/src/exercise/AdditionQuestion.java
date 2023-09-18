package exercise;

public class AdditionQuestion {
    
    private int a,b;

    public AdditionQuestion(){
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
    }

    public String getQuestion(){
        return "" + a + " + " + b + " 는 무엇입니까?";
    }

    public int getCorrectAnswer(){
        return a + b;
    }
}
