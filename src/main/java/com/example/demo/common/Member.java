package com.example.demo.common;

import java.io.Serializable;

public class Member implements Serializable {
    private String m_id;
    private String m_pwd;
    private String m_mail;

    public Member(String m_id, String m_pwd, String m_mail) {
        this.m_id = m_id;
        this.m_pwd = m_pwd;
        this.m_mail = m_mail;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_pwd() {
        return m_pwd;
    }

    public void setM_pwd(String m_pwd) {
        this.m_pwd = m_pwd;
    }

    public String getM_mail() {
        return m_mail;
    }

    public void setM_mail(String m_mail) {
        this.m_mail = m_mail;
    }
}
