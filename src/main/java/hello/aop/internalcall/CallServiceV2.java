package hello.aop.internalcall;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * ObjectProvider(Provider), ApplicationContext를 사용해서 지연(LAZY) 조회
 * applicationContext은 너무 많은 기능을 제공하고 있으므로 ObjectProvider를 사용한다.
 * ObjectProvider.getObject() 를 호출하는 시점에 스프링 컨테이너에서 빈을 조회한다.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV2 {

    //    private final ApplicationContext applicationContext;
    private final ObjectProvider<CallServiceV2> callServiceProvider;

    public void external() {
        log.info("call external");
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceProvider.getObject();
        callServiceV2.internal();
    }

    public void internal() {
        log.info("call internal");
    }
}
