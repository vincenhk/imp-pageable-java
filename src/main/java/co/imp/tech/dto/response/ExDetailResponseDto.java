package co.imp.tech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExDetailResponseDto {
    private String id;
    private String title;
    private String content;
    private String description;
    private String mention;
}
