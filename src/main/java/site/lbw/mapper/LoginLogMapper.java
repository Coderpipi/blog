package site.lbw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.lbw.entity.LoginLog;

import java.util.List;

/**
 * @Description: 登录日志持久层接口
 * @Author: lbw
 * @Date: 2021-12-03
 */
@Mapper
@Repository
public interface LoginLogMapper {
	List<LoginLog> getLoginLogListByDate(String startDate, String endDate);

	int saveLoginLog(LoginLog log);

	int deleteLoginLogById(Long id);
}
