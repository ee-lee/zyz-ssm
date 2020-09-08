/**
 * 根据cookie 判断用户有没有登录
 * @param objName
 */
function getCookie(objName) {
    var arrStr = document.cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");

        if (temp[0] == objName) {
            //  alert(unescape(temp[1]));
            document.getElementById("uname").innerHTML = '欢迎您,' + temp[1];//用户姓名传给右角

            document.getElementById("login").style.display = "inline";
            document.getElementById("outlogin").style.display = "none";
            return; // 找到有用户名就退出循环

        }

    }
    document.getElementById("login").style.display = "none";
    document.getElementById("outlogin").style.display = "inline";
}

function getCookieByScore() {
    var arrStr = document.cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");

        if (temp[0] == 'score') {
            //  alert(unescape(temp[1]));
            document.getElementById("score").style.display = "inline";
            document.getElementById("score").innerHTML = '积分: ' + temp[1];//积分
            return; // 找到就退出循环
        }
    }

}

function delCookie() {
    var $ = layui.jquery;
    $.ajax({
        url: '../../../zyz/outLogin', //调用接口
        method: 'post',
        data: "",
        dataType: 'JSON',
        success: function (data) {
           
            window.location = '../zyz.html';

            // if (data.result == '成功') {
            //     layer.msg('成功', function () {
            //         window.location = '../zyz.html';
            //     });
            //     // return false;
            // } else {
            //     layer.msg('请求失败,请稍后再试', function () {
            //     });
            //     // return false;
            // }
        }
    });

}
