package com.design.wen.game_loop;

import java.util.logging.Logger;

public class App {
    private static final int GAME_LOOP_DURATION_TIME = 2000;

    public static void main(String[] args) {
        try {
            Logger global = Logger.getGlobal();
            System.out.println("======start=====");
            FrameBaseGameLoop frameBaseGameLoop = new FrameBaseGameLoop();
            frameBaseGameLoop.run();

            Thread.sleep(GAME_LOOP_DURATION_TIME);
            frameBaseGameLoop.stop();
            System.out.println("Stop base frame game loop ");

            System.out.println("======start varia step =====");
            VariableStepGameLoop variableStepGameLoop = new VariableStepGameLoop();
            variableStepGameLoop.run();
            Thread.sleep(GAME_LOOP_DURATION_TIME);
            variableStepGameLoop.stop();
            System.out.println("Stop varia step game loop");

            System.out.println("======start fix Step=====");
            FixedStepGameLoop fixedStepGameLoop = new FixedStepGameLoop();
            fixedStepGameLoop.run();
            Thread.sleep(GAME_LOOP_DURATION_TIME);
            fixedStepGameLoop.stop();
            System.out.println("Stop fix step game loop");





        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
