package com.forest.drawguess;

public class VTDemo {

    private static final int COUNT = 4000;

    /**
     *  -XX:NativeMemoryTracking=detail
     *
     * @param args args
     */
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < COUNT; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
        Thread.sleep(Long.MAX_VALUE);
    }
}
