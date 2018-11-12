<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<table id="dg"></table>
<script>

    $('#dg').datagrid({
        url:'${pageContext.request.contextPath}/chapter/findByChapter?id=${param.id}',
        fitColumns:true,
        fit:true,
        autoRowHeight:false,

        columns:[[
            {field:'title',title:'名称',width:100},
            {field:'size',title:'大小',width:100},
            {field:'duration',title:'时长',width:100},
            {field:'downPath',title:'地址',width:100},
            {field:'uploadTime',title:'上传时间',width:100},
            {field:'options',title:'操作',width:80,
                formatter:function (value,row,index) {
                    return "<a href=\"${pageContext.request.contextPath}/chapter/downloadchapter?fileName="+row.downPath+"\" class='options' data-options=\"iconCls:'icon-remove'\">下载</a>&nbsp"
                }
            },
        ]],
        onLoadSuccess: function () {
            $(".options").linkbutton();
        },
    });
</script>