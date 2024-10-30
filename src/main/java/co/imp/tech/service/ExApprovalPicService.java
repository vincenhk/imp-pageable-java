package co.imp.tech.service;

import co.imp.tech.dto.request.ApprovalRequestDto;
import co.imp.tech.dto.response.ExApprovalPicResponseDto;
import co.imp.tech.model.ExApprovalPic;

import java.util.List;

public interface ExApprovalPicService {
    List<ExApprovalPic> create(List<ApprovalRequestDto> requestDto);
}
