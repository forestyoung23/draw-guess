package com.forest.drawguess;

/**
 * @author Forest Dong
 * @date 2024年05月14日 20:14
 */
public class VTDemo1 {
    private static final int COUNT = 4000;

    /**
     * -XX:NativeMemoryTracking=detail
     *
     * @param args args
     */
    public static void main(String[] args) throws Exception {
        for (int i = 0; i < COUNT; i++) {
            Thread.startVirtualThread(() -> {
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        Thread.sleep(Long.MAX_VALUE);
    }
}
