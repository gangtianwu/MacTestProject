package com.design.wen.game_loop;

import java.util.Random;

public abstract class GameLoop {
    protected GameController gameController;
    GameStatus status;
    private Thread thread;

    protected GameLoop() {
        gameController = new GameController();
        status = GameStatus.STOPPED;
    }


    public void run(){
        status = GameStatus.RUNNING;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                processGameLoop();
            }
        });
        thread.start();
    }

    protected abstract void processGameLoop();


    /**
     * stop game
     */
    public void stop(){
        status = GameStatus.STOPPED;
    }


    public boolean isGameRunning(){
        return  status == GameStatus.RUNNING;
    }

    protected void processInput(){
        int i = new Random().nextInt(200) + 50;
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    protected void render(){
        float bulletPosition = gameController.getBulletPosition();
        System.out.println("当前位置: "+ bulletPosition);
    }
}
