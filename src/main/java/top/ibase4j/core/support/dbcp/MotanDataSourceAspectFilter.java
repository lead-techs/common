package top.ibase4j.core.support.dbcp;

import com.weibo.api.motan.core.extension.Activation;
import com.weibo.api.motan.core.extension.SpiMeta;
import com.weibo.api.motan.filter.Filter;
import com.weibo.api.motan.rpc.Caller;
import com.weibo.api.motan.rpc.Request;
import com.weibo.api.motan.rpc.Response;

/**
 * @author ShenHuaJie
 * @since 2018年4月24日 下午2:13:07
 */
@SpiMeta(name = "dataSourceAspect")
@Activation(sequence = 1)
public class MotanDataSourceAspectFilter implements Filter {
    @Override
    public Response filter(Caller<?> caller, Request request) {
        String service = caller.getInterface().getSimpleName();
        String method = request.getMethodName();
        HandleDataSource.setDataSource(service, method);
        return caller.call(request);
    }
}
