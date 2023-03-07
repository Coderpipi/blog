package site.lbw.service;

import site.lbw.model.dto.Friend;
import site.lbw.model.vo.FriendInfo;

import java.util.List;

public interface FriendService {
	List<site.lbw.entity.Friend> getFriendList();

	List<site.lbw.model.vo.Friend> getFriendVOList();

	void updateFriendPublishedById(Long friendId, Boolean published);

	void saveFriend(site.lbw.entity.Friend friend);

	void updateFriend(Friend friend);

	void deleteFriend(Long id);

	void updateViewsByNickname(String nickname);

	FriendInfo getFriendInfo(boolean cache, boolean md);

	void updateFriendInfoContent(String content);

	void updateFriendInfoCommentEnabled(Boolean commentEnabled);
}
