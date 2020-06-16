package kr.hs.dgsw.c2.d0609;

import java.util.Scanner;

public class Calculate2 {

	public void execute(CalculateStrategy strategy) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("�� ���� �Է��ϼ���.");
			
			int value1 = scanner.nextInt();
			int value2 = scanner.nextInt();
			
			if(value1 == 0 && value2 == 0) {
				break;
			}
			strategy.calculate(value1, value2);
		}
		scanner.close();
		System.out.println("���α׷��� �����մϴ�.");
	}
}
