package site.lbw.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: 自定义爱好
 * @Author: lbw
 * @Date: 2021-08-09
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Favorite {
	private String title;
	private String content;
}
