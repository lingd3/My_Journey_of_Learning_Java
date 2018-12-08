$(function(){

    var username;
    var phone;
    var city;
    var district;
    var village;
    var lineNum;
    var stationName;
    var price;
    var squareMeter;
    var houseKind;
    var uasge;
    var ownerShip;
    var floor;
    var direction;
    var age;
    var elevator;
    var decoration;
    var remark;


    $("#submit").click(function (){
        //填充数据

        //username
        username = $("#username").val();
        if (username == "") {
            alert("姓名不能为空");
            return;
        }

        //phone
        phone = $("#phone").val();
        var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;
        if (phone == "" || !myreg.test(phone)) {
            alert("请输入正确的手机号码");
            return;
        }

        city = $("#city").val();
        district = $("#district").val();
        village = $("#village").val();
        lineNum = $("#lineNum").val();
        stationName = $("#stationName").val();
        remark = $("#remark").val();

        price="";
        var obj = $('input:checkbox[name="price"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                price += obj[i].value+',';
            }  
            price += obj[obj.length-1].value;
        }

        squareMeter="";
        var obj = $('input:checkbox[name="squareMeter"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                squareMeter += obj[i].value+',';
            }  
            squareMeter += obj[obj.length-1].value;
        }

        houseKind="";
        var obj = $('input:checkbox[name="houseKind"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                houseKind += obj[i].value+',';
            }  
            houseKind += obj[obj.length-1].value;
        }

        uasge="";
        var obj = $('input:checkbox[name="uasge"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                uasge += obj[i].value+',';
            }  
            uasge += obj[obj.length-1].value;
        }

        ownerShip="";
        var obj = $('input:checkbox[name="ownerShip"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                ownerShip += obj[i].value+',';
            }  
            ownerShip += obj[obj.length-1].value;
        }

        floor="";
        var obj = $('input:checkbox[name="floor"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                floor += obj[i].value+',';
            }  
            floor += obj[obj.length-1].value;
        }

        direction="";
        var obj = $('input:checkbox[name="direction"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                direction += obj[i].value+',';
            }  
            direction += obj[obj.length-1].value;
        }

        age="";
        var obj = $('input:checkbox[name="age"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                age += obj[i].value+',';
            }  
            age += obj[obj.length-1].value;
        }

        elevator="";
        var obj = $('input:checkbox[name="elevator"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                elevator += obj[i].value+',';
            }  
            elevator += obj[obj.length-1].value;
        }

        decoration="";
        var obj = $('input:checkbox[name="decoration"]:checked'); 
        if (obj.length != 0) {
            for (var i = 0; i < obj.length-1; i++) {
                decoration += obj[i].value+',';
            }  
            decoration += obj[obj.length-1].value;
        }


        $.ajax({
            type:"POST",
            url:"http://localhost:8080/BuyHouse/addRequirement",
            data: {
                "username" : username,
                "phone" : phone,
                "city" : city,
                "district" : district,
                "village" : village,
                "lineNum" : lineNum,
                "stationName" : stationName,
                "price" : price,
                "squareMeter" : squareMeter,
                "houseKind" : houseKind,
                "uasge" : uasge,
                "ownerShip" : ownerShip,
                "floor" : floor,
                "direction" : direction,
                "age" : age,
                "elevator" : elevator,
                "decoration" : decoration,
                "remark" : remark
            },
            success:function(data) {
                window.location.href = "../templates/success.html";
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                alert("服务器开小差了，请稍后重试...");
            }
        });
    });

    $("#reset").click(function (){

        $('input:checkbox').each(function () {
            $("input").prop({checked:false});
        });
        $("#username").val("");
        $("#phone").val("");
        $("#city").val("");
        $("#district").val("");
        $("#village").val("");
        $("#lineNum").val("");
        $("#stationName").val("");
        $("#remark").val("");
    });


});