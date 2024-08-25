package com.ncjh.justprac.model;

import com.ncjh.justprac.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private String title;
    private String content;

    @Builder
    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }

}
