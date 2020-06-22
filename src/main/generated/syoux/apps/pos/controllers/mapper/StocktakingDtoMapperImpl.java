package syoux.apps.pos.controllers.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.controllers.dto.StocktakingDto;
import syoux.apps.pos.domain.StocktakingDomain;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-22T10:23:00-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class StocktakingDtoMapperImpl implements StocktakingDtoMapper {

    @Override
    public StocktakingDomain dtoToDomain(StocktakingDto dto) {
        if ( dto == null ) {
            return null;
        }

        StocktakingDomain stocktakingDomain = new StocktakingDomain();

        stocktakingDomain.setId( dto.getId() );
        stocktakingDomain.setAvailable( dto.getAvailable() );
        stocktakingDomain.setLastCost( dto.getLastCost() );
        stocktakingDomain.setAverageCost( dto.getAverageCost() );

        return stocktakingDomain;
    }

    @Override
    public StocktakingDto domainToDto(StocktakingDomain entity) {
        if ( entity == null ) {
            return null;
        }

        StocktakingDto stocktakingDto = new StocktakingDto();

        stocktakingDto.setId( entity.getId() );
        stocktakingDto.setAvailable( entity.getAvailable() );
        stocktakingDto.setLastCost( entity.getLastCost() );
        stocktakingDto.setAverageCost( entity.getAverageCost() );

        return stocktakingDto;
    }
}
