package juc;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 打印零与奇偶数
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * 思路：
 * 使用信号量来
 * release 会使令牌+1  用来唤醒指定的线程
 *
 * @author cocowwy.cn
 * @create 2022-02-02-14:58
 */
public class printZeroEvenOdd {
    class ZeroEvenOdd {
        private int n;
        // 打印0
        private Semaphore print0 = new Semaphore(1);
        // 打印偶数
        private Semaphore printE = new Semaphore(0);
        // 打印奇数
        private Semaphore printD = new Semaphore(0);

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                print0.acquire();
                printNumber.accept(0);
                if (i % 2 == 1) {
                    printD.release();
                } else {
                    printE.release();
                }
            }
        }

        // 偶数
        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                printE.acquire();
                printNumber.accept(i);
                print0.release();
            }
        }

        // 奇数
        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                printD.acquire();
                printNumber.accept(i);
                print0.release();
            }
        }
    }
}

