package org.dan.service;

import java.util.List;
import java.util.Map;

import org.dan.dao.RequirementDao;
import org.dan.entity.Requirement;

public interface RequirementService {

	public Map<String, Object> query(Map<String, String> params);

	public void addRequirement(Requirement requirement);

}
