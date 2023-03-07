package site.lbw.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description: 关于我
 * @Author: lbw
 * @Date: 2021-08-31
 */
@NoArgsConstructor
@Getter
@Setter
@ToString
public class About {
	private Long id;
	private String nameEn;
	private String nameZh;
	private String value;
}
