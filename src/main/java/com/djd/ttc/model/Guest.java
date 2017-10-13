package com.djd.ttc.model;

public class Guest {
    private  int userid;
    private  String username;
    private  String nickname;

    public int getUserid() {
        return userid;
    }

    public String getNickname() {
        return nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
