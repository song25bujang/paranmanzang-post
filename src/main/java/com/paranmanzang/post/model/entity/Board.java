package com.paranmanzang.post.model.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@DynamicUpdate
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //jpa pk
    private Long id;
    private Long writerId;
    private String title;
    private String content;
    @Builder.Default
    private Long hits = 0L;
    @Builder.Default
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
