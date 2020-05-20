import java.util.Random;
import java.util.Scanner;

public class SeaBatl {
    private Scanner scanner = new Scanner(System.in);
    private char[][] ourMap = new char[4][4];
    private String firstNumber = "0",  secondNumber = "*", sumOfThisNumbers = firstNumber + secondNumber;
    private Random random = new Random();


    public void checkPlayerOnWin() {
        if (ourMap[0][0] == '0' && ourMap[0][1] == '0' && ourMap[0][2] == '0' && ourMap[0][3] == '0' && ourMap[1][0] == '0' && ourMap[1][1] == '0' && ourMap[1][2] == '0' && ourMap[1][3] == '0' && ourMap[2][0] == '0' && ourMap[2][1] == '0' && ourMap[2][2] == '0' && ourMap[2][3] == '0' && ourMap[3][0] == '0' && ourMap[3][1] == '0' && ourMap[3][2] == '0' && ourMap[3][3] == '0') {

            System.out.println("\n" + "Поздравляю, вас с победой!!!");
            System.out.println("Спасибо за игру!");
            System.exit(0);
        }
    }


    public void generateOnMap() {
        System.out.println( "-----Происходит рандомное генерирование карты-----" + "\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ourMap[i][j] = sumOfThisNumbers.charAt(random.nextInt(sumOfThisNumbers.length()));
                System.out.print(ourMap[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public void choiceOfPlayer() {
        System.out.println("\n" + "Введите необходимые координаты" );
        int xVertical = scanner.nextInt();
        int yHorizontal = scanner.nextInt();
        System.out.println("--Происходит выстрел--" + "\n");

        Boolean aBoolean = false;
        while (true){
            if (ourMap[xVertical][yHorizontal] == '*') {
                ourMap[xVertical][yHorizontal] = '0';
                updateMatrix();
                choiceOfPlayer();
            } else {
                System.out.println("--Увы, но вы не попали--");
                updateMatrix();
                choiceOfPlayer();
            }
        }
    }

    public void updateMatrix() {
        System.out.println("-----снова введите координаты-----" + "\n");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ourMap[i][j] + "\t");
            }
            System.out.println();
        }
        checkPlayerOnWin();
    }
}

