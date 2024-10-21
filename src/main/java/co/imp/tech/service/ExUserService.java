package co.imp.tech.service;

import co.imp.tech.dto.response.ExUserResponseDto;
import co.imp.tech.model.ExUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExUserService {
    Page<ExUser> getExUser(int page, int size);
    List<ExUser> getExUserList(int page, int size);
    List<ExUserResponseDto> getDetail(int page, int size);
}
