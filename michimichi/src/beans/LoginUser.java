package beans;

import java.io.Serializable;

public class LoginUser implements Serializable{

	private int user_id;
	private String login_id;
	private String password;
	private String name;

	public LoginUser() {

	}

	public LoginUser(int user_id,String login_id,String password,String name) {
		this.user_id = user_id;
		this.login_id = login_id;
		this.password = password;
		this.name = name;
	}

	public LoginUser(String login_id,String password) {
		this.login_id = login_id;
		this.password = password;
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
		return this.password;
	}

	public void setPass(String password) {
		this.password = password;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
