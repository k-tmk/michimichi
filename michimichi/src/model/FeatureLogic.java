package model;

import java.util.List;

import beans.Feature;
import dao.T_featuresDAO;

public class FeatureLogic {

	//指定されたIDの記事内容を表示する
	public List<Feature> getAllFeature(int showflag, int con_id) {
		//DAOオブジェクト生成
		T_featuresDAO dao = new T_featuresDAO();
		//DBから全レコードを取得する
		List<Feature> FList = dao.findAll(showflag,con_id);
		return FList;
	}
}
