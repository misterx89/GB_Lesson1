package ru.gb.les2;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(checkSum(10,6));
    }
    public static boolean checkSum(int a, int b) {
        int sum = a+b;
        if (sum>=10 && sum<=20) {
            System.out.println("sum = " + sum);
            return true;
        } else {
            System.out.println("sum = " + sum);
            return false;
        }
    }
}
