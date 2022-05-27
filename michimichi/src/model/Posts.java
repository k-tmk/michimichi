package model;

import java.io.Serializable;
import java.util.Date;

public class Posts implements Serializable{
	private int 	post_id;
	private int 	type;
	private String 	title;
	private String	content;
	private String	summary;
	private String	img_path1;
	private String	img_path2;
	private String	img_path3;
	private String	img_path4;
	private int		show_flag;
	private Date	update_time;
	private int		create_userid;
	private Date	createtime;

	//accountテーブルから取得した情報
	private String name;		//ユーザー名

	//メニュー種別表示用
	private String	typename;
	public static String[] typelist=
		{"","お知らせ","イベント","その他"};

	/**
	 * コンストラクタ
	 */
	public Posts() {

	}


	/**
	 *
	 * @param post_id
	 * @param type
	 * @param content
	 * @param summary
	 * @param img_path1
	 * @param img_path2
	 * @param img_path3
	 * @param img_path4
	 * @param update_time
	 * @param create_userid
	 * @param createtime
	 */
	public Posts(
			int 	post_id,
			int 	type,
			String	title,
			String	content,
			String	summary,
			String	img_path1,
			String	img_path2,
			String	img_path3,
			String	img_path4,
			int		show_flag,
			Date	update_time,
			int		create_userid,
			String	name,
			Date	createtime
			) {
		this.post_id = post_id;
		this.type = type;
		this.title = title;
		this.content = content;
		this.summary = summary;
		this.img_path1 = img_path1;
		this.img_path2 = img_path2;
		this.img_path3 = img_path3;
		this.img_path4 = img_path4;
		this.show_flag = show_flag;
		this.update_time = update_time;
		this.create_userid = create_userid;
		this.name = name;
		this.createtime = createtime;

	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTypename() {
		return typelist[type];
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getImg_path1() {
		return img_path1;
	}

	public void setImg_path1(String img_path1) {
		this.img_path1 = img_path1;
	}

	public String getImg_path2() {
		return img_path2;
	}

	public void setImg_path2(String img_path2) {
		this.img_path2 = img_path2;
	}

	public String getImg_path3() {
		return img_path3;
	}

	public void setImg_path3(String img_path3) {
		this.img_path3 = img_path3;
	}

	public String getImg_path4() {
		return img_path4;
	}

	public void setImg_path4(String img_path4) {
		this.img_path4 = img_path4;
	}

	public int getShow_flag() {
		return show_flag;
	}

	public void setShow_flag(int show_flag) {
		this.show_flag = show_flag;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public int getCreate_userid() {
		return create_userid;
	}

	public void setCreate_userid(int create_userid) {
		this.create_userid = create_userid;
	}

	public String getName() {
		return name;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
