package site.lbw.model.vo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: 标签和博客数量
 * @Author: lbw
 * @Date: 2021-10-08
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TagBlogCount {
	private Long id;
	private String name;//标签名
	private Integer value;//标签下博客数量
}
