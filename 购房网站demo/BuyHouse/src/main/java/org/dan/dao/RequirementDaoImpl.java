package org.dan.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.dan.entity.Requirement;
import org.dan.util.DBSessionUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class RequirementDaoImpl implements RequirementDao {

	public Map<String, Object> query(Map<String, String> params) {
		Map<String, Object> data = new HashMap<>();
		List<Requirement> requirements = new ArrayList<>();
		Session session = DBSessionUtil.getSession();
		
		int page = 1;
		StringBuilder sb = new StringBuilder("select r from Requirement r where 1=1");
		StringBuilder sb1 = new StringBuilder("select count(*) from Requirement r where 1=1");
		StringBuilder queryString = new StringBuilder();
		if (params != null && params.size() != 0) {
			for (Entry<String, String> entry : params.entrySet()) {
				if ("startDate".equals(entry.getKey())) {
					queryString.append(" and r.date>=\'" + entry.getValue() + "\'");
				}
				if ("endDate".equals(entry.getKey())) {
					queryString.append(" and r.date<=\'" + entry.getValue() + "\'");
				}
				if ("description".equals(entry.getKey())) {
					queryString.append(" and (" + 
							"r.username like \'%" + entry.getValue() + "%\'" + " or " +
							"r.city like \'%" + entry.getValue() + "%\'" + " or " +
							"r.district like \'%" + entry.getValue() + "%\'" + " or " +
							"r.village like \'%" + entry.getValue() + "%\'" + " or " +
							"r.lineNum like \'%" + entry.getValue() + "%\'" + " or " +
							"r.stationName like \'%" + entry.getValue() + "%\'" + " or " +
							"r.houseKind like \'%" + entry.getValue() + "%\'" + " or " +
							"r.uasge like \'%" + entry.getValue() + "%\'" + " or " +
							"r.decoration like \'%" + entry.getValue() + "%\'" + " or " +
							"r.floor like \'%" + entry.getValue() + "%\'" + " or " +
							"r.decoration like \'%" + entry.getValue() + "%\'" + " or " +
							"r.remark like \'%" + entry.getValue() + "%\'" 
								+ ")");
				}
				if ("page".equals(entry.getKey())) {
					page = Integer.valueOf(entry.getValue());
					continue;
				}
			}
		}
		Query query = session.createQuery(sb.append(queryString).toString());
		query.setFirstResult((page-1)*20);
		query.setMaxResults(20);
		requirements = query.list();
		
		Query query1 = session.createQuery(sb1.append(queryString).toString());
		long total = (long) query1.uniqueResult();
		System.out.println("total: " + total);
		DBSessionUtil.closeSession(session);
		
		data.put("requirements", requirements);
		data.put("total", total);
		data.put("page", page);
		return data;
	}

	public void addRequirement(Requirement requirement) {
		Session session = DBSessionUtil.getSession();
		session.save(requirement);
		DBSessionUtil.closeSession(session);
	}

	
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("username", "gordan");
		params.put("description", "Guangzhou");
		new RequirementDaoImpl().query(params);
		
//		Requirement requirement = new Requirement();
//		requirement.setCity("Jieyang");
//		requirement.setAge("5");
//		requirement.setUsername("gordan");
//		requirement.setDate(new Date());
//		new RequirementDaoImpl().addRequirement(requirement);
	}
}
