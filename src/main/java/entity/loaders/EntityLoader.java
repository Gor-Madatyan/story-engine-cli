package entity.loaders;

import entity.Scene;
import entity.StoryConfig;
import jdk.jshell.spi.ExecutionControl;

import javax.naming.InvalidNameException;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public interface EntityLoader {
    default Scene loadScene(Scene scene, String answer) throws InvalidNameException {
        AtomicReference<Scene> result = new AtomicReference<>(null);

        Arrays.asList(scene.config().cases()).forEach(aCase -> {
            if(Objects.equals(aCase.choice(), answer)) {
                try {
                    result.set(loadScene(aCase.point()));
                } catch (ExecutionControl.NotImplementedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        if(result.get() == null) result.get();

        throw new InvalidNameException();
    }
    StoryConfig loadStoryConfig() throws ExecutionControl.NotImplementedException;
    Scene loadScene(String name) throws ExecutionControl.NotImplementedException;
}
