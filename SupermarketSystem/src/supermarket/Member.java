package supermarket;

import java.util.ArrayList;

import receipt.Receipt;
import utils.Define;

public class Member {
	private String memberName; // 회원이름
	private int memberNum; // 회원번호
	private String membership; // 회원등급 기본(SILVER), 이용실적 30만원 이상(GOLD), 100만원 이상(VIP)
	private double pointRatio; // 포인트 적립 비율
	private int totalPayment; // 이용실적
	private int point; // 보유 포인트
	private ArrayList<Receipt> receiptList = new ArrayList<>(); // 영수증 목록

	public Member(String memberName, int memberNum) {
		this.memberName = memberName;
		this.memberNum = memberNum;
		this.membership = Define.MS_SILVER; // 기본 회원등급
		this.pointRatio = Define.POINT_RATIO_SILVER; // 기본 포인트 적립 비율
	}

	@Override
	public String toString() {
		return "회원이름: " + memberName + ", 회원번호: " + memberNum;
	}

	@Override
	public int hashCode() {
		return memberName.hashCode() + memberNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Member) {
			Member target = (Member) obj;
			return target.memberName.equals(memberName) && (target.memberNum == memberNum);
		} else {
			return false;
		}
	}

	public void savePoint(int payment) {
		point += payment * pointRatio;
	}

	public void usePoint(int point) {
		if (this.point < point) {
			System.out.println("포인트가 부족합니다. 현재 포인트는 " + point + "point 입니다.");
			return;
		}
		this.point -= point;
	}

	public void upgradeMembership() {
		if (membership.equals(Define.MS_SILVER) && totalPayment >= Define.TOTAL_PAYMENT_GOLD) {
			membership = Define.MS_GOLD;
			pointRatio = Define.POINT_RATIO_GOLD;
		}
		if (membership.equals(Define.MS_GOLD) && totalPayment >= Define.TOTAL_PAYMENT_VIP) {
			membership = Define.MS_VIP;
			pointRatio = Define.POINT_RATIO_VIP;
		}
	}

	// 영수증 추가
	public void addReceipt(Receipt receipt) {
		receiptList.add(receipt);
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	public double getPointRatio() {
		return pointRatio;
	}

	public void setPointRatio(double pointRatio) {
		this.pointRatio = pointRatio;
	}

	public int getTotalPayment() {
		return totalPayment;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public ArrayList<Receipt> getReceiptList() {
		return receiptList;
	}

}
