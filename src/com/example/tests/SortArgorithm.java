package com.example.tests;

import java.util.Arrays;

import com.example.interfaces.TestInterface;

public class SortArgorithm implements TestInterface{

    @Override
    public  void test() {
        // TODO Auto-generated method stub
        int[] array = {3,2,5,9,2,0,1};
        System.err.println(Arrays.toString(array));
        // maoPao(arry);
        // selectSort(arry);
        // insertSort(arry);
        // shellSort(arry);
        // array = mergeSort(array);
        // quickSort(array,0,array.length-1);
        // headSort(array);
        countSort(array, 9);
        System.out.println(Arrays.toString(array));
    }
    /* 冒泡算法 O(n^2)*/
    public static void maoPao(int[] arry){
        if (arry==null||arry.length<2) return;
        int len = arry.length;
        for (int i=1;i<len;i++){
            for(int j=0;j<len-i;j++){
                if(arry[j]>arry[j+1]){
                    int tmp = arry[j];
                    arry[j] = arry[j+1];
                    arry[j+1] = tmp;
                }
            }
        }
    }
    /* 选择排序 O(n^2)*/
    public static void selectSort(int[] arry){
        if(arry==null||arry.length<2) return;
        int len = arry.length;
        int minIndex;
        for(int i=0;i<len-1;i++){
            minIndex = i;
            for (int j=i+1;j<len;j++)
                if(arry[j]<arry[minIndex]) 
                    minIndex = j;
            if(i!=minIndex){
                int tmp = arry[i];
                arry[i] = arry[minIndex];
                arry[minIndex] = tmp;
            }
        }
    }
    /* 插入排序 O(n^2)*/
    public static void insertSort(int[] array){
        if(array==null||array.length<2) return;
        int len = array.length;
        for(int i=1;i<len;i++){
            int current = array[i];
            int preInx = i-1;
            while(preInx>=0&&array[preInx]>current){
                array[preInx+1] = array[preInx];
                preInx--;
            }
            array[preInx+1] = current;
        }

    }
    /* 希尔排序 O(nlogn)*/
    public static void shellSort(int[] array){
        System.out.println("===================shellSort");
        if(array==null||array.length<2) return;
        int len = array.length;
        int gap = len/2;//求商
        int current,preIdx;
        while(gap>0){

            for(int i=gap;i<len;i++){
                current = array[i];
                preIdx = i-gap;
                while(preIdx>=0&&array[preIdx]>current){
                    array[preIdx+gap] = array[preIdx];
                    preIdx -= gap;
                }
                array[preIdx+gap] = current;
            }
            gap /= 2;
        }

    }
    /* 归并 O(nlogn)*/
    public static int[] mergeSort(int[] array){
        System.out.println("===================mergeSort");
        if(array==null||array.length<2) return array;

        int len = array.length;
        int midIdx = len/2;
        int[] left = Arrays.copyOfRange(array, 0, midIdx);
        int[] right = Arrays.copyOfRange(array, midIdx, len);
        return merge(mergeSort(left), mergeSort(right));
    }
    private static int[] merge(int[] left,int[] right){
        if(left==null||left.length==0) return right;
        if(right==null||right.length==0) return left;
       
        int llen = left.length;
        int rlen = right.length;
        int[] res = new int[llen+rlen];
        int i=0,j=0,total=0;
        while(i<llen&&j<rlen){
            if(left[i]<right[j])
                res[total++] = left[i++];
            else
                res[total++] = right[j++];
        }
        if(i<llen)
            while(i<llen)
                res[total++] = left[i++];
        if(j<rlen)
            while(j<rlen)
                res[total++] = right[j++];
        return res;
    }

    /* 快排 O(nlogn)*/
    public static void quickSort(int[] array,int left,int right){
        System.out.println("===================mergeSort");
        if(array==null||array.length<2||left<0||right<0||left>=right) return;
        int pivot;
        pivot = searchPivot(array,left,right);
        
        quickSort(array,left,pivot-1);
        quickSort(array,pivot+1,right);
        
    }
    private static int searchPivot(int[] array,int left,int right){
        
        int preIdx=left;
        int posIdx=left;
        int tmp;
        while(++posIdx<=right){
            if(array[posIdx]<=array[left]){
                tmp = array[preIdx+1];
                array[preIdx+1] = array[posIdx];
                array[posIdx] = tmp;
                preIdx++;
            }
        }
        tmp = array[left];
        array[left] = array[preIdx];
        array[preIdx] = tmp;
        return preIdx;
    }
    /* 堆排序 O(nlogn)*/
    public static void headSort(int[] array){
        System.out.println("===================headSort");
        if(array==null||array.length<2) return;
        createMaxHead(array);
        System.out.println(Arrays.toString(array));
        int len = array.length;
        int tmp;
        for(int i=1;i<len;i++){
            tmp = array[0];
            array[0] = array[len-i];
            array[len-i] = tmp; 
            headify(array,0,len-i-1);
        }
    }
    private static void headify(int[] array, int i,int lastIdx) {
        int max = i;
        int left = i*2+1;
        int right = i*2+2;
        int tmp;
        if(left<=lastIdx&&array[left]>array[max])
            max = left;
        if(right<=lastIdx&&array[right]>array[max])
            max = right;
        if(max!=i){
            tmp = array[i];
            array[i] = array[max];
            array[max] = tmp;
            headify(array, max, lastIdx);
        }
    }
    private static void createMaxHead(int[] array) {
        int len = array.length;
        int root = len/2-1;
        for(int i=root;i>=0;i--){
            headify(array,i,len-1);
        }
    }

    /* 计数排序 O(n+k) 需要各个元素都大于等于0，知道里面的数的上限*/
    public static void countSort(int[] array,int max){
        System.out.println("===================countSort");
        if(array==null||array.length<2) return;
        int newLen = max+1;
        int[] newArray = new int[newLen];
       
        for(int v:array){
            newArray[v]++;
        }
        int i=0,j=0;
        while (i<newLen){
            while(newArray[i]>0){
                array[j++]=i;
                newArray[i]--;
            }
            i++;
        }

    }

    
    
}
