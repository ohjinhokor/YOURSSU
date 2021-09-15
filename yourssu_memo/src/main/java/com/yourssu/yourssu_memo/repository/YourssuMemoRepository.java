package com.yourssu.yourssu_memo.repository;

import com.yourssu.yourssu_memo.domain.Memo;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class YourssuMemoRepository implements MemoRepository {

    private final EntityManager em;

    @Override
    public ResponseCreateMemoDto save(Memo memo) {
        em.persist(memo);

        ResponseCreateMemoDto responseCreateMemoDto = new ResponseCreateMemoDto(memo);

        return responseCreateMemoDto;
    }

    @Override
    public ResponseUpdateMemoDto update(Long id, RequestUpdateMemoDto memo) {
        Memo updateMemo = em.find(Memo.class, id);

        updateMemo.setTitle(memo.getTitle());
        updateMemo.setText(memo.getText());

        return new ResponseUpdateMemoDto(updateMemo);
    }

    public void delete(Long id) {
        Memo deleteMemo = em.find(Memo.class, id);
        em.remove(deleteMemo);
    }
}
