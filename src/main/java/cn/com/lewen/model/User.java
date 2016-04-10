package cn.com.lewen.model;

import java.io.Serializable;
import java.util.Date;


public class User implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String username;
	
	private String password;

	private String mobile;
	
	private String email;
	
	private Integer isGuide;
	
	private Integer isAdmin;
	
	private Date createTime;
	
	private Date modifiedTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsGuide() {
		return isGuide;
	}

	public void setIsGuide(Integer isGuide) {
		this.isGuide = isGuide;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", mobile=" + mobile + ", email=" + email
				+ ", isGuide=" + isGuide + ", isAdmin=" + isAdmin
				+ ", createTime=" + createTime + ", modifiedTime="
				+ modifiedTime + "]";
	}
	
	public static enum UserStatus{		
				
		IS_GUIDE(1),IS_NOT_GUIDE(0),
		IS_ADMIN(1),IS_NOT_ADMIN(0);
		
		private final int val;
		
		private UserStatus(int val){
			this.val = val;
		}
		
		public int getVal(){
			return this.val;
		}
	}
	
}
