package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import bean.Message;
import db.DBAccess;
/*
 * 和message表相关的数据库操作
 */
public class MessageDao {
	/*
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command, String description) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null) sqlSession.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		MessageDao messageDao = new MessageDao();
		messageDao.queryMessageList("", "");
	}
	
	/*
	 * 根据查询条件查询消息列表
	 */
//	public List<Message> queryMessageList(String command, String description) {
//		List<Message> messageList = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/micro_message?useUnicode=true&characterEncoding=UTF-8", "root", "");
//			StringBuilder sql = new StringBuilder("select id, command, description, content from message where 1=1");
//			List<String> paramList = new ArrayList<String>();
//			if (command != null && !"".equals(command.trim())) {
//				sql.append(" and command=?");
//				paramList.add(command);
//			}
//			if (description != null && !"".equals(description.trim())) {
//				sql.append(" and description like '%' ? '%'");
//				paramList.add(description);
//			}
//			PreparedStatement stmt = conn.prepareStatement(sql.toString());
//			for (int i = 0; i < paramList.size(); i++) {
//				stmt.setString(i+1, paramList.get(i));
//			}
//			ResultSet rs = stmt.executeQuery();
//			while (rs.next()) {
//				Message m = new Message();
//				m.setId(rs.getInt("id"));
//				m.setCommand(rs.getString("command"));
//				m.setDescription(rs.getString("description"));
//				m.setContent(rs.getString("content"));
//				messageList.add(m);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return messageList;	
//	}
}
