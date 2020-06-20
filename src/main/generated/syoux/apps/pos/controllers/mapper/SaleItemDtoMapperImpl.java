package syoux.apps.pos.controllers.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.dto.SaleItemDto;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-20T07:13:07-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SaleItemDtoMapperImpl implements SaleItemDtoMapper {

    @Override
    public SaleItemDto domainToDto(SaleItemDomain entity) {
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
    public SaleItemDomain dtoToDomain(SaleItemDto dto) {
        if ( dto == null ) {
            return null;
        }

        SaleItemDomain saleItemDomain = new SaleItemDomain();

        saleItemDomain.setId( dto.getId() );
        saleItemDomain.setName( dto.getName() );
        saleItemDomain.setReference( dto.getReference() );
        saleItemDomain.setAmount( dto.getAmount() );
        saleItemDomain.setPrice( dto.getPrice() );
        saleItemDomain.setDeduction( dto.getDeduction() );

        return saleItemDomain;
    }
}
