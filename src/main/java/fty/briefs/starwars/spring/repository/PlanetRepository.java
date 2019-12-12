package fty.briefs.starwars.spring.repository;

import fty.briefs.starwars.spring.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Franck THERY
 */
@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
}
