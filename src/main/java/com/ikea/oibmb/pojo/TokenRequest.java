package com.ikea.oibmb.pojo;

import java.io.Serializable;

public class TokenRequest implements Serializable {

    private static final long serialVersionUID = -8400815411880555481L;

    private String client_id;
    private String client_secret;
    private String audience;
    private String grant_type;
    private String content_type;

    public String getClient_id() {
	return client_id;
    }

    public void setClient_id(String client_id) {
	this.client_id = client_id;
    }

    public String getClient_secret() {
	return client_secret;
    }

    public void setClient_secret(String client_secret) {
	this.client_secret = client_secret;
    }

    public String getAudience() {
	return audience;
    }

    public void setAudience(String audience) {
	this.audience = audience;
    }

    public String getGrant_type() {
	return grant_type;
    }

    public void setGrant_type(String grant_type) {
	this.grant_type = grant_type;
    }

    public String getContent_type() {
	return content_type;
    }

    public void setContent_type(String content_type) {
	this.content_type = content_type;
    }

}

