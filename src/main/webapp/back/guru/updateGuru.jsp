<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function(){
    $("#guruUpdate").form('load','${pageContext.request.contextPath}/guru/findByOne?id=${param.id}');
})

</script>
<div style="text-align: center">
    <form id="guruUpdate" method="post" class="easyui-form" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top:50px;">
            名称：<input type="text" name="name" class="easyui-textbox">
        </div>
        <div style="margin-top:20px;">
            头像：<input type="text" name="aas" class="easyui-filebox">
        </div>
        <div style="margin-top:20px;">q
            性别：<input type="text" name="sex" class="easyui-textbox">
        </div>
    </form>
</div>