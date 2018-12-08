package org.dan.dao;

import java.util.List;
import java.util.Map;

import org.dan.entity.Requirement;


public interface RequirementDao {

	public Map<String, Object> query(Map<String, String> params);
	
	public void addRequirement(Requirement requirement);
}
