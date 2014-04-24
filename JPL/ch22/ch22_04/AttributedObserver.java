package ch22.ch22_04;

import java.util.*;

public class AttributedObserver<V> implements Observer {

	AttributedImpl<V> watching;

    public AttributedObserver(AttributedImpl<V> attributed) {
        watching = attributed;
        watching.addObserver(this);
    }

    @Override
    public void update(Observable attributed, Object changeAttr) {
        if (attributed != watching) {
            throw new IllegalArgumentException();
        }

        System.out.println(changeAttr);

    }
}
