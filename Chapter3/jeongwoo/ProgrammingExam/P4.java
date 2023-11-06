import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        boolean isIng = false;

        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                isIng = false;
                System.out.print(line.charAt(i));
            } else if (isIng && !Character.isLetter(line.charAt(i))) {
                continue;
            } else {
                isIng = true;
                System.out.println();
            }
        }

        s.close();
    }
}
