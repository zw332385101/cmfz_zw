<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<div style="text-align: center">
    <form id="chapterAdd" method="post" class="easyui-form" enctype="multipart/form-data">
        <input type="text" name="album_id" value="${param.id}">
        <div style="margin-top:40px;">
            名称：<input type="text" name="title" class="easyui-textbox">
        </div>
        <div style="margin-top:20px;">
            上传路径：<input type="text" name="aas" class="easyui-filebox">
        </div>
    </form>
</div>