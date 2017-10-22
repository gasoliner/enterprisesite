<%--
  Created by IntelliJ IDEA.
  User: Ww
  Date: 2017/10/21
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>newsManage</title>
    <%@ include file="gloable/head-lib.jsp"%>
    <script>
        $(function () {
            var editor = KindEditor.create('#content', {
                cssPath: '/static/ui/kindeditor-4.1.7/plugins/code/prettify.css',
                uploadJson : '/admin/kindeditor/fileUpload',
                fileManagerJson : '/admin/kindeditor/fileManager',
                allowFileManager : true,
                items : ['source', '|', 'undo', 'redo', '|', 'preview', 'template', 'cut', 'copy', 'paste',
                    'plainpaste', 'wordpaste', '|', 'justifyleft', 'justifycenter', 'justifyright',
                    'justifyfull', 'insertorderedlist', 'insertunorderedlist', 'indent', 'outdent', 'subscript',
                    'superscript', 'clearhtml', 'quickformat', 'selectall', '|', 'fullscreen', '/',
                    'formatblock', 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold',
                    'italic', 'underline', 'strikethrough', 'lineheight', 'removeformat', '|', 'image','multiimage',
                    'flash', 'media', 'insertfile', 'table', 'hr', 'emoticons', 'baidumap', 'pagebreak',
                    'anchor', 'link', 'unlink']
            });
        });
    </script>
</head>
<body>
<div>
    <div align="center">
        <table id="dg" title="新闻管理表" class="easyui-datagrid" style="width: 100%;height:auto"
               toolbar="#toolbar"
               fitColumns="true" singleSelect="true" pagination="true"
               data-options="rownumbers:true,
            url:'/admin/news/list',
            method:'get',
            pageSize:15,
            pageList:[5,10,15,20,25]">
            <thead>
            <tr>
                <th field="ck" checkbox="true"></th>
                <th field="title" width="150">标题</th>
                <th field="pubdate" width="50">发布时间</th>
            </tr>
            </thead>
        </table>
    </div>
    <div id="toolbar">
        <a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newNews()">新建</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editNews()">编辑</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="batchDel()">批量删除</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="readNews()">查看详情</a>
    </div>
    <div id="NewsDialog" class="easyui-dialog" style="width:770px;height:550px;padding:10px 20px"
         closed="true" buttons="#NewsForm-buttons">
        <div class="ftitle">新闻管理表</div>
        <form id="fm" method="post">
            <div class="fitem">
                <label>新闻类别&nbsp;&nbsp;&nbsp;</label>
                <input name="kind"
                       class="easyui-combobox"
                       data-options="
                           valueField:'ddlcode',
                           textField:'ddlname',
                           width:300,
                           url:'${pageContext.request.contextPath}/admin/systemddl/list/news_kind'" />
            </div>
            <div class="fitem">
                <label>标题&nbsp;&nbsp;&nbsp;</label>
                <input name="title" class="plainText">
            </div>
            <div class="fitem">
                <label>内容&nbsp;&nbsp;&nbsp;</label>
                <textarea id="content" name="content" style="height: 550px;width: 500px;"></textarea>
            </div>
        </form>
    </div>
    <div id="NewsForm-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveNews()">保存</a>
        <a href="#" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#NewsDialog').dialog('close')">取消</a>
    </div>
    <div id="News_read-buttons">
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="javascript:$('#read_NewsDialog').dialog('close')">好的</a>
    </div>

    <div id="read_NewsDialog" class="easyui-dialog" style="width:770px;height:550px;padding:10px 20px" closed="true" buttons="#News_read-buttons">
        <div id="News_content"></div>
        <span id="News_footer" style="display:block; width: 500px; float:right; text-align:right;"></span>
    </div>

    <div>
        <form id="dfm" method="post">
            <input type="hidden" name="_method" value="DELETE">
        </form>
    </div>
</div>
</body>
</html>
