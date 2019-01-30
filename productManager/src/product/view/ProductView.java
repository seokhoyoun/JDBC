package product.view;

import java.util.List;
import java.util.Scanner;

import product.controller.ProductController;
import product.model.dto.Product;

public class ProductView {
	
	private Scanner sc = new Scanner(System.in);
	private ProductController pc = new ProductController(); 

	public void displayMenu() {
		Product prod;
		while(true) {
		System.out.print("========================\n"
				+"1. 전체 조회\r\n" + 
				"2. 추가 : 추가후 id로 조회 확인함\r\n" + 
				"3. 수정 : id으로 조회 후 가격 수정함\r\n" + 
				"4. 삭제 : id로 조회 후 삭제함\r\n" + 
				"5. 검색 : 이름으로 조회함\r\n" + 
				"6. 끝내기\n"
				+ "번호 입력 : ");
		int mnum = sc.nextInt();
		switch(mnum) {
		case 1 : displayList(pc.displayList()); break;
		case 2 : displayRow(pc.insertRow(displayInsert())); break;
		case 3 : prod = pc.searchId(putId()); pc.updatePrice(displayUpdate(prod));break;
		case 4 : prod = pc.searchId(putId()); pc.deleteProd(displayDelete(prod)); break;
		case 5 : displayRowName(pc.selectName(putName()));break;
		case 6 : return;
		}
		}
	}

	public void displayList(List<Product> list) {
		if(list == null) return;
		for(Product e : list)
			System.out.println(e);
	}
	public void displayRow(Product p) {
		System.out.println(p);
	}
	public void displayRowName(List<Product> list) {
		for(Product e : list)
			System.out.println(e);
	}
	public Product displayInsert() {
		System.out.print("아이디 입력 :");
		String id = sc.next();
		System.out.print("이름 입력 :");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("가격 입력 :");
		int price = sc.nextInt();
		System.out.print("설명 입력 :");
		sc.nextLine();
		String desc = sc.nextLine();
		return new Product(id,name,price,desc);
	}
	public Product displayUpdate(Product prod) {
		System.out.println(prod);
		System.out.print("수정할 가격 입력 : ");
		prod.setPrice(sc.nextInt());
		return prod;
	}
	public Product displayDelete(Product prod) {
		System.out.println(prod);
		System.out.print("정말 삭제하시겠습니까? (y/n) : ");
		if(sc.next().charAt(0) == 'y') {
			return prod;
		}
		return null;
			
	}
	
	public String putName() {
		System.out.println("상품명 입력 : ");
		sc.nextLine();
		return sc.nextLine();
	}
	
	public String putId() {
		System.out.print("상품 아이디 입력 : ");
		return sc.next();
	}
}
