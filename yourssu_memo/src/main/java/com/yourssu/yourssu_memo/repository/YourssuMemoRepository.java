package com.yourssu.yourssu_memo.repository;

import com.yourssu.yourssu_memo.domain.DbMemo;
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
    public ResponseCreateMemoDto save(DbMemo dbMemo) {
        em.persist(dbMemo);

        Memo memo = new Memo(dbMemo);
        ResponseCreateMemoDto responseCreateMemoDto = new ResponseCreateMemoDto(memo);

        return responseCreateMemoDto;
    }

    @Override
    public ResponseUpdateMemoDto update(Long id, RequestUpdateMemoDto memo) {

        DbMemo updateMemo = em.find(DbMemo.class, id);

        updateMemo.setTitle(memo.getTitle());
        updateMemo.setText(memo.getText());

        Memo newMemo = new Memo(updateMemo);
        return new ResponseUpdateMemoDto(newMemo);
    }

    public void delete(Long id) {
        DbMemo deleteMemo = em.find(DbMemo.class, id);
        em.remove(deleteMemo);
    }
}
