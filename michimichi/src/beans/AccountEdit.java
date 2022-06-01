package beans;

import java.io.Serializable;
import java.util.Date;

public class AccountEdit implements Serializable{

	private int user_id;		//ユーザーID（テーブル自動生成）
	private String login_id;	//ログインID
	private String pass;		//パスワード
	private String name;		//ユーザー名
	private Date birthday;		//お誕生日：yyyy-mm-dd
	private int gender;			//性別：1=男　2=女　3=不明
	private String post_code;	//郵便番号　999-1234
	private String address;		//住所：200文字まで
	private String tel;			//電話番号
	private String mail;		//Emailアドレス
	private Date createtime;	//登録日時（テーブル自動生成）

	public static String[] genderlist= {"男","女","不明"};
	/**
	 * コンストラクタ
	 */
	public AccountEdit() {

	}

	/**
	 * コンストラクタ
	 */
	public AccountEdit(String login_id, String pass) {
		this.login_id = login_id;
		this.pass = pass;
	}

	/**
	 * コンストラクタ
	 */
	public AccountEdit(
			int user_id,
			String login_id,
			String pass,
			String name,
			Date birthday,
			int gender,
			String post_code,
			String address,
			String tel,
			String mail,
			Date createtime
			) {
		this.user_id = user_id;
		this.login_id = login_id;
		this.pass = pass;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.post_code = post_code;
		this.address = address;
		this.tel = tel;
		this.mail = mail;
		this.createtime = createtime;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getLogin_id() {
		return login_id;
	}


	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


	public int getGender() {
		return gender;
	}


	public void setGender(int gender) {
		this.gender = gender;
	}


	public String getPost_code() {
		return post_code;
	}


	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
