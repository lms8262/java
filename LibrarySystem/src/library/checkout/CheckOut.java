package library.checkout;

import library.Member;

public interface CheckOut {
	public void checkOutBook(Member loginMember);

	public void returnBook(Member loginMember);

}
