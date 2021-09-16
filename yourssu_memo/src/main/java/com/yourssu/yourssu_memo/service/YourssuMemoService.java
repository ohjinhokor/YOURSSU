package com.yourssu.yourssu_memo.service;

import com.yourssu.yourssu_memo.domain.Memo;
import com.yourssu.yourssu_memo.dtos.request.RequestCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowByPageMenuDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;
import com.yourssu.yourssu_memo.repository.MemoRepository;
import javassist.Loader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

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

        memo.setCreatedAt(now);
        memo.setUpdatedAt(now);

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

    @Override
    public ResponseShowByPageMenuDto showMemoByPage(String date, int page) {
        System.out.println("2");
        //String date1 = "2000-04-05";
//        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
//        Date searchDate = fm.parse(date1);

        String date1 = "2020-03-15";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDate searchDate = LocalDate.parse(date1, formatter);
        //System.out.println("formatDateTime = " + formatDateTime);

        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        ParsePosition pos = new ParsePosition(0);
        Date searchDate = parser.parse(date1,pos);
        System.out.println("4");
        return memoRepository.showByPage(searchDate, page);
    }
}
