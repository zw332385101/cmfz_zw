<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $('#tt').edatagrid({
        url: '${pageContext.request.contextPath}/course/findByCourseAll',
        saveUrl: '${pageContext.request.contextPath}/course/addCourse',
        updateUrl: '${pageContext.request.contextPath}/course/motifyCourse',
        destroyUrl: '${pageContext.request.contextPath}/course/removeCourse',
        autoSave: true,
        toolbar: [
            {
                text: '添加',
                iconCls: 'icon-add',
                handler: function () {
                    $("#tt").edatagrid('addRow');
                }
            }
        ],
        columns: [[
            {field: 'id', title: 'id', width: 100, editor: {type: 'text'}},
            {field: 'title', title: '名称', width: 100, editor: {type: 'text'}},
            {field: 'marking', title: '标记', width: 100, editor: {type: 'text'}},
            {field: 'creatTime', title: '创建时间', width: 100,},
        ]],
    });
</script>

<table id="tt"></table>