package kr.hs.dgsw.c2.d0507;

import java.util.Random;
import java.util.Scanner;
import static java.lang.Character.getNumericValue;

public class Game {
    int winCount = 0;
    int tieCount = 0;
    int loseCount = 0;
    int inputData = 0;

    int SCISSORS = 1;
    int ROCK = 2;
    int PAPER = 3;

    public static void main(String[] args) {
        Game game = new Game();
        Scanner scanner = new Scanner(System.in);

        while (true){
            game.input(scanner);
            if(game.inputData == 'Q'){
                System.out.println(game.winCount+"��"+game.tieCount+"��"+game.loseCount+"��");
                break;
            }
            int inputNumber = Character.getNumericValue(game.inputData);

            if(inputNumber > 3 || inputNumber < 0 ){
                System.out.println("�ٽ� �Է� �� �ּ���");
                continue;
            }
            game.check(inputNumber);
        }

    }

    private void input(Scanner scanner){
        System.out.println("1.����   2.����   3.��    Q.����");
        this.inputData = scanner.next().charAt(0);
    }

    private void check(int userPick){
        int computer = getComputerRandom();

        if(computer==1)
            System.out.println("��ǻ�� : ����");
        if(computer==2)
            System.out.println("��ǻ�� : ����");
        if(computer==3)
            System.out.println("��ǻ�� : ��");

        if(userPick==1)
            System.out.println("����� : ����");
        if(userPick==2)
            System.out.println("����� : ����");
        if(userPick==3)
            System.out.println("����� : ��");

        if((computer == SCISSORS && userPick == ROCK) || (computer == ROCK && userPick == PAPER) || (computer == PAPER && userPick == SCISSORS)){
            System.out.println("��� : ��");
            winCount++;
        }else if(inputData == computer) {
            System.out.println("��� : ��");
            tieCount++;
        }else{
            System.out.println("��� : ��");
            loseCount++;
        }
    }

    private int getComputerRandom(){
        Random random = new Random();
        return random.nextInt(3);
    }

}
