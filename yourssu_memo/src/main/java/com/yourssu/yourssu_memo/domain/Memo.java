package com.yourssu.yourssu_memo.domain;

import lombok.Getter;
import java.text.SimpleDateFormat;

@Getter
public class Memo {

    private Long id;

    private String title;

    private String text;

    private String createdAt;

    private String updatedAt;

    public Memo(){

    }
    public Memo(DbMemo dbMemo) {

        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        this.id = dbMemo.getId();
        this.title = dbMemo.getTitle();
        this.text = dbMemo.getText();
        this.createdAt = transFormat.format(dbMemo.getCreatedAt());
        this.updatedAt = transFormat.format(dbMemo.getUpdatedAt());
    }
}
