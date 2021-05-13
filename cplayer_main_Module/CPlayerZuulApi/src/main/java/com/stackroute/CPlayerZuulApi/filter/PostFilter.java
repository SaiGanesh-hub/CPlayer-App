package com.stackroute.CPlayerZuulApi.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

public class PostFilter extends ZuulFilter {
    private static Logger logger = (Logger) LoggerFactory.getLogger(PostFilter.class);

    @Override
    public String filterType() {
        return "Post Filter";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("Inside Response filter");
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        logger.info("postfilter"+response.getStatus());
        return null;
    }

}
