package org.pentaho.di.ui.repo.utils;

public class JwtPayload {
	
	String UserId;
	String UserName;
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
}