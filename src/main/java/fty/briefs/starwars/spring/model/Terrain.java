package fty.briefs.starwars.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Franck THERY
 */
@Entity
@Table(name = "terrains")
public class Terrain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="terrain_name")
    private String terrainName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerrainName() {
        return terrainName;
    }

    public void setTerrainName(String terrainName) {
        this.terrainName = terrainName;
    }
    
}
