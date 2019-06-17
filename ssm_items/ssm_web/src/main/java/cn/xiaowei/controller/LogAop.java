package cn.xiaowei.controller;

import cn.xiaowei.domain.sysLog;
import cn.xiaowei.service.sysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;



import javax.servlet.http.HttpServletRequest;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;

/**
 * @Description: 日志通知类
 * @author: winkxiao
 * @date: 2019/3/29 22:35
 */
@Component
@Aspect// 声明切面
public class LogAop {

    // 用来获取URL
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private sysLogService sysLogService;
    // 访问的时间
    private Date visitTime;
    // 访问的类
    private Class clazz;
    // 访问的方法
    private Method method;

    /** 前置通知
     *  获取开始时间，执行那个类，执行的哪个方法
     * @param pj
     */
    @Before("execution(* cn.xiaowei.controller.*.*(..))")
    public void doBefore(JoinPoint pj) throws Exception {
        // 获取访问开始时间
        visitTime = new Date();
        // 获得访问的类class对象
        clazz = pj.getTarget().getClass();
        // 获得访问方法的所有参数
        Object[] args = pj.getArgs();
        // 获得方法的名字
        String methodName = pj.getSignature().getName();

        // 获取具体执行的method对象
        // 判断方法是否有参数
        if (args == null||args.length == 0){
            // 反射获得方法对象
            method = clazz.getMethod(methodName);

        }else { // 有参数的方法对象
            // 将所有参数获得class对象，存入class数组总
            Class[] argClass = new Class[args.length];
            for (int i = 0; i < argClass.length; i++) {
                argClass[i] = args[i].getClass();
            }
                method = clazz.getMethod(methodName,argClass);
        }

        

    }




    /**
     * 功能描述:
     * 〈后置通知〉
     * @return : void
     * @author : WinkXiao
     * @date : 2019/3/30 10:04
     */
    @After("execution(* cn.xiaowei.controller.*.*(..))")
    public void doAfter(JoinPoint pj){
        // 访问结束时间
        Date endTime = new Date();
        // 访问的时间
        long time = endTime.getTime() - visitTime.getTime();

        // 获得url
        String url ="";
        // 类对象不为空，方法对象不为空，不为日志类
        if (clazz != null&&method!= null&&clazz != LogAop.class && clazz != sysLogCont.class) {
            // 1.获取类上的注解 @RequestMapping("/findAll")
            RequestMapping classAnnot = (RequestMapping) clazz.getAnnotation(RequestMapping.class);

            if (classAnnot != null) {
                // 获得注解里的value
                String[] classsValue = classAnnot.value();

                // 2.获得方法上的注解
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                // 方法注解的value
                String[] methodValue = methodAnnotation.value();

                url = classsValue[0] + methodValue[0];
            }


            // 获取ip
            String ip = request.getRemoteAddr();

            //获取当前登录用户
            SecurityContext context = SecurityContextHolder.getContext();
            // 获得登录用户的username【security框架的】
            User user = (User) context.getAuthentication().getPrincipal();
            String username = user.getUsername();

            // 封装日志信息
            sysLog syslog = new sysLog();
            syslog.setExecutionTime(time);
            syslog.setUrl(url);
            syslog.setUsername(username);
            syslog.setIp(ip);
            syslog.setMethod("[类名]：" + clazz.getName() + "[方法名]：" + method.getName());
            syslog.setVisitTime(visitTime);
            // 插入数据
            sysLogService.saveLog(syslog);
        }
    }
}
