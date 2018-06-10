package com.example.demo.common;

public class Post {
    private int p_id;
    private String member_id ="";
    private String p_title = "";
    private String p_content = "";
    private String p_time = "";
    private int p_money = 0;
    private String p_location ="";
    private String p_contact = "";
    private float p_map1_x = 0;
    private float p_map1_y = 0;
    private float p_map2_x = 0;
    private float p_map2_y = 0;
    private boolean flag = false;
    public Post(){};
    public Post(String member_id, String p_title, String p_content, String p_time, int p_money, String p_location, float p_map1_x, float p_map1_y, float p_map2_x, float p_map2_y, String p_contact) {
        this.member_id = member_id;
        this.p_title = p_title;
        this.p_content = p_content;
        this.p_time = p_time;
        this.p_money = p_money;
        this.p_location = p_location;
        this.p_map1_x = p_map1_x;
        this.p_map1_y = p_map1_y;
        this.p_map2_x = p_map2_x;
        this.p_map2_y = p_map2_y;
        this.p_contact = p_contact;
    }

    public Post(String member_id, String p_title, String p_time, String p_location, int p_money, int p_id) {
        this.member_id = member_id;
        this.p_title = p_title;
        this.p_location = p_location;
        this.p_time = p_time;
        this.p_money = p_money;
        this.p_id = p_id;
    }


    @Override
    public String toString() {
        return "Post{" +
                "p_id='" + p_id + '\'' +
                ", member_id='" + member_id + '\'' +
                ", p_title='" + p_title + '\'' +
                ", p_content='" + p_content + '\'' +
                ", p_time='" + p_time + '\'' +
                ", p_money=" + p_money +
                ", p_location='" + p_location + '\'' +
                ", p_map1_x=" + p_map1_x +
                ", p_map1_y=" + p_map1_y +
                ", p_map2_x=" + p_map2_x +
                ", p_map2_y=" + p_map2_y +
                '}';
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getP_title() {
        return p_title;
    }

    public void setP_title(String p_title) {
        this.p_title = p_title;
    }

    public String getP_content() {
        return p_content;
    }

    public void setP_content(String p_content) {
        this.p_content = p_content;
    }

    public String getP_time() {
        return p_time;
    }

    public void setP_time(String p_time) {
        this.p_time = p_time;
    }

    public int getP_money() {
        return p_money;
    }

    public void setP_money(int p_money) {
        this.p_money = p_money;
    }

    public String getP_location() {
        return p_location;
    }

    public void setP_location(String p_location) {
        this.p_location = p_location;
    }

    public float getP_map1_x() {
        return p_map1_x;
    }

    public void setP_map1_x(float p_map1_x) {
        this.p_map1_x = p_map1_x;
    }

    public float getP_map1_y() {
        return p_map1_y;
    }

    public void setP_map1_y(float p_map1_y) {
        this.p_map1_y = p_map1_y;
    }

    public float getP_map2_x() {
        return p_map2_x;
    }

    public void setP_map2_x(float p_map2_x) {
        this.p_map2_x = p_map2_x;
    }

    public float getP_map2_y() {
        return p_map2_y;
    }

    public void setP_map2_y(float p_map2_y) {
        this.p_map2_y = p_map2_y;
    }

    public String getP_contact() {
        return p_contact;
    }

    public void setP_contact(String p_contact) {
        this.p_contact = p_contact;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public String flagString()
    {
        if(this.flag) return "O";
        else return "X";
    }

}
