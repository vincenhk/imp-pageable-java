package co.imp.tech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentResponseDto {
    private Long id;
    private String approvedBy;
    private LocalDateTime approvalDate;
}
