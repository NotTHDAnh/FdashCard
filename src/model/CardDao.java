package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DbUtils;

public class CardDao {
	List<Card> listOfCard;
	public List<Card> getListOfCard() {
		return listOfCard;
	}
	public boolean addCard(Card newCard,int set_id)
	throws SQLException, ClassNotFoundException {
		boolean result = false;
		Connection con = null;
		PreparedStatement stm = null;
		
		try {
			con = DbUtils.getConnection();
			String sql = "insert tblCards(id,hint,description,set_id) "
					+ "values(?,?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setInt(1, newCard.getId());
			stm.setString(2, newCard.getHint());
			stm.setString(3, newCard.getDescription());
			stm.setInt(4, set_id);
			int effectedRow = stm.executeUpdate();
			if(effectedRow > 0) {
				result = true;
			}
		}finally {
			if(con != null) {
				con.close();
			}
			if(stm != null) {
				stm.close();
			}
		}
		return result;
	}
	public boolean loadCard(int set_id)
			throws SQLException, ClassNotFoundException {
		boolean result = false;
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			con = DbUtils.getConnection();
			String sql = "select description,hint,id "
					+ "from tblCards "
					+ "where set_id = ?";
			stm = con.prepareStatement(sql);
			stm.setInt(1, set_id);
			rs = stm.executeQuery();
			if(listOfCard == null) {
				listOfCard = new ArrayList<Card>();
			}
			while(rs.next()) {
				int id = rs.getInt("id");
				String hint = rs.getString("hint");
				String description = rs.getString("description");
				listOfCard.add(new Card(id, hint, description, set_id));
				result = true;
			}
		}finally {
			if(con != null) {
				con.close();
			}
			if(stm != null) {
				stm.close();
			}
		}
		return result;
	}
	
}
