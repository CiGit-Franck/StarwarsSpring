package fty.briefs.starwars.spring.controler;

import fty.briefs.starwars.spring.model.Planet;
import fty.briefs.starwars.spring.repository.PlanetRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Franck THERY
 */
@RestController
@RequestMapping("/api/starwars/planets")
public class PlanetControler {

    private PlanetRepository planetRepository;

    public PlanetControler(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @GetMapping()
    public List<Planet> getAll() {
        return planetRepository.findAll();
    }

    @GetMapping("/{planetId}")
    public ResponseEntity<Planet> read(@PathVariable String planetId) {
        Long index = Long.parseLong(planetId);
        Optional<Planet> planet = planetRepository.findById(index);
        if (planet.isPresent()) {
            return ResponseEntity.ok(planet.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public void create(@RequestBody Planet newPlanet) {
        if (!getAll().contains(newPlanet)) {
            getAll().add(newPlanet);
            planetRepository.flush();
        }
    }

    @PutMapping()
    public void update(@RequestBody Planet newPlanet) {
        for (Planet planet : getAll()) {
            if (planet.getPlanetName().equalsIgnoreCase(newPlanet.getPlanetName())) {
                planetRepository.saveAndFlush(newPlanet);
            }
        }
    }

    @DeleteMapping("/{planetId}")
    public void delete(@PathVariable String planetId) {
        Long index = Long.parseLong(planetId);
        Optional<Planet> planet = planetRepository.findById(index);
        if (planet.isPresent()) {
            planetRepository.delete(planet.get());
        }
    }

}
