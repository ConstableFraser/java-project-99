package hexlet.code.dto.status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusUpdateDTO {
    private String name;
    private String slug;
}