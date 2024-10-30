package co.imp.tech.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExDocumentResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private List<ExApprovalPicResponseDto> exApprovalPics;
}
