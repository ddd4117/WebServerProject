package com.example.demo.controller;

import com.example.demo.common.Member;
import com.example.demo.common.TempKey;
import com.example.demo.dao.MemberDao;
import com.example.demo.mail.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    MemberDao memberDao;

    @Autowired
    EmailServiceImpl emailService;

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("username") String id, @RequestParam("password") String pwd, ModelAndView mav,
                              HttpSession session) {
        System.out.print("Login Call : ");
        System.out.println("params [" + id + " " + pwd + "]");
        boolean res = memberDao.hasID(id, pwd);
        System.out.println("return ; " +res);
        int count = memberDao.check_VerifiedKey(id);
        if (res && count > 0) {
                session.setAttribute("id", id);
                session.setAttribute("pwd", pwd);
                mav.setViewName("redirect:/main");
        } else mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("regi_name") String id,
                          @RequestParam("regi_pwd") String pwd,
                          @RequestParam("email") String email,
                          Model model, HttpSession session) {
        System.out.print("addUser Call : ");
        System.out.println("params " + id + " " + pwd + " " + email);
        int res = memberDao.addUser(new Member(id, pwd, email));
        if (res != 1) {
            System.out.println("ADD USER ERROR");
            return "redirect:/login";
        }
        String key = new TempKey().getKey(50, false);
        res = memberDao.addKey(key, id);
        String subject = "<경북대학교 대신해주세요> 메일 인증입니다.";
        String content = new StringBuffer().append("<h1>메일인증</h1>").append("<a href='http://localhost:8080/emailConfirm?userID=").
                append(id).
                append("&memberAuthKey=").append(key).
                append("' target='_blank'>이메일 인증 확인</a>").toString();
        emailService.sendSimpleMessage(email, subject, content);
        return "redirect:/";
    }

    @RequestMapping(value = "/emailConfirm", method = RequestMethod.GET)

    public String emailConfirm(@RequestParam("userID") String userID,
                               @RequestParam("memberAuthKey") String memberAuthkey,
                               Model model) {
        System.out.print("emailConfirm Call : ");
        System.out.println("params [" + userID + " " + memberAuthkey + "]");
        int res = memberDao.update_VeriedKey(userID, memberAuthkey);
        if (res == 0) {
            return "redirect:/";
        }
        return "redirect:/";
    }
}
