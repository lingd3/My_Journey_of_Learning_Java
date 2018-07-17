package org.dan.fanout;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 采用交换机广播的方式进行消息的发送
 * @author gd
 *
 */
public class EmitLog {
	private static final String EXCHANGE_NAME = "logs";

	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();

		//交换机
		channel.exchangeDeclare(EXCHANGE_NAME, "fanout");// fanout表示分发，所有的消费者得到同样的队列信息
		// 分发信息
		for (int i = 0; i < 5; i++) {
			String message = "Hello World" + i;
			channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
			System.out.println("EmitLog Sent '" + message + "'");
		}
		channel.close();
		connection.close();
	}
}
