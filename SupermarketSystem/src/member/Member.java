package member;

import java.io.Serializable;
import java.util.*;

import receipt.Receipt;
import utils.Define;

public class Member implements Serializable {

	private static final long serialVersionUID = -5019793106604660241L;
	private String memberName; // 회원이름
	private int memberNum; // 회원번호
	private String membership; // 회원등급
	private double pointRatio; // 포인트 적립 비율
	private int totalPayment; // 누적실적
	private int point; // 포인트
	private List<Receipt> receiptList = new ArrayList<>(); // 영수증 목록

	public Member(String memberName, int memberNum) {
		this.memberName = memberName;
		this.memberNum = memberNum;
		this.membership = Define.MS_SILVER; // 기본 회원등급 설정
		this.pointRatio = Define.POINT_RATIO_SILVER; // 기본 포인트 적립 비율 설정
	}

	@Override
	public String toString() {
		return "이름: " + memberName + ", 회원번호: " + memberNum;
	}

	@Override
	public int hashCode() {
		return memberName.hashCode() + memberNum;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Member)) {
			return false;
		}
		Member target = (Member) obj;
		return target.memberName.equals(this.memberName) && (target.memberNum == this.memberNum);
	}

	public void savePoint(int payment) { // 포인트 적립
		point += payment * pointRatio;
		System.out.println(Math.round(payment * pointRatio) + "point가 적립되었습니다. 현재 보유 포인트는 " + point + "point 입니다.");
	}

	public void usePoint(int point) { // 포인트 사용
		while (true) {
			if (this.point < point) {
				System.out.println("포인트가 부족합니다. 현재 보유 포인트는 " + this.point + "point 입니다.");
				return;
			} else {
				this.point -= point;
				System.out.println(point + "point를 사용하셨습니다. 남은 포인트는 " + this.point + "point 입니다.");
				break;
			}
		}
	}

	public void upgradeMembership() { // 회원등급 업그레이드
		if (membership.equals(Define.MS_VIP)) {
			return;
		}
		if (membership.equals(Define.MS_SILVER) && (totalPayment >= Define.TOTAL_PAYMENT_GOLD)) {
			membership = Define.MS_GOLD;
			pointRatio = Define.POINT_RATIO_GOLD;
		}
		if (membership.equals(Define.MS_GOLD) && (totalPayment >= Define.TOTAL_PAYMENT_VIP)) {
			membership = Define.MS_VIP;
			pointRatio = Define.POINT_RATIO_VIP;
		}
	}

	public void printMemberInfo() { // 회원정보 출력
		System.out.println(Define.LINE);
		System.out.println("회원이름: " + memberName);
		System.out.println("회원번호: " + memberNum);
		System.out.println("회원등급: " + membership);
		System.out.println(membership + "회원 혜택: 포인트 " + Math.round(pointRatio * 100) + "% 적립");
		System.out.println("누적실적: " + totalPayment + "원");
		System.out.println("보유 포인트: " + point + "point");
		System.out.println("결제건수: " + receiptList.size() + "건");
		System.out.println(Define.LINE);
	}

	public void addReceipt(Receipt receipt) { // 영수증 추가
		receiptList.add(receipt);
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public int getTotalPayment() {
		return totalPayment;
	}

	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
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

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public List<Receipt> getReceiptList() {
		return receiptList;
	}

}
