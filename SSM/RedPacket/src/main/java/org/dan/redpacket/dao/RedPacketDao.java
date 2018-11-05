package org.dan.redpacket.dao;

import org.dan.redpacket.pojo.RedPacket;
import org.springframework.stereotype.Repository;

@Repository
public interface RedPacketDao {

	/*
	 * ��ȡ�����Ϣ
	 */
	public RedPacket getRedPacket(Long id);

	/*
	 * �ۼ������
	 */
	public int decreaseRedPacket(Long id);

}
