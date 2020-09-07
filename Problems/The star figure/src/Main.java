import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        String[][] array = new String[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = ".";
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][j] = "*";
                }
                if (array.length / 2 == j) {
                    array[i][j] = "*";
                    array[j][i] = "*";
                }
                if (i + j == n - 1) {
                    array[i][j] = "*";
                }
            }
        }

        for (String[] strings : array) {
            for (String anString : strings) {
                System.out.print(anString + " ");
            }
            System.out.println();
        }

    }
}