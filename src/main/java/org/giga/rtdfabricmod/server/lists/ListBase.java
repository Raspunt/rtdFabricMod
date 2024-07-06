package org.giga.rtdfabricmod.server.lists;

import java.util.ArrayList;
import java.util.Random;

public abstract class ListBase<T> {

    protected ArrayList<T> objectList = new ArrayList<>();

    public T getRandomElement() {
        Random rand = new Random();
        int randIndex = rand.nextInt(objectList.size());
        return objectList.get(randIndex);
    }
}
