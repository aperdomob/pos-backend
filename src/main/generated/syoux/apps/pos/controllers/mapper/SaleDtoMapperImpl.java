package syoux.apps.pos.controllers.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.dto.SaleDto;
import syoux.apps.pos.repository.entity.Sale;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-18T19:58:11-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class SaleDtoMapperImpl implements SaleDtoMapper {

    @Override
    public Sale dtoToEntity(SaleDto dto) {
        if ( dto == null ) {
            return null;
        }

        Sale sale = new Sale();

        sale.setId( dto.getId() );
        sale.setDate( dto.getDate() );
        sale.setStatus( dto.getStatus() );

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

        return saleDto;
    }
}
