package com.ding.pokedex;

import java.nio.channels.NonReadableChannelException;
import java.util.List;

public class ColorConvertUtil {
    public static int convertColor(List<String> data){
        int color = 0;
        if (data != null && data.get(0) != null){
            switch (data.get(0)){
                case "grass":
                case "bug":
                    color = R.color.lightTeal;
                    break;
                case "fire":
                    color = R.color.lightRed;
                    break;
                case "water":
                case "fighting":
                case "normal":
                    color = R.color.lightBlue;
                        break;
                case "poison":
                case "ghost":
                    color = R.color.lightPurple;
                    break;
                case "ground":
                case "rock":
                    color = R.color.lightBrown;
                    break;
                case "dark":
                    color = R.color.lightBlue;
                    break;
                default:
                    color = R.color.lightBlue;
                    break;

            }
        }

        return color;

    }
}
