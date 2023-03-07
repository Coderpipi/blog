package site.lbw.service;

import site.lbw.model.dto.Comment;
import site.lbw.model.vo.PageComment;

import java.util.List;

public interface CommentService {
	List<site.lbw.entity.Comment> getListByPageAndParentCommentId(Integer page, Long blogId, Long parentCommentId);

	List<PageComment> getPageCommentList(Integer page, Long blogId, Long parentCommentId);

	site.lbw.entity.Comment getCommentById(Long id);

	void updateCommentPublishedById(Long commentId, Boolean published);

	void updateCommentNoticeById(Long commentId, Boolean notice);

	void deleteCommentById(Long commentId);

	void deleteCommentsByBlogId(Long blogId);

	void updateComment(site.lbw.entity.Comment comment);

	int countByPageAndIsPublished(Integer page, Long blogId, Boolean isPublished);

	void saveComment(Comment comment);
}
