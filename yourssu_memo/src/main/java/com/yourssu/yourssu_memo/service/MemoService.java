package com.yourssu.yourssu_memo.service;

import com.yourssu.yourssu_memo.dtos.request.RequestCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowByPageMenuDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;

import java.util.Date;

public interface MemoService {

    ResponseCreateMemoDto saveMemo(RequestCreateMemoDto memo);

    ResponseUpdateMemoDto updateMemo(Long id, RequestUpdateMemoDto memo);

    void deleteMemo(Long id);

    ResponseShowByPageMenuDto showMemoByPage(Date date, int page);

    ResponseShowMemoDto showMemoById(Long id);
}
