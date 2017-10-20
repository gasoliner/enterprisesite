package cn.enterprisesite.system.model;

import cn.enterprisesite.support.base.BaseModel;

import java.util.Date;

/**
 * Created by Ww on 2017/10/20.
 */
public class News extends BaseModel<News> {

    private String content;

    private String title;

    private Date pubdate;

    private Integer kind;

    private String voKind;

    private String spare;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getKind() {
        return kind;
    }

    public void setKind(Integer kind) {
        this.kind = kind;
    }

    public String getVoKind() {
        return voKind;
    }

    public void setVoKind(String voKind) {
        this.voKind = voKind;
    }

    public String getSpare() {
        return spare;
    }

    public void setSpare(String spare) {
        this.spare = spare;
    }
}
