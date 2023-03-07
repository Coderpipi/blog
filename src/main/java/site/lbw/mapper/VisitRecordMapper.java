package site.lbw.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import site.lbw.entity.VisitRecord;

import java.util.List;

/**
 * @Description: 访问记录持久层接口
 * @Author: lbw
 * @Date: 2021-02-23
 */
@Mapper
@Repository
public interface VisitRecordMapper {
	List<VisitRecord> getVisitRecordListByLimit(Integer limit);

	int saveVisitRecord(VisitRecord visitRecord);
}
