package co.imp.tech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExUserResponseDto {
    private Long id;
    private String name;
    private String email;
    private List<ExDetailResponseDto> exDetail;
}
