package com.joanne.loveandpeace;

import com.joanne.loveandpeace.domain.Notice;
import com.joanne.loveandpeace.repository.NoticeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeRepositoryTest {

    @Autowired
    NoticeRepository noticeRepository;

    @Test
    public void 공지사항등록및조회() {
        noticeRepository.save(
                Notice.builder()
                        .title("test")
                        .content("성공하자")
                        .build());

        List<Notice> notices = noticeRepository.findAll();

        Notice notice = notices.get(0);
        assertThat(notice.getTitle()).isEqualTo("test");
        assertThat(notice.getContent()).isEqualTo("성공하자");
    }
}
