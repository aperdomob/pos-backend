package syoux.apps.pos.services.mapper;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import syoux.apps.pos.domain.StocktakingDomain;
import syoux.apps.pos.repository.entity.Stocktaking;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-06-22T10:18:15-0500",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 12.0.1 (Oracle Corporation)"
)
@Component
public class StocktakingMapperImpl implements StocktakingMapper {

    @Override
    public StocktakingDomain entityToDomain(Stocktaking entity) {
        if ( entity == null ) {
            return null;
        }

        StocktakingDomain stocktakingDomain = new StocktakingDomain();

        stocktakingDomain.setId( entity.getId() );
        stocktakingDomain.setAvailable( entity.getAvailable() );
        stocktakingDomain.setLastCost( entity.getLastCost() );
        stocktakingDomain.setAverageCost( entity.getAverageCost() );

        return stocktakingDomain;
    }

    @Override
    public Stocktaking domainToEntity(StocktakingDomain domain) {
        if ( domain == null ) {
            return null;
        }

        Stocktaking stocktaking = new Stocktaking();

        stocktaking.setId( domain.getId() );
        stocktaking.setAvailable( domain.getAvailable() );
        stocktaking.setAverageCost( domain.getAverageCost() );
        stocktaking.setLastCost( domain.getLastCost() );

        return stocktaking;
    }
}
