package site.lbw.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.lbw.entity.VisitRecord;
import site.lbw.mapper.VisitRecordMapper;
import site.lbw.service.VisitRecordService;

@Service
public class VisitRecordServiceImpl implements VisitRecordService {
	@Autowired
	VisitRecordMapper visitRecordMapper;

	@Override
	public void saveVisitRecord(VisitRecord visitRecord) {
		visitRecordMapper.saveVisitRecord(visitRecord);
	}
}
