# Java 多播事件模式

Java 事件模式基于函数接口的多播实现，可实现一个事件调用多个事件处理方法。

## 主要类型

``` Java
package org.xstars.event;

import java.util.EventObject;

// 表示一个事件回调函数。
public interface EventCallback<E extends EventObject> { ... }
// 表示一个事件订阅器，可以向事件添加或移除回调函数。
public interface EventRegister<E extends EventObject> { ... }
// 表示一个事件管理器，可以向事件添加或移除回调函数，在事件触发时调用其中包含的回调函数。
public interface EventManager<E extends EventObject> extends EventRegister<E> { ... }
// 事件管理器的默认实现，可以向事件添加或移除回调函数，在事件触发时调用其中包含的回调函数。
public class SimpleEventManager<E extends EventObject> implements EventManager<E> { ... }
```

## 使用范例

### 定义事件

``` Java
import java.util.EventObject;

// 对内定义事件。
protected final EventManager<EventObject> timePassedOneMinuteEvent;
// 对外暴露事件订阅器。
public EventRegister<EventObject> timePassedOneMinuteEvent() {
    return this.timePassedOneMinuteEvent;
}
```

## 订阅事件

``` Java
import java.util.EventObject;

public void addMagician(Magician magician) {
    // 订阅事件，添加事件处理函数。
    magician.timePassedOneMinuteEvent().addCallback(this::addOneSecond);
}
// 事件处理函数。
private void addOneSecond(EventObject event) {
    this.seconds++;
}
```
