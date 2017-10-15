package cn.enterprisesite.system.controller;

import cn.enterprisesite.support.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Ww on 2017/10/15.
 */
@RequestMapping("/test")
@Controller
public class TestController extends BaseController {

    @RequestMapping("/test1")
    @ResponseBody
    public String test1() {
        System.out.println("test1");
        return "success";
    }
}
