/// <reference path="../jquery-1.11.2.min.js" />

(function (win) {
    win.global = {
        // host: 'http://www.iquizoo.com:7000/AZYWebServer',
        // http://api.web.iquizoo.com,
        // http://www.iquizoo.com:7000/AZYWebServer'
        //host: 'http://localhost/bank',
        host: 'http://localhost:8080/azy-manage-2',
        //host: 'http://test.eval.iquizoo.com/bank',
        staticUrl: 'http://static.cdn.iquizoo.com/eval/bank/',
        configUrl: '/interactive/config',
        reportUrl: '/interactive/report',

        configData: function () {
            return {
                userId: Request.QueryString('userId'),
                subId: Request.QueryString('subId'),
                excerciseId: Request.QueryString('qId'),
                examId: Request.QueryString('examId'),
                abId: Request.QueryString('abId'),
            }
        },
        toPracticeOver: function (gameKey, passed) {
            window.location.href = '../common/practiceReport.html?game=' + gameKey + '&type={0}&userId={1}&qId={2}&subId={3}&passed={4}&abId={5}&examId={6}&showReport={7}'.format(
                    Request.QueryString('type'),
                    Request.QueryString('userId'),
                    Request.QueryString('qId'),
                    Request.QueryString('subId'),
                    passed,
                    Request.QueryString('abId'),
                    Request.QueryString('examId'),
                    Request.QueryString('showReport')
                );
        },
        toReport: function (gameKey,str,message) {
            /* 如果不是微信中打开 */
            if(!this.is_weixn()){
                window.location.href = '../common/report.html?game=' + gameKey
                        /*window.location.href = '../common/weixin/report.html?game=' + gameKey*/
                    + '&userId=' + Request.QueryString('userId')
                    + '&qId=' + Request.QueryString('qId')
                    + '&subId=' + Request.QueryString('subId')
                    + '&showReport=' + Request.QueryString('showReport')
                    + '&r=' + str
                    + '&AAAsetParam&AAA' + message;
            }else{
                window.location.href = '../common/weixin/report.html?game=' + gameKey
                    + '&userId=' + Request.QueryString('userId')
                    + '&qId=' + Request.QueryString('qId')
                    + '&subId=' + Request.QueryString('subId')
                    + '&showReport=' + Request.QueryString('showReport')
                    + '&r=' + str
                    + '&AAAsetParam&AAA' + message;
            }
        },

        getHost: function () {
            if (typeof androidHelper != 'undefined') {
                return androidHelper.getApiHostUrl();
            }
            return this.host;
        },

        post: function (method, data, callback, errorCallback) {
            this.call('POST', method, data, callback, errorCallback);
        },

        get: function (method, data, callback, errorCallback) {
            this.call('GET', method, data, function (res) {
                if (res.code && res.code + '' == '502' && !top.alerted) {
                    // 请求已过期
                    alert('登录已过期，请重新登录！');
                    window.location.href = window.preUrl + 'signin.html';
                    top.alerted = true;
                }

                callback && callback(res);
            }, errorCallback);
        },

        getUrl: function (method) {
            return this.getHost() + method;
        },

        call: function (type, method, data, callback, errorCallback) {
            if (type == 'POST' && !isOnline) {
                /*
                 * 利用 postMessage 进行跨域操作。
                 */
                $('#postIframe')[0].contentWindow.postMessage(JSON.stringify({
                    type: type,
                    method: method,
                    data: data
                }), '*');

                /*
                 * 成功后回调返回的值
                 */
                global.postSuccessCallback = callback;
                window.addEventListener('message', function (ev) {
                    global.postSuccessCallback && global.postSuccessCallback(JSON.parse(ev.data));
                }, false);

                return;
            }

            $.ajax({
                type: type.toUpperCase(),
                url: this.getHost() + method,
                data: data,
                dataType: type == 'POST' ? 'json' : 'jsonp',
                success: callback,
                error: function (r) {
                }
            });
        },

        getQueryString: function (name) {
            var reg = new RegExp("(^|&|\\?)" + name + "=([^&]*)(&|$)");
            var r = window.location.search.substr(1).match(reg);
            if (r != null) return unescape(r[2]);
            return null;
        },

        getHashQeryString: function (name, arr, defaultValue) {
            var reg = new RegExp("(^|&|\\?)" + name + "=([^&]*)(&|$)");
            var r = window.location.hash.substr(1).match(reg);
            if (r != null) {
                r = unescape(r[2]);
            }

            if (typeof defaultValue != 'undefined' && arr) {
                if (arr.indexOf(r) < 0) {
                    r = defaultValue;
                }
            }

            return r;
        },

        displayDate: function (timestamp) {
            return new Date(timestamp).Format('MM月dd日 hh:mm')
        },

        cookie: {
            set: function (name, value, expired) {
                var Days = 30;
                var exp = new Date();
                exp.setTime(exp.getTime() + Days * 24 * 60 * 60 * 1000);
                document.cookie = name + "=" + value + ";path=/;expires=" + exp.toGMTString();
            },

            get: function (name) {
                var arr = document.cookie.match(new RegExp("(^| )" + name + "=([^;]*)(;|$)"));
                if (arr != null) {
                    return (arr[2]);
                } else {
                    return "";
                }
            },

            remove: function (name) {
                var exp = new Date();
                exp.setTime(exp.getTime() - 1);

                if (name != null) document.cookie = name + "=" + name + ";path=/;expires=" + exp.toGMTString();

            }
        },

        signin: function (token, userId, userName, nickName) {
            global.cookie.set('token', token);
            global.cookie.set('userId', userId);
            global.cookie.set('userName', encodeURI(userName));
            global.cookie.set('nickName', encodeURI(nickName));
        },

        msg: {
            '11001': '您输入的账号不存在！',
            '11002': '您的账号或密码输入错误！',
            '11004': '您输入的用户名已经被注册！',
            '11005': '手机验证码输入错误！',
            '11016': '您输入的昵称已经被使用！',
            '11008': '您输入的手机验证码已过期！',
            '11014': '您已经加入了其他家庭组！',
            '11015': '管理员无法退出账号'
        },

        getMsg: function (code, msg) {
            return this.msg[code] ? this.msg[code] : msg;
        },

        clearObject: function (obj) {
            if (obj) {
                for (var i in obj) {
                    if (obj[i]) {
                        if (typeof obj[i] == 'object') {
                            global.clearObject(obj[i]);
                        } else {
                            obj[i] = null;
                        }
                    }
                }
            }
        },

        clone: function (obj) {
            var objClone = {};

            for (var key in obj) {
                if (objClone[key] != obj[key]) {
                    if (typeof (obj[key]) == 'object') {
                        objClone[key] = global.clone(obj[key]);
                    } else {
                        objClone[key] = obj[key];
                    }
                }
            }
            objClone.toString = obj.toString;
            objClone.valueOf = obj.valueOf;

            return objClone;
        },

        showLoading: function () {
            // $('body').append('<div class="loading"><svg class="svg" width=150 height=150><circle cx=75 cy=75 r=30 /></svg></div>');
        },

        hideLoading: function () {
            // $('body > .loading').remove();
        },

        setPieProgress: function () {
            var el = document.getElementById('graph'); // get canvas

            var options = {
                percent: el.getAttribute('data-percent') || 0,
                size: el.getAttribute('data-size') || 190,
                lineWidth: el.getAttribute('data-line') || 20,
                rotate: el.getAttribute('data-rotate') || 0
            };

            var canvas = document.createElement('canvas');
            var span = $('<span><em class="text">正确率</em><em class="red">' + options.percent + '%' + '</em></span>')[0];

            if (typeof (G_vmlCanvasManager) !== 'undefined') {
                G_vmlCanvasManager.initElement(canvas);
            }

            var ctx = canvas.getContext('2d');
            canvas.width = canvas.height = options.size;

            el.innerHTML = '';
            el.appendChild(span);
            el.appendChild(canvas);

            ctx.translate(options.size / 2, options.size / 2); // change center
            ctx.rotate((-1 / 2 + options.rotate / 180) * Math.PI); // rotate -90 deg

            //imd = ctx.getImageData(0, 0, 240, 240);
            var radius = (options.size - options.lineWidth) / 2;

            var drawCircle = function (color, lineWidth, percent) {
                percent = Math.min(Math.max(0, percent || 1), 1);
                ctx.beginPath();
                ctx.arc(0, 0, radius, 0, Math.PI * 2 * percent, false);
                ctx.strokeStyle = color;
                ctx.lineCap = 'square'; // butt, round or square
                ctx.lineWidth = lineWidth;
                ctx.stroke();
            };

            drawCircle('#ffffff', options.lineWidth, 100 / 100);
            drawCircle('#ff5fa7', options.lineWidth, options.percent / 100);
        },

        /* 倒计时 */
        countdown: function (interval, count, callback) {
            this.countdown2(interval, '', count, callback);
        },

        countdown2: function (interval, title, count, callback) {

            /* 一旦倒计时结束，移除模板，同时执行callback */
            if (count <= 0) {
                $('#countdown').remove();
                callback && callback();
                return;
            }

            if ($('#countdown').length <= 0) {
                var html = '<div id="countdown" style="position: absolute; left: 0; right: 0; top: 0; bottom: 0;">' +
                    '<div style="width: 100%; height: 100%; background: #000000; position: absolute; top: 0px; left: 0px; z-index: 1; opacity: .5; transition: opacity .3s;"></div>' +
                    '<div style="margin-top: -150px; position: relative; z-index: 1200; line-height: 30px; text-align: center; height: 30px; color: #FFFFFF; font-size: 20px;"></div>' +
                    '<div style="width: 150px; height: 150px; position: absolute; background: url(\'../common/content/images/yuan.azypng\') center center no-repeat; top: 50%; left: 50%; z-index: 1000; margin-left: -75px; margin-top: -75px; font-size: 75px; color: #FFFFFF; font-weight: 200; line-height: 150px; text-align: center;" id="countdownText"></div>' +
                    '<div id="countdownTitle" class="showText" style="position: absolute;top: 50%;left: 50%;width: 300px;z-index: 1200;margin-left: -150px; text-align: center;color: #FFFFFF;font-size: 20px;margin-top: 95px;"></div>' +
                    '</div>';
                $('body').append(html);
            }

            $('#countdownText').text(count);
            $('#countdownTitle').html(title);
            setTimeout(function () {
                global.countdown2(interval, title, --count, callback);
            }, interval);
        },

        /* loading */
        getReportLoading: function (show, callback) {

            if (!show) {
                setTimeout(function () {
                    $('#showReportLoad').remove();
                    callback && callback();

                }, 2000);
            }

            if ($('#showReportLoad').length <= 0) {
                var html = '<div id="showReportLoad" style="position: absolute; left: 0; right: 0; top: 0; bottom: 0;">' +
                    '<div style="width: 100%; height: 100%; background: #000000; position: absolute; top: 0px; left: 0px; z-index: 1; opacity: .5; transition: opacity .3s;"></div>' +
                    '<div class="showReportLoadDiv">' +
                    '<div class="spinner">' +
                        /* '<div class="bounce1"></div>' +
                         '<div class="bounce2"></div>' +
                         '<div class="bounce3"></div>' +*/
                    ' <img src="../common/content/images/jh.gif" alt=""/>' +
                    '</div>' +
                    '<div id="showReportLoadText"></div>' +
                    '</div>' +
                    '</div>';
                $('body').append(html);
            }

            $('#showReportLoadText').text('正在提交数据');
        },
        //获取设备测试
        getPC: function () {
            var userAgentInfo = navigator.userAgent;
            var Agents = ["Android", "iPhone",
                "SymbianOS", "Windows Phone",
                "iPad", "iPod"];
            var flag = "pc";
            for (var v = 0; v < Agents.length; v++) {
                if (userAgentInfo.indexOf(Agents[v]) > 0) {
                    flag = Agents[v];
                    break;
                }
            }
            return flag;
        },

        loading: function (images, callback) {
            (function (images, callback) {
                var total = images.length;
                var completed = 0;

                if (total <= 0) {
                    callback && callback(total, completed);
                }

                for (var i = 0; i < images.length; i++) {
                    var url = images[i];
                    var img = new Image();
                    img.onload = function () {
                        callback && callback(total, ++completed);
                    };
                    img.onerror = function () {
                        callback && callback(total, ++completed);
                    };
                    img.src = global.staticUrl + url;
                }
            })(images, callback);
        },
        // 是否在微信中代开的页面
        is_weixn: function(){
            var ua = navigator.userAgent.toLowerCase();
            if(ua.match(/MicroMessenger/i)== "micromessenger") {
              return true;
            } else {
               return false;
            }

        }
    };

    win.onSwipeLeft = function (event) {
        console.log('on swipe left');
    };

    win.onSwipeRight = function (event) {
        console.log('on swipe right');
    }
})(window);

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份 
        "d+": this.getDate(), //日 
        "h+": this.getHours(), //小时 
        "m+": this.getMinutes(), //分 
        "s+": this.getSeconds(), //秒 
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
        "S": this.getMilliseconds() //毫秒 
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

String.prototype.format = function (args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if (args[key] != undefined) {
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        } else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    //var reg = new RegExp("({[" + i + "]})", "g");//这个在索引大于9时会有问题，谢谢何以笙箫的指出
                    var reg = new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
};

$(function () {
    //----------------------跨域专用------------------------------------------
    if (window.location.href.indexOf('iquizoo.com') >= 0) {
        document.domain = 'iquizoo.com';
    }

    $('div[href]').on('click', function () {
        window.location.href = $(this).attr('href');
    });

    if (!isOnline && $('#postIframe').length <= 0) {
        $('body').append('<div style="width: 1px; height: 1px; overflow: hidden; position: absolute; left: 0; top: 0;"><iframe id="postIframe" src="{0}/post.html"></iframe></div>'.format(global.getHost()));
    }
});

if (window.location.href.indexOf('iquizoo.com') >= 0) {
    document.domain = 'iquizoo.com';
}