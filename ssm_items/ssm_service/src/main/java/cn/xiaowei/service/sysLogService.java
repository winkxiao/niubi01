package cn.xiaowei.service;

import cn.xiaowei.domain.sysLog;

import java.util.List;

/**
 * @Description: 日志service接口
 * @author: winkxiao
 * @date: 2019/3/30 16:34
 */
public interface sysLogService {



    public void saveLog(sysLog sl);

    List<sysLog> findAll(Integer page, Integer size);
}
