package cn.enterprisesite.system.controller;

import cn.enterprisesite.support.base.BaseController;
import cn.enterprisesite.system.model.Systemddl;
import cn.enterprisesite.system.service.SystemddlService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by 万洪基 on 2017/6/26.
 */
@Controller
@RequestMapping(value = "${adminPath}/systemddl",produces = {"application/json;charset=UTF-8"} )
public class SystemDDLController extends BaseController {

    @Autowired
    private SystemddlService systemddlService;

    @RequestMapping("/keyword")
    @ResponseBody
    public String getKeyword() throws Exception{
        return JSON.toJSONString(systemddlService.getKeywordList());
    }
    @RequestMapping("/list/{keyword}")
    @ResponseBody
    public String getList(@PathVariable String keyword) throws Exception{
        Systemddl systemddl = new Systemddl();
        systemddl.setKeyword(keyword);
        return JSON.toJSONString(systemddlService.getList(systemddl));
    }
//    @RequiresPermissions("systemddl:*")
    @RequestMapping("/addition")
    @ResponseBody
    public String addition(Systemddl systemDDL) throws Exception{
        try {
            systemddlService.insert(systemDDL);
            return JSON.toJSONString("操作成功");
        }catch (Exception e){
            return JSON.toJSONString("操作失败");
        }
    }
//    @RequiresPermissions("systemddl:*")
    @RequestMapping("/updates/{uuid}")
    @ResponseBody
    public String updates(@PathVariable String uuid, Systemddl systemddl) throws Exception {
        systemddl.setId(uuid);
        try {
            systemddlService.save(systemddl);
            return JSON.toJSONString("操作成功");
        }catch (Exception e){
            return JSON.toJSONString("操作失败");
        }
    }
//    @RequiresPermissions("systemddl:*")
    @RequestMapping(value = "/deletion/{uuid}",method = RequestMethod.DELETE)
    @ResponseBody
    public String deletion(@PathVariable String uuid) throws Exception {
        Systemddl systemddl = new Systemddl();
        systemddl.setId(uuid);
        try {
            systemddlService.delete(systemddl);
            return JSON.toJSONString("操作成功");
        }catch (Exception e){
            return JSON.toJSONString("操作失败");
        }
    }

}
