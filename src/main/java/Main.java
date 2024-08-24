import entity.Dialog;
import entity.Scene;
import entity.StoryConfig;
import entity.loaders.FileSystemEntityLoader;
import jdk.jshell.spi.ExecutionControl;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ExecutionControl.NotImplementedException {
        FileSystemEntityLoader loader = new FileSystemEntityLoader();
        Scanner sc = new Scanner(System.in);

        StoryConfig config = loader.loadStoryConfig();
        String answer = "";
        Scene currentScene = loader.loadScene(config.entryPoint());

        while (true) {
            System.out.print(currentScene.toString());

            answer = sc.next();

            if (currentScene.config().casesAsMap().containsValue(answer)) {
                String point = currentScene.config().casesAsMap().get(answer);
                if (point == "$END") {
                    end();
                    return;
                }
                else {
                    currentScene = loader.loadScene(point);
                }
            }
            else{
                System.out.println("Invalid answer, try again!");
            }
        }
    }
    public static void end(){

    }
}
