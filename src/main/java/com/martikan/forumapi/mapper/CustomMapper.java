package com.martikan.forumapi.mapper;

/**
 * Base interface for mappers.
 * @param <T> - Entity.
 * @param <D> - DTO.
 */
public interface CustomMapper<T, D> {

    D toDTO(T source);

    T toEntity(D source);

    T updateEntity(T source);

}