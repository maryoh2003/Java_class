package kr.hs.dgsw.c2.d0513;

import java.util.Scanner;

public class Teacher implements Runnable {
    private int value;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("숫자를 입력하세요: ");
            this.value = sc.nextInt();

            synchronized (this) {
                this.notifyAll();
            }

            if (this.value <= 0) {
                break;
            }
        }
        sc.close();
        System.out.println("선생님 스레드가 종료되었습니다.");
    }

    public int getValue() {
        return this.value;
    }
}