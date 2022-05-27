
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Account;
import model.DbConnection;

public class M_accountsDAO {

	public Account findByUserid(int userid){

		Account account = null;

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		try {

			//SELECT文を準備
			String sql = "";
			sql += "SELECT * ";
			sql += "FROM account ";
			sql += "WHERE ";
			sql += "user_id = ?";

			//SQLを送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, String.valueOf(userid));

			//SELECTを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();

			//rs結果表に格納されたレコードをAccountインスタンスリストに代入
			if (rs.next()) {
				//Accountのデータを取得
				int user_id = rs.getInt("user_id");
				String login_id = rs.getString("login_id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				Date birthday = rs.getDate("birthday");
				int gender = rs.getInt("gender");
				String post_code = rs.getString("post_code");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String mail = rs.getString("mail");
				Date createtime = rs.getTimestamp("createtime");

				//accountインスタンスを生成
				account = new Account(
						user_id,
						login_id,
						pass,
						name,
						birthday,
						gender,
						post_code,
						address,
						tel,
						mail,
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

		return account;

	}


	public List<Account> findAll(){

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		List<Account> userList = new ArrayList<Account>();

		try {
			//SQL文
			sql = "SELECT"
					+ " *"
					+ " FROM ACCOUNT "
					+ " ORDER BY"
					+ " USER_ID";

			//SQL命令を準備する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL命令を発行する
			ResultSet rs = pStmt.executeQuery();
			//読み込んだレコードを処理する
			while(rs.next()) {
				//Accountのデータを取得
				int user_id = rs.getInt("user_id");
				String login_id = rs.getString("login_id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				Date birthday = rs.getDate("birthday");
				int gender = rs.getInt("gender");
				String post_code = rs.getString("post_code");
				String address = rs.getString("address");
				String tel = rs.getString("tel");
				String mail = rs.getString("mail");
				Date createtime = rs.getTimestamp("createtime");

				//accountインスタンスを生成
				Account account =  new Account(
						user_id,
						login_id,
						pass,
						name,
						birthday,
						gender,
						post_code,
						address,
						tel,
						mail,
						createtime
						);
				userList.add(account);
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
		return userList;
	}

	/**
	 *  insert account
	 * @param account
	 * @return
	 */
	public boolean insert(Account account) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文
			sql = "INSERT INTO"
					+ " account"
					+ " (login_id,pass,name,birthday,gender,"
					+ "post_code,address,tel,mail)"
					+ " VALUES"
					+ " (?,?,?,?,?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getLogin_id());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());

			//お誕生日を文字列に変換処理
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(account.getBirthday() !=null) {
				pStmt.setString(4, sdf.format(account.getBirthday()));
			}else {
				pStmt.setString(4, null);
			}

			pStmt.setInt(5, account.getGender());
			pStmt.setString(6, account.getPost_code());
			pStmt.setString(7, account.getAddress());
			pStmt.setString(8, account.getTel());
			pStmt.setString(9, account.getMail());
//			pStmt.setTimestamp(10, (Timestamp) account.getCreatetime());

			//SQL命令を発行する
			int result = pStmt.executeUpdate();
//			int result = 1;
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

	public boolean delete(int id){

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文
			sql = "DELETE"
					+ " FROM ACCOUNT "
					+ " WHERE USER_ID =?";

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

	public boolean update(Account account) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文を定義する
	        sql = "UPDATE"
	        		+ " account"
	        		+ " SET "
	        		+ " login_id = ?, "
	        		+ " pass = ?, "
	        		+ " name = ?, "
	        		+ " birthday = ?, "
	        		+ " gender = ?, "
	        		+ " post_code = ?, "
	        		+ " address = ?, "
	        		+ " tel = ?, "
	        		+ " mail = ? "
	        		+ " WHERE "
	        		+ " user_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, account.getLogin_id());
			pStmt.setString(2, account.getPass());
			pStmt.setString(3, account.getName());

			//お誕生日を文字列に変換処理
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if(account.getBirthday() !=null) {
				pStmt.setString(4, sdf.format(account.getBirthday()));
			}else {
				pStmt.setString(4, null);
			}

//			java.sql.Date dd= new java.sql.Date(account.getBirthday().getTime());
//			pStmt.setDate(4, dd);

			pStmt.setInt(5, account.getGender());
			pStmt.setString(6, account.getPost_code());
			pStmt.setString(7, account.getAddress());
			pStmt.setString(8, account.getTel());
			pStmt.setString(9, account.getMail());
//			pStmt.setTimestamp(10, (Timestamp) account.getCreatetime());
			pStmt.setInt(10, account.getUser_id());

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
	 * 指定アカウントを非表示する処理
	 * @param user_id
	 * @return
	 */
	public boolean update(int user_id) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文を定義する
	        sql = "UPDATE"
	        		+ " account"
	        		+ " SET "
	        		+ " show = 1 "
	        		+ " WHERE "
	        		+ " user_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, user_id);

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
