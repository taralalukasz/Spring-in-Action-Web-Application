package spitter.data;

import spitter.data.model.Spitter;

public interface ISpitterRepository {
    void save(Spitter spitter);

    Spitter findUserByUsername(String username);
}
