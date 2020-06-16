package syoux.apps.pos.controllers.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.dto.SaleItemDto;
import syoux.apps.pos.repository.entity.SaleItem;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-15T19:26:50-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SaleItemMapperImpl implements SaleItemMapper {

    @Override
    public SaleItemDto entityToDto(SaleItem entity) {
        if ( entity == null ) {
            return null;
        }

        SaleItemDto saleItemDto = new SaleItemDto();

        saleItemDto.setId( entity.getId() );
        saleItemDto.setName( entity.getName() );
        saleItemDto.setReference( entity.getReference() );
        saleItemDto.setAmount( entity.getAmount() );
        saleItemDto.setPrice( entity.getPrice() );
        saleItemDto.setDeduction( entity.getDeduction() );

        return saleItemDto;
    }

    @Override
    public SaleItem dtoToEntity(SaleItemDto dto) {
        if ( dto == null ) {
            return null;
        }

        SaleItem saleItem = new SaleItem();

        saleItem.setId( dto.getId() );
        saleItem.setName( dto.getName() );
        saleItem.setReference( dto.getReference() );
        saleItem.setAmount( dto.getAmount() );
        saleItem.setPrice( dto.getPrice() );
        saleItem.setDeduction( dto.getDeduction() );

        return saleItem;
    }
}
