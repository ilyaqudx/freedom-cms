/**
 * Created by 卢强 on 2016/11/29.
 */
/** ***************添加计划名*********************** */
function add(title, url, w, h) {
    layer_show(title, url, w, h);
}
/** ***************计划名编辑********************** */
function edit(title, url, w, h) {
    layer_show(title, url, w, h);
}
/****************导出日志表******************************/
function del(obj, id) {
    layer.confirm('消息删除须谨慎，确认要删除吗？', function (index) {
        $.post("message/del", {
            'id': id
        }, function (data) {
            location.reload();
            layer.msg("已删除", {
                icon: 1,
                time: 1000
            });
        });
    });
}
/** *******************表格数据显示********************* */
$(function () {
    var t = $('.table')
        .dataTable(
            {// 得到表格
                colReorder: false,// 是否允许你列拖动
                serverSide: true,// 是否需要服务器支持
                bFilter: false,// 是否过滤数据
                "columns": [// 具体的列
                    {// 第1列，ID
                        name: "accountId",
                        data: "accountId",
                        title: "邀请人编号",
                        orderable: false
                    }, {// 第2
                        name: "phoneNumber",
                        data: "phoneNumber",
                        title: "邀请人手机号",
                        orderable: false
                    }, {// 第3
                        name: "userName",
                        data: "userName",
                        title: "邀请人",
                        orderable: false
                    }, {// 第4
                        name: "acceptNumber",
                        data: "acceptNumber",
                        title: "被邀请人数",
                        orderable: false
                    }, {// 第5
                        name: "paymentNumber",
                        data: "paymentNumber",
                        title: "付费人数",
                        orderable: false
                    }, {// 第6
                        name: "amount",
                        data: "amount",
                        title: "被邀请人总付费",
                        orderable: false
                    }, {// 第7
                        name: "reachedNumber",
                        data: "reachedNumber",
                        title: "达标人数",
                        orderable: false
                    }, {// 第8
                        data: null,
                        title: "基本操作",
                        orderable: false
                    }],
                "bStateSave": true,
                "aoColumnDefs": [{
                    sDefaultContent: '',
                    aTargets: ['_all']
                }, {
                    targets: 7,
                    render: function (data, type, row, meta) {
                        return '<a title="查看关联用户" href="javascript:;" onclick="edit(\'测评编辑\',\'marketing-shared/account?id=' + row.accountId +'\',\'800\',\'600\')" class="ml-5" style="text-decoration:none; color: blue;">关联</a>';
                    }
                }],

                fnServerData: function (sSource, aoData, fnCallback) {
                    // 加入额外的参数
                    aoData.push({
                        "name": "params",
                        "value": getParams()
                    });
                    var postdata = {};
                    var postSize = aoData.length;
                    for (var i = 0; i < postSize; i++) {
                        aoData[i].value = JSON
                            .stringify(aoData[i].value);
                    }
                    $.ajax({
                        "dataType": 'json',
                        "type": "POST",
                        "url": sSource,
                        "data": aoData,
                        "success": fnCallback
                    });
                }
            });

    $('#search').on('click', function () {
        t.fnDraw();
    });

    function getParams() {
        var params = {};
        var searchText = $("#search-text").val();
        if (searchText != null && searchText != "") {
            params['searchText'] = searchText;
        }

        return params;
    }

});