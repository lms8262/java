package library.checkout;

import library.Library;
import library.Member;

public class SpecialCheckOut implements CheckOut {
	Library library = Library.getInstance();
	
	@Override
	public void checkOutBook(Member loginMember) {

	}

	@Override
	public void returnBook(Member loginMember) {

	}

}
