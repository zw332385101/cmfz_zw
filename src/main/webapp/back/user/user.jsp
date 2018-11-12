<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $("#tt").edatagrid({
    url:'${pageContext.request.contextPath}/user/findByUserAll',
    autoSave:true,
    saveUrl:'${pageContext.request.contextPath}/user/addUser',
    updateUrl:'${pageContext.request.contextPath}/user/motifyUser',
    destroyUrl:'${pageContext.request.contextPath}/user/removeUser',
        method:'post',
    toolbar:[
        {
            text:'添加',
            iconCls:'icon-add',
            handler:function(){
                $("#tt").edatagrid('addRow');
            }
        }
    ],
    columns:[[
        {field:'id',title:'id',width:100,editor:{type:'text'}},
        {field:'phoneNum',title:'phoneNum',width:100,editor:{type:'text'}},
        {field:'username',title:'username',width:100,editor:{type:'text'}},
        {field:'password',title:'password',width:100,editor:{type:'text'}},
        {field:'salt',title:'salt',width:100,editor:{type:'text'}},
        {field:'province',title:'province',width:100,editor:{type:'text'}},
        {field:'city',title:'city',width:100,editor:{type:'text'}},
        {field:'nickNake',title:'nickNake',width:100,editor:{type:'text'}},
        {field:'gender',title:'gender',width:100,editor:{type:'text'}},
        {field:'sign',title:'sign',width:100,editor:{type:'text'}},
        {field:'creat_date',title:'creat_date',width:100,editor:{type:'text'}},
        {field:'headPic',title:'headPic',width:100,},
        {field:'options',title:'options',widht:100,
            formatter:function(value,row,index){
                return "<a href='javascript:;' class='options' onclick=\"deRow('"+row.id+"')\" data-options=\"iconCls:'icon-remove',plain:true\">删除</a>&nbsp;&nbsp;"
            },
        },
    ]],
    onLoadSuccess:function(){
            $(".options").linkbutton();
        },
    view: detailview,
    detailFormatter: function(rowIndex, rowData){
        return '<table><tr>' +
            '<td rowspan=2 style="border:0"><img src=\"${pageContext.request.contextPath}/'+rowData.headPic+'\" style="height:50px;"></td>' +
            '<td style="border:0">' +
            '<p>Attribute: ' +rowData.headPic + '</p>' +
            '<p>Status: ' + rowData.sign + '</p>' +
            '</td>' +
            '</tr></table>';
    }
})
    function deRow(id) {
        $.post("${pageContext.request.contextPath}/user/removeUser",{"id":id},function (result) {
            $("#tt").edatagrid('reload');
        })
    }

</script>

<table id="tt"></table>
