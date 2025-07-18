package t6ex_Kiosk;

import java.sql.SQLException;
import java.util.ArrayList;

public class KioskDAO extends DBConn {
	KioskVO vo = null;
	
	// 상품명 검색(중복체크)
	public KioskVO getProductSearch(String product) {
		vo = new KioskVO();
		try {
			sql = "select * from kiosk where product = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setPart(rs.getString("part"));
				vo.setProduct(rs.getString("product"));
				vo.setDetail(rs.getString("detail"));
				vo.setContent(rs.getString("content"));
				vo.setCalorie(rs.getInt("calorie"));
				vo.setImage(rs.getString("image"));
				vo.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getProductSearch) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	// 상품 등록처리
	public int setKooskInput(KioskVO vo) {
		int res = 0;
		try {
			sql = "insert into kiosk values (default,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getPart());
			pstmt.setString(2, vo.getProduct());
			pstmt.setString(3, vo.getDetail());
			pstmt.setString(4, vo.getContent());
			pstmt.setInt(5, vo.getCalorie());
			pstmt.setString(6, vo.getImage());
			pstmt.setInt(7, vo.getPrice());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류(setKooskInput) : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 상품 가져오기
	public ArrayList<KioskVO> getProductList(String part) {
		ArrayList<KioskVO> vos = new ArrayList<KioskVO>();
		try {
			sql = "select * from kiosk where part = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, part);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new KioskVO();
				vo.setIdx(rs.getInt("idx"));
				vo.setPart(rs.getString("part"));
				vo.setProduct(rs.getString("product"));
				vo.setDetail(rs.getString("detail"));
				vo.setContent(rs.getString("content"));
				vo.setCalorie(rs.getInt("calorie"));
				vo.setImage(rs.getString("image"));
				vo.setPrice(rs.getInt("price"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류(getProductList) : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

}
