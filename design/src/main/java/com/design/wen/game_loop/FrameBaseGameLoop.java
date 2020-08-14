package com.design.wen.game_loop;

public class FrameBaseGameLoop extends GameLoop {
    @Override
    protected void processGameLoop() {
        while (isGameRunning()){
            processInput();
            update();
            render();
        }
    }

    protected void update() {
        gameController.moveBullet(0.5f);

    }
}
