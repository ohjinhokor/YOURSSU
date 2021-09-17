package com.yourssu.yourssu_memo.repository;

import com.yourssu.yourssu_memo.domain.DbMemo;
import com.yourssu.yourssu_memo.domain.Memo;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowByPageMenuDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public interface MemoRepository {

    ResponseCreateMemoDto save(DbMemo memo);

    ResponseUpdateMemoDto update(Long id, RequestUpdateMemoDto memo);

    void delete(Long id);

    ResponseShowByPageMenuDto showByPage(Date searchDate, int page);

    ResponseShowMemoDto show(Long id);
}
