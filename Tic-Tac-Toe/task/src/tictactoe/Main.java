package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void printArray(String[][] arrayMatrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.printf("%s ", arrayMatrix[i][j]);
            }

            System.out.print("|\n");
        }
        System.out.println("---------");
    }

    public static String[][] populateGameData() {
        String data = "_________";
        String[][] arrayMatrix = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arrayMatrix[i][j] = data.substring(3 * i + j, 3 * i + j + 1);
            }
        }

        return arrayMatrix;
    }

    public static boolean hasThreeOf(String[][] arrayMatrix, String winner) {
        return checkColumnByColumn(arrayMatrix, winner) || checkDiagnally(arrayMatrix, winner) || checkRowByRow(arrayMatrix, winner);
    }

    //check winner by row
    static boolean checkRowByRow(String[][] arrayMatrix, String winner) {
        for (int i = 0; i < 3; i++) {
            if (arrayMatrix[i][0].equals(winner) && arrayMatrix[i][1].equals(winner) && arrayMatrix[i][2].equals(winner)) {
                return true;
            }
        }
        return false;
    }

    //check winner by column
    static boolean checkColumnByColumn(String[][] arrayMatrix, String winner) {
        for (int j = 0; j < 3; j++) {
            if (arrayMatrix[0][j].equals(winner) && arrayMatrix[1][j].equals(winner) && arrayMatrix[2][j].equals(winner)) {
                return true;
            }
        }
        return false;

    }

    //check if winner on Diagonal or not
    static boolean checkDiagnally(String[][] arrayMatrix, String winner) {
        if (arrayMatrix[0][0].equals(winner) && arrayMatrix[1][1].equals(winner) && arrayMatrix[2][2].equals(winner)) {
            return true;
        }

        if (arrayMatrix[0][2].equals(winner) && arrayMatrix[1][1].equals(winner) && arrayMatrix[2][0].equals(winner)) {
            return true;
        }

        return false;

    }

    public static boolean hasEmptyCells(String[][] arrayMatrix) {
        for (String[] rowsArray : arrayMatrix) {
            for (String cell : rowsArray) {
                if (!cell.equals("X") && !cell.equals("O")) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isImpossibleState(String[][] arrayMatrix) {
        int noOfX = 0;
        int noOfO = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arrayMatrix[i][j].equals("X")) {
                    noOfX++;
                } else if (arrayMatrix[i][j].equals("O")) {
                    noOfO++;
                }
            }
        }

        return noOfX > noOfO + 1 || noOfO > noOfX + 1;
    }

    public static String evaluateGame(String[][] arrayMatrix) {
        boolean threeX = hasThreeOf(arrayMatrix, "X");
        boolean threeO = hasThreeOf(arrayMatrix, "O");
        if (isImpossibleState(arrayMatrix)) {
            return "Impossible";
        } else if (threeX && !threeO) {
            return "X wins";
        } else if (!threeX && threeO) {
            return "O wins";
        } else if (!threeX && !threeO) {
            if (hasEmptyCells(arrayMatrix)) {
                return "Game not finished";
            } else {
                return "Draw";
            }
        } else if (threeX && threeO) {
            return "Impossible";
        } else {
            return "Unknown";
        }
    }

    public static void makeNewMove(String[][] arrayMatric, String choice) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter the coordinates: ");
                String[] tokens = scanner.nextLine().split(" ");
                int i = Integer.parseInt(tokens[0]);
                int j = Integer.parseInt(tokens[1]);

                if (i < 1 || i > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                if (j < 1 || j > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }

                i--;
                int swap = i;
                i = Math.abs(j - 3);
                j = swap;

                if (!arrayMatric[i][j].equals("_") && !arrayMatric[i][j].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                } else {
                    arrayMatric[i][j] = choice;
                    printArray(arrayMatric);
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
        }
    }

    public static void main(String[] args) {
        // write your code here
        String[][] arrayMatrix = populateGameData();
        String choice = "X";
        String result;
        while (true) {
            printArray(arrayMatrix);
            result = evaluateGame(arrayMatrix);
            if (result.equals("Impossible") || result.equals("X wins") || result.equals("O wins") ||
                    result.equals("Draw")) {
                System.out.println(result);
                break;
            }

            makeNewMove(arrayMatrix, choice);
            if (choice.equals("X")) {
                choice = "O";
            } else {
                choice = "X";
            }
        }
    }


}