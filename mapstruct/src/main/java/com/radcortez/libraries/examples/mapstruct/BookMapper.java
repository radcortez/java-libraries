package com.radcortez.libraries.examples.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookRead toBookRead(Book book);

    @Mapping(target = "id", ignore = true)
    Book toBook(Book source, @MappingTarget Book target);
}
