package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beams.FeatureList;
import model.DbConnection;

public class M_facilitiesDAO {

	/*********
	 * 特集一覧、出力用のメソッド
	 *********/
	public List<FeatureList> findAll(int showflag) {

		List<FeatureList> FLList = new ArrayList<>();

		String sql = "";

		//データベースに接続
		Connection conn = null;
		conn = DbConnection.conn;
		if (conn == null)
			return null;

		//BDへ接続
		try {

			//SELECT文を準備
			//show_flagで表示になっているものを、降順で抽出する。
			sql = "SELECT * "
					+ " FROM t_features "
					+ " WHERE show_flag = ?"
					+ " ORDER BY"
					+ " feature_id DESC";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			//pStmt.setInt(一番目の？,代入するもの)
			pStmt.setInt(1, showflag);

			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容をFeatureListインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				int feature_id = rs.getInt("feature_id");
				String feature_name = rs.getString("feature_name");
				String main_photo_path = rs.getString("main_photo_path");
				String alt = rs.getString("alt");

				FeatureList feature = new FeatureList(feature_id, feature_name, main_photo_path, alt);
				FLList.add(feature);
			}

		} catch (SQLException e) {
			// 自動生成された catch ブロック
			e.printStackTrace();
			return null;

		} finally {
			//データベース切断

		}
		return FLList;

	}

	/*********
	 * 特集個別、出力用のメソッド
	 *********/

	/*********
	 * 特集個別、追加のメソッド
	 *********/
	public boolean create(FeatureList feature) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
