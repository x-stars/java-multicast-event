package org.xstars.event;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.junit.Assert;
import org.junit.Test;
import org.xstars.event.indi.Magician;
import org.xstars.event.indi.Person;
import org.xstars.event.indi.TheElder;

/**
 * Java 事件模式测试。
 */
public class EventTest {
    /**
     * 初始化事件模式测试的新实例。
     */
    public EventTest() {
    }

    /**
     * 时间模式测试主入口点。
     *
     * @param args 程序启动参数。
     */
    public static void main(String[] args) {
        EventTest test = new EventTest();
        test.testEvent();
    }

    @Test
    public void testEvent() {
        Collection<Person> people = new LinkedHashSet<>();
        people.add(TheElder.he);
        System.out.println("The elder has " + TheElder.he.getSeconds() + " seconds.");
        Assert.assertEquals(0, TheElder.he.getSeconds());
        for (int i = 0; i < 60; i++) {
            Magician magician = new Magician();
            TheElder.he.addMagician(magician);
            people.add(magician);
        }
        System.out.println("There are " + (people.size() - 1) + " magicians.");
        for (int i = 0; i < 60; i++) {
            for (Person person : people) {
                person.growsOneSecond();
            }
        }
        System.out.println("Time passed 60 seconds.");
        System.out.println("The elder has " + TheElder.he.getSeconds() + " seconds.");
        Assert.assertEquals(0, TheElder.he.getSeconds());
        for (int i = 0; i < 60; i++) {
            Magician magician = new Magician();
            TheElder.he.addMagician(magician);
            people.add(magician);
        }
        System.out.println("There are " + (people.size() - 1) + " magicians.");
        for (int i = 0; i < 60; i++) {
            for (Person person : people) {
                person.growsOneSecond();
            }
        }
        System.out.println("Time passed 60 seconds.");
        System.out.println("The elder has " + TheElder.he.getSeconds() + " seconds.");
        Assert.assertEquals(60, TheElder.he.getSeconds());
    }
}
