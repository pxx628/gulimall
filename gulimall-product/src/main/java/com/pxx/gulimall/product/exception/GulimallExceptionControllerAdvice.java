package com.pxx.gulimall.product.exception;

import com.pxx.gulimall.common.exception.BizException;
import com.pxx.gulimall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = "com.pxx.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {
    /**
     * 当能精确异常类型的时候会默认执行精确的异常处理器，否则会执行最大的异常处理器
     * @param e
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R entityExceptionHandler(MethodArgumentNotValidException e){
        log.error("异常类型：{}，数据校验异常：{}",e.getClass(),e.getMessage());
        BindingResult result = e.getBindingResult();
        Map<String,String> map=new HashMap<>();
            result.getFieldErrors().forEach(item->{
                //获取请求错误的列名
                String field = item.getField();
                //获取默认错误提示
                String message = item.getDefaultMessage();
                map.put(field,message);
            });
        return R.error(BizException.VALID_EXCEPTION.getCode(), BizException.VALID_EXCEPTION.getMsg()).put("data",map);

    }

    @ExceptionHandler(value = Throwable.class)
    public R largeExceptionHandler(Throwable throwable){

        return R.error(BizException.UNKNOWN_EXCEPTION.getCode(), BizException.UNKNOWN_EXCEPTION.getMsg());
    }
}
