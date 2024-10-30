package co.imp.tech.service.impl;

import co.imp.tech.dto.PaginationResponseDto;
import co.imp.tech.dto.request.DocumentRequestDto;
import co.imp.tech.dto.response.DocumentResponseDto;
import co.imp.tech.dto.response.ExDetailResponseDto;
import co.imp.tech.dto.response.ExDocumentResponseDto;
import co.imp.tech.model.ExDocument;
import co.imp.tech.repository.ExApprovalPicRepository;
import co.imp.tech.repository.ExDocumentRepository;
import co.imp.tech.service.ExApprovalPicService;
import co.imp.tech.service.ExDocumentService;
import co.imp.tech.utils.BuilderPageUtil;
import co.imp.tech.utils.GenericMapperUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExDocumentServiceImpl implements ExDocumentService {

    private final ExApprovalPicService exApprovalPicService;
    private final ExDocumentRepository exDocumentRepository;

    @Transactional
    @Override
    public ExDocumentResponseDto create(DocumentRequestDto requestDto) {
        ExDocument document = null;
        try{
            ExDocument doc = new ExDocument();
            doc.setContent(requestDto.getContent());
            doc.setTitle(requestDto.getTitle());

            document = exDocumentRepository.save(doc);
            document.setExApprovalPics(exApprovalPicService.create(requestDto.getExApprovalPics()));
            log.info("SUCCESS SAVE");
        }catch(Exception e){
            log.error(e.getMessage());
        }
        return GenericMapperUtil.toDto(document, ExDocumentResponseDto.class);
    }

    @Override
    public PaginationResponseDto<DocumentResponseDto> getMonitor(int size, int page) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        Page<ExDocument> responseDto = exDocumentRepository.getMonitor(pageable);

        if(responseDto.isEmpty())
            throw new Exception("Data not found!");

        return BuilderPageUtil.builderPageResponse(responseDto, DocumentResponseDto.class);
    }

    @Override
    public PaginationResponseDto<DocumentResponseDto> getMonitorWpic(int size, int page) throws Exception {
        Pageable pageable = PageRequest.of(page, size);
        Page<ExDocument> responseDto = exDocumentRepository.getMonitorWpic(pageable);
        if(responseDto.isEmpty())
            throw new Exception("Data not found!");
        return BuilderPageUtil.builderPageResponse(responseDto, DocumentResponseDto.class);
    }


}
