package Ch2;

public class P7 {
    public static void main(String[] args) {
        TextIO.readFile("./Ch2/testdata.txt");
        String name = TextIO.getln();
        int score1 = TextIO.getlnInt();
        int score2 = TextIO.getlnInt();
        int score3 = TextIO.getlnInt();

        System.out.println("name : " + name + ", score1 : " + score1 + ", score2 : " + score2 + ", score3 : " + score3);
    }
}
