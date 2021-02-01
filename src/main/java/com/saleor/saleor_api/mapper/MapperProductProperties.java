package com.saleor.saleor_api.mapper;

import com.saleor.saleor_api.dto.DtoProductProperties;
import com.saleor.saleor_api.table.ProductProperties;
import com.saleor.saleor_api.utils.EntityMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperProductProperties extends EntityMapper<ProductProperties, DtoProductProperties> {
    @Override
    DtoProductProperties toDto(ProductProperties source);

    @Override
    ProductProperties toEntity(DtoProductProperties source);

    @Override
    List<DtoProductProperties> toDtoList(List<ProductProperties> sourceList);

    @Override
    List<ProductProperties> toEntityList(List<DtoProductProperties> sourceList);
}
