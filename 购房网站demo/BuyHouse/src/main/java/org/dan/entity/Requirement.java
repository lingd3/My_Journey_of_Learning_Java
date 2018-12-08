package org.dan.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 需求类
 * 
 * @author gd
 *
 */
@Entity
@Table(name = "Requirement")
public class Requirement {

	private int id; // id
	private String username; // 姓名
	private String phone; // 手机号
	private String city; // 城市
	private String district; // 县区
	private String village; // 村镇
	private String lineNum; // 地铁几号线
	private String stationName; // 地铁站名
	private String price; // 售价
	private String squareMeter; // 面积
	private String houseKind; // 房型
	private String uasge; // 用途
	private String ownerShip; // 权属
	private String floor; // 楼层
	private String direction; // 朝向
	private String age; // 楼龄
	private String elevator; // 有无电梯
	private String decoration; // 装修
	private Date date; // 提交时间
	private String remark; // 备注

	public Requirement() {
		this.username = "";
		this.phone = "";
		this.city = "";
		this.district = "";
		this.village = "";
		this.lineNum = "";
		this.stationName = "";
		this.price = "";
		this.squareMeter = "";
		this.houseKind = "";
		this.uasge = "";
		this.ownerShip = "";
		this.floor = "";
		this.direction = "";
		this.age = "";
		this.elevator = "";
		this.decoration = "";
		this.date = new Date();
		this.remark = "";
	}

	public Requirement(String username, String phone, String city, String district, String village, String lineNum,
			String stationName, String price, String squareMeter, String houseKind, String uasge, String ownerShip,
			String floor, String direction, String age, String elevator, String decoration, Date date, String remark) {
		this.username = username;
		this.phone = phone;
		this.city = city;
		this.district = district;
		this.village = village;
		this.lineNum = lineNum;
		this.stationName = stationName;
		this.price = price;
		this.squareMeter = squareMeter;
		this.houseKind = houseKind;
		this.uasge = uasge;
		this.ownerShip = ownerShip;
		this.floor = floor;
		this.direction = direction;
		this.age = age;
		this.elevator = elevator;
		this.decoration = decoration;
		this.date = date;
		this.remark = remark;
	}

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "phone", length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "city", length = 20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "district", length = 20)
	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "village", length = 20)
	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	@Column(name = "lineNum", length = 20)
	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	@Column(name = "stationName", length = 20)
	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	@Column(name = "price", length = 20)
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Column(name = "squareMeter", length = 20)
	public String getSquareMeter() {
		return squareMeter;
	}

	public void setSquareMeter(String squareMeter) {
		this.squareMeter = squareMeter;
	}

	@Column(name = "houseKind", length = 20)
	public String getHouseKind() {
		return houseKind;
	}

	public void setHouseKind(String houseKind) {
		this.houseKind = houseKind;
	}

	@Column(name = "uasge", length = 20)
	public String getUasge() {
		return uasge;
	}

	public void setUasge(String uasge) {
		this.uasge = uasge;
	}

	@Column(name = "ownerShip", length = 20)
	public String getOwnerShip() {
		return ownerShip;
	}

	public void setOwnerShip(String ownerShip) {
		this.ownerShip = ownerShip;
	}

	@Column(name = "floor", length = 20)
	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Column(name = "direction", length = 20)
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Column(name = "age", length = 20)
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Column(name = "elevator", length = 20)
	public String getElevator() {
		return elevator;
	}

	public void setElevator(String elevator) {
		this.elevator = elevator;
	}

	@Column(name = "decoration", length = 20)
	public String getDecoration() {
		return decoration;
	}

	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}

	@Column(name = "date")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "remark", length = 256)
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Requirement [id=" + id + ", username=" + username + ", phone=" + phone + ", city=" + city
				+ ", district=" + district + ", village=" + village + ", lineNum=" + lineNum + ", stationName="
				+ stationName + ", price=" + price + ", squareMeter=" + squareMeter + ", houseKind=" + houseKind
				+ ", uasge=" + uasge + ", ownerShip=" + ownerShip + ", floor=" + floor + ", direction=" + direction
				+ ", age=" + age + ", elevator=" + elevator + ", decoration=" + decoration + ", date=" + date
				+ ", remark=" + remark + "]";
	}

}
