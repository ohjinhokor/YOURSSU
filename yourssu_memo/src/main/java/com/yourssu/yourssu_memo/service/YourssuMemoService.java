package com.yourssu.yourssu_memo.service;

import com.yourssu.yourssu_memo.domain.DbMemo;
import com.yourssu.yourssu_memo.domain.Memo;
import com.yourssu.yourssu_memo.dtos.request.RequestCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowByPageMenuDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;
import com.yourssu.yourssu_memo.repository.MemoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class YourssuMemoService implements MemoService {
    private final MemoRepository memoRepository;

    @Override
    @Transactional
    public ResponseCreateMemoDto saveMemo(RequestCreateMemoDto requestCreateMemoDto) {

        Date now = new Date();

        DbMemo dbmemo = new DbMemo();
        dbmemo.setTitle(requestCreateMemoDto.getTitle());
        dbmemo.setText(requestCreateMemoDto.getText());

        dbmemo.setCreatedAt(now);
        dbmemo.setUpdatedAt(now);

        return memoRepository.save(dbmemo);
    }

    @Override
    @Transactional
    public ResponseUpdateMemoDto updateMemo(Long id, RequestUpdateMemoDto memo) {
        return memoRepository.update(id, memo);
    }

    @Override
    @Transactional
    public void deleteMemo(Long id){
        memoRepository.delete(id);
    }

    @Override
    public ResponseShowByPageMenuDto showMemoByPage(Date date, int page) {
        return memoRepository.showByPage(date, page);
    }

    @Override
    public ResponseShowMemoDto showMemoById(Long id) {
        return memoRepository.show(id);
    }
}


