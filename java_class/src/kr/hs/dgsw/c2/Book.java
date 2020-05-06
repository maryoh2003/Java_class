package kr.hs.dgsw.c2;

public class Book {
	
	private String title;
	
	private String content;
	
	private int price;
	
	public Book() {
		this("무제"); //첫번째 생성자에서 두번째 생성자를 불러줌
	}
	
	public Book(String title) {
		this.title = title;
		System.out.println("위에거랑 위치가 바뀌면 오류뜸"); //생성자가 가장 먼저 일을 해줘야하기 때문에 sysout이 맨위에가면 오류
	}
	
	
//	public Book(String title) {
//		System.out.println("다른 생성자");
//	}
//	
//	public Book(String title, int price) {
//		System.out.println("세번째 생성자");
//	}
//	public Book(int price, String title) {
//	System.out.println("세번째 생성자");
//}
	// 이렇게 생성자는 시그니처가 다르면 이름이 같아도 여러번 선언할 수 있다. 대신 받아오는 시그니처의 타입이 달라야한다.(타입들의 순서만 달라도 다른걸로 간주)
	
	public void set() {
		
	}
	
	public void set(String title) {
		
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String titng) {
		this.title= title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		
	}

	public static void main(String[] args) {
		
//		Book java = new Book("자바실습");	알아서 String 타입의 하나를 부르는 생성자를 찾아서 간다
		Book java = new Book("자바 실습");
		
		System.out.println(java.getTitle()+ " " + java.getPrice());
		
		Book noname = new Book();
		System.out.println();
		
	}

}
