/**
 * Created by 卢强 on 2016/11/29.
 */

/****************删除关联******************************/
function del(inviteeId) {
    layer.confirm('您确定要删除此分享关联关系吗？', function (index) {
        $.post("marketing-shared/del", {
            'inviterId': $('#id').val(),
            'inviteeId': inviteeId
        }, function (data) {
            location.reload();
            layer.msg("您已成功删除此关联" + data + "条记录。", {
                icon: 1,
                time: 1000
            });
        });
    });
}

// 添加关联
function add() {
    layer.confirm('您确定要为此用户添加关联分享吗？', function (index) {
        $.post("marketing-shared/add", {
            'id': $('#id').val(),
            'phones': $('#phones').val()
        }, function (data) {
            location.reload();
            layer.msg("您已成功关联" + data + "条记录。", {
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
                        title: "被邀请人编号",
                        orderable: false
                    }, {// 第2
                        name: "phoneNumber",
                        data: "phoneNumber",
                        title: "被邀请人编号",
                        orderable: false
                    }, {// 第3
                        name: "userName",
                        data: "userName",
                        title: "被邀请人",
                        orderable: false
                    }, {// 第4
                        name: "amount",
                        data: "amount",
                        title: "总付费",
                        orderable: false
                    }, {// 第5
                        name: "maxContinuousPaymentMo",
                        data: "maxContinuousPaymentMo",
                        title: "最大连续付费月数",
                        orderable: false
                    }, {// 第6
                        name: "reachedTheStandard",
                        data: "reachedTheStandard",
                        title: "是否达标",
                        orderable: false
                    }, {// 第7
                        data: null,
                        title: "基本操作",
                        orderable: false
                    }],
                "bStateSave": true,
                "aoColumnDefs": [{
                    sDefaultContent: '',
                    aTargets: ['_all']
                }, {
                    targets: 5,
                    render: function (data, type, row, meta) {
                        return data ? '<b>是</b>' : '否';
                    }
                }, {
                    targets: 6,
                    render: function (data, type, row, meta) {
                        return '<a title="删除关联" href="javascript:;" onclick="del(' + row.accountId + ')" class="ml-5" style="text-decoration: none; color: red;">删除</a>';
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
        var id = $("#id").val();
        if (id != null && id != "") {
            params['id'] = id;
        }
        var datemin = $("#datemin").val();
        if (datemin != null && datemin != "") {
            params['datemin'] = datemin;
        }
        var datemax = $("#datemax").val();
        if (datemax != null && datemax != "") {
            params['datemax'] = datemax + ' 23:59:59';
        }
        return params;
    }

});