package syoux.apps.pos.controllers.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.SaleDto;
import syoux.apps.pos.controllers.dto.SaleItemDto;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.domain.SaleItemDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-20T12:25:40-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SaleDtoMapperImpl implements SaleDtoMapper {

    @Override
    public SaleDomain dtoToDomain(SaleDto dto) {
        if ( dto == null ) {
            return null;
        }

        SaleDomain saleDomain = new SaleDomain();

        saleDomain.setId( dto.getId() );
        saleDomain.setDate( dto.getDate() );
        saleDomain.setStatus( dto.getStatus() );
        saleDomain.setItems( saleItemDtoListToSaleItemDomainList( dto.getItems() ) );

        return saleDomain;
    }

    @Override
    public SaleDto domainToDto(SaleDomain entity) {
        if ( entity == null ) {
            return null;
        }

        SaleDto saleDto = new SaleDto();

        saleDto.setId( entity.getId() );
        saleDto.setDate( entity.getDate() );
        saleDto.setStatus( entity.getStatus() );
        saleDto.setItems( saleItemDomainListToSaleItemDtoList( entity.getItems() ) );

        return saleDto;
    }

    protected SaleItemDomain saleItemDtoToSaleItemDomain(SaleItemDto saleItemDto) {
        if ( saleItemDto == null ) {
            return null;
        }

        SaleItemDomain saleItemDomain = new SaleItemDomain();

        saleItemDomain.setId( saleItemDto.getId() );
        saleItemDomain.setName( saleItemDto.getName() );
        saleItemDomain.setReference( saleItemDto.getReference() );
        saleItemDomain.setAmount( saleItemDto.getAmount() );
        saleItemDomain.setPrice( saleItemDto.getPrice() );
        saleItemDomain.setDeduction( saleItemDto.getDeduction() );

        return saleItemDomain;
    }

    protected List<SaleItemDomain> saleItemDtoListToSaleItemDomainList(List<SaleItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleItemDomain> list1 = new ArrayList<SaleItemDomain>( list.size() );
        for ( SaleItemDto saleItemDto : list ) {
            list1.add( saleItemDtoToSaleItemDomain( saleItemDto ) );
        }

        return list1;
    }

    protected SaleItemDto saleItemDomainToSaleItemDto(SaleItemDomain saleItemDomain) {
        if ( saleItemDomain == null ) {
            return null;
        }

        SaleItemDto saleItemDto = new SaleItemDto();

        saleItemDto.setId( saleItemDomain.getId() );
        saleItemDto.setName( saleItemDomain.getName() );
        saleItemDto.setReference( saleItemDomain.getReference() );
        saleItemDto.setAmount( saleItemDomain.getAmount() );
        saleItemDto.setPrice( saleItemDomain.getPrice() );
        saleItemDto.setDeduction( saleItemDomain.getDeduction() );

        return saleItemDto;
    }

    protected List<SaleItemDto> saleItemDomainListToSaleItemDtoList(List<SaleItemDomain> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleItemDto> list1 = new ArrayList<SaleItemDto>( list.size() );
        for ( SaleItemDomain saleItemDomain : list ) {
            list1.add( saleItemDomainToSaleItemDto( saleItemDomain ) );
        }

        return list1;
    }
}
