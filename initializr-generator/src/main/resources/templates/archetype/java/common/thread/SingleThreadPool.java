package {{packageName}}.common.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhayujie
 * @description 单线程池
 * @date 2019/12/14
 */
public class SingleThreadPool {
    private static SingleThreadFactory singleThreadFactory = new SingleThreadFactory();
    /**
     * 核心线程数1，总线程数1
     */
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1, 10,
            TimeUnit.SECONDS, new ArrayBlockingQueue<>(300), singleThreadFactory);

    public static void addTask(Runnable task) {
        pool.execute(task);
    }

    static class SingleThreadFactory implements ThreadFactory {
        private AtomicInteger threadNum = new AtomicInteger(0);
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setName("single-thread-pool-" + threadNum.incrementAndGet());
            return t;
        }
    }

    public static void main(String[] args) {
        SingleThreadPool.addTask( () -> System.out.println("Hello, I am: " + Thread.currentThread().getName()) );
    }
}
