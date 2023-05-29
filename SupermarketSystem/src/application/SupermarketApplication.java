package application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import member.Member;
import product.*;
import supermarket.Supermarket;
import utils.Define;

public class SupermarketApplication {
	Supermarket supermarket = Supermarket.getInstance();
	Map<Product, Integer> shoppingCart = new HashMap<>(); // 장바구니
	Scanner sc = new Scanner(System.in);

	public void run() {
		createProduct();
		createMember();
		boolean runCheck = true;
		while (runCheck) {
			System.out.println(Define.LINE);
			System.out.println("\t\t" + supermarket.getName());
			System.out.println(" 1.장바구니 담기   2.장바구니 확인   3.결제하기");
			System.out.println(" 4.회원정보 확인   5.회원목록 확인   6.종료");
			System.out.println(Define.LINE);
			while (true) {
				try {
					int select = 0;
					System.out.print("선택> ");
					select = sc.nextInt();
					switch (select) {
					case 1:
						shopping(); // 쇼핑 및 장바구니 담기
						break;
					case 2:
						printShoppingCartList(); // 장바구니 확인
						break;
					case 3:
						// 결제 메소드
						break;
					case 4:
						memberInfo(); // 회원정보 확인
						break;
					case 5:
						printMemberList(); // 회원목록 확인(관리자 전용)
						break;
					case 6:
						runCheck = false;
						break;
					default:
						System.out.println("1~6 사이의 숫자를 입력해주세요.");
						break;
					}
					break;
				} catch (Exception e) {
					sc.next();
					System.out.println("1~6 사이의 숫자를 입력해주세요.");
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
		Fish fish2 = new Fish("고등어", 2000, "노르웨이산");
		Fish fish3 = new Fish("굴비", 1500, "국내산");
		Fish fish4 = new Fish("새우", 800, "에콰도르산");
		Fish fish5 = new Fish("오징어", 1500, "원양산");

		supermarket.addProduct(fish1);
		supermarket.addProduct(fish2);
		supermarket.addProduct(fish3);
		supermarket.addProduct(fish4);
		supermarket.addProduct(fish5);

		Fruit fruit1 = new Fruit("사과", 1500, "국내산");
		Fruit fruit2 = new Fruit("바나나", 5000, "필리핀산");
		Fruit fruit3 = new Fruit("포도", 10000, "칠레산");
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

	public Member searchMember(String memberName, int MemberNum) { // 회원 검색
		Iterator<Member> members = supermarket.getMemberList().iterator();
		Member member = null;
		Member checkMember = new Member(memberName, MemberNum);
		while (members.hasNext()) {
			member = members.next();
			if ((member.equals(checkMember)) && (member.hashCode() == checkMember.hashCode())) {
				return member; // 검색한 회원이 있으면 리턴
			}
		}
		return null; // 검색한 회원이 없으면 null 리턴
	}

	public Member login() { // 결제, 회원정보 확인 시 로그인
		System.out.println("회원이름과 회원번호를 입력해주세요.");
		System.out.print("회원이름> ");
		String memberName = sc.next();
		int memberNum = 0;
		while (true) {
			try {
				System.out.print("회원번호> ");
				memberNum = sc.nextInt();
				break;
			} catch (Exception e) {
				sc.next();
				System.out.println("회원번호는 정수로 입력해주세요.");
			}
		}
		Member member = searchMember(memberName, memberNum); // 입력한 정보에 맞는 회원 찾은 후 로그인
		if (member == null) { // 회원정보를 찾지 못한 경우
			System.out.println("회원정보를 찾을 수 없습니다.");
			System.out.println("입력한 정보로 회원가입 하시겠습니까? Y / N");
			while (true) {
				System.out.println("선택> ");
				String select = sc.next();
				if (select.toUpperCase().equals("Y")) { // Y 선택시 입력한 정보로 회원가입
					member = new Member(memberName, memberNum);
					supermarket.addMember(member);
					System.out.println(member.getMemberName() + "(" + member.getMemberNum() + ")님 회원가입을 환영합니다.");
					return member;
				} else if (select.toUpperCase().equals("N")) { // N 선택시 게스트로 진행
					System.out.println("회원가입을 하지 않으셨습니다. 게스트로 진행합니다.");
					return null;
				} else {
					System.out.println("Y 또는 N 으로 입력해주세요.");
				}
			}
		} else { // 회원정보를 찾은 경우
			System.out.println(member.getMemberName() + "(" + member.getMemberNum() + ")님 로그인 하였습니다.");
			return member;
		}
	}

	public void memberInfo() { // 회원정보 확인
		Member member = login();
		if (member == null) {
			System.out.println("게스트로는 회원정보를 확인할 수 없습니다.");
			return;
		}
		member.printMemberInfo();
	}

	public void printMemberList() { // 전체 회원이름(회원번호) 출력
		System.out.println("관리자 이름과 비밀번호를 입력해주세요.");
		System.out.print("이름> ");
		String adminName = sc.next();
		int adminPassword = 0;
		while (true) {
			try {
				System.out.print("비밀번호> ");
				adminPassword = sc.nextInt();
				break;
			} catch (Exception e) {
				sc.next();
				System.out.println("비밀번호는 숫자로 입력해주세요.");
			}
		}
		if (!(adminName.equals(Define.ADMIN_NAME)) || !(adminPassword == Define.ADMIN_PASSWORD)) {
			System.out.println("관리자 이름 또는 비밀번호가 맞지 않습니다.");
			return;
		}
		Iterator<Member> members = supermarket.getMemberList().iterator();
		System.out.println(Define.LINE);
		System.out.println("\t" + supermarket.getName() + " 회원목록");
		System.out.println("회원이름(회원번호)");
		while (members.hasNext()) {
			Member currentMember = members.next();
			System.out.println(currentMember.getMemberName() + "(" + currentMember.getMemberNum() + ")");
		}
		System.out.println(Define.LINE);
	}

	public void printShoppingCartList() { // 장바구니 확인
		if (shoppingCart.size() == 0) {
			System.out.println("장바구니가 비어있습니다.");
			return;
		}
		Iterator<Map.Entry<Product, Integer>> products = shoppingCart.entrySet().iterator();
		System.out.println(Define.LINE);
		System.out.println("\t\t장바구니");
		System.out.println("상품명  |  가격  |  수량");
		while (products.hasNext()) {
			Map.Entry<Product, Integer> productEntry = products.next();
			Product product = productEntry.getKey();
			int amount = productEntry.getValue();
			System.out.println(product.productInfo() + "   " + amount + "개");
		}
		System.out.println(Define.LINE);
	}

	public void shopping() { // 쇼핑하기
		System.out.println(Define.LINE);
		System.out.println("어떤 종류의 상품을 원하십니까?");
		System.out.println("1." + Define.DRINK + "   2." + Define.FISH + "   3." + Define.FRUIT);
		System.out.println("4." + Define.MEAT + "   5." + Define.SNACK + "   6." + Define.VEGETABLE);
		System.out.println(Define.LINE);
		int select = 0;
		while (true) {
			try {
				System.out.print("선택> ");
				select = sc.nextInt();
				switch (select) {
				case 1:
					printProductList(Define.DRINK);
					putProduct(Define.DRINK);
					break;
				case 2:
					printProductList(Define.FISH);
					putProduct(Define.FISH);
					break;
				case 3:
					printProductList(Define.FRUIT);
					putProduct(Define.FRUIT);
					break;
				case 4:
					printProductList(Define.MEAT);
					putProduct(Define.MEAT);
					break;
				case 5:
					printProductList(Define.SNACK);
					putProduct(Define.SNACK);
					break;
				case 6:
					printProductList(Define.VEGETABLE);
					putProduct(Define.VEGETABLE);
					break;
				default:
					System.out.println("1~6 사이의 숫자를 입력해주세요.");
					break;
				}
				break;
			} catch (Exception e) {
				sc.next();
				System.out.println("1~6 사이의 숫자를 입력해주세요.");
			}
		}
	}

	public void printProductList(String kind) { // 종류별 상품 목록 출력
		System.out.println(Define.LINE);
		System.out.println("\t" + kind + " 코너");
		Iterator<Product> products = supermarket.getProductList().iterator();
		switch (kind) {
		case Define.DRINK:
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Drink) {
					System.out.println(product.productInfo());
				}
			}
			break;
		case Define.FISH:
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Fish) {
					System.out.println(product.productInfo());
				}
			}
			break;
		case Define.FRUIT:
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Fruit) {
					System.out.println(product.productInfo());
				}
			}
			break;
		case Define.MEAT:
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Meat) {
					System.out.println(product.productInfo());
				}
			}
			break;
		case Define.SNACK:
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Snack) {
					System.out.println(product.productInfo());
				}
			}
			break;
		case Define.VEGETABLE:
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Vegetable) {
					System.out.println(product.productInfo());
				}
			}
			break;
		}
		System.out.println(Define.LINE);
	}

	public void putProduct(String kind) { // 장바구니에 상품 담기
		System.out.println("담을 상품의 정보를 입력해주세요.");
		System.out.print("상품이름(띄어쓰기 포함)> ");
		sc.nextLine();
		String productName = sc.nextLine();
		int price = 0;
		while (true) {
			try {
				System.out.print("가격> ");
				price = sc.nextInt();
				break;
			} catch (Exception e) {
				sc.next();
				System.out.println("가격은 숫자로 입력해주세요.");
			}
		}
		int capacity = 0;
		String company = null;
		String origin = null;
		if (kind.equals(Define.DRINK)) {
			while (true) {
				try {
					System.out.print("용량(단위 제외)> ");
					capacity = sc.nextInt();
					break;
				} catch (Exception e) {
					sc.next();
					System.out.println("단위를 제외한 숫자만 입력해주세요.");
				}
			}
		} else if (kind.equals(Define.SNACK)) {
			System.out.print("제조회사> ");
			company = sc.next();
		} else {
			System.out.print("원산지> ");
			origin = sc.next();
		}
		int amount = 0;
		System.out.println("상품을 몇 개 담으시겠습니까?");
		while (true) {
			try {
				System.out.print("개수> ");
				amount = sc.nextInt();
				if (amount <= 0) {
					System.out.println("개수는 1개 이상 입력해주세요.");
				} else {
					break;
				}
			} catch (Exception e) {
				sc.next();
				System.out.println("개수는 정수로 입력해주세요.");
			}
		}

		Iterator<Product> products = supermarket.getProductList().iterator();
		switch (kind) {
		case Define.DRINK:
			Drink drink = new Drink(productName, price, capacity);
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Drink) {
					if ((product.hashCode() == drink.hashCode()) && (product.equals(drink))) {
						shoppingCart.put(product, amount);
						break;
					}
				}
			}
			break;
		case Define.FISH:
			Fish fish = new Fish(productName, price, origin);
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Fish) {
					if ((product.hashCode() == fish.hashCode()) && (product.equals(fish))) {
						shoppingCart.put(product, amount);
						break;
					}
				}
			}
			break;
		case Define.FRUIT:
			Fruit fruit = new Fruit(productName, price, origin);
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Fruit) {
					if ((product.hashCode() == fruit.hashCode()) && (product.equals(fruit))) {
						shoppingCart.put(product, amount);
						break;
					}
				}
			}
			break;
		case Define.MEAT:
			Meat meat = new Meat(productName, price, origin);
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Meat) {
					if ((product.hashCode() == meat.hashCode()) && (product.equals(meat))) {
						shoppingCart.put(product, amount);
						break;
					}
				}
			}
			break;
		case Define.SNACK:
			Snack snack = new Snack(productName, price, company);
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Snack) {
					if ((product.hashCode() == snack.hashCode()) && (product.equals(snack))) {
						shoppingCart.put(product, amount);
						break;
					}
				}
			}
			break;
		case Define.VEGETABLE:
			Vegetable vegetable = new Vegetable(productName, price, origin);
			while (products.hasNext()) {
				Product product = products.next();
				if (product instanceof Vegetable) {
					if ((product.hashCode() == vegetable.hashCode()) && (product.equals(vegetable))) {
						shoppingCart.put(product, amount);
						break;
					}
				}
			}
			break;
		}
		System.out.println("상품을 장바구니에 담았습니다.");
	}

	public void payment() { // 상품 결제하기

	}
}
