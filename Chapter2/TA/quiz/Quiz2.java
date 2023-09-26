public class Quiz2 {
    public static void main(String[] args) {
        int first = getDie();
        int second = getDie();

        StringBuilder sb = new StringBuilder();
        sb.append("The first die comes up ")
                .append(first)
                .append("\nThe second die comes up ")
                .append(second)
                .append("\nYour total roll is ")
                .append(first + second);

        System.out.println(sb);
    }

    static int getDie() {
        return (int)(Math.random()*6) + 1;
    }
}