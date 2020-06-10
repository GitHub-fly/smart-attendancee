package com.soft1851.springboot.smart.attendance.controller;

import com.soft1851.springboot.smart.attendance.model.dto.NoteDto;
import com.soft1851.springboot.smart.attendance.model.entity.SysNote;
import com.soft1851.springboot.smart.attendance.model.vo.NoteIdVo;
import com.soft1851.springboot.smart.attendance.model.vo.NoteVo;
import com.soft1851.springboot.smart.attendance.model.vo.StudentNoteVo;
import com.soft1851.springboot.smart.attendance.repository.SysNoteRepository;
import com.soft1851.springboot.smart.attendance.service.SysNoteService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ke
 * @ClassName InfoNote
 * @Description TOOD
 * @Date 2020/6/10
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "/api/note")
public class NoteController {

    @Resource
    private SysNoteService sysNoteService;
    @Resource
    private SysNoteRepository sysNoteRepository;

    @PostMapping("/increase")
    public NoteIdVo getPkNoteId(@RequestBody NoteDto noteDto) {
        return sysNoteService.findNoteId(noteDto);
    }


    /**
     * 查询假条信息
     *
     * @param sysNote 假条 id
     * @return
     */
    @PostMapping("/info")
    public NoteVo getNote(@RequestBody SysNote sysNote) {
        return sysNoteService.findNote(sysNote.getPkNoteId());
    }

    /**
     * 查询假条信息
     *
     * @param sysNote 假条 id
     * @return
     */
    @PostMapping("/student/all")
    public List<StudentNoteVo> getNoteStatus(@RequestBody SysNote sysNote) {
        return sysNoteService.findAllStatus(sysNote.getUserId());
    }

}
