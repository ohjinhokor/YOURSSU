package com.yourssu.yourssu_memo.dtos.request;

import lombok.Getter;

@Getter
public class RequestCreateMemoDto {
    private String title;

    private String text;

    public RequestCreateMemoDto(){

    }
}
