package cn.enterprisesite.support.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * Controller基础接口
 */
public abstract class BaseController {

    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 后台基础路径
     */
    @Value("${adminPath}")
    protected String adminPath;

    /**
     * 前台基础路径
     */
    @Value("${frontPath}")
    protected String frontPath;

    /**
     * 前端URL后缀
     */
    @Value("${urlSuffix}")
    protected String urlSuffix;

    @ExceptionHandler
    protected String handleException(Exception ex){
        logger.error(ex.getMessage() , ex);
        return "error/500";
    }
}
