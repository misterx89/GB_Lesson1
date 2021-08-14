package ru.gb.les3;

import javax.swing.*;
import java.util.Arrays;

public class HW {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Array1()));
        System.out.println(Arrays.toString(Array2()));
        System.out.println(Arrays.toString(Array3()));
        Array4();
        System.out.println(Arrays.toString(Array5(4, 57)));
        Array6();
        System.out.println(Array7(new int[] {2,2,2,1,2,2,10,1}));
        Array8(new int[] {5,9,7,3,6,88},-1);
    }

    public static int[] Array1() {
        int[] arr = {1, 0, 1, 1, 0, 0, 1};
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
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static int[] Array3() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    public static void Array4() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i + j == arr.length - 1) {
                    arr[i][j] = 1;
                } else if (i == j) {
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] Array5(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static void Array6() {

        int[] arr = {1, 6, 9, 67, 345, 1, 8, 0};
        int max = 0;
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
            else
                min = arr[i];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Max = " + max);
        System.out.println("Min = " + min);
    }

    public static boolean Array7(int arr[]) {
//        int[] arr = {2,2,2,1,2,2,10,1};
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0, j = 0;i < arr.length-j; i++) {
            leftSum += arr[i];
            if (leftSum > rightSum)
                rightSum += arr[arr.length - 1 - j++];
        }
        if(leftSum==rightSum)
            return true;
           else
            return false;
    }

    public static void Array8(int arr[],int n) {
        System.out.print("Do: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("(n = " + n + ")");
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int tmp = arr[arr.length - 1];
                for (int j = arr.length - 1; j > 0; j--) {
                    arr[j] = arr[j - 1];
                }
                arr[0] = tmp;
            }
        } else if (n < 0) {
            for (int i = 0; i < n * (-1); i++) {
                int tmp = arr[0];
                for (int j = 0; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = tmp;
            }
        }
        System.out.print("Posle:  ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}


