package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DbUtils;

public class CardSetDao {
	List<CardSet> listOfCardSet;
	public boolean addNewSet(CardSet cardSet)
	throws SQLException, ClassNotFoundException {
		boolean result = false;
		Connection con = null;
		PreparedStatement stm = null;
		
		try {
			con = DbUtils.getConnection();
			String sql = "insert tblCardSet(id,name,description) "
					+ "values(?,?,?)";
			stm = con.prepareStatement(sql);
			stm.setInt(1, cardSet.getId());
			stm.setString(2, cardSet.getName());
			stm.setString(3, cardSet.getDescription());
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
	

	public List<CardSet> getListOfCardSet() {
		return listOfCardSet;
	}
	
	public boolean loadCardSet() 
			throws SQLException, ClassNotFoundException {
		boolean result = false;
		Connection con = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			con = DbUtils.getConnection();
			String sql = "select id,name,description "
					+ "from tblCardSet where status=1";
			stm = con.prepareStatement(sql);
			rs = stm.executeQuery();
			if(listOfCardSet == null) {
				listOfCardSet = new ArrayList<CardSet>();
			}
			while(rs.next()) {
				int id = rs.getInt("id");
				String name= rs.getString("name");
				String description = rs.getString("description");
				listOfCardSet.add(new CardSet(id, name, description));
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

	public boolean deleteSet(int id)
	throws SQLException, ClassNotFoundException {
		boolean result = false;
		Connection con = null;
		PreparedStatement stm = null;
		
		try {
			con = DbUtils.getConnection();
			String sql = "update tblCardSet "
					+ "set status = 0 where id=?";
			stm = con.prepareStatement(sql);
			stm.setInt(1, id);
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
	
}
