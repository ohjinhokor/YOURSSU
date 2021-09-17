package com.yourssu.yourssu_memo.repository;

import com.yourssu.yourssu_memo.domain.DbMemo;
import com.yourssu.yourssu_memo.domain.Memo;
import com.yourssu.yourssu_memo.dtos.request.RequestUpdateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseCreateMemoDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseShowByPageMenuDto;
import com.yourssu.yourssu_memo.dtos.response.ResponseUpdateMemoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        Date now = new Date();
        DbMemo updateMemo = em.find(DbMemo.class, id);

        updateMemo.setTitle(memo.getTitle());
        updateMemo.setText(memo.getText());
        updateMemo.setUpdatedAt(now);

        Memo newMemo = new Memo(updateMemo);
        return new ResponseUpdateMemoDto(newMemo);
    }

    public void delete(Long id) {
        DbMemo deleteMemo = em.find(DbMemo.class, id);
        em.remove(deleteMemo);
    }

    @Override
    public ResponseShowByPageMenuDto showByPage(Date searchDate, int page) {

        List<DbMemo> dbmemoList = em.createQuery("select m from DbMemo m where m.createdAt > :searchDate", DbMemo.class)
                .setParameter("searchDate", searchDate)
                .setFirstResult((page - 1) * 5)
                .setMaxResults((page) * 5 - 1)
                .getResultList();

        System.out.println("dbmemoList = " + dbmemoList);
        List<Memo> memoList = new ArrayList<>();

        for (DbMemo dbMemo : dbmemoList) {
            memoList.add(new Memo(dbMemo));
        }

        for ( DbMemo dbMemo : dbmemoList) {
            System.out.println("memo = " + dbMemo.getText());
        }
        return new ResponseShowByPageMenuDto(memoList);

    }
}
