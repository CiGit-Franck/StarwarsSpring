package fty.briefs.starwars.spring.StarWarsSpring;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StarWarsSpringApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    // Get list of planets
    @Test
    public void getPlanets() {
        // When retrieving cities from /api/starwars/planets
        List<?> planets = this.restTemplate.getForObject("/api/starwars/planets", List.class);

        // Then a non null list should be returned
        assertThat(planets).isNotNull();
    }

}
