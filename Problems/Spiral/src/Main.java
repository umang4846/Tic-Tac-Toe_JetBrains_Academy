import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] a = new int[n][n];

        int count = 0;
        int top = 0;
        int bottom = a.length - 1;
        int left = 0;
        int right = a[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                a[top][i] = ++count;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                a[i][right] = ++count;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    a[bottom][i] = ++count;
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    a[i][left] = ++count;
                }
                left++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}