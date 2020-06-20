var login = {
    URL: {
        userLoginURL: function () {
            return "userlogin";
        }
    },

    //验证表单
    validateForm: function () {
        $("#loginForm").validate({

            //ajax提交表单
            submitHandler: function () {
                $.ajax({
                    url: login.URL.userLoginURL(),
                    type: "post",
                    data: $("#loginForm").serialize(),
                    success: function (result) {
                        if (result && result['status'] == 200) {
                            setTimeout(function () {
                                window.location.href = "/rpdtester";
                            }, 1000);

                        } else {

                            //Error.displayError(result);
                        }
                    },
                    error: function () {
                        console.log(result);
                        alert("用户名密码错误！");
                        //Error.displayError(result);
                    }
                });
            }
        });

    },

    //页面初始化
    init: function () {
        login.validateForm();

    }

};