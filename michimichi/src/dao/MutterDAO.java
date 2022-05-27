package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DbConnection;
import model.Mutter;

public class MutterDAO {

	/**
	 * findAll()
	 * @return
	 */
	public List<Mutter> findAll(){

		List<Mutter> mutterList = new ArrayList<>();

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		try {

			//SELECT文を準備
			String sql = "";
			sql += "SELECT * ";
			sql += "FROM mutter ";
			//			sql += "WHERE  ";
			sql += "ORDER BY id DESC";

//			System.out.println("sql:" + sql);

			//SQLを送信
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//SELECTを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();

			//rs結果表に格納されたレコードをMutterインスタンスリストに代入
			while (rs.next()) {
				//mutterのデータを取得
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String text = rs.getString("text");
				Date createtime = rs.getTimestamp("createtime");

				//mutterインスタンスを生成
				Mutter mutter = new Mutter(id,name,text,createtime);

				//mutterインスタンスをリストに追加
				mutterList.add(mutter);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;

		} finally {
			//データベース切断
//			if(conn != null) {
//				if(DbConnection.dbDisconnection(conn)==false) {
//					return null;
//				}
//			}
		}

		return mutterList;

	}

	/**
	 * つぶやきを追加するメソッド
	 * @param mutter
	 * @return
	 */
	public boolean create(Mutter mutter) {

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {

			//SELECT文を準備
			String sql = "";
			sql += "INSERT INTO ";
			sql += "mutter ";
			sql += "( name,text ) ";
			sql += "VALUES ";
			sql += "(?,?)";

//			System.out.println("sql:" + sql);

			//SQLを送信
			PreparedStatement pStmt = conn.prepareStatement(sql);

			//Inert文の中の「？」に使用する値を設定する
			pStmt.setString(1, mutter.getUserName());
			pStmt.setString(2, mutter.getText());

			//Insert文を実行する
			int result = pStmt.executeUpdate();

			if (result != 1) {
				return false;
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;

		} finally {
			//データベース切断
		}
		return true;

	}

}
