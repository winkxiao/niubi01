package cn.xiaowei.service.Impl;

import cn.xiaowei.dao.sysLogDao;
import cn.xiaowei.domain.sysLog;
import cn.xiaowei.service.sysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/30 16:34
 */
@Service
@Transactional
public class sysLogServiceImpl implements sysLogService {

    @Autowired
    private sysLogDao s;

    @Override
    public void saveLog(sysLog sl) {
        s.save(sl);
    }

    @Override
    public List<sysLog> findAll(Integer page, Integer size) {
        // 参数pageNum    页码值，pagesize 每页显示条数
        PageHelper.startPage(page,size);
        return s.findAll();
    }
}
