package ebook;

public class EBookExample {

	public static void main(String[] args) {
		// 인스턴스 생성
		EBook myEBook = new EBook(50);
		
		myEBook.buy();
		myEBook.rental();
		myEBook.rental();
		
		myEBook.read();
		System.out.println(myEBook.currentPage);
		
	}

}
