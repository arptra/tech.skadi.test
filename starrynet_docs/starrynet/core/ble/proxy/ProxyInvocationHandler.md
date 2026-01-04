# ProxyInvocationHandler

*Пакет:* `com.upuphone.starrynet.core.ble.proxy`\n
*Источник:* `starrynet/core/ble/proxy/ProxyInvocationHandler.java`\n
*Тип:* Class

## Назначение
Класс ProxyInvocationHandler управляет логикой, связанной с ProxyInvocationHandler.

## Поля
- `Handler handler`
- `ProxyInterceptor interceptor`
- `boolean postUI`
- `Object subject`
- `boolean weakRef`

## Методы
- `private Object getObject(Object obj)`
- `private Object postSafeInvoke(ProxyBulk proxyBulk)`
- `private Object safeInvoke(ProxyBulk proxyBulk)`
- `public boolean handleMessage(Message message)`
- `public Object invoke(Object obj, Method method, Object objArr)`
- `public boolean onIntercept(Object obj, Method method, Object objArr)`
- `private Object getObject()`
- `public ProxyInvocationHandler(Object obj)`
- `public ProxyInvocationHandler(Object obj, ProxyInterceptor proxyInterceptor)`
- `public ProxyInvocationHandler(Object obj, ProxyInterceptor proxyInterceptor, boolean z)`
- `public ProxyInvocationHandler(Object obj, ProxyInterceptor proxyInterceptor, boolean z, boolean z2)`
