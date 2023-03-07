package site.lbw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.lbw.model.dto.Friend;

import java.util.List;

/**
 * @Description: 友链持久层接口
 * @Author: lbw
 * @Date: 2021-09-08
 */
@Mapper
@Repository
public interface FriendMapper {
	List<site.lbw.entity.Friend> getFriendList();

	List<site.lbw.model.vo.Friend> getFriendVOList();

	int updateFriendPublishedById(Long id, Boolean published);

	int saveFriend(site.lbw.entity.Friend friend);

	int updateFriend(Friend friend);

	int deleteFriend(Long id);

	int updateViewsByNickname(String nickname);
}
