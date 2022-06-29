import exercises.Exercises;
import datastructures.AVLTree;
public class Main {
    public static void main(String[] args) {   
        System.out.println(Exercises.isBalanced("{[()]}")); // YES,NO,YES
        System.out.println(Exercises.isBalanced("[(])"));
        System.out.println(Exercises.isBalanced("[[(())]]"));

        AVLTree<Integer> tree = new AVLTree<Integer>();
        tree.insert(12);
        tree.insert(34);
        tree.insert(10);
        tree.insert(14);
        tree.insert(8);
        tree.insert(11);
        tree.insert(13);
        tree.insert(32);
        tree.insert(33);
        System.out.println(tree.postOrden());
        System.out.println(tree.get(14));
        System.out.println(tree.size());
        System.out.println(tree.height());
    }
}
