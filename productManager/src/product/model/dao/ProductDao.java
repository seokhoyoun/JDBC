package product.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static common.JDBCTemplate.*;
import product.PException;
import product.model.dto.Product;

public class ProductDao {

	private Properties p = new Properties();
	
	public ProductDao() throws PException {
		try {
			p.load(new FileReader("prop/query.properties"));
		} catch (IOException e) {
			throw new PException(e.getMessage());
		}
	}
	
	public ArrayList<Product> displayList(Connection conn) throws PException {
		ArrayList<Product> list = new ArrayList<>();
		try(PreparedStatement ps = CreatePS(conn, p.getProperty("selectall"));
				 ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setPrice(rs.getInt(3));
				prod.setDescription(rs.getString(4));
				list.add(prod);
			}
			if(list.isEmpty())
				throw new PException("상품 정보 조회에 실패했습니다.");
			
		} catch (SQLException e) {
			throw new PException(e.getMessage());
		}
		return list;
	}

	private PreparedStatement CreatePS(Connection conn, String query) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(query);
		return ps;
	}

	public int insertRow(Connection conn, Product prod) throws PException {
		int result = 0;
		try(PreparedStatement ps = conn.prepareStatement(p.getProperty("insert"))){
			ps.setString(1, prod.getId());
			ps.setString(2, prod.getName());
			ps.setInt(3, prod.getPrice());
			ps.setString(4, prod.getDescription());
			result = ps.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new PException("상품 추가에 실패했습니다.");
			}
				
		} catch (SQLException e) {
			rollback(conn);
			throw new PException(e.getMessage());
		}
		return result;
	}

	public Product searchId(Connection conn, String id) throws PException {
		Product prod = new Product();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(p.getProperty("selectid"));
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				prod.setId(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setPrice(rs.getInt(3));
				prod.setDescription(rs.getString(4));
			}
		} catch (SQLException e) {
			throw new PException(e.getMessage());
		} finally {
			try {
				rs.close();
				ps.close();
			} catch (SQLException e) {
				throw new PException(e.getMessage());
			}
		}
		return prod;
	}


	public int updatePrice(Connection conn, Product prod) throws PException {
		int result = 0;
		try(PreparedStatement ps = conn.prepareStatement(p.getProperty("update"))){
			ps.setInt(1, prod.getPrice());
			ps.setString(2, prod.getId());
			result = ps.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new PException("가격 정보 수정에 실패했습니다.");
			}
			
		} catch (SQLException e) {
			rollback(conn);
			throw new PException(e.getMessage());
		}
		return result;
	}

	public int deleteProd(Connection conn, Product prod) throws PException {
		int result = 0;
		try(PreparedStatement ps = conn.prepareStatement(p.getProperty("delete"))){
			ps.setString(1, prod.getId());
			result = ps.executeUpdate();
			if(result <= 0) {
				rollback(conn);
				throw new PException("상품 정보 삭제에 실패했습니다.");
			}
		} catch (SQLException e) {
			rollback(conn);
			throw new PException(e.getMessage());
		}
		return result;
	}

	public ArrayList<Product> selectName(Connection conn, String name) throws PException {
		ArrayList<Product> list = new ArrayList<>();
		try(PreparedStatement ps = CreateNamePS(conn,name);
				ResultSet rs = ps.executeQuery()){
			while(rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getString(1));
				prod.setName(rs.getString(2));
				prod.setPrice(rs.getInt(3));
				prod.setDescription(rs.getString(4));
				list.add(prod);
			}
			if(list.isEmpty())
				throw new PException("조회 된 상품 정보가 없습니다.");
			
		} catch (SQLException e) {
			throw new PException(e.getMessage());
		}
		return list;
	}

	private PreparedStatement CreateNamePS(Connection conn, String name) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(p.getProperty("selectname"));
		ps.setString(1, "%"+name+"%");
		return ps;
	}
	
	

}
