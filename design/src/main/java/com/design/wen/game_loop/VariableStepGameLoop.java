package com.design.wen.game_loop;

import java.util.logging.Logger;

public class VariableStepGameLoop extends GameLoop {
    @Override
    protected void processGameLoop() {
        long lastFrameTime = System.currentTimeMillis();
        while (isGameRunning()){
            processInput();
            long timeMillis = System.currentTimeMillis();
            long elapsedTime = timeMillis - lastFrameTime;
            update(elapsedTime);
            lastFrameTime = timeMillis;
            render();
        }
    }

    protected void update(Long elapsedTime){
      gameController.moveBullet(0.5f*elapsedTime/1000);
    }
}
