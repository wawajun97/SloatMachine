package ex1;

import java.util.Scanner;

public class Bank {
	
	int bankMoney = 1000000;
	int money = 0;
	Scanner sc = new Scanner(System.in);
	
	public int getMoney() {
		return money;
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void deposit(int depositMoney) {
		money += depositMoney;
		System.out.println("입금이 완료되었습니다. 잔액은 " + money + "원 입니다");
		
		atm();
	}

	public void withdraw() {
		System.out.println("출금하실 금액을 입력해주세요.");
		int withdrawMoney = sc.nextInt();

		if (money >= withdrawMoney) {
			money -= withdrawMoney;
			System.out.println("출금이 완료되었습니다. 잔액은 " + money + "원 입니다");
		}
		else {
			System.out.println("잔액이 부족합니다.");
		}
		
		atm();
	}

	public void printMoney() {

		System.out.println("잔액은 " + money + "원 입니다");

		atm();
	}

	public void loan() {
		System.out.println("대출하실 금액을 입력해주세요.");
		int borrowMoney = sc.nextInt();

		if (bankMoney >= borrowMoney) {
			money += borrowMoney;
			bankMoney -= borrowMoney;
			System.out.println(borrowMoney + "원 대출하였습니다. 잔액은 " + money + "원 입니다.");
		}
		else {
			System.out.println("은행 돈이 부족합니다.");
		}

		atm();
	}

	public void atm() {

		System.out.println();
		System.out.println("--------------------");
		System.out.println("ATM 업무를 선택해주세요.");
		System.out.println("0: 입금");
		System.out.println("1: 출금");
		System.out.println("2: 잔액조회");
		System.out.println("3: 대출");
		System.out.println("4: 종료");

		int mode = sc.nextInt();

		switch (mode) {
		case 0:
			//입금
			System.out.println("입금하실 금액을 입력해주세요.");
			int depositMoney = sc.nextInt();
			deposit(depositMoney);
			break;
		case 1:
			//출금
			withdraw();
			break;
		case 2:
			//잔액조회
			printMoney();
			break;
		case 3:
			//대출
			loan();
			break;
		case 4:
			//종료
			System.out.println("종료합니다.");
			break;
		}
	}
}
