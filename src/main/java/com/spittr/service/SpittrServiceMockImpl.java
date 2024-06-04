package com.spittr.service;

import com.spittr.model.Spitter;
import com.spittr.model.Spittle;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class SpittrServiceMockImpl implements SpittrService {
    @Override
    public List<Spitter> getAllSpitters() {
        Spitter spitter1 = new Spitter(1,"spitter1","","Spitter 1", new ArrayList<>());
        Spitter spitter2 = new Spitter(2,"spitter2","","Spitter 2", new ArrayList<>());
        List spitterList = new ArrayList<>();
        spitterList.add(spitter1);
        spitterList.add(spitter2);
        return spitterList;
    }

    @Override
    public Spitter getSpitterById(int id) {
        Spitter spitter = new Spitter(id,"spitter_selected","","spitter selected", new ArrayList<>());
        return spitter;
    }

    @Override
    public void saveSpitter(Spitter spitter) {

    }

    @Override
    public void deleteSpitterById(int id) {

    }

    @Override
    public List<Spittle> getAllSpittles() {
        Spittle spittle1 = new Spittle(1,"spittle1",null, new Spitter());
        Spittle spittle2 = new Spittle(2,"spittle2",null, new Spitter());
        Spittle spittle3 = new Spittle(3,"spittle3",null, new Spitter());
        List spittleList = new ArrayList<>();
        spittleList.add(spittle1);
        spittleList.add(spittle2);
        spittleList.add(spittle3);
        return spittleList;
    }

}
