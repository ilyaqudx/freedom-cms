//全选或者反选
function selectAll(ele, gvr, chk) {
    var list = document.getElementsByTagName("input");
    for (var i = 0; i < list.length; i++) {
        if (list[i].type == "checkbox" && list[i].id.indexOf(chk) != -1 && list[i].id.indexOf(gvr) != -1) {
            list[i].checked = ele.checked;
        }
    }

}
function checkForm(gvr, chk) {
    var list = document.getElementsByTagName("input");
    var n = 0;
    for (var i = 0; i < list.length; i++) {
        if (list[i].type == "checkbox" && list[i].id.indexOf(chk) != -1 && list[i].id.indexOf(gvr) != -1) {
            if (list[i].checked)
                n++;
        }
    }
    if (n == 0) {
        alert("您尚未选择要操作的对象！ ");
        return false;
    }
    else {
        return confirm("您确认要执行该操作吗");
    }
}
//上传图片
function UpPhoto(obj) {
    var url = 'imagegallery.aspx?frame=1&rif=images/' + obj + '&cif=images/' + obj;
    imgArr = window.showModalDialog(url, window, "dialogHeight:550px;dialogWidth:750px;;toolbar:no;status:yes;resizable:no;help:No;scroll:yes;");
    if (imgArr != null) {
        //        var imgname = imgArr.split('/');
        //        var img = imgname[imgname.length - 1];
        document.getElementById("txt_images").value = imgArr;
    }
}
function renderGender(v, m) {
    if (m != undefined) {
        m.css = 'x-grid-front-underline';
        return v;
    }
}
function showMessaggeInfo(id) {
    $.dialog({ id: 'a3_2', title: '系统公告', content: 'url:/notice_detail.aspx?id=' + id, max: true, min: true, width: '80%', height: '60%', lock: true, padding: 0 });
}
function showMemberInfo(id) {
    $.dialog({ id: 'a3_3', title: '会员信息', content: 'url:/member/member/minfo.aspx?id=' + id, max: false, min: false, width: '300px', height: '150px', lock: true, padding: 0 });
}

function showProductDetail(id) {
    $.dialog({ id: 'a3_1', title: '订单详情', content: 'url:/member/pd/detail.aspx?oid=' + id, max: false, min: false, width: '600px', height: '400px', lock: true, padding: 0 });
}

function tgmx() {
    $.dialog({ id: 'A11', title: '提供众筹', content: 'url:/member/order/tg_add.aspx', max: false, min: false, width: '300px', height: '360px', lock: true, padding: 0 });
}
function dthdmx() {
    $.dialog({ id: 'A21', title: 'G钱包获得众筹', content: 'url:/member/order/hd_add.aspx', max: false, min: false, width: '300px', height: '340px', lock: true, padding: 0 });
}


function hdmx() {
    $.dialog({ id: 'A22', title: 'P钱包获得众筹', content: 'url:/member/order/hd_jt_add.aspx', max: false, min: false, width: '300px', height: '340px', lock: true, padding: 0 });
}

function jdhdmx() {
    $.dialog({ id: 'A22', title: 'D钱包获得众筹', content: 'url:/member/order/hd_jd_add.aspx', max: false, min: false, width: '300px', height: '340px', lock: true, padding: 0 });
}

function showProductInfo(id) {
    $.dialog({ id: 'a3_2', title: '产品详情', content: 'url:/member/pdetail.aspx?id=' + id, max: false, min: false, width: '500px', height: '600px', lock: true, padding: 0 });
}
function divCollapse(id)
{
    $("#" + id).slideToggle();
}