package ru.gb.les4;


import java.util.Random;
import java.util.Scanner;

public class HW {
    private static char[][] field;
    private static final int FIELD_SIZE = 5;    //размер поля
    private static final int DOTS_TO_WIN = 4;   //количество заполненых символов для победы

    private static final char FIELD_EMPTY = '_';  //не заполненное поле
    private static final char FIELD_DOT_PLAYER = 'X'; //определяет знак игрока
    private static final char FIELD_DOT_AI = '0'; //определяет знак компьютера
    private static Scanner scanner;
    private static Random random;

    public static void main(String[] args) {
        random = new Random();
        scanner = new Scanner(System.in);
        System.out.println("Игра крестики-нолики");

        initField();    //инициализация игрового поля
        printMap();     //вывод на экран игрового поля

        while (true){
            playerMove();
            printMap();
            if(checkWin(FIELD_DOT_PLAYER)) {
                System.out.println("Победил Игрок");
                break;
            }
            if(isFieldFull()) {
                System.out.println("Игра окончена, Ничья!");
                break;
            }
            aiMove();
            printMap();
            if(checkWin(FIELD_DOT_AI)){
                System.out.println("Победил Компьютер");
                break;
            }
            if(isFieldFull()) {
                System.out.println("Игра окончена, Ничья!");
                break;
            }
        }
    }

    public static boolean checkWin(char element) {  //проверка игры на победу
        int horizont, vertikal;
        int diaganalMain, diaganalReverse;
        for (int i = 0; i < FIELD_SIZE; i++) {
            horizont = 0;
            vertikal = 0;
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (field[i][j] == element) {   // проверка горизонтальных линий на победу
                    horizont++;
                } else if (field[i][j] != element && horizont < DOTS_TO_WIN) {
                    horizont = 0;
                }
                if (field[j][i] == element) {   // проверка вертикальных линий на победу
                    vertikal++;
                }   else if (field[j][i] != element && vertikal < DOTS_TO_WIN) {
                    vertikal = 0;
                }
            }
            if (horizont >= DOTS_TO_WIN || vertikal >= DOTS_TO_WIN) {
                System.out.println("По горизонтали или вертикали " + horizont + " " + vertikal);
                return true;
            }
        }

