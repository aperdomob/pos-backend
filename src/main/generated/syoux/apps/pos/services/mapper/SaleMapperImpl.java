package syoux.apps.pos.services.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.domain.SaleDomain;
import syoux.apps.pos.repository.entity.Sale;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-22T13:37:20-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SaleMapperImpl implements SaleMapper {

    @Override
    public SaleDomain entityToDomain(Sale entity) {
        if ( entity == null ) {
            return null;
        }

        SaleDomain saleDomain = new SaleDomain();

        saleDomain.setId( entity.getId() );
        saleDomain.setDate( entity.getDate() );
        saleDomain.setStatus( entity.getStatus() );

        return saleDomain;
    }

    @Override
    public Sale domainToEntity(SaleDomain domain) {
        if ( domain == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setId( domain.getId() );
        sale.setDate( domain.getDate() );
        sale.setStatus( domain.getStatus() );

        return sale;
    }
}
