package com.guli.edu.controller.admin;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.guli.common.vo.R;
import com.guli.edu.com.guli.query.TeacherQuery;
import com.guli.edu.entity.Teacher;
import com.guli.edu.service.TeacherService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Api(description = "讲师管理")
@RestController
@CrossOrigin//跨域
@RequestMapping("/admin/edu/teacher")
@ApiModel("讲师后台管理")
public class TeacherAdminController {

    @Autowired
    public  TeacherService teacherService;

    @ApiOperation("查询讲师列表")
    @GetMapping
    public R list(){
        return R.ok().data("items",teacherService.list(null));
    }

    @ApiModelProperty("根据Id查询讲师")
    @GetMapping("{id}")
    public R getById(@ApiParam(name = "Id",value = "讲师Id",required = true)
                     @PathVariable Long id){
        Teacher teacher = teacherService.getById(id);
        if (teacher == null){
            return R.error();
        }
        return R.ok().message("查询成功").data("teacher", teacher);
    }
    @ApiOperation("通过Id删除讲师")
    @DeleteMapping("{id}")
    public R removeById(@PathVariable
        @ApiParam(name = "id",value = "讲师Id",required = true)
                                          String id){
        if (!teacherService.removeById(id)) {
            return R.error();
        }else
        return R.ok().message("删除成功").success(teacherService.removeById(id));
    }

    @ApiModelProperty(value = "分页查询")
    @GetMapping("{page}/{limit}")
    public R pageList(@PathVariable
                      @ApiParam(name = "page",value = "当前页码",required = true) Long page,

                      @PathVariable
                      @ApiParam(name = "limit",value = "每页记录数",required = true) Long limit
                    , @ApiParam(name = "teacherQuery",value = "查询对象",required = false)
                                  TeacherQuery teacherQuery){

        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        List<Teacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();

        return R.ok().data("pageList", records).data("total", total);
    }

    @ApiModelProperty(value = "添加讲师")
    @PutMapping("/save")
    public R save(@ApiParam(name = "添加对象",value = "讲师")
                    Teacher teacher){
        if (!teacherService.save(teacher)) {
            return R.error().success(false).message("添加失败");
        }
        return R.ok().success(true).message("添加成功");
    }

    @ApiModelProperty(value = "修改讲师")
    @PutMapping("/update")
    public R update(@ApiParam(name = "修改对象",value = "讲师")
                    Teacher teacher){
        if (!teacherService.update(teacher,null)) {
            return R.error().success(false).message("失败");
        }

        return R.ok().success(true).message("成功");
    }

}
