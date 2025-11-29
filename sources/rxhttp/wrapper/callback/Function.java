package rxhttp.wrapper.callback;

public interface Function<T, R> {
    Object apply(Object obj);
}
