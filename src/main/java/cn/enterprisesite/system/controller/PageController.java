package cn.enterprisesite.system.controller;

import cn.enterprisesite.support.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 万洪基 on 2017/6/25.
 */
@Controller
public class PageController extends BaseController {

    @RequestMapping("${adminPath}/")
    public String showAdminIndex(){
        return "admin_index";
    }

    @RequestMapping("${adminPath}/{page}")
    public String showAdminPage(@PathVariable String page){
        return page;
    }

}
