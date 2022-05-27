package model;

import java.util.List;

import dao.MenuDAO;

public class MenuLogic {

	/**
	 * すべてのメニュをID降順で取得する
	 * @return
	 */
	public List<Menu> getAllMenu(int showflag){
		//DAOオブジェクト生成
		MenuDAO dao = new MenuDAO();
		//DBから全レコードを取得する
		List<Menu> menuList = dao.findAll(showflag);
		return menuList;
	}

	/**
	 * menu_idによる指定記事を取得
	 * @param id
	 * @return
	 */
	public Menu getMenuById(int id){
		//DAOオブジェクト生成
		MenuDAO dao = new MenuDAO();
		//DBから全レコードを取得する
		Menu menu = dao.findMenuById(id);
		return menu;
	}

	/**
	 * 新規menu登録
	 * @param post
	 * @return
	 */
	public boolean createMenu(Menu menu) {
		MenuDAO dao = new MenuDAO();
		if(dao.insert(menu) != false) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * メニューの内容を更新
	 * @param menu
	 * @return
	 */
	public boolean updateMenu(Menu menu) {
		MenuDAO dao = new MenuDAO();
		if(dao.update(menu) != false) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 指定メニューの表示・非表示処理
	 * @param id
	 * @param showflag
	 * @return
	 */
	public boolean updateMenu(int id,int showflag) {
		MenuDAO dao = new MenuDAO();
		if(dao.update(id,showflag) != false) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 指定menuを削除
	 * @param id
	 * @return
	 */
	public boolean deleteMenu(int id) {
		MenuDAO dao = new MenuDAO();
		if(dao.delete(id) != false) {
			return true;
		}else {
			return false;
		}
	}
}
