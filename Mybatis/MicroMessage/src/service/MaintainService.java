package service;

import java.util.ArrayList;
import java.util.List;

import dao.MessageDao;

/**
 * 维护相关的业务功能
 */
public class MaintainService {

	/*
	 * 单挑删除
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	/*
	 * 批量删除
	 */
	public void deleteBatch(String[] ids) {
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<>();
		for (String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);		
	}
}
