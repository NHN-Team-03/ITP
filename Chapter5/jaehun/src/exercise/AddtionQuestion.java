package exercise;

public class AddtionQuestion implements IntQuestion{
    private int a, b;

    public AddtionQuestion() {
        a = (int)(Math.random() * 50 + 1);
        b = (int)(Math.random() * 50);
    }

    public String getQuestion() {
        return a + " + " + b + " 는 무엇입니까?";
    }

    public int getCordirectAnswer() {
        return a + b;
    }
}
