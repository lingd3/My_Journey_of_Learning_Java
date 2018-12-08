package org.dan.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dan.entity.Requirement;
import org.dan.service.RequirementServiceImpl;
import org.dan.util.EncodingUtil;
import org.dan.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
public class RequirementController {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	@Autowired
	private RequirementServiceImpl requirementService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String test() {
		return "test";
	}
	
	@RequestMapping(value = "/addRequirement", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addRequirement(@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "phone", required = true) String phone,
			@RequestParam(value = "remark", required = false) String remark,
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "district", required = false) String district,
			@RequestParam(value = "village", required = false) String village,
			@RequestParam(value = "lineNum", required = false) String lineNum,
			@RequestParam(value = "stationName", required = false) String stationName,
			@RequestParam(value = "price", required = false) String price,
			@RequestParam(value = "squareMeter", required = false) String squareMeter,
			@RequestParam(value = "houseKind", required = false) String houseKind,
			@RequestParam(value = "uasge", required = false) String uasge,
			@RequestParam(value = "ownerShip", required = false) String ownerShip,
			@RequestParam(value = "floor", required = false) String floor,
			@RequestParam(value = "direction", required = false) String direction,
			@RequestParam(value = "age", required = false) String age,
			@RequestParam(value = "elevator", required = false) String elevator,
			@RequestParam(value = "decoration", required = false) String decoration) {
		Map<String, Object> map = new HashMap<String, Object>();
		Requirement requirement = new Requirement();
		try {
			requirement.setUsername(username);
			requirement.setPhone(phone);
			if (remark != null)
				requirement.setRemark(remark);
			if (city != null)
				requirement.setCity(city);
			if (district != null)
				requirement.setDistrict(district);
			if (village != null)
				requirement.setVillage(village);
			if (lineNum != null)
				requirement.setLineNum(lineNum);
			if (stationName != null)
				requirement.setStationName(stationName);
			if (price != null)
				requirement.setPrice(price);
			if (squareMeter != null)
				requirement.setSquareMeter(squareMeter);
			if (houseKind != null)
				requirement.setHouseKind(houseKind);
			if (uasge != null)
				requirement.setUasge(uasge);
			if (ownerShip != null)
				requirement.setOwnerShip(ownerShip);
			if (floor != null)
				requirement.setFloor(floor);
			if (direction != null)
				requirement.setDirection(direction);
			if (age != null)
				requirement.setAge(age);
			if (elevator != null)
				requirement.setElevator(elevator);
			if (decoration != null)
				requirement.setDecoration(decoration);
			requirement.setDate(new Date());
			System.out.println(requirement.toString());
			requirementService.addRequirement(requirement);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
			map.put("data", null);
			return map;
		}
		map.put("status", 200);
		map.put("data", "填写成功，稍后会有工作人员联系您，谢谢！");
		return map;
	}

	@RequestMapping(value = "/getRequirement", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> getRequirement(@RequestParam(value = "startDate", required = false) String startDate,
			@RequestParam(value = "endDate", required = false) String endDate,
			@RequestParam(value = "description", required = false) String description,
			@RequestParam(value = "page", required = false) String page) {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			Map<String, String> params = new HashMap<String, String>();
			if (startDate != null)
				params.put("startDate", startDate);
			if (endDate != null)
				params.put("endDate", endDate);
			if (description != null)
				params.put("description", EncodingUtil.encodeStr(description));
			if (page != null)
				params.put("page", page);
			data = requirementService.query(params);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("status", 500);
			map.put("data", data);
			return map;
		}
		map.put("status", 200);
		map.put("data", data);
		return map;
	}

	@RequestMapping(value = "/export")
	@ResponseBody
	public void export(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取数据
		Map<String, Object> data = requirementService.query(null);
		List<Requirement> list = (List<Requirement>) data.get("requirements");
		//excel标题
		String[] title = {"id","姓名","手机号","城市","县区","房源","地铁线","地铁站","售价","面积","房型","用途","权属","楼层","朝向",
				"楼龄","有无电梯","装修","咨询时间","备注"};
		//excel文件名
		String fileName = "购房需求信息表"+System.currentTimeMillis()+".xls";
		//sheet名
		String sheetName = "购房需求信息表";
		
		String[][] content = new String[list.size()+1][title.length];
		for (int i = 0; i < list.size(); i++) {
			Requirement r = list.get(i);
			System.out.println(r.toString());
			content[i][0] = r.getId()+"";
			content[i][1] = r.getUsername();
			content[i][2] = r.getPhone();
			content[i][3] = r.getCity();
			content[i][4] = r.getDistrict();
			content[i][5] = r.getVillage();
			content[i][6] = r.getLineNum();
			content[i][7] = r.getStationName();
			content[i][8] = r.getPrice();
			content[i][9] = r.getSquareMeter();
			content[i][10] = r.getHouseKind();
			content[i][11] = r.getUasge();
			content[i][12] = r.getOwnerShip();
			content[i][13] = r.getFloor();
			content[i][14] = r.getDirection();
			content[i][15] = r.getAge();
			content[i][16] = r.getElevator();
			content[i][17] = r.getDecoration();
			content[i][18] = sdf.format(r.getDate());
			content[i][19] = r.getRemark();
 		}
		//创建HSSFWorkbook 
		HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);
		//响应到客户端
		try {
			this.setResponseHeader(response, fileName);
			OutputStream os = response.getOutputStream();
				wb.write(os);
				os.flush();
				os.close();
	 	} catch (Exception e) {
	 		e.printStackTrace();
	 	}
	}
	
	//发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
