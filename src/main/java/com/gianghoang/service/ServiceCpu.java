package com.gianghoang.service;

import com.gianghoang.service.servicescaller.ICpu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 8/18/2016.
 */

public class ServiceCpu implements ICpu {

    @Override
    public void testHighCpu() {
        ExecutorService executor = Executors.newFixedThreadPool(1500);

        for (int i = 0; i < 50000; i++) {
            Runnable cpu = (Runnable) new Cpu(i);
            executor.execute(cpu);
        }
        executor.shutdown();

        while (!executor.isTerminated()) {
        }
    }
}
