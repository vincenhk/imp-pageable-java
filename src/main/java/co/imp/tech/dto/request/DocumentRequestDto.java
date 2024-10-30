package co.imp.tech.dto.request;

import co.imp.tech.dto.response.ExApprovalPicResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentRequestDto {
    private String title;
    private String content;
    private List<ApprovalRequestDto> exApprovalPics;
}
