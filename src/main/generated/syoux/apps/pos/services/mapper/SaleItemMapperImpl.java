package syoux.apps.pos.services.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.domain.SaleItemDomain;
import syoux.apps.pos.repository.entity.SaleItem;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-22T13:37:20-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SaleItemMapperImpl implements SaleItemMapper {

    @Override
    public SaleItemDomain entityToDomain(SaleItem entity) {
        if ( entity == null ) {
            return null;
        }

        SaleItemDomain saleItemDomain = new SaleItemDomain();

        saleItemDomain.setId( entity.getId() );
        saleItemDomain.setName( entity.getName() );
        saleItemDomain.setReference( entity.getReference() );
        saleItemDomain.setAmount( entity.getAmount() );
        saleItemDomain.setPrice( entity.getPrice() );
        saleItemDomain.setDeduction( entity.getDeduction() );

        return saleItemDomain;
    }

    @Override
    public SaleItem domainToEntity(SaleItemDomain domain) {
        if ( domain == null ) {
            return null;
        }

        SaleItem saleItem = new SaleItem();

        saleItem.setId( domain.getId() );
        saleItem.setName( domain.getName() );
        saleItem.setReference( domain.getReference() );
        saleItem.setAmount( domain.getAmount() );
        saleItem.setPrice( domain.getPrice() );
        saleItem.setDeduction( domain.getDeduction() );

        return saleItem;
    }
}
