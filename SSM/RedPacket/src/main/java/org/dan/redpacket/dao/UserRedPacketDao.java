package org.dan.redpacket.dao;

import org.dan.redpacket.pojo.UserRedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRedPacketDao {

	/*
	 * �����������Ϣ
	 */
	public int grapRedPacket(UserRedPacket userRedPacket);
}
