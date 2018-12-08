$(function(){
	var obj = window.localStorage.getItem("requirement");
	var json = eval("("+obj+")");

	var unixTimestamp = new Date(json.date);
	commonTime = unixTimestamp.toLocaleDateString();

	document.getElementById("detail_id").innerHTML += json.id
	document.getElementById("detail_username").innerHTML += json.username
	document.getElementById("detail_phone").innerHTML += json.phone
	document.getElementById("detail_city").innerHTML += json.city
	document.getElementById("detail_district").innerHTML += json.district
	document.getElementById("detail_village").innerHTML += json.village
	document.getElementById("detail_lineNum").innerHTML += json.lineNum
	document.getElementById("detail_stationName").innerHTML += json.stationName
	document.getElementById("detail_price").innerHTML += json.price
	document.getElementById("detail_squareMeter").innerHTML += json.squareMeter
	document.getElementById("detail_houseKind").innerHTML += json.houseKind
	document.getElementById("detail_uasge").innerHTML += json.uasge
	document.getElementById("detail_ownerShip").innerHTML += json.ownerShip
	document.getElementById("detail_floor").innerHTML += json.floor
	document.getElementById("detail_direction").innerHTML += json.direction
	document.getElementById("detail_age").innerHTML += json.age
	document.getElementById("detail_elevator").innerHTML += json.elevator
	document.getElementById("detail_decoration").innerHTML += json.decoration
	document.getElementById("detail_date").innerHTML += commonTime
	document.getElementById("detail_remark").innerHTML += json.remark


});