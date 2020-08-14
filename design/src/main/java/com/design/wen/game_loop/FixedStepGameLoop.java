package com.design.wen.game_loop;

public class FixedStepGameLoop extends GameLoop {
    @Override
    protected void processGameLoop() {
        long currentTimeMillis = System.currentTimeMillis();
        long lag = 0L;
        while (isGameRunning()){
            long timeMillis = System.currentTimeMillis();
            long l = timeMillis - currentTimeMillis;
            currentTimeMillis = timeMillis;
            lag += l;
            processInput();
            while (lag >= 20){
                update();
                lag -= 20;
            }

        }
    }

    private void update() {
        gameController.moveBullet(0.5f * 20 /1000);
    }
}
