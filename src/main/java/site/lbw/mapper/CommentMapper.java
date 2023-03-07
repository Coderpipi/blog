package site.lbw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.lbw.model.dto.Comment;
import site.lbw.model.vo.PageComment;

import java.util.List;

/**
 * @Description: 博客评论持久层接口
 * @Author: lbw
 * @Date: 2021-08-03
 */
@Mapper
@Repository
public interface CommentMapper {
	List<site.lbw.entity.Comment> getListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId);

	List<site.lbw.entity.Comment> getListByParentCommentId(Long parentCommentId);

	List<PageComment> getPageCommentListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId);

	site.lbw.entity.Comment getCommentById(Long id);

	int updateCommentPublishedById(Long commentId, Boolean published);

	int updateCommentNoticeById(Long commentId, Boolean notice);

	int deleteCommentById(Long commentId);

	int deleteCommentsByBlogId(Long blogId);

	int updateComment(site.lbw.entity.Comment comment);

	int countByPageAndIsPublished(Integer page, Long blogId, Boolean isPublished);

	int countComment();

	int saveComment(Comment comment);
}
