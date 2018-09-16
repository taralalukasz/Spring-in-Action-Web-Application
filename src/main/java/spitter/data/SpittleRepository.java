package spitter.data;

import org.springframework.stereotype.Component;
import spitter.data.model.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class SpittleRepository implements ISpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittleList = new ArrayList<>();

        for (int i = 0 ; i < count; i++) {
            spittleList.add(new Spittle("spittleNumber" + i, new Date()));
        }
        return spittleList;
    }

    @Override
    public Spittle findOne(long spittleId) {

        if (spittleId <= 0)
            return null;

        List<Spittle> spittleList = new ArrayList<>();

        for (long i = 0 ; i < 100; i++) {
            spittleList.add(new Spittle(i, "spittleNumber" + i, new Date()));
        }

        return spittleList.stream().filter(spittle->spittle.getId() == spittleId).findFirst().orElse(null);

    }
}
