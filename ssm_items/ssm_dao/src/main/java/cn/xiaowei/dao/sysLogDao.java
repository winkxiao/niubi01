package cn.xiaowei.dao;

import cn.xiaowei.domain.sysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Description:
 * @author: winkxiao
 * @date: 2019/3/30 16:57
 */
public interface sysLogDao {


    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
     public void save(sysLog sl);

    // 查询日志信息
    @Select("select * from sysLog")
    /*@Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "visitTime",column = "visitTime"),
            @Result(property = "username",column = "username"),
            @Result(property = "ip",column = "ip"),
            @Result(property = "url",column = "url"),
            @Result(property = "executionTime",column = "executionTime"),
            @Result(property = "method",column = "method")
    })*/
    List<sysLog> findAll();
}
