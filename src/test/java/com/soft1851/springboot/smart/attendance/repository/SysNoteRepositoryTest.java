package com.soft1851.springboot.smart.attendance.repository;

import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import com.soft1851.springboot.smart.attendance.util.DataTypeChange;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class SysNoteRepositoryTest {
    @Resource
    private SysNoteRepository sysNoteRepository;

    @Test
    void insert() {
        SysNote sysNote = SysNote.builder()
                .userId("001")
                .type(1)
                .userPhone("18851998839")
                .dayCount(2)
                .isDormitory(1)
                .isSchool(0)
                .startTime(new Timestamp(System.currentTimeMillis()))
                .finishTime(new Timestamp(System.currentTimeMillis()))
                .reason("我今天不舒服")
                .build();
        System.out.println(sysNoteRepository.save(sysNote));
        SysNote s = sysNoteRepository.save(sysNote);
        System.out.println(s.getPkNoteId());
    }

//    @Test
//    void findAllByPkNoteIdEquals() {
//        System.out.println( sysNoteRepository.findAllByPkNoteIdEquals(1));
//
//    }

    @Test
    void findNoteVoByPkNoteIdEquals() {
        System.out.println(sysNoteRepository.findNoteVoByPkNoteId(1l));
    }
}