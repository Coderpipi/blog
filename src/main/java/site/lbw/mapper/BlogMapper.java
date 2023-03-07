package site.lbw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.lbw.model.dto.Blog;
import site.lbw.model.dto.BlogView;
import site.lbw.model.dto.BlogVisibility;
import site.lbw.model.vo.ArchiveBlog;
import site.lbw.model.vo.BlogDetail;
import site.lbw.model.vo.BlogInfo;
import site.lbw.model.vo.CategoryBlogCount;
import site.lbw.model.vo.NewBlog;
import site.lbw.model.vo.RandomBlog;
import site.lbw.model.vo.SearchBlog;

import java.util.List;

/**
 * @Description: 博客文章持久层接口
 * @Author: lbw
 * @Date: 2021-07-26
 */
@Mapper
@Repository
public interface BlogMapper {
	List<site.lbw.entity.Blog> getListByTitleAndCategoryId(String title, Integer categoryId);

	List<SearchBlog> getSearchBlogListByQueryAndIsPublished(String query);

	List<site.lbw.entity.Blog> getIdAndTitleList();

	List<NewBlog> getNewBlogListByIsPublished();

	List<BlogInfo> getBlogInfoListByIsPublished();

	List<BlogInfo> getBlogInfoListByCategoryNameAndIsPublished(String categoryName);

	List<BlogInfo> getBlogInfoListByTagNameAndIsPublished(String tagName);

	List<String> getGroupYearMonthByIsPublished();

	List<ArchiveBlog> getArchiveBlogListByYearMonthAndIsPublished(String yearMonth);

	List<RandomBlog> getRandomBlogListByLimitNumAndIsPublishedAndIsRecommend(Integer limitNum);

	List<BlogView> getBlogViewsList();

	int deleteBlogById(Long id);

	int deleteBlogTagByBlogId(Long blogId);

	int saveBlog(Blog blog);

	int saveBlogTag(Long blogId, Long tagId);

	int updateBlogRecommendById(Long blogId, Boolean recommend);

	int updateBlogVisibilityById(Long blogId, BlogVisibility bv);

	int updateBlogTopById(Long blogId, Boolean top);

	int updateViews(Long blogId, Integer views);

	site.lbw.entity.Blog getBlogById(Long id);

	String getTitleByBlogId(Long id);

	BlogDetail getBlogByIdAndIsPublished(Long id);

	String getBlogPassword(Long blogId);

	int updateBlog(Blog blog);

	int countBlog();

	int countBlogByIsPublished();

	int countBlogByCategoryId(Long categoryId);

	int countBlogByTagId(Long tagId);

	Boolean getCommentEnabledByBlogId(Long blogId);

	Boolean getPublishedByBlogId(Long blogId);

	List<CategoryBlogCount> getCategoryBlogCountList();
}
