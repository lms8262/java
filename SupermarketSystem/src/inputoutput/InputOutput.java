package inputoutput;

import java.io.*;
import java.util.*;

import member.Member;
import receipt.Receipt;
import supermarket.Supermarket;
import utils.Define;

public class InputOutput {
	Supermarket supermarket = Supermarket.getInstance();

	// 회원 목록 직렬화
	public void saveMemberList() {
		HashSet<Member> memberList = supermarket.getMemberList();

		try {
			FileOutputStream fos = new FileOutputStream(Define.MEMBER_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(memberList);

			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 회원 목록 역직렬화
	@SuppressWarnings("unchecked")
	public void loadMemberList() {
		File file = new File(Define.MEMBER_FILE);
		if (file.exists() == false) {
			return;
		}
		HashSet<Member> memberList = null;

		try {
			FileInputStream fis = new FileInputStream(Define.MEMBER_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);

			memberList = (HashSet<Member>) ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		supermarket.setMemberList(memberList);
	}

	// 영수증 목록 직렬화
	public void saveReceiptList() {
		try {
			FileOutputStream fos = new FileOutputStream(Define.RECEIPT_FILE);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(supermarket.getReceiptList());

			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 영수증 목록 역직렬화
	@SuppressWarnings("unchecked")
	public void loadReceiptList() {
		File file = new File(Define.RECEIPT_FILE);
		if (file.exists() == false) {
			return;
		}
		ArrayList<Receipt> receiptList = null;

		try {
			FileInputStream fis = new FileInputStream(Define.RECEIPT_FILE);
			ObjectInputStream ois = new ObjectInputStream(fis);

			receiptList = (ArrayList<Receipt>) ois.readObject();

			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		supermarket.setReceiptList(receiptList);
	}
}
