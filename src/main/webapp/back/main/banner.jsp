<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
$(function(){
    $("#banner").datagrid({
        url:"${pageContext.request.contextPath}/banner/findBannerAll",
        fitColumns:true,
        toolbar:[
            {
                text:'添加',
                iconCls:'icon-add',
                handler:addBanner,
            },
            {
                text:'修改',
                iconCls:'icon-edit',
                handler:updateBanner,
            },
            {
                text:'删除',
                iconCls:'icon-remove',
                handler:removeBanner,
            },
            {
                text:'保存',
                iconCls:'icon-save',
                handler:function(){
                    alert('a');
                }
            }
        ],
        columns:[[
            {field :'ck',checkbox:true},
            {field:'id',title:'id',width:100},
            {field:'title',title:'名称',width:100},
            {field:'imgPath',title:'地址',width:100},
            {field:'banner_desc',title:'内容',width:100},
            {field:'status',title:'状态',width:100},
            {field:'banner_date',title:'时间',width:100}
        ]],
        view: detailview,
        detailFormatter: function(rowIndex, rowData){
            return '<table><tr>' +
                '<td rowspan=2 style="border:0"><img src=\"${pageContext.request.contextPath}'+rowData.imgPath+'\" style="height:50px;"></td>' +
                '<td style="border:0">' +
                '<p>Attribute: ' + rowData.imgPath + '</p>' +
                '<p>Status: ' + rowData.title + '</p>' +
                '</td>' +
                '</tr></table>';
        }
    })
})

    function addBanner() {
        $("#addBanner").dialog({
            width:500,
            height:350,
            iconCls:'iconCls-add',
            title:'添加',
            href:"${pageContext.request.contextPath}/back/banner/add.jsp",
          buttons:[{
                iconCls:'icon-save',
                text:'添加',
                handler:function(){
                    $("#bannerAdd").form('submit',{
                        url:'${pageContext.request.contextPath}/banner/addBanner',
                        success:function (result){
                            $("#addBanner").dialog('close');
                            $("#banner").datagrid('reload');
                        }
                    })
                }
            }]
        })
    }
function updateBanner() {
    //获取id
    var rows = $("#banner").datagrid('getSelections');
    var id=[];
    for(var i=0;i<rows.length;i++){
        id.push(rows[i].id);
    }
    $("#updateBanner").dialog({
        width:600,
        height:400,
        title:'修改',
        href:'${pageContext.request.contextPath}/back/banner/updateBanner.jsp?id='+id,
        buttons:[{
            iconCls:'icon-save',
            text:'保存',
            handler:function(){
                $("#bannerUpdate").form('submit',{
                    url:'${pageContext.request.contextPath}/banner/motifyBanner',
                    success:function(result){
                        $("#updateBanner").dialog('close');
                        $("#banner").datagrid('reload');
                    }
                })
            }
        }]
    })
}
    /*
    * 删除
    * */
    function removeBanner(){
        var rows = $("#banner").datagrid('getSelections');
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
                url:"${pageContext.request.contextPath}/banner/removeBanner",
                type:"POST",
                traditional:true,//非传统
                data:{id:ids},
                success:function(result) {
                    $("#banner").datagrid('reload');
                }
            })
    }
    }
</script>
<table id="banner"></table>
<div id="addBanner"></div>
<div id="updateBanner"></div>



