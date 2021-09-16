package com.yourssu.yourssu_memo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Getter
public class Memo {

    private Long id;

    private String title;

    private String text;

    private String createAt;

    private String updateAt;

    public Memo(DbMemo dbMemo) {

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.id = dbMemo.getId();
        this.title = dbMemo.getTitle();
        this.text = dbMemo.getTitle();
        this.createAt = transFormat.format(dbMemo.getCreateAt());
        System.out.println(this.createAt.getClass());
        this.updateAt = transFormat.format(dbMemo.getUpdateAt());
        System.out.println("33333");
    }
}
