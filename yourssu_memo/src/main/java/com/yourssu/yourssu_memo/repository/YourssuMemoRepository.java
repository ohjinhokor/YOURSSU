package com.yourssu.yourssu_memo.repository;

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
import java.util.Date;
import java.util.List;

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

    @Override
    public ResponseShowByPageMenuDto showByPage(Date searchDate, int page) {
        System.out.println("3");
        String searchDate1 = "2020-03-15";
        List<Memo> memoList = em.createQuery("select m from Memo m where m.createdAt<:searchDate", Memo.class)
                .setParameter("searchDate", searchDate1)
                .setFirstResult((page - 1) * 5)
                .setMaxResults((page) * 5 - 1)
                .getResultList();

        System.out.println("5");
        System.out.println("memoList = " + memoList);
        return new ResponseShowByPageMenuDto(memoList);

    }
}
