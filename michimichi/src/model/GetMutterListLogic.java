package model;

import java.util.List;

import dao.MutterDAO;

public class GetMutterListLogic {

	public List<Mutter> execute(){
		//DAOオブジェクト生成
		MutterDAO dao = new MutterDAO();
		//DBから全レコードを取得する
		List<Mutter> mutterList = dao.findAll();
		return mutterList;
	}
}
