package juc;

import java.util.concurrent.Semaphore;

/**
 * T1115：交替打印 FooBar
 * https://leetcode-cn.com/problems/print-foobar-alternately/
 *
 * 思路 1：
 * 用两个信号量，打印完通知另外一个线程的信号量
 *
 *
 * @author cocowwy.cn
 * @create 2022-02-02-10:20
 */
public class PrintFoobarAlternately {
    class FooBar {
        private int n;
        private Semaphore foo = new Semaphore(1);
        private Semaphore bar = new Semaphore(0);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.
                foo.acquire();
                printFoo.run();
                bar.release();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                bar.acquire();
                printBar.run();
                foo.release();
            }
        }
    }
}

