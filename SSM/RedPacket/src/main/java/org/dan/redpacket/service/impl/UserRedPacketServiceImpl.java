package org.dan.redpacket.service.impl;

import org.dan.redpacket.dao.RedPacketDao;
import org.dan.redpacket.dao.UserRedPacketDao;
import org.dan.redpacket.pojo.RedPacket;
import org.dan.redpacket.pojo.UserRedPacket;
import org.dan.redpacket.service.UserRedPacketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserRedPacketServiceImpl implements UserRedPacketService {

	@Autowired
	private UserRedPacketDao userRedPacketDao;

	@Autowired
	private RedPacketDao redPacketDao;

	// 失败
	private static final int FAILED = 0;

	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public int grapRedPacket(Long redPacketId, Long userId) {
		// 获取红包信息
		RedPacket redPacket = redPacketDao.getRedPacket(redPacketId);
		int leftRedPacket = redPacket.getStock();
		// 当前小红包库存大于0
		if (leftRedPacket > 0) {
			redPacketDao.decreaseRedPacket(redPacketId);
			// 生成抢红包信息
			UserRedPacket userRedPacket = new UserRedPacket();
			userRedPacket.setRedPacketId(redPacketId);
			userRedPacket.setUserId(userId);
			userRedPacket.setAmount(redPacket.getUnitAmount());
			userRedPacket.setNote("redpacket- " + redPacketId);
			// 插入抢红包信息
			int result = userRedPacketDao.grapRedPacket(userRedPacket);
			return result;
		}
		// 失败返回
		return FAILED;
	}

}
