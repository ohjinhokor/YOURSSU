package com.yourssu.yourssu_memo.service;

import com.yourssu.yourssu_memo.domain.Memo;
import com.yourssu.yourssu_memo.dtos.request.RequestCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;
import com.yourssu.yourssu_memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class YourssuMemoService implements MemoService {
    private final MemoRepository memoRepository;

    @Override
    @Transactional
    public ResponseCreateMemoDto saveMemo(RequestCreateMemoDto requestCreateMemoDto) {

        SimpleDateFormat time = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");

        String now = time.format(System.currentTimeMillis());

        Memo memo = new Memo();
        memo.setTitle(requestCreateMemoDto.getTitle());
        memo.setText(requestCreateMemoDto.getText());

        memo.setCreateAt(now);
        memo.setUpdateAt(now);

        return memoRepository.save(memo);
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
}
