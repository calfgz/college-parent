package cn.calfgz.college.edu.listener;

import cn.calfgz.college.common.util.exception.CustomException;
import cn.calfgz.college.edu.entity.Subject;
import cn.calfgz.college.edu.model.ExcelSubjectData;
import cn.calfgz.college.edu.service.SubjectService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @author calfgz
 * @description:
 * @date 2020-03-30 12:37
 */
@Slf4j
public class SubjectExcelListener extends AnalysisEventListener<ExcelSubjectData> {

    public SubjectService subjectService;

    public SubjectExcelListener() {}

    public SubjectExcelListener(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public void invoke(ExcelSubjectData data, AnalysisContext context) {
        if (data == null) {
            throw new CustomException(20001, "添加失败,data is null");
        }
        //添加一级分类
        Subject parentSubject = existOneSubject(subjectService, data.getParentName());
        if (parentSubject == null) {
            parentSubject = new Subject();
            parentSubject.setTitle(data.getParentName());
            parentSubject.setParentId("0");
            subjectService.save(parentSubject);
        }

        String pid = parentSubject.getId();
        Subject subject = existTwoSubject(subjectService, data.getSubjectName(), pid);
        if (subject == null) {
            subject = new Subject();
            subject.setTitle(data.getSubjectName());
            subject.setParentId(pid);
            subjectService.save(subject);
        }

    }

    //读取excel表头信息
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        log.info("表头信息:{}", headMap);
    }


    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    //判断一级分类是否重复
    private Subject existTwoSubject(SubjectService subjectService, String name, String pid) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        Subject subject = subjectService.getOne(wrapper);
        return subject;
    }

    //判断一级分类是否重复
    private Subject existOneSubject(SubjectService subjectService,String name) {
        QueryWrapper<Subject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        Subject subject = subjectService.getOne(wrapper);
        return subject;
    }
}
