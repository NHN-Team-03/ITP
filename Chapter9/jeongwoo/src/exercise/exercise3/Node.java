package exercise.exercise3;

public class Node {
    private String data;
    public Node leftNode;
    public Node rightNode;

    /*
    Constructor
     */
    public Node(String data) {
        this.data = data;
        this.leftNode = null;
        this.rightNode = null;
    }

    /*
    Getter
     */
    public String getData() {
        return data;
    }

}
