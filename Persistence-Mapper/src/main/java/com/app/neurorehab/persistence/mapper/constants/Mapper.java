package com.app.neurorehab.persistence.mapper.constants;

public interface Mapper<T, F> {

    T mapTo(F object);
    F mapFrom(T object);
}
