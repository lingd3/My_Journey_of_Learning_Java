package org.dan.redpacket.service;

import org.dan.redpacket.pojo.RedPacket;

public interface RedPacketService {

	/*
	 * 获取红包
	 */
	public RedPacket getRedPacket(Long id);
	
	/*
	 * 扣减红包
	 */
	public int decreaseRedPacket(Long id);
	
}
