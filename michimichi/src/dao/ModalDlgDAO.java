package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DbConnection;
import model.Posts;

/**
 * モーダルダイアログ用DAO
 */
public class ModalDlgDAO {
	/**
	 * 指定されたconIdに対応するコンテンツビーンズのリストを返す
	 * @param conId
	 */
	public Posts findContents(int conId) {
		Posts post = null;

		//サブカテゴリテーブルからcatIdに対応するサブカテゴリリストを取得
		String sql = "";
		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		try {
			sql = "SELECT";
			sql += " CON_ID,TITLE,OVERVIEW,IMG_URL,PAGE_URL,"
					+ "LINK1, LINK2, LOCATION";
			sql += " FROM T_CONTENTS ";
			sql += " WHERE CON_ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL文の「？」に使用する値を設定しSQLを完成
			pStmt.setInt(1, conId);
			ResultSet rs = pStmt.executeQuery();
			while(rs.next()) {
				String title = rs.getString("TITLE");
				String overview = rs.getString("OVERVIEW");
				String imgUrl = DAOConstant.convImg(rs.getString("IMG_URL"));
				String pageUrl = rs.getString("PAGE_URL");
				if(pageUrl!=null) {
					pageUrl = Integer.toString(conId);
				}
				String link1 = rs.getString("LINK1");
				String link2 = rs.getString("LINK2");
				String location = rs.getString("LOCATION");
				post = new Posts();
//				contents = new Contents(conId,
//						title,overview,imgUrl,pageUrl,link1,link2,null,location);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;

		}finally {
			//フィルターで統一処理している
		}
		return post;
	}
}
