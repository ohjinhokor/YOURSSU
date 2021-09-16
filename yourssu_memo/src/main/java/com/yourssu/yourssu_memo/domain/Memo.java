package com.yourssu.yourssu_memo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "memo_id")
    private Long id;

    @Column
    private String title;

    @Lob
    private String text;

    //@Temporal(TemporalType.TIMESTAMP)
    private String createdAt;

    //@Temporal(TemporalType.TIMESTAMP)
    private String updatedAt;

}
