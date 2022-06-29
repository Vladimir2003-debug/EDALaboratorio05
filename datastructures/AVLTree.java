package datastructures;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
public class AVLTree<E extends Comparable<? super E>> implements AVLTreeInterface<E>{
    private Node<E> root;

    public AVLTree() {
        this.root = null;
    }

    public AVLTree(E root) {
        this.root = new Node<E>(root);
    }

    public Node<E> rotateSL(Node<E> node) {
        Node<E> h = node.getRight();

        node.setRight(h.getLeft());
        h.setLeft(node);
        node = h;

        node.setBalanceFactor(node.getBalanceFactor() - 1);
        node.getLeft().setBalanceFactor(node.getBalanceFactor());
        return node;
    }

    public Node<E> rotateSR(Node<E> node) {
        Node<E> h = node.getLeft();
        
        node.setLeft(h.getRight());
        h.setRight(node);
        node = h;
        
        node.setBalanceFactor(node.getBalanceFactor() + 1);
        node.getRight().setBalanceFactor(node.getBalanceFactor());
        return node;
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
        } else if(resC == 0) {
            return null;
        } else if (resC > 0) {
            node.setRight(insert(node.getRight(), data));
        }        

        node.setBalanceFactor(balance(node));
        
        if(node.getBalanceFactor() > 1 ) 
            if(node.getRight().getData().compareTo(data) < 0)
                return rotateSL(node);
            else {
                node.setRight(rotateSR(node.getRight()));
                return rotateSL(node);
            }
            
        if(node.getBalanceFactor() < -1 ){
            if(node.getLeft().getData().compareTo(data) > 0)
                return rotateSR(node);
            else{
                node.setLeft(rotateSL(node.getLeft()));
                return rotateSR(node);
            }
        }
    
        return node;
    }



    private int balance(Node<E> node) {
        int fe = height(node.getRight()) - height(node.getLeft());
        return fe;
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
        this.root = removeNode(this.root, data);
        return null;
    }
    private Node<E> removeNode(Node<E> actual, E data) {
        Node<E> res = actual;
        if(actual == null)
            throw new IllegalArgumentException();
        
        int resC = actual.getData().compareTo(data);
        if (resC < 0)
            res.setRight(removeNode(actual.getRight(), data));
        else if (resC > 0)
            res.setLeft(removeNode(actual.getLeft(), data));
        else if (actual.getLeft() != null && actual.getRight() != null) {// dos hijos
            // res.data = minRecover(actual.getRight()).data;
            res.setData(minRecover(actual.getRight()).getData());
            res.setRight(minRemove(actual.getRight()));
        } else { // 1 hijo o ninguno
            res = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();
        }
            
        return res;
    }

    protected Node<E> minRecover(Node<E> node) {
        if (node.getLeft() == null) {
            return node;
        }
        return minRecover(node.getLeft());
    }

    protected Node<E> minRemove(Node<E> actual) {
        if (actual.getLeft() != null)
            actual.setLeft(minRemove(actual.getLeft()));
        else {
            actual = actual.getRight();
        }
        return actual;
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
        if(data == null)
            throw new IllegalArgumentException("El parametro es null");
        return get(root,data).getData();
    }

    protected Node<E> get(Node<E> node, E data) {
        if(data.compareTo(node.getData()) == 0)
            return node;
        if(data.compareTo(node.getData()) < 0 && node.getLeft() != null)
            return get(node.getLeft(), data);
        if(data.compareTo(node.getData()) > 0 && node.getRight() != null)
            return get(node.getRight(), data);
        else
            throw new NoSuchElementException();

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
        if(data == null)
            throw new IllegalArgumentException("El parametro enviado es null");   
        return get(data) != null;
    }

    /**
     * Get the number of elements in the tree.
     *
     * @return the number of elements in the tree
     */
    @Override
    public int size() {        
        return size(root);
    }

    private int size(Node<E> node) {
        if(node == null )
            return 0;
        return size(node.getLeft()) + size(node.getRight()) + 1;    

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
     * Metodo que imprime el arbol en  izquierda-derecha-raiz
     * @return el arbol en postorden
     */
    public String postOrden() {
        return postOrden(root);
    }

    protected String postOrden(Node<E> node) {
        if (node == null) {
            return "";
        }
        return postOrden(node.getLeft()) + " " + postOrden(node.getRight()) + " " + node.toString() + "-"+ node.getBalanceFactor();
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
        return inOrder(root);
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
        if(this.root == null) 
            return -1;                
        return height(root);
    }

    private int height(Node<E> node) {
        if(node == null)
            return 0;
        if(node.getLeft() == null && node.getRight() == null)
            return 1;
        if(node.getBalanceFactor() == -1)
            return height(node.getLeft()) + 1;
        if(node.getBalanceFactor() == 1)
            return height(node.getRight()) + 1;
        return height(node.getLeft()) + 1;
    }

    /**
     * @return the root of the tree
     */
    @Override
    public Node<E> getRoot() {
        return this.root;
    }
}
