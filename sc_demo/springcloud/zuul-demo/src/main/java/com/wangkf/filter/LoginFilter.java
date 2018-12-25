package com.wangkf.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by wangk on 2018-12-23.
 */
@Component //注入到spring容器
public class LoginFilter extends ZuulFilter {


    @Override
    public String filterType() {
        //pre 请求在路由之前执行
        //routing 在路由请求时调用
        //post 在routing和error过滤器之后调用
        //error 处理请求时发生错误调用
        return FilterConstants.PRE_TYPE; //pre 请求在路由之前执行
    }

    @Override
    public int filterOrder() {
        //过滤器执行级别顺序 在请求头之前
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true ;
    }

    @Override
    public Object run() throws ZuulException {
        //过滤器业务逻辑
        //获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        //获取request
        HttpServletRequest request =  ctx.getRequest();
        //获取请求参数access-token
        String token = request.getParameter("access-token");
        //判断是否存在
        if (StringUtils.isBlank(token)) {
            //不存在则拦截
            ctx.setSendZuulResponse(false);
            //返回403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        //不存在则拦截
        return null;
    }
}
