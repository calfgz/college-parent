package cn.calfgz.college.edu.controller;


import cn.calfgz.college.common.util.rest.CommonResponse;
import cn.calfgz.college.common.util.rest.CommonResult;
import cn.calfgz.college.edu.entity.Chapter;
import cn.calfgz.college.edu.service.ChapterService;
import cn.calfgz.college.common.admin.edu.vo.ChapterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author calfgz
 * @since 2020-03-30
 */
@RestController
@RequestMapping("/edu/chapter")
@CrossOrigin
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("nested-list/{courseId}")
    public CommonResult nestedListByCourseId(@PathVariable String courseId){
        List<ChapterVo> chapterVoList = chapterService.nestedList(courseId);
        return CommonResponse.okRsp(chapterVoList);
    }

    @PostMapping
    public CommonResult save(@RequestBody Chapter chapter){
        chapterService.save(chapter);
        return CommonResponse.okRsp();
    }

    @GetMapping("{id}")
    public CommonResult getById(@PathVariable String id){
        Chapter chapter = chapterService.getById(id);
        return CommonResponse.okRsp(chapter);
    }

    @PutMapping("{id}")
    public CommonResult updateById(@PathVariable String id, @RequestBody Chapter chapter){
        chapter.setId(id);
        chapterService.updateById(chapter);
        return CommonResponse.okRsp();
    }

    @DeleteMapping("{id}")
    public CommonResult removeById(@PathVariable String id){
        boolean result = chapterService.removeChapterById(id);
        if(result){
            return CommonResponse.okRsp();
        }else{
            return CommonResponse.errRsp("删除失败");
        }
    }

}

