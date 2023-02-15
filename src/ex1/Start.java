package ex1;

import java.util.Scanner;

public class Start {

	Scanner sc = new Scanner(System.in);
	int mode;
	Bank bank = new Bank();
	SloatMachine sm = new SloatMachine(bank);
	
	public void start() {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("모드를 선택해주세요.");
		System.out.println("1: 은행업무");
		System.out.println("2: 자판기");
		System.out.println("3: 종료");
		
		mode = sc.nextInt();

		switch (mode) {
		case 1:
			bank.atm();
			start();
			break;
		case 2:
			sm.machine();
			start();
			break;
		case 3:
			System.out.println("종료합니다");
			return;
		}
		
	}

	public static void main(String[] args) {
		
		Start s = new Start();
		s.start();
	}
}
