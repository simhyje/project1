package com.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Getter//클래스 내 모든 필드의 게터 메소드 자동 실행
@NoArgsConstructor//기본생성자 자동추가 (public Posts{}와 같은 효과)
@Entity//테이블과 링그될 클래스임을 표시
public class Posts extends BaseTimeEntity{

    @Id//해당 테이블의 PK 필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK의 생성규칙
    private Long id;

    @Column(length = 500, nullable = false)//테이블의 컬럼 선언하지 않아도 자동으로 컬럼
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;
    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
