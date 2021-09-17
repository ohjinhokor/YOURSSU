package com.yourssu.yourssu_memo.dtos.response;

import com.yourssu.yourssu_memo.domain.Memo;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseShowByPageMenuDto {

    private List<Memo> Memo;

    public ResponseShowByPageMenuDto(List<Memo> memoList) {
        Memo = memoList;
    }
}
