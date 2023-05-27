package application;

import java.util.HashSet;
import java.util.Scanner;

import member.Member;
import product.*;
import supermarket.Supermarket;
import utils.Define;

public class SupermarketApplication {
	Supermarket supermarket = Supermarket.getInstance();
	HashSet<Product> shoppingCart = new HashSet<>(); // 장바구니
	Scanner sc = new Scanner(System.in);

	public void run() {
		createMember();
		createProduct();
		boolean runCheck = true;
		Member member = null;
		while (runCheck) {
			System.out.println("----------------------------------------");
			System.out.println("\t\t" + supermarket.getName());
			System.out.println(" 1.장바구니 담기   2.장바구니 확인   3.결제하기");
			System.out.println(" 4.회원정보 확인   5.종료");
			System.out.println("----------------------------------------");
			while (true) {
				try {
					int select = 0;
					System.out.print("선택> ");
					select = sc.nextInt();
					switch (select) {
					case 1:
						// 장바구니 담기 메소드
						break;
					case 2:
						// 장바구니 확인 메소드
						break;
					case 3:
						// 결제 메소드
						break;
					case 4:
						// 회원정보 확인 메소드
						break;
					case 5:
						runCheck = false;
						break;
					default:
						System.out.println("1~5 사이의 숫자를 입력해주세요.");
						break;
					}
					break;
				} catch (Exception e) {
					sc.next();
					System.out.println("1~5 사이의 숫자를 입력해주세요.");
				}
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
	}

	public void createMember() { // 기본 회원 생성 및 등록
		Member member1 = new Member("김철수", 1234);
		Member member2 = new Member("이소라", 2345);
		Member member3 = new Member("강백호", 3456);
		Member member4 = new Member("정소연", 4567);
		Member member5 = new Member("박찬호", 5678);

		supermarket.addMember(member1);
		supermarket.addMember(member2);
		supermarket.addMember(member3);
		supermarket.addMember(member4);
		supermarket.addMember(member5);

		member4.setMembership(Define.MS_GOLD);
		member4.setPointRatio(Define.POINT_RATIO_GOLD);
		member5.setMembership(Define.MS_VIP);
		member5.setPointRatio(Define.POINT_RATIO_VIP);
	}

	public void createProduct() { // 상품 생성 및 등록
		Drink drink1 = new Drink("옥수수 수염차", 1500, 500);
		Drink drink2 = new Drink("포카리스웨트", 1200, 340);
		Drink drink3 = new Drink("웰치스", 800, 355);
		Drink drink4 = new Drink("레쓰비", 800, 200);
		Drink drink5 = new Drink("바나나맛 우유", 1600, 240);

		supermarket.addProduct(drink1);
		supermarket.addProduct(drink2);
		supermarket.addProduct(drink3);
		supermarket.addProduct(drink4);
		supermarket.addProduct(drink5);

		Fish fish1 = new Fish("고등어", 2500, "국내산");
		Fish fish2 = new Fish("고등어", 2000, "노르웨이");
		Fish fish3 = new Fish("굴비", 1500, "국내산");
		Fish fish4 = new Fish("새우", 800, "에콰도르");
		Fish fish5 = new Fish("오징어", 1500, "원양산");

		supermarket.addProduct(fish1);
		supermarket.addProduct(fish2);
		supermarket.addProduct(fish3);
		supermarket.addProduct(fish4);
		supermarket.addProduct(fish5);

		Fruit fruit1 = new Fruit("사과", 1500, "국내산");
		Fruit fruit2 = new Fruit("바나나", 5000, "필리핀");
		Fruit fruit3 = new Fruit("포도", 10000, "칠레");
		Fruit fruit4 = new Fruit("배", 1300, "국내산");
		Fruit fruit5 = new Fruit("딸기", 8000, "국내산");

		supermarket.addProduct(fruit1);
		supermarket.addProduct(fruit2);
		supermarket.addProduct(fruit3);
		supermarket.addProduct(fruit4);
		supermarket.addProduct(fruit5);

		Meat meat1 = new Meat("돼지고기 삼겹살", 13000, "국내산");
		Meat meat2 = new Meat("돼지고기 목살", 12000, "국내산");
		Meat meat3 = new Meat("소고기 등심", 15000, "미국산");
		Meat meat4 = new Meat("생닭", 7000, "국내산");
		Meat meat5 = new Meat("훈제오리", 10000, "국내산");

		supermarket.addProduct(meat1);
		supermarket.addProduct(meat2);
		supermarket.addProduct(meat3);
		supermarket.addProduct(meat4);
		supermarket.addProduct(meat5);

		Snack snack1 = new Snack("포카칩", 1500, "오리온");
		Snack snack2 = new Snack("썬칩", 1300, "오리온");
		Snack snack3 = new Snack("홈런볼", 1500, "해태");
		Snack snack4 = new Snack("초코파이", 5000, "오리온");
		Snack snack5 = new Snack("새우깡", 1600, "농심");

		supermarket.addProduct(snack1);
		supermarket.addProduct(snack2);
		supermarket.addProduct(snack3);
		supermarket.addProduct(snack4);
		supermarket.addProduct(snack5);

		Vegetable vegetable1 = new Vegetable("양배추", 4000, "국내산");
		Vegetable vegetable2 = new Vegetable("당근", 4000, "국내산");
		Vegetable vegetable3 = new Vegetable("감자", 2500, "국내산");
		Vegetable vegetable4 = new Vegetable("고구마", 3000, "국내산");
		Vegetable vegetable5 = new Vegetable("배추", 2500, "국내산");

		supermarket.addProduct(vegetable1);
		supermarket.addProduct(vegetable2);
		supermarket.addProduct(vegetable3);
		supermarket.addProduct(vegetable4);
		supermarket.addProduct(vegetable5);
	}

	public void memberInfo(Member member) {
		if (member == null) {

		}
	}

}
