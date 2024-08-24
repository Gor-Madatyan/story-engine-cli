package entity.loaders;

import entity.Scene;
import entity.StoryConfig;
import jdk.jshell.spi.ExecutionControl;

public class FileSystemEntityLoader implements EntityLoader{
    @Override
    public StoryConfig loadStoryConfig() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Message haven't been created yet");
    }

    @Override
    public Scene loadScene(String name) throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Message haven't been created yet");
    }
}
