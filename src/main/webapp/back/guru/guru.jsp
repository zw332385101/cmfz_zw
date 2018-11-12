<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function(){
    $("#guru").datagrid({
        url:"${pageContext.request.contextPath}/guru/findByGuruAll",
        fitColumns:true,
        toolbar:[
            {
                text:'添加',
                iconCls:'icon-add',
                handler:addGuru,
            },
            {
                text:'修改',
                iconCls:'icon-edit',
                handler:updateGuru,
            },
            {
                text:'删除',
                iconCls:'icon-remove',
                handler:removeGuru,
            },
        ],
        columns:[[
            {field :'ck',checkbox:true},
            {field:'id',title:'id',width:100},
            {field:'name',title:'名称',width:100},
            {field:'headPic',title:'头像',width:100},
            {field:'sex',title:'性别',width:100},
        ]],
        view: detailview,
        detailFormatter: function(rowIndex, rowData){
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src=\"${pageContext.request.contextPath}'+rowData.headPic+'\" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>Attribute: ' + rowData.headPic + '</p>' +
                '<p>Status: ' + rowData.name + '</p>' +
                '</td>' +
                '</tr></table>';
        }
    })
})

    function addGuru() {
        $("#addGuru").dialog({
            width:400,
            height:300,
            iconCls:'iconCls-add',
            title:'添加',
            href:"${pageContext.request.contextPath}/back/guru/add.jsp",
          buttons:[{
                iconCls:'icon-save',
                text:'添加',
                handler:function(){
                    $("#bannerAdd").form('submit',{
                        url:'${pageContext.request.contextPath}/guru/addGuru',
                        success:function (result){
                            $("#addGuru").dialog('close');
                            $("#guru").datagrid('reload');
                        }
                    })
                }
            }]
        })
    }

function updateGuru() {
    //获取id
    var rows = $("#guru").datagrid('getSelections');
    var id=[];
    for(var i=0;i<rows.length;i++){
        id.push(rows[i].id);
    }
    $("#updateGuru").dialog({
        width:600,
        height:400,
        title:'修改',
        href:'${pageContext.request.contextPath}/back/guru/updateGuru.jsp?id='+id,
        buttons:[{
            iconCls:'icon-save',
            text:'保存',
            handler:function(){
                $("#guruUpdate").form('submit',{
                    url:'${pageContext.request.contextPath}/guru/motifyGuru',
                    success:function(result){
                        $("#updateGuru").dialog('close');
                        $("#guru").datagrid('reload');
                    }
                })
            }
        }]
    })
}
    /*
    * 删除
    * */
    function removeGuru(){
        var rows = $("#guru").datagrid('getSelections');
        if(rows.length<=0){
            $.messager.show({
                title:'提示',
                msg:"至少选中一行",
            })
        }else {
            var ids=[];
            for(var i=0;i<rows.length;i++){
                ids.push(rows[i].id);
            }
            $.ajax({
                url:"${pageContext.request.contextPath}/guru/removeGuru",
                type:"POST",
                traditional:true,//非传统
                data:{id:ids},
                success:function(result) {
                    $("#guru").datagrid('reload');
                }
            })
    }
    }
</script>
<table id="guru"></table>
<div id="addGuru"></div>
<div id="updateGuru"></div>





