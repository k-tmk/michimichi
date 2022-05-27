package model;

import java.util.List;

import dao.PostsDAO;


public class PostsLogic {

	/**
	 * すべての記事をID降順で取得する
	 * @return
	 */
	public List<Posts> getAllPosts(int showflag){
		//DAOオブジェクト生成
		PostsDAO dao = new PostsDAO();
		//DBから全レコードを取得する
		List<Posts> postsList = dao.findAll(showflag);
		return postsList;
	}

	/**
	 * post_idによる指定記事を取得
	 * @param id
	 * @return
	 */
	public Posts getPostById(int id){
		//DAOオブジェクト生成
		PostsDAO dao = new PostsDAO();
		//DBから全レコードを取得する
		Posts post = dao.findPostById(id);
		return post;
	}

	/**
	 * 新規記事登録
	 * @param post
	 * @return
	 */
	public boolean createPost(Posts post) {
		PostsDAO dao = new PostsDAO();
		if(dao.insert(post) != false) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 記事の内容を更新
	 * @param post
	 * @return
	 */
	public boolean updatePost(Posts post) {
		PostsDAO dao = new PostsDAO();
		if(dao.update(post) != false) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 指定記事の表示・非表示処理
	 * @param id
	 * @param showflag
	 * @return
	 */
	public boolean updatePost(int id,int showflag) {
		PostsDAO dao = new PostsDAO();
		if(dao.update(id,showflag) != false) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 指定記事を削除
	 * @param id
	 * @return
	 */
	public boolean deletePost(int id) {
		PostsDAO dao = new PostsDAO();
		if(dao.delete(id) != false) {
			return true;
		}else {
			return false;
		}
	}

}
