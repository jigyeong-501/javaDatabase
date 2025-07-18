package Burgerking;

import java.util.ArrayList;
import java.util.List;

public class BurgerkingDAO extends DBConn{
	
	public BurgerkingDAO() {
	
	}
	
	public List<String> getMenuByKind(int kind) {
	    List<String> menus = new ArrayList<>();
	    try {
	        String sql = "SELECT name FROM burgerking WHERE kind = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, kind);

	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	            menus.add(rs.getString("name"));
	        }

	        rs.close();
	        pstmt.close();
	        //conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return menus;
	}

}
