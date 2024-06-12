package com.busanit501.boot501.service;

import com.busanit501.boot501.domain.Reply;
import com.busanit501.boot501.dto.ReplyDTO;
import com.busanit501.boot501.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class ReplyServiceImpl implements ReplyService {

    private final ReplyRepository replyRepository;
    private final ModelMapper modelMapper;

    @Override
    public Long register(ReplyDTO replyDTO) {
        Reply reply = modelMapper.map(replyDTO,Reply.class);
        Long rno = replyRepository.save(reply).getRno();
        return rno;
    }
}
