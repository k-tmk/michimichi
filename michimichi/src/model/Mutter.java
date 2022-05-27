package model;

import java.io.Serializable;
import java.util.Date;

public class Mutter implements Serializable{
	private int id;
	private String userName;
	private String text;
	private Date createtime;

	/**
	 * コンストラクタ
	 */
	public Mutter() {

	}

	/**
	 * コンストラクタ
	 * @param userName
	 * @param text
	 */
	public Mutter(String userName,String text) {
		this.userName = userName;
		this.text = text;
	}

	/**
	 * コンストラクタ
	 * @param userName
	 * @param text
	 */
	public Mutter(int id,String userName,String text,Date createtime) {
		this.id = id;
		this.userName = userName;
		this.text = text;
		this.createtime = createtime;
	}

	public int getId() {
		return id;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public String getUserName() {
		return userName;
	}

	public String getText() {
		return text;
	}
}
