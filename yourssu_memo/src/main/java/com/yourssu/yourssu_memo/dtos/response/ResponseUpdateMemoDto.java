package com.yourssu.yourssu_memo.dtos.response;

import com.yourssu.yourssu_memo.domain.Memo;
import lombok.Getter;

@Getter
public class ResponseUpdateMemoDto {

    private Memo memo;

    public ResponseUpdateMemoDto(Memo memo) {
        this.memo = memo;
    }
}
