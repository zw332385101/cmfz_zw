<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center;">
    <form id="updateInputForm" class="easyui-form" method="post">
        <input type="hidden" name="id" value="${sessionScope.id}">
        <div style="margin-top: 58px">
            用户名:&nbsp;<input type="text" value="${sessionScope.admin.name}" class="easyui-textbox" data-options="required:true,iconCls:'icon-man'">
        </div>

        <div style="margin-top: 20px">
            密&nbsp;&nbsp;码:&nbsp;&nbsp;&nbsp;<input type="text" class="easyui-passwordbox" value="${sessionScope.admin.password}"> <br>
        </div>

        <div style="margin-top:20px">
            新密码:&nbsp;<input type="text" name="password" class="easyui-passwordbox" data-options="prompt:'请输入密码'"> <br>
        </div>
    </form>
</div>
