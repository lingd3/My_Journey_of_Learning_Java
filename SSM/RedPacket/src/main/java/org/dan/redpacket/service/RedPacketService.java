package org.dan.redpacket.service;

import org.dan.redpacket.pojo.RedPacket;

public interface RedPacketService {

	/*
	 * ��ȡ���
	 */
	public RedPacket getRedPacket(Long id);
	
	/*
	 * �ۼ����
	 */
	public int decreaseRedPacket(Long id);
	
}
