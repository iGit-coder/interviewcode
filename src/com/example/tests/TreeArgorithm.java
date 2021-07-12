package com.example.tests;

import java.util.Arrays;

import com.example.entities.BinarySearchTree;
import com.example.interfaces.TestInterface;

public class TreeArgorithm implements TestInterface{

    @Override
    public void test() {
        // TODO Auto-generated method stub
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        int[] arr = {5,3,7,1,8,0};
        for(int v : arr){
            bst.insert(v);
        }
        System.out.println(Arrays.toString(arr));
        bst.printTree();
    }
    
}
