package site.lbw.service;

import site.lbw.model.dto.Blog;
import site.lbw.model.dto.BlogVisibility;
import site.lbw.model.vo.BlogDetail;
import site.lbw.model.vo.BlogInfo;
import site.lbw.model.vo.NewBlog;
import site.lbw.model.vo.PageResult;
import site.lbw.model.vo.RandomBlog;
import site.lbw.model.vo.SearchBlog;

import java.util.List;
import java.util.Map;

public interface BlogService {
	List<site.lbw.entity.Blog> getListByTitleAndCategoryId(String title, Integer categoryId);

	List<SearchBlog> getSearchBlogListByQueryAndIsPublished(String query);

	List<site.lbw.entity.Blog> getIdAndTitleList();

	List<NewBlog> getNewBlogListByIsPublished();

	PageResult<BlogInfo> getBlogInfoListByIsPublished(Integer pageNum);

	PageResult<BlogInfo> getBlogInfoListByCategoryNameAndIsPublished(String categoryName, Integer pageNum);

	PageResult<BlogInfo> getBlogInfoListByTagNameAndIsPublished(String tagName, Integer pageNum);

	Map<String, Object> getArchiveBlogAndCountByIsPublished();

	List<RandomBlog> getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend();

	void deleteBlogById(Long id);

	void deleteBlogTagByBlogId(Long blogId);

	void saveBlog(Blog blog);

	void saveBlogTag(Long blogId, Long tagId);

	void updateBlogRecommendById(Long blogId, Boolean recommend);

	void updateBlogVisibilityById(Long blogId, BlogVisibility blogVisibility);

	void updateBlogTopById(Long blogId, Boolean top);

	void updateViewsToRedis(Long blogId);

	void updateViews(Long blogId, Integer views);

	site.lbw.entity.Blog getBlogById(Long id);

	String getTitleByBlogId(Long id);

	BlogDetail getBlogByIdAndIsPublished(Long id);

	String getBlogPassword(Long blogId);

	void updateBlog(Blog blog);

	int countBlogByIsPublished();

	int countBlogByCategoryId(Long categoryId);

	int countBlogByTagId(Long tagId);

	Boolean getCommentEnabledByBlogId(Long blogId);

	Boolean getPublishedByBlogId(Long blogId);
}
