package com.atguigu.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;
import javax.crypto.SecretKey;

/**
 * @author: vikko
 * @Date: 2021/7/8 18:21
 * @Description:
 */
public class NIOServer {

	public static void main(String[] args) throws Exception {

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		Selector selector = Selector.open();

		serverSocketChannel.socket().bind(new InetSocketAddress(6666));

		serverSocketChannel.configureBlocking(false);

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while(true){

			//无时间发生，返回
			if(selector.select(1000) == 0){
				System.out.println("服务器等待了一秒，无链接");
				continue;
			}

			Set<SelectionKey> selectionKeys = selector.selectedKeys();

			Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

			while (keyIterator.hasNext()){

				SelectionKey key = keyIterator.next();
				if(key.isAcceptable()){
					//该客户端生成一个
				}

			}

		}

	}

}
