package com.paranmanzang.post.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@RequiredArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //jpa pk
    private Long id;
    private Long writerId;
    private String title;
    private String text;
    private Long hits;
    private LocalDateTime createdDate = LocalDateTime.now();
    private LocalDateTime modifiedDate;
    @Builder
    public Board(String title,String text,Long writerId,Long hits){
        this.title=title;
        this.text=text;
        this.writerId=writerId;
        this.hits=hits;
    }

}
