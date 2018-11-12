<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>

<div style="text-align: center">
    <form id="bannerAdd" method="post" class="easyui-form" enctype="multipart/form-data">
        <div style="margin-top:40px;">
           名称：<input type="text" name="title" class="easyui-textbox">
        </div>
      <div style="margin-top:20px;">
            上传：<input  type="text" name="aas" class="easyui-filebox">
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

