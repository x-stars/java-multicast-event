package org.xstars.event;

import java.util.Collection;
import java.util.EventObject;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 事件管理器的默认实现，可以向事件添加或移除回调函数，在事件触发时调用其中包含的回调函数。
 *
 * @param <E> 事件对象的类型。
 */
public class SimpleEventManager<E extends EventObject> implements EventManager<E> {
    /**
     * 当前事件的所有回调函数集合。
     */
    private final Collection<EventCallback<? super E>> callbacks;

    /**
     * 创建一个事件管理器的实例。
     */
    public SimpleEventManager() {
        this.callbacks = new LinkedList<EventCallback<? super E>>();
    }

    /**
     * 添加一个新的回调函数到当前事件。
     *
     * @param callback 要添加到当前事件的回调函数。
     * @throws NullPointerException {@code callback} 为 {@code null}。
     */
    @Override
    public void addCallback(EventCallback<? super E> callback) {
        synchronized (this.callbacks) {
            this.callbacks.add(Objects.requireNonNull(callback));
        }
    }

    /**
     * 从当前事件移除一个已有回调函数。
     *
     * @param callback 要从当前事件移除的回调函数。
     * @throws NullPointerException {@code callback} 为 {@code null}。
     */
    @Override
    public void removeCallback(EventCallback<? super E> callback) {
        synchronized (this.callbacks) {
            this.callbacks.remove(Objects.requireNonNull(callback));
        }
    }

    /**
     * 触发事件，调用所有回调函数。
     *
     * @param event 事件对象。
     */
    @Override
    public void raiseEvent(E event) {
        synchronized (this.callbacks) {
            for (EventCallback<? super E> callback : this.callbacks) {
                callback.invoke(event);
            }
        }
    }
}
