package com.testantd.demo.service.Impl;

import com.testantd.demo.bean.Notice;
import com.testantd.demo.mapper.NoticeMapper;
import com.testantd.demo.service.NoticeService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getNoticeList() {
        Example example = new Example(Notice.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andCondition("is_delete = ", 0);
        return noticeMapper.selectByExample(example);
    }
}
