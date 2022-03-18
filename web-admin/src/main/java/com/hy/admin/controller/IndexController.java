package com.hy.admin.controller;

import com.hy.admin.bean.Account;
import com.hy.admin.bean.Fruit;
import com.hy.admin.bean.User;
import com.hy.admin.service.AccountService;
import com.hy.admin.service.FruitService;
import com.hy.admin.service.serviceImpl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/12 16:25
 */

@Controller
@Slf4j
public class IndexController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountService accountService;

    @Autowired
    FruitService fruitService;

    @ResponseBody
    @GetMapping("/fruit")
    public Fruit getFruit(@RequestParam("id") Integer id){
        return fruitService.getFruitById(id);
    }

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Integer id) {
        return accountService.getAcctById(id);
    }

    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (!StringUtils.isEmpty(user.getUserName()) && !StringUtils.isEmpty(user.getPassword())) {
            if (user.getUserName().equals("hy") && user.getPassword().equals("1111")) {
                session.setAttribute("loginUser", user);
                //登录成功跳转到index页面 如果不跳转浏览器地址还是login会存在重复提交问题
                //重定向防止重复提交
                return "redirect:/main.html";
            } else {
                model.addAttribute("msg", "账号或密码错误");
                return "login";
            }
        } else {
            model.addAttribute("msg", "账号密码不能为空");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            return "login";
        }
    }

    @ResponseBody
    @GetMapping("/sql")
    public String sql() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        return aLong.toString();
    }

}
