package com.guli.edu.com.guli.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel(value = "Teacher查询封装",description = "讲师查询对象封装")
public class TeacherQuery implements Serializable {
    private static final Long serialVersionUID = 1L;

    @ApiModelProperty(value = "讲师名字，模糊查询")
    private String name;

    @ApiModelProperty(value = "头衔 1高级讲师，2 首席讲师")
    private Integer level;

    @ApiModelProperty(value = "查询开始时间",example = "2020-08=08 10:10:10")
    private String begin;

    @ApiModelProperty(value = "查询结束时间",example = "2020-08-08 10:10:10")
    private String end;

}
