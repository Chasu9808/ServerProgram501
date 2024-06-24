package com.busanit501.boot501.service;

import com.busanit501.boot501.domain.Member;
import com.busanit501.boot501.dto.MemberJoinDTO;
import com.busanit501.boot501.dto.upload.UploadResultDTO;
import org.springframework.web.multipart.MultipartFile;

public interface MemberService {
    // 중복 아이디 예외처리
    static class MidExistException extends Exception {

    }
    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;

    default Member dtoToEntity(MemberJoinDTO memberJoinDTO){

        Member member = Member.builder()
                .mid(memberJoinDTO.getMid())
                .mpw(memberJoinDTO.getMpw())
                .email(memberJoinDTO.getEmail())
                .uuid(memberJoinDTO.getUuid())
                .fileName(memberJoinDTO.getFileName())
                .build();

        // 첨부 이미지들이 추가
//        if(memberJoinDTO.getFileNames() != null) {
//            memberJoinDTO.getFileNames().forEach(fileName ->
//            {
//                String[] arr = fileName.split("_");
//                member.changeUuidFileName(arr[0],arr[1]);
//            }); // forEach 닫기
//        } // if 닫기
        return member;
    } // dtoToEntity 닫기.

    // entityToDTO
    // 화면(DTO) ->  컨트롤러 ->서비스(각 변환작업을함.) - Entity 타입으로 - DB
    default MemberJoinDTO entityToDTO(Member member) {
        MemberJoinDTO memberJoinDTO = MemberJoinDTO.builder()
                .mid(member.getMid())
                .mpw(member.getMpw())
                .email(member.getEmail())
                .uuid(member.getUuid())
                .fileName(member.getFileName())
                .build();



        return memberJoinDTO;
    }

    //프로필 이미지 업로드
    public UploadResultDTO uploadProfileImage(MultipartFile fileImageName);


}
