package org.dan.redpacket.dao;

import org.dan.redpacket.pojo.UserRedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedPacketDao {

	/*
	 * 插入抢红包信息
	 */
	public int grapRedPacket(UserRedPacket userRedPacket);
}
