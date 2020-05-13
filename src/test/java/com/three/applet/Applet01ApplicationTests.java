package com.three.applet;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@SpringBootTest
class Applet01ApplicationTests {

	@Test
	void contextLoads() throws InterruptedException {
		Lock lock = new ReentrantLock();
		lock.tryLock();
		BlockingDeque queue = new LinkedBlockingDeque();
		queue.take();
	}
	

}
