package beams;

import java.io.Serializable;

public class LoginUser implements Serializable{

	private int user_id;
	private String login_id;
	private String pass;
	private String name;

	public LoginUser() {

	}

	public LoginUser(int user_id,String login_id,String pass,String name) {
		this.user_id = user_id;
		this.login_id = login_id;
		this.pass = pass;
		this.name = name;
	}

	public LoginUser(String login_id,String pass) {
		this.login_id = login_id;
		this.pass = pass;
	}

	public int getUser_id() {
		return this.user_id;
	}

	public void setLogin_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLogin_id() {
		return this.login_id;
	}

	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
