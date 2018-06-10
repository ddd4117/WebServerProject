package com.example.demo.common;

public class Match {
    private int match_id = 0;
    private String req_id;
    private String res_id;
    private int post_id;

    public Match(String req_id, String res_id, int post_id) {
        this.req_id = req_id;
        this.res_id = res_id;
        this.post_id = post_id;
    }

    public int getMatch_id() {
        return match_id;
    }

    public void setMatch_id(int match_id) {
        this.match_id = match_id;
    }

    public String getReq_id() {
        return req_id;
    }

    public void setReq_id(String req_id) {
        this.req_id = req_id;
    }

    public String getRes_id() {
        return res_id;
    }

    public void setRes_id(String res_id) {
        this.res_id = res_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }
}
