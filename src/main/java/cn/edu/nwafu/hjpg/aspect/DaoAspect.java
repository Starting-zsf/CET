package cn.edu.nwafu.hjpg.aspect;


import cn.edu.nwafu.hjpg.utils.SecurityUtils;
import cn.edu.nwafu.hjpg.utils.StringUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * DAO切面，插入创建时间，修改时间
 */
@Aspect
@Component
@Configuration
public class DaoAspect {
	//	private static final String createBy = "createBy";
	private static final String gmtCreate = "gmtCreate";
	//	private static final String lastUpdateBy = "lastUpdateBy";
	private static final String gmtModified = "gmtModified";

	@Pointcut("execution(* cn.edu.nwafu.hjpg.dao.*.save(..))")
	public void daoUpdate() {
	}

	@Pointcut("execution(* cn.edu.nwafu.hjpg.dao.*.insert(..))")
	public void daoCreate() {
	}

	@Around("daoUpdate()")
	public Object doAroundUpdate(ProceedingJoinPoint pjp) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null) {
			return pjp.proceed();
		}
		HttpServletRequest request = attributes.getRequest();
		String token = request.getHeader("token");
		String username = getUserName();
		if (token != null && username != null) {
			Object[] objects = pjp.getArgs();
			if (objects != null && objects.length > 0) {
				for (Object arg : objects) {
					BeanUtils.setProperty(arg, gmtModified, new Date());
				}
			}
		}
		Object object = pjp.proceed();
		return object;

	}

	@Around("daoCreate()")
	public Object doAroundCreate(ProceedingJoinPoint pjp) throws Throwable {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		if (attributes == null) {
			return pjp.proceed();
		}
		Object[] objects = pjp.getArgs();
		if (objects != null && objects.length > 0) {
			for (Object arg : objects) {
//				String username = getUserName();
//				if (username != null) {
//
//
//				}
				if (StringUtils.isBlank(BeanUtils.getProperty(arg, gmtCreate))) {
					BeanUtils.setProperty(arg, gmtCreate, new Date());
				}
			}
		}
		Object object = pjp.proceed();
		return object;
	}

	private String getUserName() {
		return SecurityUtils.getUsername();
	}
}
