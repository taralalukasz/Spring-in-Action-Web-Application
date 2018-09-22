package spitter.data;

import org.springframework.stereotype.Component;
import spitter.data.model.Spitter;

@Component
public class SpitterRepository implements ISpitterRepository {
    @Override
    public void save(Spitter spitter) {

    }

    @Override
    public Spitter findUserByUsername(String username) {
        return new Spitter("test", "user", "username", "pasword");
    }
}
