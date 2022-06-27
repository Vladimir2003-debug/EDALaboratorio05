package datastructures;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
public class AVLTree<E extends Comparable<? super E>> implements AVLTreeInterface<E>{
    private Node<E> root;

    public AVLTree(E root) {
        this.root = new Node<E>(root);
    }

    /**
     * Add the data as a leaf in the AVL.  Should traverse the tree to find the
     * appropriate location. If the data being added already exists in the tree,
     * do nothing.
     *
     * @throws java.lang.IllegalArgumentException if the data is null
     * @param data the data to be added
     */
    @Override
    public void insert(E data) {
        root = insert(root, data);
    }

    protected Node<E> insert(Node<E> node, E data) {
        if (node == null) {
            return new Node<E>(data);
        }
        // Almacena en un int la comparacion con el nodo actual
        int resC = data.compareTo(node.getData());
        if (resC < 0) {
            node.setLeft(insert(node.getLeft(), data));
        } else if (resC > 0) {
            node.setRight(insert(node.getRight(), data));
        }

        return node;
    }

    /**
     * Removes the data from the tree.  There are 3 cases to consider:
     * 1: the data is a leaf.  In this case, simply remove it.
     * 2: the data has one child.  In this case, simply replace the node with
     * the child node.
     * 3: the data has 2 children.  There are generally two approaches:
     * replacing the data with either the largest element in the left subtree
     * (commonly called the predecessor), or replacing it with the smallest
     * element in the right subtree (commonly called the successor). For this
     * assignment, use the successor.
     *
     * @throws java.lang.IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not in the tree
     * @param data data to remove from the tree
     * @return the data removed from the tree.  Do not return the same data
     * that was passed in.  Return the data that was stored in the tree.
     */
    @Override
    public E remove(E data) {
        //TODO implement here!
        return null;
    }

    /**
     * Returns the data in the tree matching the parameter passed in.
     *
     * @throws java.lang.IllegalArgumentException if the data is null
     * @throws java.util.NoSuchElementException if the data is not found
     * @param data data to get in the AVL tree
     * @return the data in the tree equal to the parameter.  Do not return the
     * same data that was passed in.  Return the data that was stored in the
     * tree.
     */
    @Override
    public E get(E data) {
        //TODO implement here!
        return null;
    }

    /**
     * Returns whether or not the parameter is contained within the tree.
     *
     * @throws java.lang.IllegalArgumentException if the data is null
     * @param data data to find in the AVL tree
     * @return whether or not the parameter is contained within the tree
     */
    @Override
    public boolean contains(E data) {
        //TODO implement here!
        return false;
    }

    /**
     * Get the number of elements in the tree.
     *
     * @return the number of elements in the tree
     */
    @Override
    public int size() {
        //TODO implement here!
        return 0;
    }

    /**
     * Get the preorder traversal of the tree.
     *
     * @return a preorder traversal of the tree, or an empty list
     */
    @Override
    public List<E> preorder() {
        return preOrder(root);
    }

    private List<E> preOrder(Node<E> node) {
        List<E> preorder = new ArrayList<E>();
        preorder.add(node.getData());
        if(node.getLeft() != null) preorder.addAll(preOrder(node.getLeft()));
        if(node.getRight() != null) preorder.addAll(preOrder(node.getRight()));
        return  preorder;
    }

    /**
     * Get the postorder traversal of the tree.
     *
     * @return a postorder traversal of the tree, or an empty list
     */
    public List<E> postorder() {
        return postOrder(root);
    }

    private List<E> postOrder(Node<E> node) {
        List<E> postorder = new ArrayList<E>();
        if(node.getLeft() != null) postorder.addAll(postOrder(node.getLeft()));
        if(node.getRight() != null) postorder.addAll(postOrder(node.getRight()));
        postorder.add(node.getData());

        return postorder;
    }

    /**
     * Get the inorder traversal of the tree.
     *
     * @return an inorder traversal of the tree, or an empty list
     */
    @Override
    public List<E> inorder() {
        return postOrder(root);
    }

    private List<E> inOrder(Node<E> node) {
        List<E> inorder = new ArrayList<E>();
        if(node.getLeft() != null) inorder.addAll(inOrder(node.getLeft()));
        inorder.add(node.getData());
        if(node.getRight() != null) inorder.addAll(inOrder(node.getRight()));
        return  inorder;  
    }
    /**
     * Clear the tree.
     */
    @Override
    public void clear() {
        this.root = null;
    }

    /**
     * Return the height of the root of the tree.
     *
     * This method does not need to traverse the entire tree.
     *
     * @return the height of the root of the tree, -1 if the tree is empty
     */
    @Override
    public int height() {     
        return 0;
    }

    /**
     * @return the root of the tree
     */
    @Override
    public Node<E> getRoot() {
        return this.root;
    }
}
