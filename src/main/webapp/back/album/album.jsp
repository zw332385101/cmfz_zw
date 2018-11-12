<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false" %>
<script>
    $('#tt').treegrid({
        width:'100%',
        url:'${pageContext.request.contextPath}/album/findByAlbumAll',
        idField:'id',
        treeField:'title',
        fitColumns:true,
        fit:true,
        columns:[[
            {field:'title',title:'名字',width:80,align:'right',align:'center'},
            {field:'downPath ',title:'下载路径',width:80,align:'center'},
            {field:'size ',title:'章节大小',width:80,align:'center'},
            {field:'uploadTime',title:'章节时长',width:80,align:'center'},
        ]],
        toolbar:[
            {
                text:'专辑详情',
                iconCls:'icon-edit',
                handler:function(){
                    //获取的专辑
                    var selectRow1=$("#tt").treegrid("getSelected");
                    console.log(selectRow1);
                    var id = selectRow1.id;
                    console.log(id)
                    console.log(selectRow1);
                    if(selectRow1!=null){
                        if(selectRow1.size==null){
                            $("#chakan").dialog({
                                width:800,
                                height:400,
                                href:'${pageContext.request.contextPath}/back/album/ckAlbum.jsp?id='+id,
                            })
                        }else{
                            alert('请选择您要了解的专辑');
                        }
                    }else{
                        alert('请选择您要了解的专辑');
                    }
                }
            },
            {
                text:'添加专辑',
                iconCls:'icon-add',
                handler:addAlbumAll,
            }, {
                text:'添加章节',
                iconCls:'icon-add',
                handler:addChapter,
            },{
                text:'下载音频',
                iconCls:'icon-download',
                handler:download,
            }

        ],
    });

    function addAlbumAll(){
        $("#addAlbum").dialog({
            width:650,
            height:500,
            href:"${pageContext.request.contextPath}/back/album/addAlbum.jsp",
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function(){
                    $("#albumAdd").form('submit',{
                        url:'${pageContext.request.contextPath}/album/addAlbum',
                        success:function (result){
                            $("#addAlbum").dialog('close');
                            $('#tt').treegrid('reload');
                        }
                    })
                }
            }]

        })
    }
    function addChapter() {
        var selectRow1=$("#tt").treegrid("getSelected");
        var id = selectRow1.id;
        $("#addChapter").dialog({
            width:650,
            height:500,
            href:"${pageContext.request.contextPath}/back/album/addChapter.jsp?id="+id,
            buttons:[{
                iconCls:'icon-save',
                text:'保存',
                handler:function(){
                    $("#chapterAdd").form('submit',{
                        url:'${pageContext.request.contextPath}/chapter/addChapter',
                        success:function (result){
                            $("#addChapter").dialog('close');
                            $('#tt').treegrid('reload');
                        }
                    })
                }
            }]
        })
    }

    function download(){
        var selectRow1=$("#tt").treegrid("getSelected");
        var id = selectRow1.id;
        console.log(id);
        $("#xiazai").dialog({
            width:'1000',
            height:'400',
            autoRowHeight:false,
            href:'${pageContext.request.contextPath}/back/album/download.jsp?id='+id,
        })
    }
    
</script>
<table id="tt" style="width:800px;height:400px" date-options="fitColumns:true"></table>
<div id="addAlbum"></div>
<div id="addChapter"></div>
<div id="chakan"></div>
<%--下载音频--%>
<div id="download"></div>
<div id="xiazai"></div>