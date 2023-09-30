package example;

public class OuterClass {
    private int a;
    private int b;

    public OuterClass() {
        this.a = 10;
        this.b = 11;
    }

    public class InnerClass {
        private int innerClassA;
        private int innerClassB;

        public InnerClass() {
            this.innerClassA = 13;
            this.innerClassB = 14;
        }

        public String printOuterClass() {
            return a + ", " + b;
        }

        public String printInnerClass() {
            return this.innerClassA + ", " + this.innerClassB;
        }
    }
}
