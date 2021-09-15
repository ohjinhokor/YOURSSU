package com.yourssu.yourssu_memo.repository;

import com.yourssu.yourssu_memo.domain.Memo;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;

public interface MemoRepository {

    ResponseCreateMemoDto save(Memo memo);

    ResponseUpdateMemoDto update(Long id, RequestUpdateMemoDto memo);

    void delete(Long id);
}
