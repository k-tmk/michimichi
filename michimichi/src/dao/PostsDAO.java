
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.DbConnection;
import model.Posts;

public class PostsDAO {

	/**
	 * post_idで該当記事を取得
	 * @param postid
	 * @return
	 */
	public Posts findPostById(int postid){

		Posts post = null;

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		try {

			//SELECT文を準備
			String sql = "";

//			sql = "SELECT"
//					+ " *"
//					+ " FROM posts"
//					+ " WHERE "
//					+ " post_id = ?";

			sql += "SELECT posts.*,account.name ";
			sql += "FROM posts ";
			sql += "INNER JOIN account ";
			sql += "ON posts.create_userid = account.user_id ";
			sql += "WHERE ";
			sql += "post_id = ?";

			//SQLを送信
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, postid);

			//SELECTを実行し、結果を取得
			ResultSet rs = pStmt.executeQuery();

			//rs結果表に格納されたレコードをPostインスタンスリストに代入
			if (rs.next()) {
				//Postのデータを取得
				int post_id = rs.getInt("post_id");
				int type = rs.getInt("type");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String summary = rs.getString("summary");
				String img_path1 = rs.getString("img_path1");
				String img_path2 = rs.getString("img_path2");
				String img_path3 = rs.getString("img_path3");
				String img_path4 = rs.getString("img_path4");
				int show_flag = rs.getInt("show_flag");
				Date update_time = rs.getTimestamp("update_time");
				int create_userid = rs.getInt("create_userid");
				String name = rs.getString("name");
				Date createtime = rs.getTimestamp("createtime");

				//postインスタンスを生成
				post = new Posts(
						post_id,
						type,
						title,
						content,
						summary,
						img_path1,
						img_path2,
						img_path3,
						img_path4,
						show_flag,
						update_time,
						create_userid,
						name,
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

		return post;

	}


	/**
	 * 記事一覧取得
	 * @return
	 */
	public List<Posts> findAll(int showflag){

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return null;

		List<Posts> postsList = new ArrayList<Posts>();

		try {
			//SQL文
//			sql = "SELECT"
//					+ " *"
//					+ " FROM posts"
//					+ " WHERE show_flag = 1"
//					+ " ORDER BY"
//					+ " post_id DESC";

			sql += "SELECT posts.*,account.name ";
			sql += "FROM posts ";
			sql += "INNER JOIN account ";
			sql += "ON posts.create_userid = account.user_id ";

			//表示する項目だけを抽出
			if(showflag == 1) {
				sql += "WHERE show_flag = 1 ";
			}

			sql += "ORDER BY ";
			sql += "post_id DESC";

			//SQL命令を準備する
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//SQL命令を発行する
			ResultSet rs = pStmt.executeQuery();
			//読み込んだレコードを処理する
			while(rs.next()) {
				//Postsのデータを取得
				int post_id = rs.getInt("post_id");
				int type = rs.getInt("type");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String summary = rs.getString("summary");
				String img_path1 = rs.getString("img_path1");
				String img_path2 = rs.getString("img_path2");
				String img_path3 = rs.getString("img_path3");
				String img_path4 = rs.getString("img_path4");
				int show_flag = rs.getInt("show_flag");
				Date update_time = rs.getTimestamp("update_time");
				int create_userid = rs.getInt("create_userid");
				String name = rs.getString("name");
				Date createtime = rs.getTimestamp("createtime");

				//postインスタンスを生成
				Posts post =  new Posts(
						post_id,
						type,
						title,
						content,
						summary,
						img_path1,
						img_path2,
						img_path3,
						img_path4,
						show_flag,
						update_time,
						create_userid,
						name,
						createtime
						);
				postsList.add(post);
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
		return postsList;
	}

	/**
	 *  insert記事
	 * @param post
	 * @return
	 */
	public boolean insert(Posts post) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文
			sql = "INSERT INTO"
					+ " posts"
					+ " (type,title,content,summary,img_path1,img_path2,"
					+ "img_path3,img_path4,show_flag,create_userid)"
					+ " VALUES"
					+ " (?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, post.getType());
			pStmt.setString(2, post.getTitle());
			pStmt.setString(3, post.getContent());
			pStmt.setString(4, post.getSummary());
			pStmt.setString(5, post.getImg_path1());
			pStmt.setString(6, post.getImg_path2());
			pStmt.setString(7, post.getImg_path3());
			pStmt.setString(8, post.getImg_path4());
			pStmt.setInt(9, post.getShow_flag());
			pStmt.setInt(10, post.getCreate_userid());

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
	 * 記事を削除
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
					+ " FROM posts "
					+ " WHERE post_id =?";

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
	 *
	 * @param post
	 * @return
	 */
	public boolean update(Posts post) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文を定義する
	        sql = "UPDATE"
	        		+ " posts"
	        		+ " SET "
	        		+ " type = ?, "
	        		+ " title = ?, "
	        		+ " content = ?, "
	        		+ " summary = ?, "
	        		+ " img_path1 = ?, "
	        		+ " img_path2 = ?, "
	        		+ " img_path3 = ?, "
	        		+ " img_path4 = ?, "
	        		+ " show_flag = ?, "
	        		+ " update_time = ?, "
	        		+ " create_userid = ? "
	        		+ " WHERE "
	        		+ " post_id = ?";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, post.getType());
			pStmt.setString(2, post.getTitle());
			pStmt.setString(3, post.getContent());
			pStmt.setString(4, post.getSummary());
			pStmt.setString(5, post.getImg_path1());
			pStmt.setString(6, post.getImg_path2());
			pStmt.setString(7, post.getImg_path3());
			pStmt.setString(8, post.getImg_path4());
			pStmt.setInt(9, post.getShow_flag());

			//Update日時を文字列に変換処理
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			if(post.getUpdate_time() !=null) {
				pStmt.setString(10, sdf.format(post.getUpdate_time()));
			}else {
				pStmt.setString(10, null);
			}

			pStmt.setInt(11, post.getCreate_userid());
			pStmt.setInt(12, post.getPost_id());

			//SQL命令を発行する
			int result = pStmt.executeUpdate();

			System.out.println(pStmt.getWarnings());

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
	 * 指定記事を非表示・非表示する処理
	 * @param postid
	 * @param show_flag
	 * @return
	 */
	public boolean update(int post_id,int show_flag ) {

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if(conn == null) return false;

		try {
			//SQL文を定義する
	        sql = "UPDATE"
	        		+ " posts"
	        		+ " SET "
	        		+ " show_flag = ? "
	        		+ " WHERE "
	        		+ " post_id = ? ";

			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, show_flag);
			pStmt.setInt(2, post_id);

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
