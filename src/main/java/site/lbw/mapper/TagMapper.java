package site.lbw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.lbw.entity.Tag;
import site.lbw.model.vo.TagBlogCount;

import java.util.List;

/**
 * @Description: 博客标签持久层接口
 * @Author: lbw
 * @Date: 2021-07-30
 */
@Mapper
@Repository
public interface TagMapper {
	List<Tag> getTagList();

	List<Tag> getTagListNotId();

	List<Tag> getTagListByBlogId(Long blogId);

	int saveTag(Tag tag);

	Tag getTagById(Long id);

	Tag getTagByName(String name);

	int deleteTagById(Long id);

	int updateTag(Tag tag);

	List<TagBlogCount> getTagBlogCount();
}
