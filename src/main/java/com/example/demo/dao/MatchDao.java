package com.example.demo.dao;

import com.example.demo.common.Match;
import com.example.demo.common.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.metal.MetalCheckBoxIcon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MatchDao {
    @Autowired
    JdbcTemplate template;

    public int addMatch(Match match)
    {
        String query = "insert into MATCH values(?,?,?)";
        return template.update(query,
                match.getReq_id(),
                match.getRes_id(),
                match.getPost_id());
    }


}
