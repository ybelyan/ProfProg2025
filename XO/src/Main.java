import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static char[] board = {'-', '-', '-',
            '-', '-', '-',
            '-', '-', '-'};
    static boolean isPlayerX = false;
    private static boolean isGameOn;

    public static void main(String[] args) {
        do {
            isPlayerX = !isPlayerX;
            printBoard();
            int cell = readCell();
            board[cell] = isPlayerX ? 'X' : 'O';
            isGameOn = !isGameOver(cell);
            if(isDeadHeat()) {
                printBoard();
                System.out.println("Ничья");
                return;
            }
        }
        while (isGameOn);
        System.out.println("Выиграл игрок " + (isPlayerX ? "X" : "O"));
    }

    private static boolean isDeadHeat() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }

    private static boolean isGameOver(int cell) {
        return false;
    }

    private static int readCell() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int cell = scanner.nextInt();
            if (cell >= 0 && cell < board.length && board[cell] == '-') {
                return cell;
            }
            System.out.println("Введено неверное значение");
        }
    }

    private static void printBoard() {
        System.out.println(Arrays.toString(board));
    }
}