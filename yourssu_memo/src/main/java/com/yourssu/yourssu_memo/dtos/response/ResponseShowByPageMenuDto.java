package com.yourssu.yourssu_memo.dtos.response;

import com.yourssu.yourssu_memo.domain.Memo;

import java.util.List;

public class ResponseShowByPageMenuDto {

    List<Memo> Memo;

    public ResponseShowByPageMenuDto(List<Memo> memoList) {
        Memo = memoList;
    }
}
