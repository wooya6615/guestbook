package com.example.guestbook.service;

import com.example.guestbook.entity.Guestbook;
import com.example.guestbook.dto.GuestbookDTO;
import java.util.List;

public interface GuestbookService {
    Long register(GuestbookDTO dto);
    List<GuestbookDTO> getList();
    GuestbookDTO read(Long gno); // 메서드 선언

    default Guestbook dtoToEntity(GuestbookDTO dto){
        return Guestbook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();
    }

    default GuestbookDTO entityToDto(Guestbook entity){
        return GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .build();
    }
}