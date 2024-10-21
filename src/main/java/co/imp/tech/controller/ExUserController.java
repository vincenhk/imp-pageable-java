package co.imp.tech.controller;

import co.imp.tech.dto.response.ExUserResponseDto;
import co.imp.tech.service.ExUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ExUserController {

    private final ExUserService exUserService;

    @GetMapping("/getData")
    public ResponseEntity<?> geExUser(@RequestParam int size,
                                      @RequestParam int page) {
        Page<?> exUser = exUserService.getExUser(page, size);
        return new ResponseEntity<>(exUser, HttpStatus.OK);
    }

    @GetMapping("/getDataList")
    public ResponseEntity<?> geExUserList(@RequestParam int size,
                                          @RequestParam int page) {
        List<?> exUser = exUserService.getExUserList(page, size);
        return new ResponseEntity<>(exUser, HttpStatus.OK);
    }

    @GetMapping("/getDetail")
    public ResponseEntity<?> getDetail(@RequestParam int size,
                                       @RequestParam int page) {
        List<ExUserResponseDto> exUser = exUserService.getDetail(page, size);
        return new ResponseEntity<>(exUser, HttpStatus.OK);
    }
}
