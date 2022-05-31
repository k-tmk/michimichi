package model;

import java.util.List;

import beams.FeatureList;
import dao.M_facilitiesDAO;


public class FeatureListLogic {

//	//記事一覧リストにアプリケーションスコープに追加するメソッド(いらんかも)
//	public void execute(FeatureList feature, List<FeatureList> FLList) {
//		FLList.add(0,feature);
//	}

	//記事作成時に失敗したときのメソッド（管理側）
	public void execute(FeatureList feature) {
		M_facilitiesDAO dao = new M_facilitiesDAO();
		if(dao.create(feature) == false) {

		}
	}

	//すべての記事をID降順で取得する
	public List<FeatureList> getAllFeatureList(int showflag){
		//DAOオブジェクト生成
		M_facilitiesDAO dao = new M_facilitiesDAO();
		//DBから全レコードを取得する
		List<FeatureList> FLList = dao.findAll(showflag);
		return FLList;
	}

}
