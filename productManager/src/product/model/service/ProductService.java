package product.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import static common.JDBCTemplate.*;

import product.PException;
import product.model.dao.ProductDao;
import product.model.dto.Product;

public class ProductService {
	
	private ProductDao pd;
	
	public ProductService() throws PException {
		 pd = new ProductDao();
	}

	public ArrayList<Product> displayList() throws PException {
		Connection conn = getConnection();
		ArrayList<Product> list = pd.displayList(conn); 
		return list;
	}

	public int insertRow(Product p) throws PException {
		Connection conn = getConnection();
		int result = pd.insertRow(conn, p);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public Product searchId(String id) throws PException {
		Connection conn = getConnection();
		Product prod = pd.searchId(conn, id);
		return prod;
	}

	public int updatePrice(Product prod) throws PException {
		Connection conn = getConnection();
		int result = pd.updatePrice(conn, prod);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public int deleteProd(Product prod) throws PException {
		Connection conn = getConnection();
		int result = pd.deleteProd(conn, prod);
		if(result > 0)
			commit(conn);
		close(conn);
		return result;
	}

	public ArrayList<Product> selectName(String name) throws PException {
		Connection conn = getConnection();
		ArrayList<Product> list = pd.selectName(conn, name);
		return list;
	}

	
}
