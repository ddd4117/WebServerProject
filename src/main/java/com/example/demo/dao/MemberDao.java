package com.example.demo.dao;

import com.example.demo.common.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {
    @Autowired
    private JdbcTemplate template;

    public boolean hasID(String id, String pwd) {
        String query = "SELECT count(*) FROM MEMBER WHERE m_id = '" + id + "' and m_pwd = '" + pwd + "'";
        int count = template.queryForObject(query, Integer.class);
        return count == 1;
    }


    public int addUser(Member member) {
        String query = "insert into Member values(?,?,?, NULL, '0')";
        return template.update(query,
                member.getM_id(),
                member.getM_pwd(),
                member.getM_mail());
    }

    public int addKey(String key, String id) {
        String query = "UPDATE MEMBER set authKey = '" +key + "' WHERE m_id = '" + id + "'";
        return template.update(query);
    }

    public int update_VeriedKey(String id, String authKey){
        String query = "update member set verified = '1' where m_id = '" + id + "' and AUTHKEY = '" + authKey + "'";
        int res = template.update(query);
        return res;

    }

    public int check_VerifiedKey(String id)
    {
        String query = "Select count(*) from MEMBER where m_id = '" + id + "' and verified = '1'";
        int res = template.queryForObject(query, Integer.class);
        return res;
    }

}
