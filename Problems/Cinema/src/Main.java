import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int m = Integer.parseInt(scanner.next());
        int[][] seats = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                seats[i][j] = Integer.parseInt(scanner.next());
            }
        }
        int k = Integer.parseInt(scanner.next());
        scanner.close();
        int maxSeats = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (seats[row][col] == 0) {
                    maxSeats++;
                    if (maxSeats >= k) {
                        System.out.println(row + 1);
                        return;
                    }
                } else {
                    maxSeats = 0;
                }
            }
            maxSeats = 0;
        }
        if (maxSeats < k) {
            System.out.println(0);
        }

    }
}