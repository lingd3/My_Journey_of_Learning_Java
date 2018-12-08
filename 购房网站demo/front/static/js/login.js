$(function(){
    $("#login").click(function (){
        var username = $("#username").val();
        var password = $("#password").val();
        if (username=="test" && password=="test") {
            sessionStorage.setItem("username", username);
            window.location.href = "../templates/index2.html";
        }
        else {
            alert("用户名或密码错误，请重试");
        }
        
    })

})