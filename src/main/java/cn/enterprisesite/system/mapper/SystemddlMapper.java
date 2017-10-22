package cn.enterprisesite.system.mapper;

import cn.enterprisesite.support.base.BaseDao;
import cn.enterprisesite.support.persistence.MyBatisDao;
import cn.enterprisesite.system.model.Systemddl;

import java.util.List;

/**
 * Created by Ww on 2017/10/22.
 */
@MyBatisDao
public interface SystemddlMapper extends BaseDao<Systemddl> {

    List<Systemddl> getKeywordList();

//    public int batchDelete(List<Systemddl> list)
}
