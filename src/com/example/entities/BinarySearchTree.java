package com.example.entities;



public class BinarySearchTree<T extends Comparable<? super T>>{

    /* 二叉树节点 */
    private static class BinaryNode<T>{
        T element;
        BinaryNode<T> left;
        BinaryNode<T> right;
        BinaryNode(T el){
            this(el,null,null);
        }
        BinaryNode(T el,BinaryNode<T> lt, BinaryNode<T> rt){
            element = el;
            left = lt;
            right = rt;
        }
        
    }
    /* 二叉搜索树的根节点 */
    private BinaryNode<T> root;
    public BinarySearchTree(){
        root = null;
    }

    public void makeEmpay(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean contain(T el){
        return contain(el,root);
    }
    public boolean contain(T el,BinaryNode<T> t){
        if(t==null) return false;
        int com = el.compareTo(t.element);
        if(com<0) return contain(el,t.left);
        if(com>0) return contain(el,t.right);
        return true;
    }
    public T findMin(){
        if(isEmpty()) return null;
        return findMin(root).element;
    }
    private BinaryNode<T> findMin(BinaryNode<T> t){
        if (t==null) return null;
        if(t.left==null) return t;
        return findMin(t.left);
    }
    public T findMax(){
        if(isEmpty()) return null;
        return findMax(root).element;
    }
    private BinaryNode<T> findMax(BinaryNode<T> t){
        // if(t==null) return null;
        // if(t.right==null) return t;
        // return findMax(t.right);

        /* 循环实现 */
        if(t!=null)
            while(t.right!=null)
                t = t.right;
        return t;
    }
    public void insert(T t){
        root = insert(t,root);
    }
    private BinaryNode<T> insert(T t,BinaryNode<T> root){
        if(root==null) return new BinaryNode<T>(t); 
        int com = t.compareTo(root.element);
        if (com<0) root.left = insert(t,root.left);
        if (com>0) root.right = insert(t,root.right);
        return root;
    }
    public void remove(T t){
        root = remove(t,root);
    }
    private BinaryNode<T> remove(T t,BinaryNode<T> root){
        if(root==null) return null;//可以抛出异常
        int com = t.compareTo(root.element);
        if(com<0) root.left = remove(t, root.left);
        else if(com>0) root.right = remove(t, root.right);
        else if(root.left!=null&&root.right!=null){
            root.element = findMin(root.right).element;
            root.right = remove(root.element, root.right);
        }
        else root = (root.left!=null)?root.left:root.right;
        return root;
    }
    public void printTree(){
        if(isEmpty()) 
            System.out.println("Empty tree");
        printTree(root);
    }

    private void printTree(BinaryNode<T> root) {
        if(root==null) return;
        /* 中序打印 */
        printTree(root.left);
        System.out.print(root.element+" ");
        printTree(root.right);
    }

}
