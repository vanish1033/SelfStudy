package com.bjpowernode.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * java实现 nio 的服务端
 *
 * @author:whr 2019/11/9
 */
public class NioServer {


    public void start() throws IOException {

        synchronized (Object.class) {

        }

        /**
         * 1. 创建一个selector监听器
         */
        Selector selector = Selector.open();

        /**
         * 2. 通过一个 ServerSocketChannel 创建 Channel 通道
         */
        ServerSocketChannel channel = ServerSocketChannel.open();

        /**
         * 3. 为Channel通道绑定监听端口
         */
        channel.bind(new InetSocketAddress(8000));

        /**
         * 4. 为channel设置为非阻塞模式
         */
        channel.configureBlocking(false);

        /**
         * 5. 将channel注册到Selector上监听连接事件
         */
        channel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("server端启动成功");


        /**
         * 6. 循环等待接入新的连接
         */
        for (; ; ) {
            // 获取可用的channel连接
            int select = selector.select();

            if (select == 0) continue;

            /**
             * 获取可用的channel集合
             */
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            if (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();

                // 取完 SelectionKey 就移除该 SelectionKey
                iterator.remove();

                /**
                 * 7. 根据 SelectionKey 的状态调用不同的方法处理
                 */
                // 如果是接入事件


                // 如果是可读事件

            }


        }


    }

}
