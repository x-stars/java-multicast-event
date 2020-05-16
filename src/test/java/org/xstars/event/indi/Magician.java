package org.xstars.event.indi;

import org.xstars.event.Event;
import org.xstars.event.EventRegister;
import org.xstars.event.SimpleEvent;

public class Magician extends Person {
    private int secondsInMinute;
    protected final Event<Object> timePassedOneMinuteEvent;

    public Magician() {
        super();
        this.secondsInMinute = 0;
        this.timePassedOneMinuteEvent = new SimpleEvent<>();
    }

    public EventRegister<Object> timePassedOneMinuteEvent() {
        return this.timePassedOneMinuteEvent;
    }

    @Override
    public void growsOneSecond() {
        super.growsOneSecond();
        this.secondsInMinute++;
        if (this.secondsInMinute == 59) {
            this.secondsInMinute = 0;
            this.timePassedOneMinuteEvent.raiseEvent(this, null);
        }
    }
}
