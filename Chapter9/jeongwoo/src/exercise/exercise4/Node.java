package exercise.exercise4;

public class Node {
    private String data;
    public Node left;
    public Node right;

    public Node(String data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public String getData() {
        return data;
    }
}
