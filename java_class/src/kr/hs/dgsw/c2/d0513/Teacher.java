package kr.hs.dgsw.c2.d0513;

import java.util.Scanner;

public class Teacher implements Runnable {
    private int value;

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("���ڸ� �Է��ϼ���: ");
            this.value = sc.nextInt();

            synchronized (this) {
                this.notifyAll();
            }

            if (this.value <= 0) {
                break;
            }
        }
        sc.close();
        System.out.println("������ �����尡 ����Ǿ����ϴ�.");
    }

    public int getValue() {
        return this.value;
    }
}