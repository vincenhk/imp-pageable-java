package co.imp.tech.service;

import co.imp.tech.dto.PaginationResponseDto;
import co.imp.tech.dto.request.DocumentRequestDto;
import co.imp.tech.dto.response.DocumentResponseDto;
import co.imp.tech.dto.response.ExDetailResponseDto;
import co.imp.tech.dto.response.ExDocumentResponseDto;
import co.imp.tech.model.ExDocument;
import org.springframework.data.domain.Page;

public interface ExDocumentService {
    ExDocumentResponseDto create(DocumentRequestDto requestDto);

    PaginationResponseDto<DocumentResponseDto> getMonitor(int size, int page) throws Exception;
    PaginationResponseDto<DocumentResponseDto> getMonitorWpic(int size, int page) throws Exception;
}
