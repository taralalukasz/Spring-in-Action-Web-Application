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
}
