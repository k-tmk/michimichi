package beans;

import java.io.Serializable;

public class Feature implements Serializable{

	//フィールドのカプセル化
		//t_featuresから
		private int feature_id;
		private String feature_name;
		private String main_photo_path;
		private String alt;
		private String content;

		//m_feature_typesから
		private int feature_type_id;
		private String feature_type_name;
		private String photo_path1;
		private String alt1;
		private String photo_path2;
		private String alt2;
		private String photo_path3;
		private String alt3;

		//コンストラクタの定義
		public Feature(){}

		public Feature(int feature_id, String feature_name, String main_photo_path, String alt, String content,
				int feature_type_id,String feature_type_name,String photo_path1,String alt1,
				String photo_path2,String alt2,String photo_path3,String alt3){

			this.feature_id = feature_id;
			this.feature_name = feature_name;
			this.main_photo_path = main_photo_path;
			this.alt = alt;
			this.content = content;

			this.feature_type_id = feature_type_id;
			this.feature_type_name = feature_type_name;
			this.photo_path1 = photo_path1;
			this.alt1 = alt1;
			this.photo_path2 = photo_path2;
			this.alt2 = alt2;
			this.photo_path3 = photo_path3;
			this.alt3 = alt3;
		}

		public int getFeature_id() {
			return feature_id;
		}

		public void setFeature_id(int feature_id) {
			this.feature_id = feature_id;
		}

		public String getFeature_name() {
			return feature_name;
		}

		public void setFeature_name(String feature_name) {
			this.feature_name = feature_name;
		}

		public String getMain_photo_path() {
			return main_photo_path;
		}

		public void setMain_photo_path(String main_photo_path) {
			this.main_photo_path = main_photo_path;
		}

		public String getAlt() {
			return alt;
		}

		public void setAlt(String alt) {
			this.alt = alt;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public int getFeature_type_id() {
			return feature_type_id;
		}

		public void setFeature_type_id(int feature_type_id) {
			this.feature_type_id = feature_type_id;
		}

		public String getFeature_type_name() {
			return feature_type_name;
		}

		public void setFeature_type_name(String feature_type_name) {
			this.feature_type_name = feature_type_name;
		}

		public String getPhoto_path1() {
			return photo_path1;
		}

		public void setPhoto_path1(String photo_path1) {
			this.photo_path1 = photo_path1;
		}

		public String getAlt1() {
			return alt1;
		}

		public void setAlt1(String alt1) {
			this.alt1 = alt1;
		}

		public String getPhoto_path2() {
			return photo_path2;
		}

		public void setPhoto_path2(String photo_path2) {
			this.photo_path2 = photo_path2;
		}

		public String getAlt2() {
			return alt2;
		}

		public void setAlt2(String alt2) {
			this.alt2 = alt2;
		}

		public String getPhoto_path3() {
			return photo_path3;
		}

		public void setPhoto_path3(String photo_path3) {
			this.photo_path3 = photo_path3;
		}

		public String getAlt3() {
			return alt3;
		}

		public void setAlt3(String alt3) {
			this.alt3 = alt3;
		}



}
