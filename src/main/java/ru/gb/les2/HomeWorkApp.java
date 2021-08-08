package ru.gb.les2;

public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(checkSum(10, 6));
        checkNumber(9);
        System.out.println(checkReturnNumber(-50));
        showString("Тест", 5);
        //System.out.println(leapYear(2020));
        leapYear(2004);
    }

    public static boolean checkSum(int a, int b) {
        int sum = a + b;
        if (sum >= 10 && sum <= 20) {
            System.out.println("sum = " + sum);
            return true;
        } else {
            System.out.println("sum = " + sum);
            return false;
        }
    }

    public static void checkNumber(int n) {
        if (n >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательные число");
        }
    }

    public static boolean checkReturnNumber(int n) {
        if (n >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void showString(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    public static void leapYear(int thisYear) {
        float step1 = thisYear % 4;
        float step2 = thisYear % 100;
        float step3 = thisYear % 400;

        if (step1 != 0) {
            System.out.println("step1 "+ step1);
            //return false;
        } else if (step2 != 0) {
            System.out.println("step2 "+ step2);
            //return false;
        } else if (step3 != 0) {
            System.out.println("step3 "+ step3);
            //return false;
        } else {
            System.out.println("step3 "+ step3);
            //return true;
        }
    }
}
