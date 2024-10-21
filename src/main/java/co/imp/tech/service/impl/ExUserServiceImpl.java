package co.imp.tech.service.impl;

import co.imp.tech.dto.response.ExUserResponseDto;
import co.imp.tech.model.ExUser;
import co.imp.tech.repository.ExUserRepository;
import co.imp.tech.service.ExUserService;
import co.imp.tech.utils.GenericMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExUserServiceImpl implements ExUserService {

    private final ExUserRepository exUserRepository;

    @Override
    public Page<ExUser> getExUser(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        return exUserRepository.findAllBy(pageable);
    }

    @Override
    public List<ExUser> getExUserList(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("email").descending());
        return exUserRepository.findAllCustom(pageable);
    }

    @Override
    public List<ExUserResponseDto> getDetail(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<ExUser> responseDto = exUserRepository.findDetail(pageable);
        return GenericMapperUtil.toDtoList(responseDto, ExUserResponseDto.class );
    }
}
