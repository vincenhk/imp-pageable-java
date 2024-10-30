package co.imp.tech.controller;

import co.imp.tech.dto.PaginationResponseDto;
import co.imp.tech.dto.request.DocumentRequestDto;
import co.imp.tech.dto.response.DocumentResponseDto;
import co.imp.tech.dto.response.ExDetailResponseDto;
import co.imp.tech.dto.response.ExDocumentResponseDto;
import co.imp.tech.service.ExDocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Document")
@RequiredArgsConstructor
public class ExDocumentController {
    private final ExDocumentService exDocumentService;

    @PostMapping("/request-doc")
    public ResponseEntity<?> requestDoc(@RequestBody DocumentRequestDto requestDto) {
        ExDocumentResponseDto responseDto = exDocumentService.create(requestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/request-monitor/{size}/{page}")
    public ResponseEntity<?> requestMonitor(@PathVariable int size,
                                            @PathVariable int page) throws Exception {
        PaginationResponseDto<DocumentResponseDto> responseDto = exDocumentService.getMonitor(size, page);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/request-monitor-wpic/{size}/{page}")
    public ResponseEntity<?> requestMonitorWithOutPic(@PathVariable int size,
                                                      @PathVariable int page) throws Exception {
        PaginationResponseDto<DocumentResponseDto> responseDto = exDocumentService.getMonitorWpic(size, page);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}
