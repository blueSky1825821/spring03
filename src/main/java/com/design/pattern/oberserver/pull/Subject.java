package com.design.pattern.oberserver.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wm on 18-1-5.
 */
public class Subject {
    private List<Observer> readers = new ArrayList<>();

    public void attach(Observer reader) {
        readers.add(reader);
    }

    public void detach(Observer reader) {
        readers.remove(reader);
    }

    protected void notifyObservers() {
        for (Observer reader : readers) {
            reader.update(this);
        }
    }
}
