package site.lbw.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: 友链页面信息
 * @Author: lbw
 * @Date: 2021-09-09
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class FriendInfo {
	private String content;
	private Boolean commentEnabled;
}
