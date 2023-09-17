package exercise;

public class SubtractionQuestion implements IntQuestion{
    private int a, b;

    public SubtractionQuestion() {
        a = (int)(Math.random() * 50) + 1;
        b = (int)(Math.random() * 50);
    }

    @Override
    public String getQuestion() {
        return a + " - " + b + " 는 무엇입니까?";
    }

    @Override
    public int getCordirectAnswer() {
        return a - b;
    }
    
}
