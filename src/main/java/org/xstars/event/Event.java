package org.xstars.event;

/**
 * 表示一个事件，在触发时可调用其中包含的回调函数。
 * 
 * @param <A> 事件的参数的类型。
 */
public interface Event<A> extends EventRegister<A> {
    /**
     * 触发事件，调用所有回调函数。
     * 
     * @param source 事件源。
     * @param argument 事件所需的参数。
     */
    void raiseEvent(Object source, A argument);
}
