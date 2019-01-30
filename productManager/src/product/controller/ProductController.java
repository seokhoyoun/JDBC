package product.controller;

import java.util.ArrayList;
import java.util.List;

import product.PException;
import product.model.dto.Product;
import product.model.service.ProductService;

public class ProductController {

	private ProductService ps;
	
	public ProductController() {
		try {
			ps = new ProductService();
		} catch (PException e) {
			printError(e.getMessage());
		}
	}
	
	
	private void printError(String message) {
		System.out.println("\n프로그램 오류 발생!");
		System.out.println("시스템 관리자에게 문의하십시요.");
		System.out.println("오류 메세지 : " + message);
	}


	public List<Product> displayList() {
		ArrayList<Product> list = null;
		try {
			list = ps.displayList();
		} catch (PException e) {
			printError(e.getMessage());
		}
			
		return list;
	}
	public Product insertRow(Product p) {
		int result;
		try {
			result = ps.insertRow(p);
			if(result <= 0)
				System.out.println("상품 추가를 실패했습니다.");
		} catch (PException e) {
			printError(e.getMessage());
		}
		return p;
	}
	public Product searchId(String id) {
		Product prod = null;
		try {
			prod = ps.searchId(id);
			if(prod == null)
				System.out.println(id+"의 검색 실패");
		} catch (PException e) {
			printError(e.getMessage());
		}
		return prod;
	}
	public void updatePrice(Product prod) {
		int result;
		try {
			result = ps.updatePrice(prod);
			if(result > 0)
				System.out.println("수정되었습니다.");
		} catch (PException e) {
			printError(e.getMessage());
		}
	}
	public void deleteProd(Product prod) {
		if(prod == null)
			return;
		else {	
			try {
				int result = ps.deleteProd(prod);
				if(result > 0)
					System.out.println("삭제되었습니다.");
			} catch (PException e) {
				printError(e.getMessage());
			}
		}
			
				
	}
	public List<Product> selectName(String name) {
		ArrayList<Product> list = null;
		try {
			list = ps.selectName(name);
		} catch (PException e) {
			printError(e.getMessage());
		}
		return list;
	}

}
