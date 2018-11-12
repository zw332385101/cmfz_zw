<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function(){
    $("#bannerUpdate").form('load','${pageContext.request.contextPath}/banner/findByOne?id=${param.id}');
})

</script>
<div style="text-align: center">
    <form id="bannerUpdate" method="post" class="easyui-form">
        <input type="hidden" name="id" value="${param.id}">
        <div style="margin-top:50px;">
            名称：<input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top:20px;">
            地址：<input type="text" name="imgPath" class="easyui-textbox">
        </div>
        <div style="margin-top:20px;">
            内容：<input type="text" name="banner_desc" class="easyui-textbox">
        </div>
        <div style="margin-top:20px;">
            状态：<input type="text" name="status" class="easyui-textbox">
        </div>
        <div style="margin-top:20px;">
            时间：<input type="text" name="banner_date" class="easyui-datebox">
        </div>
    </form>
</div>