package org.xstars.event;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 事件的默认实现，在触发时可调用其中包含的回调函数。
 *
 * @param <A> 事件的参数的类型。
 */
public class SimpleEvent<A> implements Event<A> {
    /**
     * 当前事件的所有回调函数集合。
     */
    private final Collection<EventCallback<? super A>> callbacks;

    /**
     * 创建一个事件的实例。
     */
    public SimpleEvent() {
        this.callbacks = new LinkedList<EventCallback<? super A>>();
    }

    /**
     * 添加一个新的回调函数到当前事件。
     *
     * @param callback 要添加到当前事件的回调函数。
     * @throws NullPointerException {@code callback} 为 {@code null}。
     */
    @Override
    public void addCallback(EventCallback<? super A> callback) {
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
    public void removeCallback(EventCallback<? super A> callback) {
        synchronized (this.callbacks) {
            this.callbacks.remove(Objects.requireNonNull(callback));
        }
    }

    /**
     * 触发事件，调用所有回调函数。
     *
     * @param source   事件源。
     * @param argument 事件所需的参数。
     */
    @Override
    public void raiseEvent(Object source, A argument) {
        synchronized (this.callbacks) {
            for (EventCallback<? super A> callback : this.callbacks) {
                callback.invoke(source, argument);
            }
        }
    }
}
