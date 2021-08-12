import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class Server {
	private Selector selector;
	private ServerSocketChannel lisenterChinel;
	private InetSocketAddress address = new InetSocketAddress(8888);
	
	public Server(){
		try {
			selector = Selector.open();
			lisenterChinel = ServerSocketChannel.open();
			lisenterChinel.bind(address);
			lisenterChinel.configureBlocking(false);
			lisenterChinel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("服务器启动，监听中。。。。。");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void  lisenter(){
		try {
			while (true){
				int select = selector.select();
				if(select > 0){
					Set<SelectionKey> selectionKeys = selector.selectedKeys();
					Iterator<SelectionKey> iterator = selectionKeys.iterator();
					while (iterator.hasNext()){
						SelectionKey key = iterator.next();
						if(key.isAcceptable()){
							SocketChannel accept = lisenterChinel.accept();
							accept.configureBlocking(false);
							accept.register(selector,SelectionKey.OP_READ);
							System.out.println(accept.getRemoteAddress()+"已上线");
						}
						if(key.isReadable()){
							ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
							SocketChannel channel = (SocketChannel) key.channel();
							try {
								int read = channel.read(byteBuffer);
								if(read > 0){
									String msg = new String(byteBuffer.array(), StandardCharsets.UTF_8);
									System.out.println("from-"+channel.getRemoteAddress()+"说："+msg);
									sendAll(msg,channel);
								}
							} catch (IOException e) {
								System.out.println(channel.getRemoteAddress()+"离线了");
								channel.close();
							}
						}
						iterator.remove();
					}
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	private void sendAll(String msg,SocketChannel self){
		for (SelectionKey key : selector.keys()) {
			if(key.channel() instanceof SocketChannel && key.channel()!=self){
				SocketChannel channel = (SocketChannel) key.channel();
				try {
					channel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
				} catch (IOException e) {
					try {
						System.out.println(channel.getRemoteAddress()+"离线了");
					} catch (IOException ioException) {
						ioException.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.lisenter();
	}
}
