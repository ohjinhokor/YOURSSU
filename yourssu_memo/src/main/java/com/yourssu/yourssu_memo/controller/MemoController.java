package com.yourssu.yourssu_memo.controller;

import com.yourssu.yourssu_memo.dtos.request.RequestCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;
import com.yourssu.yourssu_memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/memos")
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @PostMapping
    @ResponseBody
    public ResponseCreateMemoDto saveMemo(@RequestBody RequestCreateMemoDto requestCreateMemoDto){
        return memoService.saveMemo(requestCreateMemoDto);
    }

    @PutMapping(path="{memoId}")
    @ResponseBody
    public ResponseUpdateMemoDto updateMemo(@PathVariable(name = "memoId") Long Id, @RequestBody RequestUpdateMemoDto requestUpdateMemoDto){
        return memoService.updateMemo(Id, requestUpdateMemoDto);
    }

    @DeleteMapping(path="{memoId}")
    @ResponseBody
    public void deleteMemo(@PathVariable(name = "memoId") Long Id){
        memoService.deleteMemo(Id);
    }
}
