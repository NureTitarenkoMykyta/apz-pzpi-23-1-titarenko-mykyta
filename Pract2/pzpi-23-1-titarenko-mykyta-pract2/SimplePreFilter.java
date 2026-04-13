public class SimplePreFilter extends ZuulFilter {
    
    @Override
    public String filterType() {
        return "pre";
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
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        
        ctx.addZuulRequestHeader("X-Netflix-Trace-Id", UUID.randomUUID().toString());
        
        return null;
    }
}