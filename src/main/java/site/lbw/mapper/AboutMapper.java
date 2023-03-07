package site.lbw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.lbw.entity.About;

import java.util.List;

/**
 * @Description: 关于我持久层接口
 * @Author: lbw
 * @Date: 2021-08-31
 */
@Mapper
@Repository
public interface AboutMapper {
	List<About> getList();

	int updateAbout(String nameEn, String value);

	String getAboutCommentEnabled();
}
