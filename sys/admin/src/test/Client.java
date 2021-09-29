import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

public class Client {
	private Selector selector;
	private SocketChannel socketChannel;
	public Client(){
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress("127.0.0.1",8888));
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_READ);
			System.out.println(socketChannel.getLocalAddress()+"我已经准备好了");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void send(String msg){
		try {
			System.out.println("我说："+msg);
			socketChannel.write(ByteBuffer.wrap(msg.getBytes(StandardCharsets.UTF_8)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		Scanner scanner = new Scanner(System.in);
		new Thread(){
			@Override
			public void run() {
				client.readInf();
			}
		}.start();
		while(scanner.hasNext()){
			String msg = scanner.next();
			client.send(msg);
		}
	}

	private void readInf() {
		while (true){
			try {
				int select = selector.select();
				if(select > 0){
					Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
					while (iterator.hasNext()){
						SelectionKey key = iterator.next();
						SocketChannel channel = (SocketChannel) key.channel();
						if(key.isReadable()){
							ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
							channel.read(byteBuffer);
							System.out.println(new String(byteBuffer.array(),StandardCharsets.UTF_8));
						}
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
