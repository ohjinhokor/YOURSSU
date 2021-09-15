//package com.yourssu.yourssu_memo.dtos.response;
//
//import com.yourssu.yourssu_memo.domain.Memo;
//import lombok.Getter;
//
//import javax.persistence.Column;
//import javax.persistence.Lob;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//@Getter
//public class ResponseCreateMemoDto {
//    private Long id;
//
//    private String title;
//
//    private String text;
//
//    private String createAt;
//
//    private String updateAt;
//
//    public ResponseCreateMemoDto(Memo memo) {
//        this.id = memo.getId();
//        this.title = memo.getTitle();
//        this.text = memo.getText();
//        this.createAt = memo.getCreateAt();
//        this.updateAt = memo.getUpdateAt();
//        System.out.println("===========================");
//    }
//}

package com.yourssu.yourssu_memo.dtos.response;

import com.yourssu.yourssu_memo.domain.Memo;
import lombok.Getter;

@Getter
public class ResponseCreateMemoDto {

    private Memo memo;

    public ResponseCreateMemoDto(Memo memo) {
        this.memo = memo;
    }
}
