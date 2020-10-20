package net.yakovlev.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.yakovlev.model.Product;
import net.yakovlev.model.Users;

public class DBUtils {

	public static Users findUser(Connection conn, String userName, String password) throws SQLException {
		
		String sql = "SELECT a.user_name, a.password, a.gender FROM user_account a WHERE a.user_name = ? AND a.password = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();
		
		if (rs.next()) {
			String gender = rs.getString("gender");
            Users user = new Users();
            user.setUserName(userName);;
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
	}
	
	public static Users findUser(Connection conn, String userName) throws SQLException {
		 
        String sql = "SELECT a.user_name, a.password, a.gender FROM user_account a WHERE a.user_name=?";
              
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
 
        ResultSet rs = pstm.executeQuery();
 
        if (rs.next()) {
            String password = rs.getString("Password");
            String gender = rs.getString("Gender");
            Users user = new Users();
            user.setUserName(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;
        }
        return null;
    }
	
	public static List<Product> qeueryProduct(Connection conn) throws SQLException {
		String sql = "SELECT a.code, a.name, a.price, a.score FROM product a ";
		 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()) {
            String code = rs.getString("code");
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            String score = rs.getString("score");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            product.setScore(score);
            list.add(product);
        }
        return list;
	}
	
	public static Product findProduct(Connection conn, String code) throws SQLException {
        String sql = "SELECT a.code, a.name, a.price, a.score FROM product a WHERE a.code=?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            String name = rs.getString("name");
            float price = rs.getFloat("price");
            String score = rs.getString("score");
            Product product = new Product(code, name, price, score);
            return product;
        }
        return null;
    }
	
	public static void updateProduct(Connection conn, Product product) throws SQLException {
        String sql = "UPDATE product SET name =?, price=?, score=? WHERE code=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.setString(4, product.getScore());
        pstm.executeUpdate();
    }
	
	public static void insertProduct(Connection conn, Product product) throws SQLException {
        String sql = "INSERT INTO product(code, name, price, score) VALUES (?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());
        pstm.setString(4, product.getScore());
        
        pstm.executeUpdate();
    }
	
	public static void deleteProduct(Connection conn, String code) throws SQLException {
        String sql = "DELETE FROM product WHERE code= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        pstm.executeUpdate();
    }
}
