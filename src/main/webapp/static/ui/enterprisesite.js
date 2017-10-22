//字典管理的按类型查询
$(function () {
    $('#searchInput').combobox({
        onChange: function(){
            $("#dg").datagrid({
                url:'/admin/systemddl/list/'+$("#searchInput").combobox("getValue")
            });
            // $("#dg").datagrid("load");
        }
    });
});
//字典
function newSystemDDL(){
    $("#fm").form("clear");
    $("#sysDDLDialog").dialog("open").dialog("setTitle","字典管理--新建");
    url = "/admin/systemddl/addition";
}
function editSystemDDL(){
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $("#sysDDLDialog").dialog("open").dialog("setTitle","字典管理--编辑");
        $("#fm").form("clear");
        $("#fm").form("load",row);
        url = "/admin/systemddl/updates/"+row.uuid;
    }
}
function destroySystemDDL(){
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/admin/systemddl/deletion/"+row.uuid,
                    success: function (res) {
                        alert(res);
                        $("#sysDDLDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveSysDDL(){
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#sysDDLDialog").dialog("close");
            $("#dg").datagrid("reload");
        }
    })
}

//新闻
function newNews(){
    $("#fm").form("clear");
    $("#NewsDialog").dialog("open").dialog("setTitle","新闻管理--新建");
    url = "/admin/news/addition";
}
function editNews(){
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.get("/admin/news/single/" + row.id,null,function (res) {
            news = $.parseJSON(res);
            $("#NewsDialog").dialog("open").dialog("setTitle","新闻管理--编辑");
            $("#fm").form("clear");
            $("#fm").form("load",row);
            $("#content").val(row.content);
            url = "/admin/news/updates/"+row.id;
        })
    }
}
function destroyNews(){
    var row = $("#dg").datagrid("getSelected");
    if (row){
        $.messager.confirm("Confirm","确定要删除这条记录吗",function (r) {
            if (r){
                $("#dfm").form("submit",{
                    url:"/admin/news/deletion/"+row.id,
                    success: function (res) {
                        alert(res);
                        $("#NewsDialog").dialog("close");
                        $("#dg").datagrid("reload")
                    }
                })
            }
        })
    }
}
function saveNews(){
    $("#fm").form("submit",{
        url:url,
        success: function (res) {
            alert(res);
            $("#NewsDialog").dialog("close");
            $("#dg").datagrid("reload");
        }
    })
}
//后端获取单条新闻
function readNews() {
    var row = $("#dg").datagrid("getSelected");
    $.get("/admin/news/single/" + row.id,null,function (res) {
        news = $.parseJSON(res);
        $("#read_NewsDialog").dialog("open").dialog("setTitle",row.title);
        $("#News_content").html(news.content);
        // $("#News_footer").html("发布人："+news.publisher+"  发布日期："+news.pubdate);
        $("#News_footer").html("  发布日期："+news.pubdate);
    })
}
function batchDel() {
    var rows = $("#dg").datagrid('getSelections');
    if (rows){
        $.messager.confirm("Confirm","确定要删除选择的记录吗",function (r) {
            if (r){
                var rowIds = new Array();
                var i = 0;
                for (i; i < rows.length; i++) {
                    rowIds[i] = rows[i].id;
                }
                $.post("/admin/news/deletion",
                    {
                        nids:rowIds,
                        _method:DELETE
                    },
                    function (res) {
                    alert(res);
                    $("#NewsDialog").dialog("close");
                    $("#dg").datagrid("reload");
                });
                // $("#dfm").form("submit",{
                //     url:"/admin/news/deletion/"+row.id,
                //     success: function (res) {
                //         alert(res);
                //         $("#NewsDialog").dialog("close");
                //         $("#dg").datagrid("reload")
                //     }
                // })
            }
        })
    }
}
function downloadFile(model1,model2) {
    window.location.href = "/"+model1+"/download/"+model2;
}

//用户登录登出
function login() {
    $("#fm").form("submit",{
        url:"/user/login",
        success: function (res) {
            window.location.href = res;
        }
    })
}
function logout() {
    $.get("/user/logout",null,function (res) {
        window.location.href = "/login";
    })
}
