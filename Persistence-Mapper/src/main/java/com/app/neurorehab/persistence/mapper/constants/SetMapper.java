package com.app.neurorehab.persistence.mapper.constants;

import com.app.neurorehab.persistence.mapper.constants.Mapper;

import java.util.HashSet;
import java.util.Set;

public class SetMapper {
    /**
     * Maps lists of objects.
     */
    public <T, R> Set<R> mapSet(final Mapper mapper, boolean isTo, final Set<T> classA) {

        Set<R> mappedObjectSet = null;

        if (classA != null) {

            mappedObjectSet = new HashSet<>();

            if (isTo) {
                for (final T classAObject : classA) {
                    mappedObjectSet.add((R) mapper.mapTo(classAObject));
                }
            } else {
                for (final T classAObject : classA) {
                    mappedObjectSet.add((R) mapper.mapFrom(classAObject));
                }
            }
        }

        return mappedObjectSet;
    }
}