        for (int j = 0; j < FIELD_SIZE; j++) {
            diaganalMain = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (field[i][k] == element) {   // проверка главной диаганали от центральной оси в право на победу
                        diaganalMain++;
                    } else if (field[i][k] != element && diaganalMain < DOTS_TO_WIN) {
                        diaganalMain = 0;
                    }
                }
                if (diaganalMain>= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вправо " + element);
                    return true;
                }
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            diaganalMain = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = j + i;
                if (k < FIELD_SIZE) {
                    if (field[k][i] == element) {   // проверка главную диагональ от центральной оси вниз на победу
                        diaganalMain++;
                    } else if (field[k][i] != element && diaganalMain < DOTS_TO_WIN) {
                        diaganalMain = 0;
                    }
                }
                if (diaganalMain >= DOTS_TO_WIN) {
                    System.out.println("По главной диагонали от центральной оси вниз " + diaganalMain);
                    return true;
                }
            }
        }
        for (int j = 0; j < FIELD_SIZE; j++) {
            diaganalReverse = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - i;
                int l = j + i;
                if (k >= 0 && l < FIELD_SIZE) {
                    if (field[l][k] == element) {                     // проверяем побочную диагональ от центральной оси вниз на возможную победу
                        diaganalReverse++;
                    } else if (field[l][k] != element && diaganalReverse < DOTS_TO_WIN) {
                        diaganalReverse = 0;
                    }
                }
                if (diaganalReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси вниз " + diaganalReverse);
                    return true;
                }
            }
        }
        for (int j = 1; j < FIELD_SIZE; j++) {
            diaganalReverse = 0;
            for (int i = 0; i < FIELD_SIZE; i++) {
                int k = (FIELD_SIZE - 1) - j - i;
                if (k >= 0) {
                    if (field[i][k] == element) {     // проверяем побочную диагональ от центральной оси влево на возможную победу
                        diaganalReverse++;
                    } else if (field[i][k] != element && diaganalReverse < DOTS_TO_WIN) {
                        diaganalReverse = 0;
                    }
                }
                if (diaganalReverse >= DOTS_TO_WIN) {
                    System.out.println("По побочной диагонали от центральной оси влево " + diaganalReverse);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isFieldFull() { //проверка полного поля (ничья)
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                if(field[i][j]==FIELD_EMPTY){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCellBusy(int x, int y) {
        if (x < 0 || y < 0 || x > FIELD_SIZE - 1 || y > FIELD_SIZE - 1) {
            return false;
        }
        return field[x][y] != FIELD_EMPTY;
    }
    public static void aiMove() {   //ход компьютера
        int x = -1;
        int y = -1;
        boolean ai_win = false;
        boolean player_win = false;

        for (int i = 0; i < FIELD_SIZE; i++) {  //поиск выигрышного хода
            for (int j = 0; j < FIELD_SIZE; j++) {
                if (!isCellBusy(i, j)) {
                    field[i][j] = FIELD_DOT_AI;
                    if (checkWin(FIELD_DOT_AI)) {
                        x = i;
                        y = j;
                        ai_win = true;
                    }
                    field[i][j] = FIELD_EMPTY;
                }
            }
        }
            if (!ai_win) {
                for (int i = 0; i < FIELD_SIZE; i++) {
                    for (int j = 0; j < FIELD_SIZE; j++) {
                        if (!isCellBusy(i, j)) {
                            field[i][j] = FIELD_DOT_PLAYER;
                            if (checkWin(FIELD_DOT_PLAYER)) {
                                x = i;
                                y = j;
                                player_win = true;
                            }
                            field[i][j] = FIELD_EMPTY;
                        }
                    }
                }
            }
            if (!ai_win && !player_win) {
                do {
                    Random rnd = new Random();
                    x = rnd.nextInt(FIELD_SIZE);
                    y = rnd.nextInt(FIELD_SIZE);
                }
                while (isCellBusy(x, y));
            }
            field[x][y] = FIELD_DOT_AI;
            System.out.println("Компьютер походил на [" + (x + 1) + "," + (y + 1) + "]");
        }

    public static boolean isMoveValid(int x, int y) { //проверка правильного ввода по координатам
        return x >= 0 && x <= FIELD_SIZE && y >= 0 && y <= FIELD_SIZE && field[x][y] == FIELD_EMPTY;
    }

    public static void playerMove() {   //ход игрока
        int x, y;

        do {
            System.out.println("Введите положительные координаты Х, не больше значения: " + FIELD_SIZE);
            x = scanner.nextInt() - 1;  //X координата

            System.out.println("Введите положительные координаты Y, не больше значения: " + FIELD_SIZE);
            y = scanner.nextInt() - 1;  //Y координата

        } while (!isMoveValid(x, y));

        field[x][y] = FIELD_DOT_PLAYER;
    }

    public static void printMap() { //вывод поля на экран
        int n = 1;
        do {
            System.out.print("   " + n);
            n++;
        }   while (n <= FIELD_SIZE);    //вывод нумерации столбцов

        System.out.println();

            for (int i = 0; i < FIELD_SIZE; i++) {
                System.out.print(i + 1 + "-");  //вывод нумерации строк
                for (int j = 0; j < FIELD_SIZE; j++) {
                    System.out.print("|" + field[i][j] + "| ");
                }
                System.out.println();
            }
            System.out.println();
        }

    public static void initField() {    //иницилизация игрового поля
        field = new char[FIELD_SIZE][FIELD_SIZE];
        for (int i = 0; i < FIELD_SIZE; i++) {
            for (int j = 0; j < FIELD_SIZE; j++) {
                field[i][j] = FIELD_EMPTY;
            }
        }
    }
}

