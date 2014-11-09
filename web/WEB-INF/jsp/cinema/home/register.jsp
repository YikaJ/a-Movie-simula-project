<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
    <title>爆米花合作申请</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/css/bootstrap-admin-theme.css">

    <!-- Custom styles -->
    <style type="text/css">
        .alert{
            margin: 0 auto 20px;
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bootstrap-admin-without-padding">
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <s:form method="post" action="register" namespace="/cinema/manage" cssClass="bootstrap-admin-login-form clearfix">
                <a href="login.jsp" class="btn btn-default btn-sm pull-right" style="margin-top: -10px">回到登录</a>
                <h3>商家后台注册<small class="text-danger"> (下列都为必填)</small></h3>
                <s:fielderror cssClass="list-unstyled text-danger"/>
                <div class="form-group">
                    <input class="form-control input-group col-lg-10" type="text" name="name"  placeholder="影院名称" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password" name="password"  placeholder="登录密码" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="email" name="email" placeholder="电子邮箱" required>
                </div>
                <div class="form-group">
                    影院所在省市:
                    <select style="width: 50px">

                    </select>
                    省
                    <select style="width: 50px">

                    </select>
                    市
                    <select style="width: 50px">

                    </select>
                    县/区
                </div>
                <div class="form-group">
                    <input class="form-control" type="text" name="address"  placeholder="影院地址" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="tel" name="telephone"  placeholder="联系方式" required>
                </div>
                <div class="form-group">
                <input class="form-control" type="text" name="workTime" placeholder="营业时间" required>
            </div>
                <button class="btn  btn-primary form-control " type="submit" style="line-height: 0px;">注册</button>

            </s:form>
        </div>
    </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/cinema/bootstrap.min.js"></script>
<script type="text/javascript">
    $(function() {
        // Setting focus
        $('input[name="email"]').focus();

        // Setting width of the alert box
        var alert = $('.alert');
        var formWidth = $('.bootstrap-admin-login-form').innerWidth();
        var alertPadding = parseInt($('.alert').css('padding'));

        if (isNaN(alertPadding)) {
            alertPadding = parseInt($(alert).css('padding-left'));
        }

        $('.alert').width(formWidth - 2 * alertPadding);
    });
</script>
</body>
</html>
