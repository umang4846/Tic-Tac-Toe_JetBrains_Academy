import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);

        char[][] array = new char[4][4];

        for (int i = 0; i < 4; i++) {
            array[i] = scanner.next().toCharArray();
        }
        scanner.close();
        boolean isPretty = true;
        for (int row = 0; row <= array.length - 2 && isPretty; row++) {
            for (int col = 0; col <= array[row].length - 2; col++) {
                if (array[row][col] == array[row][col + 1] &&
                        array[row + 1][col] == array[row + 1][col + 1] &&
                        array[row][col] == array[row + 1][col]) {
                    isPretty = false;
                    break;
                }
            }
        }

        if (isPretty) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


    }
}