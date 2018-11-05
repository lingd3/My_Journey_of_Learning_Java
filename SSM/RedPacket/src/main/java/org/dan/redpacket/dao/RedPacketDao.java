package org.dan.redpacket.dao;

import org.dan.redpacket.pojo.RedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPacketDao {

	/*
	 * 获取红包信息
	 */
	public RedPacket getRedPacket(Long id);

	/*
	 * 扣减红包数
	 */
	public int decreaseRedPacket(Long id);

}
