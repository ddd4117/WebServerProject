package com.example.demo.controller;


import com.example.demo.common.Match;
import com.example.demo.dao.MatchDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MatchController {
    @Autowired
    MatchDao matchDao;
    @RequestMapping(value = "/match/accept", method = RequestMethod.POST)
    public ModelAndView addUser(@RequestParam("p_id") String pid,
                                @RequestParam("writer") String writer,
                                @RequestParam("myid") String myid,
                                ModelAndView mav, HttpSession session)
    {
        mav.setViewName("redirect:/main");
        System.out.print("match/accept Call : ");
        System.out.println("params [" + pid + " " + writer + " " + myid +"]");
        Match m = new Match(writer, myid, Integer.parseInt(pid));
        matchDao.addMatch(m);
        return mav;
    }
}
