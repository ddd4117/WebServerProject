package com.example.demo.controller;

import com.example.demo.common.Post;
import com.example.demo.dao.PostDao;
import com.example.demo.mail.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private PostDao postDao;
    @Autowired
    EmailServiceImpl emailService;

    @RequestMapping("/main")
    public ModelAndView index(ModelAndView mav, HttpSession session){
        mav.setViewName("main");
        List<Post> postList =  postDao.PostLIstView();
        for(Post p : postList)
        {
            p.setFlag(postDao.isMatching(p.getP_id()));
        }
        mav.addObject("list", postList);
        return mav;
    }


    @RequestMapping("/logout")
    public ModelAndView logout(ModelAndView mav, HttpSession session){
        mav.setViewName("redirect:/");
        System.out.println("Logout call : " + session.getAttribute("id"));
        session.removeAttribute("id");
        return mav;
    }
}
