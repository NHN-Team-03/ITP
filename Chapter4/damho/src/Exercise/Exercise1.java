package Chapter4.damho.src.Exercise;

public class Exercise1 {

    public static String printCapitalized(String str) {
        StringBuilder sb = new StringBuilder();
        char ch;
        char prevCh = ' ';
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            if (Character.isLetter(ch) && ( !Character.isLetter(prevCh))) {
                sb.append(Character.toUpperCase(ch));
            } else {
                sb.append(ch);
            }
            prevCh = ch;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(printCapitalized("hello world!!"));
        System.out.println("It's a dog");
    }
}
