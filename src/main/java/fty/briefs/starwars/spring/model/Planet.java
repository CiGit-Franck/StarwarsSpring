package fty.briefs.starwars.spring.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Franck THERY
 */
@Entity
@Table(name = "planets")
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "planet_name")
    private String planetName;
    @Column(name = "rotation_period")
    private Integer rotationPeriod;
    @Column(name = "orbital_period")
    private Integer orbitalPeriod;
    @Column(name = "diameter")
    private Integer diameter;
    @Column(name = "gravity")
    private Double gravity;
    @Column(name = "surface_water")
    private Integer surfaceWater;
    @Column(name = "population")
    private Long population;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "planet_terrains", joinColumns = @JoinColumn(name = "planet_idx"), inverseJoinColumns = @JoinColumn(name = "terrain_idx"))
    private Set<Terrain> planetTerrains = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "planet_climates", joinColumns = @JoinColumn(name = "planet_idx"), inverseJoinColumns = @JoinColumn(name = "climate_idx"))
    private Set<Climate> planetClimates = new HashSet<>();

    public Planet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Climate> getPlanetClimates() {
        return planetClimates;
    }

    public void setPlanetClimates(Set<Climate> planetClimates) {
        this.planetClimates = planetClimates;
    }

    public Set<Terrain> getPlanetTerrains() {
        return planetTerrains;
    }

    public void setPlanetTerrains(Set<Terrain> planetTerrains) {
        this.planetTerrains = planetTerrains;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public Integer getRotationPeriod() {
        return rotationPeriod;
    }

    public void setRotationPeriod(Integer rotationPeriod) {
        this.rotationPeriod = rotationPeriod;
    }

    public Integer getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public void setOrbitalPeriod(Integer orbitalPeriod) {
        this.orbitalPeriod = orbitalPeriod;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Double getGravity() {
        return gravity;
    }

    public void setGravity(Double gravity) {
        this.gravity = gravity;
    }

    public Integer getSurfaceWater() {
        return surfaceWater;
    }

    public void setSurfaceWater(Integer surfaceWater) {
        this.surfaceWater = surfaceWater;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

}
