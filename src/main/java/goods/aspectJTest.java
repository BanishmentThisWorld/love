package goods;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class aspectJTest {
    @Before("execution(* goods.*.*(..) )")
    public void log(JoinPoint point) {

        System.out.println("日志输出");
        System.out.println("开始调用方法" + point.getSignature().getDeclaringTypeName() +
                "以及 " + point.getSignature().getName());
        System.out.println("参数是" + Arrays.toString(point.getArgs()));
        System.out.println("被织入的目标对象是" + point.getTarget());
    }

    @AfterReturning(value = "execution(* goods.*.*(..) )", returning = "returnValue")
    public void log(JoinPoint point, Object returnValue) {
        System.out.println("方法执行结束了" + point.getSignature().getName());
        System.out.println("返回值是" + returnValue);
    }
}
