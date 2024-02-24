package org.xstars.event;

/**
 * 表示一个事件订阅器，可以向事件添加或移除回调函数。
 *
 * @param <A> 事件的参数的类型。
 */
public interface EventRegister<A> {
    /**
     * 添加一个新的回调函数到当前事件。
     *
     * @param callback 要添加到当前事件的回调函数。
     * @throws NullPointerException {@code callback} 为 {@code null}。
     */
    void addCallback(EventCallback<? super A> callback);

    /**
     * 从当前事件移除一个已有回调函数。
     *
     * @param callback 要从当前事件移除的回调函数。
     * @throws NullPointerException {@code callback} 为 {@code null}。
     */
    void removeCallback(EventCallback<? super A> callback);
}
