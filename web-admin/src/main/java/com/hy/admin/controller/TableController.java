package com.hy.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hy.admin.bean.User;
import com.hy.admin.exception.UserTwoManyException;
import com.hy.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

/**
 * @author hy
 * @version 1.0
 * @Desctiption
 * @date 2022/3/12 17:28
 */
@Controller
public class TableController {
    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table";
    }

    @GetMapping("/del_dynamic/{id}")
    public String delByid(@PathVariable("id") Long id,
                          @RequestParam(value="pn",defaultValue = "1") Integer pn,
                          RedirectAttributes ra){
        userService.removeById(id);
        ra.addAttribute("pn",pn);
        return "redirect:/dynamic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn,Model model){
        /*
        List<User> users = Arrays.asList(new User("zhangsan", "123456"),
                new User("lisi", "123456"),
                new User("haha", "123456"),
                new User("hehe", "123456"));
        model.addAttribute("users",users);
        if(users.size()>3) {
            throw new UserTwoManyException();
        }
         */

        List list = userService.list();
//        model.addAttribute("users",list);
        Page<User> userPage = new Page<>(pn, 2);
        IPage page = userService.page(userPage,null);
        model.addAttribute("page",page);
        //page包含查询出来的user记录

        return "table/dynamic_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "table/pricing_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

}
