package co.imp.tech.service.impl;

import co.imp.tech.dto.request.ApprovalRequestDto;
import co.imp.tech.dto.response.ExApprovalPicResponseDto;
import co.imp.tech.model.ExApprovalPic;
import co.imp.tech.repository.ExApprovalPicRepository;
import co.imp.tech.service.ExApprovalPicService;
import co.imp.tech.utils.GenericMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExApprovalPicServiceImpl implements ExApprovalPicService {

    private final ExApprovalPicRepository exApprovalPicRepository;

    @Override
    public List<ExApprovalPic> create(List<ApprovalRequestDto> requestDto) {

        List<ExApprovalPic> addData = new ArrayList<>();

        for(ApprovalRequestDto data : requestDto){
            ExApprovalPic ap = new ExApprovalPic();
            ap.setApprovedBy(data.getApprovedBy());
            ap.setApprovalPicUrl(data.getApprovalPicUrl());

            addData.add(ap);
        }

        return exApprovalPicRepository.saveAll(addData);
    }
}
