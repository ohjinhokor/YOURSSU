package com.yourssu.yourssu_memo.service;

import com.yourssu.yourssu_memo.dtos.request.RequestCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowByPageMenuDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;

public interface MemoService {

    ResponseCreateMemoDto saveMemo(RequestCreateMemoDto memo);

    ResponseUpdateMemoDto updateMemo(Long id, RequestUpdateMemoDto memo);

    void deleteMemo(Long id);

    ResponseShowByPageMenuDto showMemoByPage(String date, int page);
}
