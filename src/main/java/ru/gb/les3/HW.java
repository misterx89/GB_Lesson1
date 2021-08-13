package ru.gb.les3;

import java.util.Arrays;

public class HW {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Array1()));
        System.out.println(Arrays.toString(Array2()));
        System.out.println(Arrays.toString(Array3()));
        Array4();
    }

    public static int[] Array1() {
        int arr[] = {1, 0, 1, 1, 0, 0, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static int[] Array2() {
        int arr[] = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        return arr;
    }

    public static int[] Array3() {
        int arr[] = {1,5,3,2,11,4,5,2,4,8,9,1};
        for(int i=0;i< arr.length;i++){
            if(arr[i]<6){
                arr[i]*=2;
            }
        }
        return arr;
    }

    public static void Array4(){
        int arr[][] = new int[5][5];
        for(int i=0;i< arr.length;i++) {
            for (int j = 0; j < arr.length; j++) {
                        if (i+j== arr.length-1) {
                            arr[i][j] = 1;
                        } else if(i==j){
                            arr[i][j] = 1;
                        }
                        System.out.print(arr[i][j] + " ");
            }
                    System.out.println();
        }
    }
}

