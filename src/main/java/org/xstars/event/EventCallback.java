package org.xstars.event;

import java.util.EventObject;

/**
 * 表示一个事件回调函数。
 *
 * @param <E> 事件对象的类型。
 */
@FunctionalInterface
public interface EventCallback<E extends EventObject> {
    /**
     * 调用当前事件回调函数。
     *
     * @param event 事件对象。
     */
    void invoke(E event);
}
