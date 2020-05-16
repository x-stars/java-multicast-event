package org.xstars.event.indi;

public class Person {
    protected int seconds;

    public Person() {
        this.seconds = 0;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void growsOneSecond() {
        this.seconds--;
    }
}
