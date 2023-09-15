package Chapter4.damho.src.Example;

public class CLDemo {
    public static void main(String[] args) {
        System.out.println("당신은 " + args.length + "개의 args를 입력하였습니다.");
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                System.out.println(args[i]);
            }
        }
    }
}
