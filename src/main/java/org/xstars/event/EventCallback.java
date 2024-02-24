package org.xstars.event;

/**
 * 表示一个事件回调函数。
 *
 * @param <A> 事件的参数的类型。
 */
@FunctionalInterface
public interface EventCallback<A> {
    /**
     * 调用当前事件回调函数。
     *
     * @param source   事件源。
     * @param argument 事件所需的参数。
     */
    void invoke(Object source, A argument);
}
