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
                System.out.println(game.winCount+"승"+game.tieCount+"무"+game.loseCount+"패");
                break;
            }
            int inputNumber = Character.getNumericValue(game.inputData);

            if(inputNumber > 3 || inputNumber < 0 ){
                System.out.println("다시 입력 해 주세요");
                continue;
            }
            game.check(inputNumber);
        }

    }

    private void input(Scanner scanner){
        System.out.println("1.가위   2.바위   3.보    Q.종료");
        this.inputData = scanner.next().charAt(0);
    }

    private void check(int userPick){
        int computer = getComputerRandom();

        if(computer==1)
            System.out.println("컴퓨터 : 가위");
        if(computer==2)
            System.out.println("컴퓨터 : 바위");
        if(computer==3)
            System.out.println("컴퓨터 : 보");

        if(userPick==1)
            System.out.println("사용자 : 가위");
        if(userPick==2)
            System.out.println("사용자 : 바위");
        if(userPick==3)
            System.out.println("사용자 : 보");

        if((computer == SCISSORS && userPick == ROCK) || (computer == ROCK && userPick == PAPER) || (computer == PAPER && userPick == SCISSORS)){
            System.out.println("결과 : 승");
            winCount++;
        }else if(inputData == computer) {
            System.out.println("결과 : 무");
            tieCount++;
        }else{
            System.out.println("결과 : 패");
            loseCount++;
        }
    }

    private int getComputerRandom(){
        Random random = new Random();
        return random.nextInt(3);
    }

}
