package site.lbw.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: GitHub徽标
 * @Author: lbw
 * @Date: 2021-08-09
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Badge {
	private String title;
	private String url;
	private String subject;
	private String value;
	private String color;
}
