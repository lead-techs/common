package top.ibase4j.core.exception;

import top.ibase4j.core.support.HttpCode;

import static top.ibase4j.core.support.HttpCode.REQUEST_TIMEOUT;

/**
 * Created by HH on 2018-06-07.
 */
public class HttpProcessException extends BaseException{

    public HttpProcessException(Exception e){
        super(e);
    }

    /**
     * @param message	消息
     */
    public HttpProcessException(String message) {
        super(message);
    }

    @Override
    protected HttpCode getCode() {
        return REQUEST_TIMEOUT;
    }

    /**
     * @param message	异常消息
     * @param e			异常
     */
    public HttpProcessException(String message, Exception e) {
        super(message, e);
    }
}
