package site.lbw.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import site.lbw.constant.RedisKeyConstants;
import site.lbw.service.BlogService;
import site.lbw.service.RedisService;

import java.util.Map;
import java.util.Set;

/**
 * @Description: Redis相关定时任务
 * @Author: lbw
 * @Date: 2021-11-02
 */
@Component
public class RedisSyncScheduleTask {
	@Autowired
    RedisService redisService;
	@Autowired
    BlogService blogService;

	/**
	 * 从Redis同步博客文章浏览量到数据库
	 */
	public void syncBlogViewsToDatabase() {
		String redisKey = RedisKeyConstants.BLOG_VIEWS_MAP;
		Map blogViewsMap = redisService.getMapByHash(redisKey);
		Set<Integer> keys = blogViewsMap.keySet();
		for (Integer key : keys) {
			Integer views = (Integer) blogViewsMap.get(key);
			blogService.updateViews(key.longValue(), views);
		}
	}
}
