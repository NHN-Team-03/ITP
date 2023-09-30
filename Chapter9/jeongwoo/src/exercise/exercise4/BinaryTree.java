package exercise.exercise4;

public class BinaryTree {
    private Node root;

    private int length;

    public BinaryTree() {
        length = 0;
        root = null;
    }

    public int getLength() {
        return length;
    }

    public void put(String data){
        if(isEmpty()){
            root = new Node(data);
            length++;
            return;
        }

        Node newNode = new Node(data);
        Node node = root;
        while(true){
            if(data.compareTo(node.getData()) > 0){ // 들어온 데이터가 높을 떄
                if(node.right == null){
                    node.right = newNode;
                    length++;
                    return;
                }
                node = node.right;
            }
            else if(data.compareTo(node.getData()) < 0){ // 들어온 데이터가 적을 때
                if(node.left == null){
                    node.left = newNode;
                    length++;
                    return;
                }
                node = node.left;
            }else{
                System.out.println("이미 있는 데이터!");
                return;
            }
        }
    }



    public boolean isEmpty() {
        if (length == 0) {
            return true;
        }
        return false;
    }
}
