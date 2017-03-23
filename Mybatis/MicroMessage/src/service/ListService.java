package service;

import java.util.List;

import bean.Message;
import dao.MessageDao;

/*
 * 列表相关的业务功能
 */
public class ListService {
	public List<Message> queryMessageList(String command, String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
	}
}
