package com.guli.edu.service.impl;

import com.guli.edu.entity.Comment;
import com.guli.edu.mapper.CommentMapper;
import com.guli.edu.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author Likun
 * @since 2020-08-04
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

}
