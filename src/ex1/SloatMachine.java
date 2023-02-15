package ex1;

import java.util.Scanner;

public class SloatMachine {
	
	private Bank bank;
	
	public SloatMachine(Bank bank) {
		this.bank = bank;
	}
	
	Scanner sc = new Scanner(System.in);

	int initialCount = 5;
	int mode, cnt;
	int profit = 0;

	Drink coke = new Drink("콜라", initialCount, 500);
	Drink sprite = new Drink("사이다", initialCount, 600);
	Drink milkis = new Drink("밀키스", initialCount, 650);
	
	public void machine() {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("모드를 선택해주세요.");
		System.out.println("1: 사용자 모드");
		System.out.println("2: 관리자 모드");
		System.out.println("3: 종료");

		mode = sc.nextInt();

		switch (mode) {
		case 1:
			client();
			break;
		case 2:
			management();
			break;
		case 3:
			System.out.println("종료합니다");
			break;
		}
	}

	public void management() {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("추가하실 음료와 개수를 입력해주세요.");
		System.out.println("1: " + coke.getName());
		System.out.println("2: " + sprite.getName());
		System.out.println("3: " + milkis.getName());
		System.out.println("4: 음료 개수 출력");
		System.out.println("5: 잔액");
		System.out.println("6: 종료");

		mode = sc.nextInt();

		if (1 <= mode && mode <= 3) {
			System.out.print("개수: ");
			cnt = sc.nextInt();
			addProduct(mode, cnt);
		}
		else if (4 == mode) {
			System.out.println(coke.getName() + " 개수: " + coke.getCount());
			System.out.println(sprite.getName() + " 개수: " + sprite.getCount());
			System.out.println(milkis.getName() + " 개수: " + milkis.getCount());
		}
		else if (5 == mode) {
			System.out.println("번 돈은 총 " + profit + "원이고 잔액은 " + bank.getMoney() + "원 입니다.");
		}
		else if (6 == mode) {
			System.out.println("종료합니다.");
		}
	}

	public void addProduct(int mode, int cnt) {
		Drink drink = selectDrink(mode);
		drink.setCount(drink.getCount() + cnt);
	}

	public void client() {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("음료를 선택해주세요.");
		System.out.println("1: " + coke.getName() + " - " + coke.getPrice());
		System.out.println("2: " + sprite.getName() + " - " + sprite.getPrice());
		System.out.println("3: " + milkis.getName() + " - " + milkis.getPrice());
		System.out.println("4: 종료");

		mode = sc.nextInt();

		if (1 <= mode && mode <= 3) {
			buyDrink(selectDrink(mode));
		}
		else if (4 == mode) {
			System.out.println("종료합니다.");
		}
	}

	public Drink selectDrink(int mode) {

		switch (mode) {
		case 1:
			return coke;
		case 2:
			return sprite;
		case 3:
			return milkis;
		default:
			return null;
		}
	}

	public void buyDrink(Drink drink) {

		if (drink.getCount() > 0) {
			System.out.println(drink.getName() + "가 나왔습니다.");
			profit += drink.getPrice();
			bank.setMoney(bank.getMoney() + drink.getPrice());
			drink.setCount(drink.getCount() - 1);
		}
		else {
			System.out.println(drink.getName() + "가 없습니다");
		}
	}
}
