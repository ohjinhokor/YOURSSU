package com.yourssu.yourssu_memo.dtos.response;

import com.yourssu.yourssu_memo.domain.Memo;
import lombok.Getter;

@Getter
public class ResponseShowMemoDto {

    private Memo memo;

    public ResponseShowMemoDto(Memo memo) {
        this.memo = memo;
    }
}
