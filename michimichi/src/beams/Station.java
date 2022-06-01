package beams;

public class Station {

	//フィールドのカプセル化
	//m_road_stationsから（道の駅マスター）
	private int michinoeki_id;
	private String michinoeki_name;
	private String photo_path1;
	private String alt1;
	private String photo_path2;
	private String alt2;
	private String photo_path3;
	private String alt3;
	private String photo_path4;
	private String alt4;
	private String explanation;

	private String post_code;
	private String address;
	private String tel;
	private String parking;
	private String service_time;
	private String closed;
	private String url;

	private String gas_station;
	private String hospital;
	private String near_station;

	private String iframe_src;

	private String feature1_photo_path;
	private String feature1_alt;
	private String feature1_overview;
	private String feature2_photo_path;
	private String feature2_alt;
	private String feature2_overview;

	private int feature_bunner1;
	private int feature_bunner2;
	private int feature_bunner3;

	//m_recommendsから（おすすめマスター）
	private int recommend_id;
	private String recommend_name;
	private String recommend_photo_path;
	private String recommend_alt;
	private String recommed_overview;

	//m_spotsから（周辺スポットマスター）
	private int spot_id;
	private String spot_name;
	private String spot_photo_path1;
	private String spot_alt1;
	private String spot_photo_path2;
	private String spot_alt2;
	private String spot_photo_path3;
	private String spot_alt3;
	private String spot_overview;
	private String spot_adress;
	private String spot_url;

	//m_tages
	private int tages_id;
	private String category_name;
	private String tages_photo_path;
	private String tages_alt;
	private String icon_path1;
	private String icon_path2;

	//t_good_recordsから（いいねテーブル）
	private int good_id;
	private String user_ip_address;



	//コンストラクタの定義
	public Station(){}

	public Station(
			//m_road_stationsから（道の駅マスター）
			int michinoeki_id, String michinoeki_name, String photo_path1, String alt1, String photo_path2, String alt2, String photo_path3, String alt3, String photo_path4, String alt4, String explanation,

			 String post_code, String address, String tel, String parking, String service_time, String closed, String url,

			 String gas_station, String hospital, String near_station,

			 String iframe_src,

			 String feature1_photo_path, String feature1_alt, String feature1_overview, String feature2_photo_path, String feature2_alt, String feature2_overview,

			 int feature_bunner1, int feature_bunner2, int feature_bunner3,

			//m_recommendsから（おすすめマスター）
			 int recommend_id, String recommend_name, String recommend_photo_path, String recommend_alt, String recommed_overview,

			//m_spotsから（周辺スポットマスター）
			 int spot_id, String spot_name, String spot_photo_path1, String spot_alt1, String spot_photo_path2, String spot_alt2, String spot_photo_path3, String spot_alt3, String spot_overview, String spot_adress, String spot_url,

			//m_tages
			 int tages_id, String category_name, String tages_photo_path, String tages_alt, String icon_path1, String icon_path2,

			//t_good_recordsから（いいねテーブル）
			 int good_id, String user_ip_address,

			//t_commentsから（コメントテーブル）
			 int comment_id, String name, String comment, String post_time
			 ){

		//m_road_stationsから（道の駅マスター）
		this.michinoeki_id = michinoeki_id;
		this.michinoeki_name = michinoeki_name;
		this.photo_path1 = photo_path1;
		this.alt1 = alt1;
		this.photo_path2 = photo_path2;
		this.alt2 = alt2;
		this.photo_path3 = photo_path3;
		this.alt3 = alt3;
		this.photo_path4 = photo_path4;
		this.alt4 = alt4;
		this.explanation = explanation;

		this.post_code = post_code;
		this.address = address;
		this.tel = tel;
		this.parking = parking;
		this.service_time = parking;
		this.closed = closed;
		this.url = url;

		this.gas_station = gas_station;
		this.hospital = hospital;
		this.near_station = near_station;

		this.iframe_src = iframe_src;

		this.feature1_photo_path = feature1_photo_path;
		this.feature1_alt = feature1_alt;
		this.feature1_overview = feature1_overview;
		this.feature2_photo_path = feature2_photo_path;
		this.feature2_alt = feature2_alt;
		this.feature2_overview = feature2_overview;

		this.feature_bunner1 = feature_bunner1;
		this.feature_bunner2 = feature_bunner2;
		this.feature_bunner3 = feature_bunner3;

		//m_recommendsから（おすすめマスター）
		this.recommend_id = recommend_id;
		this.recommend_name = recommend_name;
		this.recommend_photo_path = recommend_photo_path;
		this.recommend_alt = recommend_alt;
		this.recommed_overview = recommed_overview;

		//m_spotsから（周辺スポットマスター）
		this.spot_id = spot_id;
		this.spot_name = spot_name;
		this.spot_photo_path1 = spot_photo_path1;
		this.spot_alt1 = spot_alt1;
		this.spot_photo_path2 = spot_photo_path2;
		this.spot_alt2 = spot_alt2;
		this.spot_photo_path3 = spot_photo_path3;
		this.spot_alt3 = spot_alt3;
		this.spot_overview = spot_overview;
		this.spot_adress = spot_adress;
		this.spot_url = spot_url;

		//m_tages
		this.tages_id = tages_id;
		this.category_name = category_name;
		this.tages_photo_path = tages_photo_path;
		this.tages_alt = tages_alt;
		this.icon_path1 = icon_path1;
		this.icon_path2 = icon_path2;

		//t_good_recordsから（いいねテーブル）
		this.good_id = good_id;
		this.user_ip_address = user_ip_address;

	}



}
