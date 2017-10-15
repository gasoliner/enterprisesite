package cn.enterprisesite.support.listener;

import cn.enterprisesite.support.config.Constant;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;

/**
 * web启动监听器
 */
public class WebContextListener extends ContextLoaderListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n       欢迎使用 "+ Constant.getConfig("productName") + "  ^_^\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        super.contextInitialized(event);
    }

}