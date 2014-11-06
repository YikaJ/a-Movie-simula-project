<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html class="bootstrap-admin-vertical-centered">
<head>
    <title>爆米花合作申请</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Bootstrap -->
    <link rel="stylesheet" media="screen" href="../css/bootstrap.min.css">
    <link rel="stylesheet" media="screen" href="../css/bootstrap-theme.min.css">

    <!-- Bootstrap Admin Theme -->
    <link rel="stylesheet" media="screen" href="../css/bootstrap-admin-theme.css">

    <!-- Custom styles -->
    <style type="text/css">
        .alert{
            margin: 0 auto 20px;
        }
    </style>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="../js/html5shiv.js"></script>
    <script type="text/javascript" src="../js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="bootstrap-admin-without-padding">
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <form method="post" action="BE-homepage.jsp" class="bootstrap-admin-login-form">
                <h3>商家后台注册<small class="text-danger"> (下列都为必填)</small></h3>
                <div class="form-group">
                    <input class="form-control input-group col-lg-10" type="text"  placeholder="影院名称" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="password"  placeholder="登录密码" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="email"  placeholder="电子邮箱" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text"  placeholder="影院地址" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="tel"  placeholder="联系方式" required>
                </div>
                <div class="form-group">
                    <input class="form-control" type="text"  placeholder="QQ" required>
                </div>
                <button class="btn btn-xs btn-primary" type="submit">注册</button>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript" src="../js/cinema/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/cinema/bootstrap.min.js"></script>
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
