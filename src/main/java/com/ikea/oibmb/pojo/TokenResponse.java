package com.ikea.oibmb.pojo;

public class TokenResponse {

    private String access_token;
    private String scope;
    private Integer expires_in;
    private String token_type;
    private Long tokenExpirationTime;

    public String getAccess_token() {
	return access_token;
    }

    public void setAccess_token(String access_token) {
	this.access_token = access_token;
    }

    public String getScope() {
	return scope;
    }

    public void setScope(String scope) {
	this.scope = scope;
    }

    public Integer getExpires_in() {
	return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
	this.expires_in = expires_in;
    }

    public String getToken_type() {
	return token_type;
    }

    public void setToken_type(String token_type) {
	this.token_type = token_type;
    }

    public Long getTokenExpirationTime() {
	return tokenExpirationTime;
    }

    public void setTokenExpirationTime(Long tokenExpirationTime) {
	this.tokenExpirationTime = tokenExpirationTime;
    }

}

