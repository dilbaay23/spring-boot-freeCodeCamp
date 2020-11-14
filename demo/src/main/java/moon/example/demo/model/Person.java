package moon.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;


import java.util.UUID;

@Data // bu anotasyon kullaninca consructor getter ve setterlar yazmaya gerek yok
public class Person {
    private final UUID id;

    @NotBlank
    private final String name;

    public Person(@JsonProperty("id") UUID id,
                  @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }


}
