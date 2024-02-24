package org.xstars.event.indi;

import java.util.EventObject;

public final class TheElder extends Person {
    public static final TheElder he = new TheElder();

    private TheElder() {
        super();
    }

    public void addMagician(Magician magician) {
        magician.timePassedOneMinuteEvent().addCallback(this::addOneSecond);
    }

    private void addOneSecond(EventObject event) {
        this.seconds++;
    }
}
