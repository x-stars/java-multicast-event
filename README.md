# Java 多播事件模式

Java 事件模式基于函数接口的多播实现，可实现一个事件调用多个事件处理方法。

## 主要类型

``` Java
package org.xstars.event;

// 表示一个事件回调函数。
public interface EventCallback<A> { ... }
// 表示一个事件订阅器，可以向事件添加或移除回调函数。
public interface EventRegister<A> { ... }
// 表示一个事件，在触发时可调用其中包含的回调函数。
public interface Event<A> extends EventRegister<A> { ... }
// 事件的默认实现，在触发时可调用其中包含的回调函数。
public class SimpleEvent<A> implements Event<A> { ... }
```

## 使用范例

### 定义事件

``` Java
// 对内定义事件。
protected final Event<Object> timePassedOneMinuteEvent;
// 对外暴露事件订阅器。
public EventRegister<Object> timePassedOneMinuteEvent() {
    return this.timePassedOneMinuteEvent;
}
```

## 订阅事件

``` Java
public void addMagician(Magician magician) {
    // 订阅事件，添加事件处理函数。
    magician.timePassedOneMinuteEvent().addCallback(this::addOneSecond);
}
// 事件处理函数。
private void addOneSecond(Object source, Object argument) {
    this.seconds++;
}
```
