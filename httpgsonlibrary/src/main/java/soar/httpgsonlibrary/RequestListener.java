package soar.httpgsonlibrary;

/**
 * Created by gaofei on 2016/4/29.
 */
public interface RequestListener<T> {
    void ok(T t);
}
