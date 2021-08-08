package ru.gb.les2;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(checkSum(10,6));
        checkNumber(9);
        System.out.println(checkReturnNumber(-50));
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

    public static void checkNumber(int n){
        if (n>=0){
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательные число");
        }
    }

    public static boolean checkReturnNumber(int n) {
        if(n>=0){
            return false;
        }   else{
            return true;
        }
    }

}
