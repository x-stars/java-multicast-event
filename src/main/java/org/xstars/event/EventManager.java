package org.xstars.event;

import java.util.EventObject;

/**
 * 表示一个事件管理器，可以向事件添加或移除回调函数，在事件触发时调用其中包含的回调函数。
 *
 * @param <E> 事件对象的类型。
 */
public interface EventManager<E extends EventObject> extends EventRegister<E> {
    /**
     * 触发事件，调用所有回调函数。
     *
     * @param event 事件对象。
     */
    void raiseEvent(E event);
}
