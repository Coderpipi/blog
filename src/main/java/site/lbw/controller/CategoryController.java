package site.lbw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.lbw.enums.VisitBehavior;
import site.lbw.annotation.VisitLogger;
import site.lbw.model.vo.BlogInfo;
import site.lbw.model.vo.PageResult;
import site.lbw.model.vo.Result;
import site.lbw.service.BlogService;

/**
 * @Description: 分类
 * @Author: lbw
 * @Date: 2021-08-19
 */
@RestController
public class CategoryController {
	@Autowired
	BlogService blogService;

	/**
	 * 根据分类name分页查询公开博客列表
	 *
	 * @param categoryName 分类name
	 * @param pageNum      页码
	 * @return
	 */
	@VisitLogger(VisitBehavior.CATEGORY)
	@GetMapping("/category")
	public Result category(@RequestParam String categoryName,
	                       @RequestParam(defaultValue = "1") Integer pageNum) {
		PageResult<BlogInfo> pageResult = blogService.getBlogInfoListByCategoryNameAndIsPublished(categoryName, pageNum);
		return Result.ok("请求成功", pageResult);
	}
}
