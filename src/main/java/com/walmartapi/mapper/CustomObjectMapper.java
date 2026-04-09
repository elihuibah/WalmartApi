package com.walmartapi.mapper;

public interface CustomObjectMapper <E, D> {

    E mapToEntity(D dto);

    D mapToDTO(E entity);

}
