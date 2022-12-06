package com.roi.rentalcar.mappers;

import java.util.List;

public interface BaseMapper<E,D> {
     D toDTO(E e);
   E toEntity(D d);

    List<D> toDTOList(List<E> e);
    List<E> toEntityList(List<D> d);
}
