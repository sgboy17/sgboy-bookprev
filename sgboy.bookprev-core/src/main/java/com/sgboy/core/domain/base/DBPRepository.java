package com.sgboy.core.domain.base;

/**
 * Created by NghiaPV on 7/1/2017.
 */
public interface DBPRepository<T> {
    public void update(String sessionId, T model);

    public T read(String sessionId);

    public void delete(String sessionId);

    public T create(String sessionId);
}
