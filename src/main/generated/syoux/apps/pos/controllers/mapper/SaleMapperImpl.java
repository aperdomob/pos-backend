package syoux.apps.pos.controllers.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.dto.SaleDto;
import syoux.apps.pos.dto.SaleItemDto;
import syoux.apps.pos.repository.entity.Sale;
import syoux.apps.pos.repository.entity.SaleItem;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-15T19:26:50-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Override
    public Sale dtoToEntity(SaleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setId( dto.getId() );
        sale.setDate( dto.getDate() );
        sale.setStatus( dto.getStatus() );
        sale.setItems( saleItemDtoListToSaleItemList( dto.getItems() ) );

        return sale;
    }

    @Override
    public SaleDto entityToDto(Sale entity) {
        if ( entity == null ) {
            return null;
        }

        SaleDto saleDto = new SaleDto();

        saleDto.setId( entity.getId() );
        saleDto.setDate( entity.getDate() );
        saleDto.setStatus( entity.getStatus() );
        saleDto.setItems( saleItemListToSaleItemDtoList( entity.getItems() ) );

        return saleDto;
    }

    protected SaleItem saleItemDtoToSaleItem(SaleItemDto saleItemDto) {
        if ( saleItemDto == null ) {
            return null;
        }

        SaleItem saleItem = new SaleItem();

        saleItem.setId( saleItemDto.getId() );
        saleItem.setName( saleItemDto.getName() );
        saleItem.setReference( saleItemDto.getReference() );
        saleItem.setAmount( saleItemDto.getAmount() );
        saleItem.setPrice( saleItemDto.getPrice() );
        saleItem.setDeduction( saleItemDto.getDeduction() );

        return saleItem;
    }

    protected List<SaleItem> saleItemDtoListToSaleItemList(List<SaleItemDto> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleItem> list1 = new ArrayList<SaleItem>( list.size() );
        for ( SaleItemDto saleItemDto : list ) {
            list1.add( saleItemDtoToSaleItem( saleItemDto ) );
        }

        return list1;
    }

    protected SaleItemDto saleItemToSaleItemDto(SaleItem saleItem) {
        if ( saleItem == null ) {
            return null;
        }

        SaleItemDto saleItemDto = new SaleItemDto();

        saleItemDto.setId( saleItem.getId() );
        saleItemDto.setName( saleItem.getName() );
        saleItemDto.setReference( saleItem.getReference() );
        saleItemDto.setAmount( saleItem.getAmount() );
        saleItemDto.setPrice( saleItem.getPrice() );
        saleItemDto.setDeduction( saleItem.getDeduction() );

        return saleItemDto;
    }

    protected List<SaleItemDto> saleItemListToSaleItemDtoList(List<SaleItem> list) {
        if ( list == null ) {
            return null;
        }

        List<SaleItemDto> list1 = new ArrayList<SaleItemDto>( list.size() );
        for ( SaleItem saleItem : list ) {
            list1.add( saleItemToSaleItemDto( saleItem ) );
        }

        return list1;
    }
}
