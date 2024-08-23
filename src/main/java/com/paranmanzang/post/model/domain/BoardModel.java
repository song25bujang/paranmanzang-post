package com.paranmanzang.post.model.domain;
import com.paranmanzang.post.model.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardModel {
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
