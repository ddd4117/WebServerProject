package com.example.demo.dao;

import com.example.demo.common.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDao {
    @Autowired
    JdbcTemplate template;

    public int insert(Post post) {
        String query = "INSERT INTO POST VALUES(post_id.nextval,?,?,?,?,?,?,?,?,?,?,?)";
        return template.update(query,
                post.getMember_id(),
                post.getP_title(),
                post.getP_content(),
                post.getP_time(),
                post.getP_money(),
                post.getP_location(),
                post.getP_map1_x(),
                post.getP_map1_y(),
                post.getP_map2_x(),
                post.getP_map2_y(),
                post.getP_contact());
    }

    public List<Post> PostLIstView() {
        List<Post>postList = template.query("select * from post order by post.P_ID DESC", new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post p = new Post();
                p.setP_id(rs.getInt(1));
                p.setMember_id(rs.getString(2));
                p.setP_title(rs.getString(3));
                p.setP_content(rs.getString(4));
                p.setP_time(rs.getString(5));
                p.setP_money(rs.getInt(6));
                p.setP_location(rs.getString(7));
                p.setP_map1_x(rs.getFloat(8));
                p.setP_map1_y(rs.getFloat(9));
                p.setP_map2_x(rs.getFloat(10));
                p.setP_map2_y(rs.getFloat(11));
                p.setP_contact(rs.getString(12));
                return p;
            }

        });
        return postList;
    }

    public Post PostView(int p_id) {
        String query = "select * from post where p_id = " + p_id;
        List<Post> postList = template.query(query, new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post p = new Post();
                p.setP_id(rs.getInt(1));
                p.setMember_id(rs.getString(2));
                p.setP_title(rs.getString(3));
                p.setP_content(rs.getString(4));
                p.setP_time(rs.getString(5));
                p.setP_money(rs.getInt(6));
                p.setP_location(rs.getString(7));
                p.setP_map1_x(rs.getFloat(8));
                p.setP_map1_y(rs.getFloat(9));
                p.setP_map2_x(rs.getFloat(10));
                p.setP_map2_y(rs.getFloat(11));
                p.setP_contact(rs.getString(12));
                return p;
            }

        });
        return postList.get(0);
    }

    public boolean isMatching(int p_id)
    {
        String query = "select count(*) from match m where m.Post_id =" + p_id;
        int count = template.queryForObject(query, Integer.class);
        if (count == 0) return false;
        else return true;
    }

    public List<Post> myPost(String id) {
        String query = "select * from post where member_id = '" + id +"'";
        List<Post> postList = template.query(query, new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post p = new Post();
                p.setP_id(rs.getInt(1));
                p.setMember_id(rs.getString(2));
                p.setP_title(rs.getString(3));
                p.setP_content(rs.getString(4));
                p.setP_time(rs.getString(5));
                p.setP_money(rs.getInt(6));
                p.setP_location(rs.getString(7));
                p.setP_map1_x(rs.getFloat(8));
                p.setP_map1_y(rs.getFloat(9));
                p.setP_map2_x(rs.getFloat(10));
                p.setP_map2_y(rs.getFloat(11));
                p.setP_contact(rs.getString(12));
                return p;
            }
        });
        return postList;
    }

    public List<Post> myMatch(String id) {
        String query = "select * from post p where p.p_id = (select m.post_id from match m where m.REQ_ID = '" + id + "')";
        List<Post> postList = template.query(query, new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post p = new Post();
                p.setP_id(rs.getInt(1));
                p.setMember_id(rs.getString(2));
                p.setP_title(rs.getString(3));
                p.setP_content(rs.getString(4));
                p.setP_time(rs.getString(5));
                p.setP_money(rs.getInt(6));
                p.setP_location(rs.getString(7));
                p.setP_map1_x(rs.getFloat(8));
                p.setP_map1_y(rs.getFloat(9));
                p.setP_map2_x(rs.getFloat(10));
                p.setP_map2_y(rs.getFloat(11));
                p.setP_contact(rs.getString(12));
                return p;
            }
        });
        return postList;
    }
    public List<Post> myAccption(String id) {
        String query = "select * from post p where p.p_id = (select m.post_id from match m where m.RES_ID = '" + id + "')";
        List<Post> postList = template.query(query, new RowMapper<Post>() {
            @Override
            public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
                Post p = new Post();
                p.setP_id(rs.getInt(1));
                p.setMember_id(rs.getString(2));
                p.setP_title(rs.getString(3));
                p.setP_content(rs.getString(4));
                p.setP_time(rs.getString(5));
                p.setP_money(rs.getInt(6));
                p.setP_location(rs.getString(7));
                p.setP_map1_x(rs.getFloat(8));
                p.setP_map1_y(rs.getFloat(9));
                p.setP_map2_x(rs.getFloat(10));
                p.setP_map2_y(rs.getFloat(11));
                p.setP_contact(rs.getString(12));
                return p;
            }
        });
        return postList;
    }
}
