package com.example.guestbook.dto;

import lombok.*;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDTO{
    private Long gno;              // 게시글 번호
    private String title;          // 제목
    private String content;        // 내용
    private String writer;         // 작성자
    private LocalDateTime regDate; // 등록 시간
}
