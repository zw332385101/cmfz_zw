<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>持名法州主页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/IconExtension.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/back/themes/icon.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/datagrid-detailview.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.etree.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/back/js/jquery.edatagrid.js"></script>


    <script type="text/javascript">
        /*
        * 修改后台密码
        * */
        function updatePassword() {
            $("#openxiugai").dialog({
                title: '修改密码',
                width: 500,
                height: 300,
                href: '${pageContext.request.contextPath}/back/main/updatePassword.jsp',
                buttons: [{
                    iconCls: 'icon-save',
                    text: '保存',
                    handler: function () {
                        $("#updateInputForm").form('submit', {
                            url: "${pageContext.request.contextPath}/admin/updateAdminPassword",
                        })
                        $("#openxiugai").dialog('close');
                        location.href='${pageContext.request.contextPath}/back/login.jsp';
                    }
                }, {
                    iconCls: 'icon-cancel',
                    text: '关闭',
                    handler: function () {
                        $("#openxiugai").dialog('close');
                    }
                }]
            })
        }

        /*
        * 菜单
        *
        * */
        $(function () {
         $.post("${pageContext.request.contextPath}/menu/findAll",function (menu){
            if(${sessionScope.admin==null}){
                location.href="${pageContext.request.contextPath}/back/login.jsp";
            }
                //遍历一级菜单
             $.each(menu,function (index,m) {
                 //遍历二级菜单
                 var content="<div style='text-align: center'>";
                 $.each(m.c_menu,function (idx,child) {
                     content+="<a  onclick=\"addTabs('"+child.title+"','"+child.iconCls+"','"+child.href+"')\" style='width: 95%;margin: 5px 0 10px 0;' class='easyui-linkbutton' data-options=\"iconCls:'"+child.iconCls+"'\">"+child.title+"</a><br>";
                 })
                 content+="</div>"

                $("#menu").accordion('add',{
                     title:m.title,
                     iconCls:m.iconCls,
                     content:content,
                 })
             })
         })
        });

        /*
        * 添加Tabs
        * */
        function addTabs(title,iconCls,href) {
            console.log("地址"+href);
            if (!$("#tabs").tabs('exists',title)) {
                $("#tabs").tabs('add',{
                    title:title,
                    iconCls:iconCls,
                    href:"${pageContext.request.contextPath}/"+href,
                    fit:true,
                    closable:true,//关闭选项卡
                    //href:"${pageContext.request.contextPath}/"+href,
                });
            }else {
                $("#tabs").tabs('select',title);
            }

        }
    </script>

</head>
<body class="easyui-layout">
<div data-options="region:'north',split:true" style="height:60px;background-color:#5C160C">
    <div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px">
        持名法州后台管理系统
    </div>
    <div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">
        欢迎您:${sessionScope.admin.name}&nbsp;<a href="#" onclick="updatePassword()" id="updatepwd" class="easyui-linkbutton"
                                         data-options="iconCls:'icon-edit'">修改密码</a>&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/admin/tuichu"  class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
    </div>
</div>
<div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    <div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体">&copy;百知教育 htf@zparkhr.com.cn</div>
    a
</div>

<div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    <div id="menu" class="easyui-accordion" data-options="fit:true">

    </div>
</div>

<div data-options="region:'center'">
    <div id="tabs" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
        <div title="主页" data-options="iconCls:'icon-neighbourhood',"
             style="background-image:url(${pageContext.request.contextPath}/back/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
    </div>
</div>
//修改密码
<div id="openxiugai"></div>
<%--//退出登录
<div id="edit">
    <h3 style="text-align: center;color:red;">你确定要退出??</h3>
</div>--%>
</body>
</html>