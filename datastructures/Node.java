package datastructures;

public class Node<E extends Comparable<? super E>> {

    /**
     * TODO
     * Complete here:
     * (i) Constructor
     * (ii) Attributes e.g., data, leftNode, rightNode, balanceFactor. All
     * (iii) Implements accessors for the attributes i.e., get and set methods
     */
    E data;
    private Node<E> leftNode;
    private Node<E> rightNode;
    private int balanceFactor;

    public Node(E data) {
        this.data = data;
    }
    
    public Node(E data, int balanceFactor) {
        this.balanceFactor = balanceFactor;
        this.data = data;
    }
    public Node(E data, Node<E> leftNode, Node<E> rightNode) {
        this.data = data;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLeft() {
        return leftNode;
    }

    public void setLeft(Node<E> leftNode) {
        this.leftNode = leftNode;
    }

    public Node<E> getRight() {
        return rightNode;
    }

    public void setRight(Node<E> rightNode) {
        this.rightNode = rightNode;
    }

    public int getBalanceFactor() {
        return balanceFactor;
    }

    public void setBalanceFactor(int balanceFactor) {
        this.balanceFactor = balanceFactor;
    }

    public String toString() {
        return data.toString();
    }
}
