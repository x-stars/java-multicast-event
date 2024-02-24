package org.xstars.event.indi;

import java.util.EventObject;

import org.xstars.event.EventManager;
import org.xstars.event.EventRegister;
import org.xstars.event.SimpleEventManager;

public class Magician extends Person {
    private int secondsInMinute;
    protected final EventManager<EventObject> timePassedOneMinuteEvent;

    public Magician() {
        super();
        this.secondsInMinute = 0;
        this.timePassedOneMinuteEvent = new SimpleEventManager<>();
    }

    public EventRegister<EventObject> timePassedOneMinuteEvent() {
        return this.timePassedOneMinuteEvent;
    }

    @Override
    public void growsOneSecond() {
        super.growsOneSecond();
        this.secondsInMinute++;
        if (this.secondsInMinute == 59) {
            this.secondsInMinute = 0;
            this.timePassedOneMinuteEvent.raiseEvent(new EventObject(this));
        }
    }
}
