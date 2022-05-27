
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DbConnection;
import model.Menu;

public class MenuDAO {

	public Menu findMenuById(int menuid){

		Menu menu = null;

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		try {

			//SELECT文を準備
			String sql = "";
			sql += "SELECT * ";
			sql += "FROM menu ";
			sql += "WHERE ";
			sql += "menu_id = ?";

			//SQLを送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, menuid);

			//SELECTを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();

			//rs結果表に格納されたレコードをmenuインスタンスリストに代入
			if (rs.next()) {
				//menuのデータを取得
				int menu_id = rs.getInt("menu_id");
				int type = rs.getInt("type");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String img_path1 = rs.getString("img_path1");
				String img_path2 = rs.getString("img_path2");
				String img_path3 = rs.getString("img_path3");
				String img_path4 = rs.getString("img_path4");
				int price = rs.getInt("price");
				int show_flag = rs.getInt("show_flag");
				int point = rs.getInt("point");
				Date createtime = rs.getTimestamp("createtime");

				//menuインスタンスを生成
				menu = new Menu(
						menu_id,
						type,
						title,
						summary,
						img_path1,
						img_path2,
						img_path3,
						img_path4,
						price,
						show_flag,
						point,
						createtime
						);

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

		return menu;

	}

	/**
	 * 全メニューを抽出する
	 * @param showflag
	 * @return
	 */
	public List<Menu> findAll(int showflag){

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		List<Menu> menuList = new ArrayList<Menu>();

		try {
			//SQL文
//			sql = "SELECT"
//					+ " *"
//					+ " FROM menu "
//					+ " WHERE show_flag = 1"
//					+ " ORDER BY"
//					+ " menu_id";

			sql += "SELECT * ";
			sql += "FROM menu ";

			//表示する項目だけを抽出
			if(showflag == 1) {
				sql += "WHERE show_flag = 1 ";
			}

			sql += "ORDER BY ";
			sql += "menu_id ";

			//SQL命令を準備する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL命令を発行する
			ResultSet rs = pStmt.executeQuery();
			//読み込んだレコードを処理する
			while(rs.next()) {
				//menuのデータを取得
				int menu_id = rs.getInt("menu_id");
				int type = rs.getInt("type");
				String title = rs.getString("title");
				String summary = rs.getString("summary");
				String img_path1 = rs.getString("img_path1");
				String img_path2 = rs.getString("img_path2");
				String img_path3 = rs.getString("img_path3");
				String img_path4 = rs.getString("img_path4");
				int price = rs.getInt("price");
				int show_flag = rs.getInt("show_flag");
				int point = rs.getInt("point");
				Date createtime = rs.getTimestamp("createtime");

				//Menuインスタンスを生成
				Menu menu =  new Menu(
						menu_id,
						type,
						title,
						summary,
						img_path1,
						img_path2,
						img_path3,
						img_path4,
						price,
						show_flag,
						point,
						createtime

						);
				menuList.add(menu);
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;

		}finally {
			//データベース切断
//			if(conn != null) {
//				if(DbConnection.dbDisconnection(conn)==false) {
//					return null;
//				}
//			}
		}
		//読み込んだ結果を返す
		return menuList;
	}

	/**
	 *  insert account
	 * @param account
	 * @return
	 */
	public boolean insert(Menu menu) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文
			sql = "INSERT INTO"
					+ " menu"
					+ " (type,title,summary,img_path1,img_path2,"
					+ "img_path3,img_path4,price,show_flag,point)"
					+ " VALUES"
					+ " (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, menu.getType());
			pStmt.setString(2, menu.getTitle());
			pStmt.setString(3, menu.getSummary());
			pStmt.setString(4, menu.getImg_path1());
			pStmt.setString(5, menu.getImg_path2());
			pStmt.setString(6, menu.getImg_path3());
			pStmt.setString(7, menu.getImg_path4());
			pStmt.setInt(8, menu.getPrice());
			pStmt.setInt(9, menu.getShow_flag());
			pStmt.setInt(10, menu.getPoint());

			//SQL命令を発行する
			int result = pStmt.executeUpdate();
			//読み込んだ結果を処理する
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;

		}finally {
			//データベース切断

		}
		return true;
	}

	/**
	 * 指定IDで関連メニューを削除する
	 * @param id
	 * @return
	 */
	public boolean delete(int id){

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文
			sql = "DELETE"
					+ " FROM MENU "
					+ " WHERE MENU_ID =?";

			//SQL命令を準備する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);

			//SQL命令を発行する
			int result = pStmt.executeUpdate();

			if(result != 1) {
				return false;
			}

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;

		}finally {
			//データベース切断

		}
		//読み込んだ結果を返す
		return true;
	}

	/**
	 * メニューの更新処理
	 * @param menu
	 * @return
	 */
	public boolean update(Menu menu) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文を定義する
	        sql = "UPDATE"
	        		+ " menu"
	        		+ " SET "
	        		+ " type = ?, "
	        		+ " title = ?, "
	        		+ " summary = ?, "
	        		+ " img_path1 = ?, "
	        		+ " img_path2 = ?, "
	        		+ " img_path3 = ?, "
	        		+ " img_path4 = ?, "
	        		+ " price = ?, "
	        		+ " show_flag = ?, "
	        		+ " point = ? "
	        		+ " WHERE "
	        		+ " menu_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, menu.getType());
			pStmt.setString(2, menu.getTitle());
			pStmt.setString(3, menu.getSummary());
			pStmt.setString(4, menu.getImg_path1());
			pStmt.setString(5, menu.getImg_path2());
			pStmt.setString(6, menu.getImg_path3());
			pStmt.setString(7, menu.getImg_path4());
			pStmt.setInt(8, menu.getPrice());
			pStmt.setInt(9, menu.getShow_flag());
			pStmt.setInt(10, menu.getPoint());
			pStmt.setInt(11, menu.getMenu_id());

			//SQL命令を発行する
			int result = pStmt.executeUpdate();

			//読み込んだ結果を処理する
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;

		}finally {
			//データベース切断

		}
		return true;
	}

	/**
	 * 指定メニューを非表示する処理
	 * @param id
	 * @param showflag: 1->表示　0→非表示
	 * @return
	 */
	public boolean update(int id,int showflag) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文を定義する
	        sql = "UPDATE"
	        		+ " menu"
	        		+ " SET "
	        		+ " show_flag = ? "
	        		+ " WHERE "
	        		+ " menu_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, showflag);
			pStmt.setInt(2, id);

			//SQL命令を発行する
			int result = pStmt.executeUpdate();

			//読み込んだ結果を処理する
			if(result != 1) {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return false;

		}finally {
			//データベース切断

		}
		return true;
	}

}
