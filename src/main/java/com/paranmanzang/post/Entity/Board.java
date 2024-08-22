package com.paranmanzang.post.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //jpa pk
    private Long id;
    private Long writerId;
    private String title;
    private String content;
    private Long hits;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;
    @Builder
    public Board(String title,String content,Long writerId,Long hits){
        this.title=title;
        this.content=content;
        this.writerId=writerId;
        this.hits=hits;
    }

}
