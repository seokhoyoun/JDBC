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
			e.printStackTrace();
		}
	}
	public List<Product> displayList() {
		ArrayList<Product> list = ps.displayList();
			
		return list;
	}
	public Product insertRow(Product p) {
		int result = ps.insertRow(p);
		if(result <= 0)
			System.out.println("상품 추가를 실패했습니다.");
		return p;
	}
	public Product searchId(String id) {
		Product prod = ps.searchId(id);
		if(prod == null)
			System.out.println(id+"의 검색 실패");
		return prod;
	}
	public void updatePrice(Product prod) {
		int result = ps.updatePrice(prod);
		if(result > 0)
			System.out.println("수정되었습니다.");
	}
	public void deleteProd(Product prod) {
		if(prod == null)
			return;
		else {	
			int result = ps.deleteProd(prod);
			if(result > 0)
				System.out.println("삭제되었습니다.");
		}
			
				
	}
	public List<Product> selectName(String name) {
		ArrayList<Product> list = ps.selectName(name);
		if(list.isEmpty())
			System.out.println("조회된 결과가 없습니다.");
		return list;
	}

}
