package com.paranmanzang.post.DTO;

import com.paranmanzang.post.Entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Date;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long writerId;
    private String title;
    private String content;
    private Long hits;
    private Date createdDate;
    public Board toEntity(){
        return Board.builder()
                .title(title).content(content).hits(0L).writerId(1L).
                createdDate(LocalDateTime.now()).
                build();
    }


}
