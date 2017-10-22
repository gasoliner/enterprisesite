package cn.enterprisesite.system.model;

import cn.enterprisesite.support.base.BaseModel;

public class Systemddl extends BaseModel<Systemddl> implements Comparable<Systemddl> {
    private String keyword;

    private Integer ddlcode;

    private String ddlname;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getDdlcode() {
        return ddlcode;
    }

    public void setDdlcode(Integer ddlcode) {
        this.ddlcode = ddlcode;
    }

    public String getDdlname() {
        return ddlname;
    }

    public void setDdlname(String ddlname) {
        this.ddlname = ddlname == null ? null : ddlname.trim();
    }

    @Override
    public int compareTo(Systemddl o) {
        return this.getDdlcode().compareTo(o.getDdlcode());
    }
}