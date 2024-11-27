package Interface;

public interface Factory<T> {
    T create(Object... params);
}