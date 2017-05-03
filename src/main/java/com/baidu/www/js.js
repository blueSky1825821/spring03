/**
 * Created by sky on 2017/4/25.
 */
if (!this.JSON) {
    this.JSON = {};
    (function () {
        function u(l) {
            return l < 10 ? "0" + l : l
        }

        function y(l) {
            m.lastIndex = 0;
            return m.test(l) ? '"' + l.replace(m, function (r) {
                var n = w[r];
                return typeof n === "string" ? n : "\\u" + ("0000" + r.charCodeAt(0).toString(16)).slice(-4)
            }) + '"' : '"' + l + '"'
        }

        function v(l, r) {
            var n, a, b, d, g = k, f, c = r[l];
            if (c && typeof c === "object" && typeof c.toJSON === "function") c = c.toJSON(l);
            if (typeof s === "function") c = s.call(r, l, c);
            switch (typeof c) {
                case "string":
                    return y(c);
                case "number":
                    return isFinite(c) ? String(c) : "null";
                case "boolean":
                case "null":
                    return String(c);
                case "object":
                    if (!c)return "null";
                    k += i;
                    f = [];
                    if (Object.prototype.toString.apply(c) === "[object Array]") {
                        d = c.length;
                        for (n = 0; n < d; n += 1)f[n] = v(n, c) || "null";
                        b = f.length === 0 ? "[]" : k ? "[\n" + k + f.join(",\n" + k) + "\n" + g + "]" : "[" + f.join(",") + "]";
                        k = g;
                        return b
                    }
                    if (s && typeof s === "object") {
                        d = s.length;
                        for (n = 0; n < d; n += 1) {
                            a = s[n];
                            if (typeof a === "string")if (b = v(a, c)) f.push(y(a) + (k ? ": " : ":") + b)
                        }
                    } else for (a in c)if (Object.hasOwnProperty.call(c, a))if (b = v(a, c)) f.push(y(a) + (k ? ": " : ":") + b);
                    b = f.length === 0 ? "{}" : k ? "{\n" + k + f.join(",\n" + k) + "\n" + g + "}" : "{" + f.join(",") + "}";
                    k = g;
                    return b
            }
        }

        if (typeof Date.prototype.toJSON !== "function") {
            Date.prototype.toJSON = function () {
                return isFinite(this.valueOf()) ? this.getUTCFullYear() + "-" + u(this.getUTCMonth() + 1) + "-" + u(this.getUTCDate()) + "T" + u(this.getUTCHours()) + ":" + u(this.getUTCMinutes()) + ":" + u(this.getUTCSeconds()) + "Z" : null
            };
            String.prototype.toJSON = Number.prototype.toJSON = Boolean.prototype.toJSON = function () {
                return this.valueOf()
            }
        }
        var e = /[\u0000\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g,
            m = /[\\\"\x00-\x1f\x7f-\x9f\u00ad\u0600-\u0604\u070f\u17b4\u17b5\u200c-\u200f\u2028-\u202f\u2060-\u206f\ufeff\ufff0-\uffff]/g, k, i, w = {
                "\u0008": "\\b",
                "\t": "\\t",
                "\n": "\\n",
                "\u000c": "\\f",
                "\r": "\\r",
                '"': '\\"',
                "\\": "\\\\"
            }, s;
        if (typeof JSON.stringify !== "function") JSON.stringify = function (l, r, n) {
            var a;
            i = k = "";
            if (typeof n === "number")for (a = 0; a < n; a += 1)i += " "; else if (typeof n === "string") i = n;
            if ((s = r) && typeof r !== "function" && (typeof r !== "object" || typeof r.length !== "number"))throw Error("JSON.stringify");
            return v("",
                {"": l})
        };
        if (typeof JSON.parse !== "function") JSON.parse = function (l, r) {
            function n(b, d) {
                var g, f, c = b[d];
                if (c && typeof c === "object")for (g in c)if (Object.hasOwnProperty.call(c, g)) {
                    f = n(c, g);
                    if (f !== undefined) c[g] = f; else delete c[g]
                }
                return r.call(b, d, c)
            }

            var a;
            l = String(l);
            e.lastIndex = 0;
            if (e.test(l)) l = l.replace(e, function (b) {
                return "\\u" + ("0000" + b.charCodeAt(0).toString(16)).slice(-4)
            });
            if (/^[\],:{}\s]*$/.test(l.replace(/\\(?:["\\\/bfnrt]|u[0-9a-fA-F]{4})/g, "@").replace(/"[^"\\\n\r]*"|true|false|null|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?/g,
                    "]").replace(/(?:^|:|,)(?:\s*\[)+/g, ""))) {
                a = eval("(" + l + ")");
                return typeof r === "function" ? n({"": a}, "") : a
            }
            throw new SyntaxError("JSON.parse");
        }
    })()
}
(function (u) {
    function y() {
        m("https form probe...");
        l.initListener(u, "*");
        e(function () {
            e('<iframe id="https-form-probe" name="https-form-probe" style="display:none;">').appendTo("body");
            e("<form>").attr({
                target: "https-form-probe",
                method: "POST",
                action: i.HttpsFormProbe
            }).appendTo("body").submit()
        })
    }

    var v = false, e = jQuery, m = e.noop, k = document.domain, i, w, s, l;
    if (/\.kaixin/.test(k)) k = k.replace(/^.*?\.kaixin/, "kaixin"); else if (/\.kx/.test(k)) k = k.replace(/^.*?\.kx/, "kx");
    k = k.replace(/\.cn$/, "");
    if (/009/.test(k) ||
        /002/.test(k)) v = true;
    i = {
        EnterAccount: "\u8bf7\u8f93\u5165\u7528\u6237\u8d26\u53f7",
        InvalidAccount: "\u8d26\u53f7\u683c\u5f0f\u9519\u8bef",
        EnterPassword: "\u8bf7\u8f93\u5165\u5bc6\u7801",
        EnterCaptcha: "\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801",
        AccountPlaceholder: "\u90ae\u7bb1/\u624b\u673a\u53f7/\u5176\u4ed6\u7528\u6237\u540d",
        PasswordPlaceholder: "\u8bf7\u8f93\u5165\u5bc6\u7801",
        CaptchaPlaceholder: "\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801",
        Chinese: /([\u4E00-\uFA29]|[\uE7C7-\uE7F3])/,
        ExtraInputs: ["code", "rcode",
            "url", "remember", "rpkey", "diarykey", "invisible_mode"],
        HttpsEnabled: false,
        LoginAPI: {
            Http: "/login/login_auth.php",
            Https: "https://security." + k + "/login/login_auth.php",
            SecLogin: "http://www." + k + "/login/seclogin.php"
        },
        HttpsFormProbe: "https://security." + k + "/login/login_probe.php",
        LoginDiagnose: "http://www." + k + "/login/login_diagnose.php",
        LoginTimeout: 15
    };
    if (v) m = function () {
        if (window.console && console.log) navigator.userAgent.indexOf("MSIE") >= 0 ? console.log(arguments) : console.log.apply(console, arguments)
    };
    var r =
        {
            encode: function (a, b, d) {
                b = b === undefined ? "&" : b;
                d = d === false ? function (f) {
                    return f
                } : encodeURIComponent;
                var g = [];
                e.each(a, function (f, c) {
                    c !== null && typeof c != "undefined" && g.push(d(f) + "=" + d(c))
                });
                g.sort();
                return g.join(b)
            }, decode: function (a) {
            var b = decodeURIComponent, d = {};
            a = a.split("&");
            var g = a.length, f, c;
            for (f = 0; f < g; f++)if ((c = a[f].split("=", 2)) && c[0]) d[b(c[0])] = b(c[1]);
            return d
        }
        };
    l = function (a) {
        var b = "postMessage" in a, d, g = "", f = [];
        return {
            type: "CrossDomainMessenger", send: function (c, h, j) {
                m("crossDomainMessenger.send");
                c = JSON.stringify(c);
                b ? h.postMessage(c, j) : updateHash(h, c)
            }, initListener: function () {
                m("crossDomainMessenger.initListener");
                var c, h, j, o, q = function (p) {
                    o = typeof p == "string" ? JSON.parse(p) : p;
                    e.each(f, function (t, x) {
                        x(o)
                    })
                };
                if (b) {
                    m("  using postMessage");
                    "addEventListener" in a ? a.addEventListener("message", function (p) {
                        q(p.data)
                    }, false) : a.attachEvent("onmessage", function (p) {
                        q(p.data)
                    })
                } else {
                    m("  using updateHash");
                    d && clearInterval(d);
                    d = null;
                    m("  start interval");
                    d = setInterval(function () {
                        h = document.location.hash;
                        re = /^.*?#/;
                        if (h !== g) {
                            g = h;
                            j = r.decode(h.replace(re, ""));
                            for (c in j)j[c] = decodeURIComponent(j[c]);
                            "message" in j && q(j.message)
                        }
                    }, 100)
                }
            }, receive: function (c) {
                f.push(c)
            }, stopListener: function () {
                m("crossDomainMessenger.stopListener");
                d && clearInterval(d)
            }, accept: function (c) {
                m("crossDomainMessenger.accept");
                c = JSON.parse(c);
                e.each(f, function (h, j) {
                    j(c)
                })
            }
        }
    }(window);
    w = function (a, b) {
        var d, g, f, c = this, h, j, o;
        b = b || {};
        b.selectorMap = b.selectorMap || {};
        e.each(["isCheckEmptyAccount", "isCheckChineseAccount", "isCheckEmptyPassword",
            "isCheckEmptyCaptcha"], function (p, t) {
            if (typeof b[t] === "undefined") b[t] = true
        });
        this._options = b;
        d = this._form = e(a);
        this._account = d.find("input[name=loginemail]");
        if (this._account.length == 0) this._account = d.find("input[name=email]");
        this._password = d.find("input[name=password]");
        this._submit = d.find("input[type=submit]");
        this._code = d.find("input[name=code]");
        this._clearEmailButton = d.find("#clearEmail");
        this._isCaptchaShowed = false;
        this._onError = b.onError || e.noop;
        this._onValidateFailed = b.onValidateFailed ||
            function (p) {
                c._prompt.display(0, '<div id="prompt0" class="box-login logintips"><p>' + p + "</p><i></i></div>")
            };
        this._onSuccess = b.onSuccess;
        this._onFatalError = b.onFatalError;
        this._onNeedCaptcha = b.onNeedCaptcha || e.noop;
        this._preLoginCallback = b.preLoginCallback || e.noop;
        this._loginTimeoutTimerIds = [];
        this._loginDiagnosis = {logintimeout: i.LoginTimeout, logincounter: 0, loginerrno: -1};
        this.para = f = this._params = {ver: 1};
        g = window.location.href;
        if (g.indexOf("?") >= 0) {
            g = window.location.href.replace(/^.*?\?/, "");
            e.extend(this._params,
                r.decode(g));
            e.isFunction(b.afterPreprocessURL) && b.afterPreprocessURL(f)
        }
        d.submit(e.proxy(this.login, this));
        h = this._account;
        o = this._clearEmailButton;
        h.bind("blur", function () {
            var p = h.val();
            if (p === "" || p === i.AccountPlaceholder) h.val(i.AccountPlaceholder).css({color: "#cccccc"});
            o.hide()
        }).bind("focus", function () {
            if (h.val() === i.AccountPlaceholder) {
                h.val("").css({color: "#000000"});
                o.hide()
            } else o.show()
        }).bind("keyup", function () {
            var p = h.val();
            p === i.AccountPlaceholder || p === "" ? o.hide() : o.show()
        });
        if (d.data("use-custom-placeholder")) {
            var q =
                e('<div class="custom-placeholder">');
            j = this._password;
            q.text(i.PasswordPlaceholder).bind("mousedown", function () {
                setTimeout(e.proxy(j.focus, j), 0)
            });
            j.parent().css("position", "relative").append(q);
            setInterval(function () {
                j.val() && q.hide()
            }, 200);
            j.bind("blur", function () {
                j.val() === "" && q.show()
            }).bind("focus", function () {
                q.hide()
            });
            e("#randdiv").bind("appendCaptchaInput", function (p, t) {
                var x = e('<div class="custom-placeholder">');
                x.text(i.CaptchaPlaceholder).bind("mousedown", function () {
                    setTimeout(e.proxy(t.focus,
                        t), 0)
                });
                t.parent().css("position", "relative").append(x).end().bind("blur", function () {
                    t.val() === "" && x.show()
                }).bind("focus", function () {
                    x.hide()
                }).end()
            })
        }
        o.parent().bind("mousedown", function (p) {
            var t = p.srcElement;
            if (typeof t === "undefined" && p.originalEvent) t = p.originalEvent.target;
            if (t === o[0]) {
                h.val("").focus();
                setTimeout(function () {
                    h.val("").css("color", "#000000").focus()
                }, 0)
            }
        });
        if (arguments.length > 0) {
            l.receive(e.proxy(this.onLoginRespond, this));
            y();
            d = h.val();
            if (d === "" || d === i.AccountPlaceholder) d =
                getCookie("_email") || "";
            if (d === "") h.val(i.AccountPlaceholder).css("color", "#cccccc").css("fontWeight", "normal"); else {
                h.val(d).css("color", "#000000");
                this._password.focus()
            }
            o.hide()
        }
    };
    e.extend(w.prototype, {
        login: function () {
            m("Login.login");
            var a = true, b = this;
            window.Kx && Kx.Utils && Kx.Utils.writeLog2 ? Kx.Utils.writeLog2("submit_form_seclogin_js") : m("Kx.Utils.writeLog2 is not defined");
            if (e.isFunction(this._preLoginCallback) && this._preLoginCallback !== e.noop) {
                a = this._preLoginCallback(this._form[0]);
                if (a ===
                    false)return false
            }
            if (!this.beforeLoginProcess())return false;
            this._loginTimeoutTimerIds.push(setTimeout(function () {
                var d = b._loginDiagnosis;
                d.account = b._account.val();
                d.loginmode = i.HttpsEnabled ? "https" : "http";
                d = e.param(d);
                e.getScript(i.LoginDiagnose + "?" + d, e.noop)
            }, i.LoginTimeout * 1E3));
            if (i.HttpsEnabled) {
                m("HTTPS login");
                this.doHttpsLogin();
                return true
            } else {
                m("HTTP login");
                this.doHttpLogin();
                return false
            }
        }, doHttpLogin: function () {
            this._form.attr({action: i.LoginAPI.Http, method: "POST"});
            this._params.response_type =
                "json";
            e.ajax({
                url: i.LoginAPI.Http,
                type: "POST",
                data: this._params,
                success: e.proxy(this.onLoginRespond, this),
                error: e.proxy(this.onFatalError, this)
            })
        }, doHttpsLogin: function () {
            m("Login.httpsLogin");
            var a = this._form.attr("id") + "_httpsIFrame";
            e("#" + a).length === 0 && e('<iframe id="' + a + '" name="' + a + '" style="display:none">').appendTo("body");
            this._form.attr({target: a, method: "POST", action: i.LoginAPI.Https});
            m("  " + this._form.serialize())
        }, beforeLoginProcess: function () {
            m("Login.beforeLoginProcess");
            var a = this.validateInputs(),
                b = this;
            if (a !== null) {
                this._onValidateFailed(a);
                return false
            }
            this._params.email = this._account.val();
            this._params.password = this._password.val();
            e.each(i.ExtraInputs, function (d, g) {
                var f = e(b._form[0][g]), c = f.attr("type");
                if (c && f.length > 0)if (c.toLowerCase() !== "checkbox") {
                    f = f.val();
                    if (typeof f !== "undefined") b._params[g] = f
                } else {
                    f = f.is(":checked");
                    b._params[g] = +f
                }
            });
            return true
        }, onLoginRespond: function (a) {
            m("Login.onLoginRespond:json=" + JSON.stringify(a));
            if (a && typeof a.loginprobe !== "undefined") {
                window.SSOMessenger =
                    l;
                i.HttpsEnabled = true;
                m("https form post ok!")
            } else {
                e.each(this._loginTimeoutTimerIds, function (b, d) {
                    clearTimeout(d)
                });
                this._loginTimeoutTimerIds = [];
                if (a.ok) {
                    if (this._onSuccess) this._onSuccess(a.loc); else window.location = a.loc;
                    this._submit.attr("disabled", false)
                } else {
                    this._loginDiagnosis.logincounter += 1;
                    this._loginDiagnosis.loginerrno = a.errno;
                    a.captcha ? this._onNeedCaptcha(a.errno) : this._onError(this._params, a.errno)
                }
            }
        }, onFatalError: function () {
            e.isFunction(this._onFatalError) && this._onFatalError()
        },
        validateInputs: function () {
            var a = this._account, b = this._password, d = this._code, g = a.val();
            if (this._options.isCheckEmptyAccount && (g === "" || g === i.AccountPlaceholder)) {
                a.focus();
                return i.EnterAccount
            }
            if (this._options.isCheckChineseAccount && i.Chinese.test(g)) {
                a.focus();
                return i.InvalidAccount
            }
            g = b.val();
            if (this._options.isCheckEmptyPassword && (g === "" || g === i.PasswordPlaceholder)) {
                b.focus();
                return i.EnterPassword
            }
            if (this._options.isCheckEmptyCaptcha && this._isCaptchaShowed && d.val() === "") {
                d.focus();
                return i.EnterCaptcha
            }
            return null
        },
        setPreLoginFn: function (a) {
            if (e.isFunction(a)) this._preLoginCallback = a
        }
    });
    i.PromptHTMLs = {
        "1": ["<p>\u60a8\u9700\u8981\u767b\u5f55\u540e\u624d\u80fd\u7ee7\u7eed\u6d4f\u89c8\u6216\u64cd\u4f5c\uff01</p>"],
        "2": ["<p>\u8d26\u53f7\u4e0d\u592a\u5bf9\u5427\uff01 \u91cd\u8bd5\u4e00\u6b21\uff1f&nbsp;&nbsp;", '<a href="http://www.{domain}.com/t/help_user.html#q9" target="_blank" class="sl2 helpIco ml9">', "\u5e2e\u52a9</a></p>"],
        "3": ["<p>\u8be5\u8d26\u53f7\u5c1a\u672a\u5b8c\u6210\u6ce8\u518c\uff0c\u8bf7\u8fdb\u884c\u90ae\u7bb1\u786e\u8ba4</p>"],
        "4": ["<p>\u8d26\u53f7\u548c\u5bc6\u7801\u4e0d\u5339\u914d", '<a href="http://www.{domain}/t/help_user.html#q9" target="_blank" class="sl2 helpIco ml9">', "\u5e2e\u52a9</a></p>"],
        "5": ["<p>\u8bf7\u8f93\u5165\u60a8\u7684\u5f00\u5fc3\u7f51\u8d26\u53f7\uff01</p>"],
        "6": ["<p>\u8bf7\u8f93\u5165\u5bc6\u7801\uff01</p>"],
        "7": ['<p><img src="http://img.{domain}.cn/i/fzcg_dh.gif" align="absmiddle" />&nbsp;Email\u5730\u5740\u4fee\u6539\u6210\u529f\uff01<br/>', "&nbsp;&nbsp;&nbsp;&nbsp;\u8bf7\u7528\u6b64Email\u5730\u5740\u91cd\u65b0\u767b\u5f55\u4f60\u7684\u5f00\u5fc3\u8d26\u6237</p>"],
        "8": ["<p>\u5bc6\u7801\u591a\u6b21\u8f93\u5165\u9519\u8bef\uff0c\u8bf7\u4e00\u5c0f\u65f6\u540e\u518d\u767b\u5f55&nbsp;", '<a href="http://www.{domain}/t/help_safe.html#q14" class="sl2 helpIco ml9" target="_blank">\u5e2e\u52a9</a></p>'],
        "9": ["<p>\u9690\u8eab\u767b\u5f55\u662f\u5185\u90e8\u529f\u80fd\uff0c\u6682\u65f6\u505c\u6b62\u4f7f\u7528\uff01</p>"],
        "10": ["<p>\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801\uff01</p>"],
        "11": ["<p>\u9a8c\u8bc1\u7801\u8f93\u5165\u9519\u8bef\uff0c\u8bf7\u91cd\u8bd5\uff01</p>"],
        "12": ["<p>\u4e3a\u4fdd\u8bc1\u4f60\u7684\u8d26\u6237\u5b89\u5168\uff0c\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801\uff01</p>"],
        "13": ["<p>\u4e3a\u4fdd\u8bc1\u4f60\u7684\u8d26\u6237\u5b89\u5168\uff0c\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801\u540e\u767b\u5f55\u3002&nbsp;", '<a href="http://www.{domain}/t/help_safe.html#q14" class="sl2 helpIco ml9" target="_blank">\u5e2e\u52a9</a></p>'],
        "131": ["<p>\u5f02\u5730\u767b\u9646\uff0c\u8bf7\u8f93\u5165\u9a8c\u8bc1\u7801\uff01</p>"],
        "14": ["<p>\u6b64\u8d26\u53f7\u5df2\u88ab\u7981\u7528\uff01</p>"],
        "15": ["<p>\u8d26\u53f7\u548c\u5bc6\u7801\u4e0d\u5339\u914d\u3002&nbsp;&nbsp;", '<a href="http://www.{domain}/t/help_user.html#q9" target="_blank" class="sl2 helpIco ml9">',
            "\u5e2e\u52a9</a></p>"],
        "16": ["<p>\u8d26\u53f7\u5b58\u5728\u5371\u9669\uff0c\u8bf7\u7acb\u5373\u4fee\u6539\u5bc6\u7801\uff01</p>"],
        "17": ["<p>\u8d26\u53f7\u548c\u5bc6\u7801\u4e0d\u5339\u914d\u3002&nbsp;&nbsp;", '<a href="http://www.{domain}/t/help_user.html#q9" target="_blank" class="sl2 helpIco ml9">', "\u5e2e\u52a9</a></p>"],
        "19": ["<p>\u767b\u5f55\u6743\u9650\u9519\u8bef\uff01</p>"],
        "116": ["<p>\u60a8\u9700\u8981\u767b\u5f55\u540e\u624d\u80fd\u7ee7\u7eed\u64cd\u4f5c\uff01</p>"],
        "117": ['<p>\u4f60\u7684\u8d26\u53f7\u8fd8\u6ca1\u6709\u5b8c\u6210\u6ce8\u518c\uff0c\u8bf7\u5148<a href="http://www.{domain}/reg/wizard.php" class="sl" target="_blank">',
            "\u70b9\u51fb\u8fd9\u91cc</A>\u5230\u5f00\u5fc3\u7f51\u5b8c\u6210\u6ce8\u518c\u3002&nbsp;&nbsp; </p>"],
        "118": ["<p>\u8bf7\u6362\u4e00\u4e2a\u8d26\u53f7\u767b\u5f55</p>"],
        "119": ["<p>\u8bf7\u6362\u4e00\u4e2a\u516c\u5171\u4e3b\u9875\u8d26\u53f7\u767b\u5f55</p>"],
        "201": ["<p>\u8bf7\u8f93\u5165\u7528\u6237\u5e10\u53f7!</p>"],
        "202": ["<p>\u8bf7\u8f93\u5165\u5e10\u53f7\u5bc6\u7801!</p>"],
        prepare: function (a, b) {
            var d = this[a];
            if (typeof d === "undefined")return "";
            return ['<div id="prompt' + a + '" class="box-login logintips">',
                d.join(""), "<i></i></div>"].join("").replace("{email}", b.email || "").replace("{domain}", k)
        }
    };
    s = function (a, b) {
        var d = e(a), g, f = this, c;
        g = d.find("form");
        b = b || {};
        if (!e.isFunction(b.afterPreprocessURL)) b.afterPreprocessURL = function (h) {
            var j = h.flag, o = h.email, q;
            e(function () {
                if (!e.isNaN(parseInt(j, 10))) {
                    q = i.PromptHTMLs.prepare(j, h);
                    f._prompt.display(j, q)
                }
                if (typeof o !== "undefined") {
                    f._account.val(o);
                    f._password.focus()
                }
                if (typeof h.captcha !== "undefined" || j == 10 || j == 11 || j == 12 || j == 13 || j == 131) {
                    f.showCaptcha();
                    f._code.focus()
                }
            })
        };
        w.call(this, g, b);
        this._onError = function (h, j) {
            m("LoginDialog:_onError");
            m(JSON.stringify(h));
            m("errno:" + j);
            var o = i.PromptHTMLs.prepare(j, h);
            e.isFunction(b.onError) ? b.onError(h, j, o) : this._prompt.display(j, o)
        };
        this._prompt = e(".kx_prompt");
        if (this._prompt.length === 0) {
            this._prompt = e("div[id*=prompt]");
            this._prompt.display = function (h, j) {
                e("div[id*=prompt]").hide();
                var o = this.filter("#prompt" + h), q;
                if (e.isFunction(b.onShowPrompt)) b.onShowPrompt(o, h, j); else {
                    o.show();
                    q = b.hidePromptTimeout;
                    if (typeof q === "undefined") q =
                        4E3;
                    q > 0 && setTimeout(function () {
                        o.hide()
                    }, q)
                }
            }
        } else this._prompt.display = function (h, j) {
            this.html(j);
            e.isFunction(b.onShowPrompt) ? b.onShowPrompt(this, h, j) : this.show()
        };
        c = this._options.selectorMap.captchaImage || "img.kx_captcha";
        this._captchaImg = d.find(c).css({cursor: "pointer"}).attr("data-keytype", "login");
        if (!e.isFunction(b.onNeedCaptcha)) this._onNeedCaptcha = function (h) {
            this.showCaptcha();
            f._prompt.display(h, i.PromptHTMLs.prepare(h, this._params));
            e.isFunction(b.onNeedCaptcha) && b.onNeedCaptcha()
        };
        this._code =
            g.find("input[name=code]");
        d = this._rcode = g.find("input[name=rcode]");
        if (!d || d.length === 0) this._rcode = e('<input type="hidden" name="rcode">').appendTo(g);
        this._rcode.val(this._captchaImg.data("rcode"));
        c = this._options.selectorMap.recaptcha;
        g = this._recaptcha = g.find(c);
        g.is("a") && g.css("text-decoration", "none").attr("href", "javascript:void(0);");
        this.bind()
    };
    s.prototype = new w;
    e.extend(s.prototype, {
        bind: function () {
            var a = e.proxy(this.refreshCaptcha, this);
            this._recaptcha.click(a);
            this._captchaImg.click(a)
        },
        refreshCaptcha: function () {
            m("LoginDialog.refreshCaptcha");
            this._rcode.val(this._captchaImg.toCaptcha().data("rcode"));
            return false
        }, showCaptcha: function () {
            e.isFunction(this._options.onShowCaptcha) && this._options.onShowCaptcha.call(this);
            this._form.find(this._options.selectorMap.captchaContainer || "div.kx_captcha").show();
            this._code.show().focus().select();
            this._isCaptchaShowed = true;
            this.refreshCaptcha();
            this._captchaImg.show();
            this._recaptcha.show()
        }
    });
    var n = {
        captchaContainer: "#randdiv", captchaImage: "#randimg",
        recaptcha: "#changeRcode"
    };
    u.KxLoginDialog = s;
    u.EnLogin = function (a, b, d, g, f, c) {
        c = c || {};
        a = {onError: d, onValidateFailed: g, onSuccess: f, selectorMap: n};
        a = e.extend(a, c);
        return new s(e(b).parent(), a)
    };
    u.EnFormLogin = function (a, b, d) {
        d = d || {};
        a = {
            selectorMap: n,
            isCheckEmptyAccount: false,
            isCheckChineseAccount: false,
            isCheckEmptyPassword: false,
            isCheckEmptyCaptcha: false
        };
        a = e.extend(a, d);
        b = new s(e(b).parent(), a);
        b._onError = b._onNeedCaptcha = function (g, f) {
            if (typeof f === "undefined") f = g;
            this._password.val("");
            location.href =
                i.LoginAPI.SecLogin + "?flag=" + f + "&" + this._form.serialize()
        };
        return b
    }
})(window);

$j(function () {
    K.App("common/AQqLogin").define(function () {
        return {
            main: function () {
            }
        }
    })
});

$j(function () {
    K.App("common/AOauthLogin").define(function (h) {
        var e = h("jQuery"), i = function (a, b) {
            window.top.location = b
        }, f = function (a, b) {
            window.top.location = b
        };
        return {
            events: {"click a#qqlogin": "qqNewLogin", "click a.oauthlogin": "oauthLogin"}, oauthLogin: function (a) {
                a.preventDefault();
                if (typeof window.oauth_login != "function") window.oauth_login = f;
                var b = e(a.currentTarget).attr("data-login-type"), c = e(a.currentTarget).attr("data-act");
                b = "http://" + K.Env.KX_HOST + "/login/oauth/oauth_login.php?ltype=" + b + "&";
                b +=
                    "act=" + encodeURIComponent(c) + "&";
                this._commonJump(b, a)
            }, qqLogin: function (a) {
                a.preventDefault();
                if (typeof window.qq_login != "function") window.qq_login = i;
                var b = "http://" + K.Env.KX_HOST + "/login/qq_login.php?";
                if (e(a.currentTarget).attr("data-autobind")) b += "autobind=1&";
                this._commonJump(b, a)
            }, qqNewLogin: function (a) {
                a.preventDefault();
                if (typeof window.oauth_login != "function") window.oauth_login = f;
                var b = "login", c = e(a.currentTarget).attr("data-autobind"), d = "http://" + K.Env.KX_HOST + "/login/oauth/oauth_login.php?ltype=tencent&";
                if (c) b = "loginbind";
                d += "act=" + encodeURIComponent(b) + "&";
                this._commonJump(d, a)
            }, _commonJump: function (a, b) {
                var c = e(b.currentTarget), d = c.attr("data-url"), g = c.attr("data-from");
                c = c.attr("target");
                if (d) a += "url=" + encodeURIComponent(d) + "&"; else this.isUrlJumpToHome(window.top.location.href) || (a += "url=" + encodeURIComponent(window.top.location.href) + "&");
                if (g) a += "from=" + encodeURIComponent(g) + "&";
                a += "r=" + Math.random();
                if (c == "_blank") window.open(a, "TencentLogin", "left=" + (window.screen.availWidth - 585) / 2 + ",top=" +
                    (window.screen.availHeight - 525) / 2 + ",width=585,height=525,menubar=0,scrollbars=1,resizable=1,status=1,titlebar=0,toolbar=0,location=1"); else window.top.location = a
            }, isUrlJumpToHome: function (a) {
                a = this.parseUrl(a);
                if (a.Host == K.Env.KX_HOST && a.Pathname == "/" || a.Host.substr(0, 6) == "login." || a.Host == K.Env.KX_HOST && a.Pathname.substr(0, 7) == "/login/")return true;
                return false
            }, parseUrl: function (a) {
                var b = {
                    Username: 4,
                    Password: 5,
                    Port: 7,
                    Protocol: 2,
                    Host: 6,
                    Pathname: 8,
                    URL: 0,
                    Querystring: 9,
                    Fragment: 10
                }, c = {}, d;
                for (d in b)c[d] =
                    "";
                a = /^((\w+):\/\/)?((\w+):?(\w+)?@)?([^\/\?:]+):?(\d+)?(\/?[^\?#]+)?\??([^#]+)?#?(\w*)/.exec(a);
                if (!a)return c;
                for (d in b)if (typeof a[b[d]] != "undefined") c[d] = a[b[d]];
                return c
            }, main: function () {
            }
        }
    })
});
