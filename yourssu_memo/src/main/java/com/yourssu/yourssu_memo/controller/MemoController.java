package com.yourssu.yourssu_memo.controller;

import com.yourssu.yourssu_memo.dtos.request.RequestCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowByPageMenuDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;
import com.yourssu.yourssu_memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@Controller
@RequestMapping(path="/memos")
@RequiredArgsConstructor
@ResponseBody
public class MemoController {

    private final MemoService memoService;

    @PostMapping
    public ResponseCreateMemoDto saveMemo(@RequestBody RequestCreateMemoDto requestCreateMemoDto) {
        return memoService.saveMemo(requestCreateMemoDto);
    }

    @PutMapping(path = "{memoId}")
    public ResponseUpdateMemoDto updateMemo(@PathVariable(name = "memoId") Long Id, @RequestBody RequestUpdateMemoDto requestUpdateMemoDto) {
        return memoService.updateMemo(Id, requestUpdateMemoDto);
    }

    @DeleteMapping(path = "{memoId}")
    public void deleteMemo(@PathVariable(name = "memoId") Long id) {
        memoService.deleteMemo(id);
    }

    @GetMapping
    public ResponseShowByPageMenuDto showMemoByPage(@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date, @RequestParam("page") int page) {
        return memoService.showMemoByPage(date, page);
    }

    @GetMapping(path="{memoId}")
    public ResponseShowMemoDto showMemoById(@PathVariable(name = "memoId") Long id){return memoService.showMemoById(id);}
}
