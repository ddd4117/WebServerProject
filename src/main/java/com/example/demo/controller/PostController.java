package com.example.demo.controller;

import com.example.demo.common.Post;
import com.example.demo.dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PostController {
    @Autowired
    PostDao postDao;
    @RequestMapping("/post")
    public String post(HttpSession session){
        return "post";
    }

    @RequestMapping("/post={num}")
    public ModelAndView post(@PathVariable int num, HttpSession session, ModelAndView mav)
    {
        System.out.print("Post call : ");
        System.out.println("params [" + num +"]");
        mav.setViewName("/post");
        Post post = postDao.PostView(num);
        mav.addObject("post",post);
        return mav;
    }

    @RequestMapping("/writing")
    public String writing(HttpSession session){
        return "writing";
    }

    @RequestMapping(value="/addPost", method = RequestMethod.POST)
    public ModelAndView addPost(@RequestParam("title")String title,
                       @RequestParam("content")String content,
                       @RequestParam("time")String time,
                       @RequestParam("pay")String pay,
                       @RequestParam("location")String location,
                       @RequestParam("contact")String contact,
                       @RequestParam("x1")String x1,
                       @RequestParam("y1")String y1,
                       @RequestParam("x2")String x2,
                       @RequestParam("y2")String y2,
                       ModelAndView mav,
                       HttpSession session){
        mav.setViewName("redirect:/main");
        System.out.print("Writing Call :");
        System.out.println("params [" + title + " " + content + " " + time +
        " " + pay + " " + location + " " + contact + " " + x1 + " " + y2 + " " + x2 + " " + y2 + "]");
        Post p = new Post(
                (String)session.getAttribute("id"), title, content, time,
                Integer.parseInt(pay), location,
                Float.parseFloat(x1), Float.parseFloat(y1), Float.parseFloat(x2), Float.parseFloat(y2),
                contact
        );
        postDao.insert(p);
        return mav;
    }

    @RequestMapping("/myWriting")
    public ModelAndView myWriting(ModelAndView mav, HttpSession session)
    {
        mav.setViewName("myWriting");
        System.out.print("Writing Call :");
        String id = (String)session.getAttribute("id");
        if(id != null)
        {
            List<Post> postList = postDao.myPost(id);
            for(Post p : postList)
                p.setFlag(postDao.isMatching(p.getP_id()));

            List<Post> myMatchList = postDao.myMatch(id);
            for(Post p : myMatchList)
                p.setFlag(postDao.isMatching(p.getP_id()));

            List<Post> myAccept = postDao.myAccption(id);
            for(Post p : myAccept)
                p.setFlag(postDao.isMatching(p.getP_id()));

            mav.addObject("postList", postList);
            mav.addObject("matchList", myMatchList);
            mav.addObject("accept", myAccept);
        }
        return mav;
    }
}
