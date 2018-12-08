$(function(){
	var query = "1=1"
    var json;
    var currPage = 1;

    var login = $.isEmptyObject(sessionStorage.getItem('username'));
    if (!login) {
        getInfo()
    }
    else {
        alert("请先登录")
        window.location.href = "../templates/login.html";
    }

	$("#query").click(function (){
        query = "1=1"
        var startDate = $("#startDate").val();
        if (startDate != "") {
            query += "&startDate="+startDate;
        }

        var endDate = $("#endDate").val();
        if (endDate != "") {
            query += "&endDate="+endDate;
        }

        var description = $("#description").val();
        if (description != "") {
            query += "&description="+description;
        }
		getInfo2(currPage);
	});

    $("#export").click(function (){
        window.location.href = "http://localhost:8080/BuyHouse/export"
    })

	// 初始查询
	function getInfo() {
		$.ajax({
            type:"get",
            async:true,
            url:"http://localhost:8080/BuyHouse/getRequirement",
            dataType:"text",
            success:function(data) {
                callBackPagination(data);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                // alert(XMLHttpRequest.status+","+XMLHttpRequest.readyState+","+textStatus);
                alert("服务器开小差了，请稍后重试...");
            }
        });
	}

	//多条件查询
	function getInfo2(page) {
		$.ajax({
            type:"get",
            async:true,
            url:"http://localhost:8080/BuyHouse/getRequirement?"+query+"&page="+page,
            dataType:"text",
            success:function(data) {
                callBackPagination2(data);
            },
            error:function(XMLHttpRequest, textStatus, errorThrown){
                // alert(XMLHttpRequest.status+","+XMLHttpRequest.readyState+","+textStatus);
                alert("服务器开小差了，请稍后重试...");
            }
        });
	}

	function callBackPagination(data) {
        json = eval("("+data+")");
        var totalCount = json.data.total;
        var currPage = json.data.page;
        var limit = 20;
        createTable(currPage, limit, totalCount, json);

        $('#callBackPager').extendPagination({
            totalCount: totalCount,
            limit: limit,
            callback: function () {
                return false;
            }
        });
    }

    function callBackPagination2(data) {
        json = eval("("+data+")");
        var totalCount = json.data.total;
        var currPage = json.data.page;
        var limit = 20;

        createTable(currPage, limit, totalCount, json);
    }

    function createTable(currPage, limit, total, json) {
        var html = [], showNum = limit;
        if (total < limit) showNum = total;
        else if (total-(currPage*limit) < 0) showNum = total-((currPage-1)*limit);

        html.push(' <table class="table table-hover piece" style="margin-left: 0;">');
        html.push(' <caption class="num">总数据量：<span class="total">'+total+'</span> 条， 当前第 '+'<span id="currPage">'+currPage+'</span> 页' +'</caption>');
        html.push(' <thead><tr><th style="width:3%">id</th><th style="width:3%">姓名</th><th style="width:5%">手机号</th><th style="width:5%">县区</th><th style="width:5%">地铁站</th><th style="width:8%">售价</th><th style="width:8%">面积</th><th style="width:5%">房型</th><th style="width:5%">楼层</th><th style="width:5%">楼龄</th><th style="width:5%">有无电梯</th><th style="width:5%">装修</th></tr></thead><tbody>');

        for (var i = 0; i < showNum; i++) {
        	var requirement = json.data.requirements[i];
            html.push('<tr class="mytr"><td>' + requirement.id + '</td>');
            html.push('<td>' + requirement.username + '</td>');
            html.push('<td>' + requirement.phone + '</td>');
            html.push('<td>' + requirement.district + '</td>');
            html.push('<td>' + requirement.stationName + '</td>');
            html.push('<td>' + requirement.price + '</td>');
            html.push('<td>' + requirement.squareMeter + '</td>');
            html.push('<td>' + requirement.houseKind + '</td>');
            html.push('<td>' + requirement.floor + '</td>');
            html.push('<td>' + requirement.age + '</td>');
            html.push('<td>' + requirement.elevator + '</td>');
            html.push('<td>' + requirement.decoration + '</td>');
            html.push('</tr>');
        }
        html.push('</tbody></table>');
        var mainObj = $('#mainContent');
        mainObj.empty();
        mainObj.html(html.join(''));
        init()
    }

    function init() {
        var trs = document.getElementsByClassName("mytr");
        for (var i = 0; i < trs.length; i++) {
            trs[i].onclick = function() {
                id = $(this).find("td").eq(0).html()
                var requirement;
                for (var i = 0; i < json.data.requirements.length; i++) {
                    if (id == json.data.requirements[i].id) {
                        requirement = json.data.requirements[i];
                        break;
                    }
                }
                var obj = JSON.stringify(requirement)
                localStorage.setItem("requirement", obj);
                window.open("../templates/detail.html")
            }
        }
    }

    $.fn.extendPagination = function (options) {
        var defaults = {
            totalCount: '',
            showPage: '10',
            limit: '20',
            callback: function () {
                return false;
            }
        };
        $.extend(defaults, options || {});
        if (defaults.totalCount == '') {
            //alert('总数不能为空!');
            $(this).empty();
            return false;
        } else if (Number(defaults.totalCount) <= 0) {
            //alert('总数要大于0!');
            $(this).empty();
            return false;
        }
        if (defaults.showPage == '') {
            defaults.showPage = '10';
        } else if (Number(defaults.showPage) <= 0) defaults.showPage = '10';
        if (defaults.limit == '') {
            defaults.limit = '20';
        } else if (Number(defaults.limit) <= 0) defaults.limit = '30';
        
        var totalCount = Number(defaults.totalCount), showPage = Number(defaults.showPage),
            limit = Number(defaults.limit), totalPage = Math.ceil(totalCount / limit);

        if (totalPage > 0) {
            var html = [];
            html.push(' <ul class="pagination">');
            html.push(' <li class="previous"><a href="#">&laquo;</a></li>');
            html.push('<li class="disabled hidden"><a href="#">...</a></li>');
            if (totalPage <= showPage) {
                for (var i = 1; i <= totalPage; i++) {
                    if (i == 1) html.push(' <li class="active"><a href="#">' + i + '</a></li>');
                    else html.push(' <li><a href="#">' + i + '</a></li>');
                }
            } else {
                for (var j = 1; j <= showPage; j++) {
                    if (j == 1) html.push(' <li class="active"><a href="#">' + j + '</a></li>');
                    else html.push(' <li><a href="#">' + j + '</a></li>');
                }
            }
            html.push('<li class="disabled hidden"><a href="#">...</a></li>');
            html.push('<li class="next"><a href="#">&raquo;</a></li></ul>');
            $(this).html(html.join(''));
            if (totalPage > showPage) $(this).find('ul.pagination li.next').prev().removeClass('hidden');

            var pageObj = $(this).find('ul.pagination'), preObj = pageObj.find('li.previous'),
                currentObj = pageObj.find('li').not('.previous,.disabled,.next'),
                nextObj = pageObj.find('li.next');

            function loopPageElement(minPage, maxPage) {
                var tempObj = preObj.next();
                for (var i = minPage; i <= maxPage; i++) {
                    if (minPage == 1 && (preObj.next().attr('class').indexOf('hidden')) < 0)
                        preObj.next().addClass('hidden');
                    else if (minPage > 1 && (preObj.next().attr('class').indexOf('hidden')) > 0)
                        preObj.next().removeClass('hidden');
                    if (maxPage == totalPage && (nextObj.prev().attr('class').indexOf('hidden')) < 0)
                        nextObj.prev().addClass('hidden');
                    else if (maxPage < totalPage && (nextObj.prev().attr('class').indexOf('hidden')) > 0)
                        nextObj.prev().removeClass('hidden');
                    var obj = tempObj.next().find('a');
                    if (!isNaN(obj.html()))obj.html(i);
                    tempObj = tempObj.next();
                }
            }

            function callBack(curr) {
                $("#currPage").text(curr);
                getInfo2(curr);
            }

            currentObj.click(function (event) {
                event.preventDefault();
                currPage = Number($(this).find('a').html()), activeObj = pageObj.find('li[class="active"]'),
                    activePage = Number(activeObj.find('a').html());
                if (currPage == activePage) return false;
                if (totalPage > showPage && currPage > 1)  {
                    var maxPage = currPage, minPage = 1;
                    if (($(this).prev().attr('class'))
                        && ($(this).prev().attr('class').indexOf('disabled')) >= 0) {
                        minPage = currPage - 1;
                        maxPage = minPage + showPage - 1;
                        loopPageElement(minPage, maxPage);
                    } else if (($(this).next().attr('class'))
                        && ($(this).next().attr('class').indexOf('disabled')) >= 0) {
                        if (totalPage - currPage >= 1) maxPage = currPage + 1;
                        else  maxPage = totalPage;
                        if (maxPage - showPage > 0) minPage = (maxPage - showPage) + 1;
                        loopPageElement(minPage, maxPage)
                    }                  
                }
                activeObj.removeClass('active');
                $.each(currentObj, function (index, thiz) {
                    if ($(thiz).find('a').html() == currPage) {
                        $(thiz).addClass('active');
                        callBack(currPage);
                    }
                });
            });
            preObj.click(function (event) {
                event.preventDefault();
                var activeObj = pageObj.find('li[class="active"]'), activePage = Number(activeObj.find('a').html());
                if (activePage <= 1) return false;
                if (totalPage > showPage) {
                    var maxPage = activePage, minPage = 1;                  
                    if ((activeObj.prev().prev().attr('class'))
                        && (activeObj.prev().prev().attr('class').indexOf('disabled')) >= 0) {
                        minPage = activePage - 1;
                        if (minPage > 1) minPage = minPage - 1;
                        maxPage = minPage + showPage - 1;
                        loopPageElement(minPage, maxPage);
                    }
                }
                $.each(currentObj, function (index, thiz) {
                    if ($(thiz).find('a').html() == (activePage - 1)) {
                        activeObj.removeClass('active');
                        $(thiz).addClass('active');
                        callBack(activePage - 1);
                    }
                });
            });
            nextObj.click(function (event) {
                event.preventDefault();
                var activeObj = pageObj.find('li[class="active"]'), activePage = Number(activeObj.find('a').html());
                if (activePage >= totalPage) return false;
                if (totalPage > showPage) {
                    var maxPage = activePage, minPage = 1;                  
                    if ((activeObj.next().next().attr('class'))
                        && (activeObj.next().next().attr('class').indexOf('disabled')) >= 0) {
                        maxPage = activePage + 2;
                        if (maxPage > totalPage) maxPage = totalPage;
                        minPage = maxPage - showPage + 1;
                        loopPageElement(minPage, maxPage);
                    }
                }
                $.each(currentObj, function (index, thiz) {
                    if ($(thiz).find('a').html() == (activePage + 1)) {
                        activeObj.removeClass('active');
                        $(thiz).addClass('active');
                        callBack(activePage + 1);
                    }
                });
            });
        }
    };

});






