package org.dan.service;

import java.util.List;
import java.util.Map;

import org.dan.dao.RequirementDao;
import org.dan.dao.RequirementDaoImpl;
import org.dan.entity.Requirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequirementServiceImpl implements RequirementService {

	@Autowired
	private RequirementDaoImpl requirementDaoImpl;
	
	@Override
	public Map<String, Object> query(Map<String, String> params) {
		return requirementDaoImpl.query(params);
	}

	@Override
	public void addRequirement(Requirement requirement) {
		requirementDaoImpl.addRequirement(requirement);
	}

}
