package spitter.data;

import spitter.data.model.Spittle;

import java.util.List;

public interface ISpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
