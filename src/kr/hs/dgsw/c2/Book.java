package kr.hs.dgsw.c2;

public class Book {
	
	private String title;
	
	private String content;
	
	private int price;
	
	public Book() {
		this("����"); //ù��° �����ڿ��� �ι�° �����ڸ� �ҷ���
	}
	
	public Book(String title) {
		this.title = title;
		System.out.println("�����Ŷ� ��ġ�� �ٲ�� ������"); //�����ڰ� ���� ���� ���� ������ϱ� ������ sysout�� ���������� ����
	}
	
	
//	public Book(String title) {
//		System.out.println("�ٸ� ������");
//	}
//	
//	public Book(String title, int price) {
//		System.out.println("����° ������");
//	}
//	public Book(int price, String title) {
//	System.out.println("����° ������");
//}
	// �̷��� �����ڴ� �ñ״�ó�� �ٸ��� �̸��� ���Ƶ� ������ ������ �� �ִ�. ��� �޾ƿ��� �ñ״�ó�� Ÿ���� �޶���Ѵ�.(Ÿ�Ե��� ������ �޶� �ٸ��ɷ� ����)
	
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
		
//		Book java = new Book("�ڹٽǽ�");	�˾Ƽ� String Ÿ���� �ϳ��� �θ��� �����ڸ� ã�Ƽ� ����
		Book java = new Book("�ڹ� �ǽ�");
		
		System.out.println(java.getTitle()+ " " + java.getPrice());
		
		Book noname = new Book();
		System.out.println();
		
	}

}
