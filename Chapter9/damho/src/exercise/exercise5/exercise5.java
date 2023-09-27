package exercise.exercise5;

public class exercise5 {
    public static void main(String[] args) {
        TreeNode<Double> treeNode = new TreeNode<>();

        treeNode.insertRandomValueNodes(Math::random, 1023); // 랜덤 double 1023개 삽입.
        System.out.println(treeNode.numberOfNodes());          // node 개수 출력.

        System.out.println(treeNode.numberOfLeaves());         // leaf 노드들의 개수.
        System.out.println(treeNode.sumOfLeavesDepth());       // leaf 노드들의 depth 합.
        System.out.println(treeNode.averageOfLeavesDepth());   // leaf 노드들의 평균 depth.
        System.out.println(treeNode.maxDepthOfLeaves());       // leaf 노드들 중 가장 깊은 depth.

    }
}
