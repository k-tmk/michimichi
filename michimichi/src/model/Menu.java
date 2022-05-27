package model;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable{
	private int 	menu_id;
	private int 	type;
	private String	title;
	private String	summary;
	private String	img_path1;
	private String	img_path2;
	private String	img_path3;
	private String	img_path4;
	private int		price;
	private int		show_flag;
	private int		point;
	private Date	createtime;

	//メニュー種別表示用
	private String	typename;
	public static String[] typelist=
		{"","お茶","コヒー","お酒","ジュース","デザート","その他"};

	/**
	 * コンストラクタ
	 */
	public Menu() {

	}

	/**
	 *
	 * @param menu_id
	 * @param type
	 * @param title
	 * @param summary
	 * @param img_path1
	 * @param img_path2
	 * @param img_path3
	 * @param img_path4
	 * @param price
	 * @param show_flag
	 * @param point
	 * @param createtime
	 */
	public Menu(
			int 	menu_id,
			int 	type,
			String	title,
			String	summary,
			String	img_path1,
			String	img_path2,
			String	img_path3,
			String	img_path4,
			int		price,
			int		show_flag,
			int		point,
			Date	createtime
			) {
		this.menu_id = menu_id;
		this.type = type;
		this.title = title;
		this.summary = summary;
		this.img_path1 = img_path1;
		this.img_path2 = img_path2;
		this.img_path3 = img_path3;
		this.img_path4 = img_path4;
		this.show_flag =  show_flag;
		this.price = price;
		this.point = point;
		this.createtime = createtime;

	}

	public String getTypename() {
		return typelist[type];
	}

	public int getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
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


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public int getShow_flag() {
		return show_flag;
	}


	public void setShow_flag(int show_flag) {
		this.show_flag = show_flag;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
