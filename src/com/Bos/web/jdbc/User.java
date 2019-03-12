package com.Bos.web.jdbc;

public class User {
	private int id;
	private String login;
	private String mdp;
	public Boolean valid;


	public User(int id, String login, String mdp) {
		this.id = id;
		this.login = login;
		this.mdp = mdp;
	}
	
	public User()
	{

	}
	
	public User(String login, String mdp) {
		this.login = login;
		this.mdp = mdp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
		
	 public boolean isValid() {
         return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", mot de passe=" + mdp + ", type=" + "]";
	}

	
}
