package cn.enterprisesite.system.service;

import cn.enterprisesite.support.base.BaseService;
import cn.enterprisesite.system.mapper.SystemddlMapper;
import cn.enterprisesite.system.model.Systemddl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ww on 2017/10/22.
 */
@Service
//@Transactional(readOnly = true)
public class SystemddlService extends BaseService<SystemddlMapper,Systemddl> {



    public List<Systemddl> getKeywordList(){
        List<Systemddl> list = dao.getKeywordList();
        return list;
    }

    public Systemddl getDDLNameByDDLCode(String keyword, Integer ddlCode) {
        Systemddl systemddl = new Systemddl();
        systemddl.setKeyword(keyword);
        systemddl.setDdlcode(ddlCode);
        List<Systemddl> list = dao.getList(systemddl);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public void insert(Systemddl systemDDL) {
        Systemddl select = new Systemddl();
        select.setKeyword(systemDDL.getKeyword());
        List<Systemddl> systemddlList = getList(select);
        Collections.sort(systemddlList);
        systemDDL.setDdlcode(systemddlList.get(systemddlList.size()-1).getDdlcode()+1);
        save(systemDDL);
        return;
    }
}
