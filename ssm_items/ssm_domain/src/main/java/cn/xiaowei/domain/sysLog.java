package cn.xiaowei.domain;

import cn.xiaowei.utils.dateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @Description: 日志实体类
 * @author: winkxiao
 * @date: 2019/3/29 22:28
 */
public class sysLog {

    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date visitTime;
    private String visitTimeStr;
    private String username;
    private String ip;
    private String url;
    private Long executionTime;
    private String method;

    @Override
    public String toString() {
        return "sysLog{" +
                "id='" + id + '\'' +
                ", visitTime=" + visitTime +
                ", visitTimeStr='" + visitTimeStr + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", executionTime=" + executionTime +
                ", method='" + method + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() throws ParseException {
        if (visitTime != null){
            visitTimeStr = dateUtils.date2String(visitTime, "yyyy-MM-dd HH:mm");
        }
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Long executionTime) {
        this.executionTime = executionTime;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
