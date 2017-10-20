package cn.enterprisesite.support.web;

/**
 * Created by ww on 2017/2/17.
 * 因为对BootStrap不了解，所以临时用EasyUI顶替。
 * 这是EasyUI的DataGrid组件。
 */
public class DataGrid {
    private Long total = 0L;
    private Object rows ;

    public Long getTotal() {
            return total;
        }

    public void setTotal(Long total) {
            this.total = total;
        }

    public Object getRows() {
        return rows;
    }

    public void setRows(Object rows) {
        this.rows = rows;
    }
}
