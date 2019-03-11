package com.wx.jddk.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author weixing
 * @date 2019/3/11
 **/
public class NioServer {
    public static void main(String[] args) {
        try {
            Selector serverSelector = Selector.open();
            Selector clientSelector = Selector.open();
            new Thread(() -> {
                try {
                    ServerSocketChannel listenerChannnel = ServerSocketChannel.open();
                    listenerChannnel.socket().bind(new InetSocketAddress(8888));
                    listenerChannnel.configureBlocking(false);
                    listenerChannnel.register(serverSelector, SelectionKey.OP_ACCEPT);

                    while (true) {
                        if(serverSelector.select(1) > 0) {
                            Set<SelectionKey> set = serverSelector.selectedKeys();
                            Iterator<SelectionKey> keyIterator = set.iterator();
                            while (keyIterator.hasNext()) {
                                SelectionKey key = keyIterator.next();
                                if(key.isAcceptable()) {
                                    try {
                                        SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                                        clientChannel.configureBlocking(false);
                                        clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                    } finally {
                                        keyIterator.remove();
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
