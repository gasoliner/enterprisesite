<%--
  Created by IntelliJ IDEA.
  User: 万洪基
  Date: 2016/12/26
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<style type="text/css">
    .menu-last {
        margin-bottom: 5px;
    }
</style>
<body>
<div class="easyui-accordion" style="width:auto;border: 0px;">
    <ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
        <li>
            <span>相关模块操作</span>
            <ul>
                <li data-options="attributes:{'url':'admin_newsManage'}">新闻管理</li>
                <li>
                    <span>课题相关查询</span>
                    <ul>
                        <li data-options="attributes:{'url':'tp_2_defenseGroup'}">答辩分组查询</li>
                        <li data-options="attributes:{'url':'tp_1_myStudent'}">我的学生名单</li>
                    </ul>
                </li>
                <li>
                    <span>课题相关填写</span>
                    <ul>
                        <li data-options="attributes:{'url':''}">填报设计成绩</li>
                        <li data-options="attributes:{'url':'tp_3_answerPT'}">答疑时间和地点设置</li>
                    </ul>
                </li>
            </ul>
        </li>
        <li>
            <span>系统相关操作</span>
            <ul>
                <li data-options="attributes:{'url':'admin_sys_directory'}">数据字典</li>
                <li>
                    <span>个人信息管理</span>
                    <ul>
                        <li data-options="attributes:{'url':'personalInfo'}">个人信息</li>
                        <li data-options="attributes:{'url':'personalPass'}">密码修改</li>
                    </ul>
                </li>
                <li>
                    <span>邮件管理</span>
                    <ul>
                        <li data-options="attributes:{'url':'per_mail_message'}">给同学留言</li>
                        <li data-options="attributes:{'url':''}">收件箱</li>
                        <li data-options="attributes:{'url':''}">发件箱</li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</div>

<script type="text/javascript">
    $(function(){
        $('#menu').tree({
            onClick: function(node){
                if($('#menu').tree("isLeaf",node.target)){
                    if ($('#tt').tabs('exists', node.text)){
                        $('#tt').tabs('select', node.text);
                    } else {
                        var content = '<iframe scrolling="auto" frameborder="0"  src="'+node.attributes.url+'" style="width:100%;height:100%;"></iframe>';
                        $('#tt').tabs('add',{
                            title:node.text,
                            content:content,
                            closable:true
                        });
                    }
                }
            }
        });
    });
</script>
</body>
