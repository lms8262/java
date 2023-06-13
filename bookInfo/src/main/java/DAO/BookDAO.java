package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Book;

public class BookDAO {
	final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:xe";

	public Connection open() {
		Connection conn = null; // 데이터베이스 연결 담당
		try {
			Class.forName(JDBC_DRIVER); // 드라이버 로드
			conn = DriverManager.getConnection(JDBC_URL, "test", "test1234"); // DB연결
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 리스트 가져오기
	public ArrayList<Book> getList() throws Exception {
		Connection conn = open();

		ArrayList<Book> bookList = new ArrayList<>();

		String sql = "select book_no, book_name, category, img from book";
		PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리문 등록
		ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Book b = new Book();
				b.setBook_no(rs.getInt("book_no"));
				b.setBook_name(rs.getString("book_name"));
				b.setCategory(rs.getString("category"));
				b.setImg(rs.getString("img"));
				bookList.add(b);
			}
			return bookList;
		}
	}

	// 만화 리스트 가져오기
	public ArrayList<Book> getComicList() throws Exception {
		Connection conn = open();

		ArrayList<Book> bookList = new ArrayList<>();

		String sql = "select book_no, book_name, category, img from book where category = '만화'";
		PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리문 등록
		ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Book b = new Book();
				b.setBook_no(rs.getInt("book_no"));
				b.setBook_name(rs.getString("book_name"));
				b.setCategory(rs.getString("category"));
				b.setImg(rs.getString("img"));
				bookList.add(b);
			}
			return bookList;
		}
	}

	// 소설 리스트 가져오기
	public ArrayList<Book> getNovelList() throws Exception {
		Connection conn = open();

		ArrayList<Book> bookList = new ArrayList<>();

		String sql = "select book_no, book_name, category, img from book where category = '소설'";
		PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리문 등록
		ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Book b = new Book();
				b.setBook_no(rs.getInt("book_no"));
				b.setBook_name(rs.getString("book_name"));
				b.setCategory(rs.getString("category"));
				b.setImg(rs.getString("img"));
				bookList.add(b);
			}
			return bookList;
		}
	}

	// 만화, 소설 제외 리스트 가져오기
	public ArrayList<Book> getEtcList() throws Exception {
		Connection conn = open();

		ArrayList<Book> bookList = new ArrayList<>();

		String sql = "select book_no, book_name, category, img from book where category not in('만화', '소설')";
		PreparedStatement pstmt = conn.prepareStatement(sql); // 쿼리문 등록
		ResultSet rs = pstmt.executeQuery(); // 쿼리문 실행

		try (conn; pstmt; rs) {
			while (rs.next()) {
				Book b = new Book();
				b.setBook_no(rs.getInt("book_no"));
				b.setBook_name(rs.getString("book_name"));
				b.setCategory(rs.getString("category"));
				b.setImg(rs.getString("img"));
				bookList.add(b);
			}
			return bookList;
		}
	}

	public Book getView(int book_no) throws Exception {
		Connection conn = open();
		Book b = new Book();

		String sql = "select book_no, book_name, to_char(publication_date, 'yyyy-mm-dd') publication_date, author, publisher, page, book_intro, category, img from book where book_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, book_no);
		ResultSet rs = pstmt.executeQuery();

		try (conn; pstmt; rs) {
			while (rs.next()) {
				b.setBook_no(rs.getInt("book_no"));
				b.setBook_name(rs.getString("book_name"));
				b.setPublication_date(rs.getString("publication_date"));
				b.setAuthor(rs.getString("author"));
				b.setPublisher(rs.getString("publisher"));
				b.setPage(rs.getInt("page"));
				b.setBook_intro(rs.getString("book_intro"));
				b.setCategory(rs.getString("category"));
				b.setImg(rs.getString("img"));
			}
			return b;
		}
	}

	public void insertBook(Book b) throws Exception {
		Connection conn = open();

		String sql = "insert into book values(book_no_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setString(1, b.getBook_name());
			Date publication_date = Date.valueOf(b.getPublication_date());
			pstmt.setDate(2, publication_date);
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setInt(5, b.getPage());
			pstmt.setString(6, b.getBook_intro());
			pstmt.setString(7, b.getCategory());
			pstmt.setString(8, b.getImg());
			pstmt.executeUpdate();
		}
	}

	public void updateBook(Book b) throws Exception {
		Connection conn = open();

		String sql = "update book set book_name = ?, publication_date = ?, author = ?, publisher = ?, page = ?, book_intro = ?, category = ?, img = ? where book_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setString(1, b.getBook_name());
			Date publication_date = Date.valueOf(b.getPublication_date());
			pstmt.setDate(2, publication_date);
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setInt(5, b.getPage());
			pstmt.setString(6, b.getBook_intro());
			pstmt.setString(7, b.getCategory());
			pstmt.setString(8, b.getImg());
			pstmt.setInt(9, b.getBook_no());

			if (pstmt.executeUpdate() != 1) {
				throw new Exception("수정된 글이 없습니다.");
			}
		}
	}

	public void deleteBook(int book_no) throws Exception {
		Connection conn = open();

		String sql = "delete from book where book_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		try (conn; pstmt) {
			pstmt.setInt(1, book_no);

			if (pstmt.executeUpdate() != 1) {
				throw new Exception("삭제된 글이 없습니다.");
			}
		}
	}

}
