package exercise.exercise5;

public class Node {
    private double data;
    public Node left;
    public Node right;

    public Node(double data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public double getData() {
        return data;
    }
}
