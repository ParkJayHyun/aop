package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 참고 : 생성자 주입은 순환 사이클을 만들기 때문에 실패한다.
 * Srpingboot 2.6버전 이후에는 생성자를 자기 자신에 넣을 경우 내부 순환 사이클이 발생함으로
 * spring.main.allow-circular-references=true 를 추가해준다.
 */
@Slf4j
@Component
public class CallServiceV1 {

    private CallServiceV1 callServiceV1;

    @Autowired
    public void setCallServiceV1(CallServiceV1 callServiceV1) {
        this.callServiceV1 = callServiceV1;
    }

    public void external() {
        log.info("call external");
        callServiceV1.internal();   //외부 메서드 호출
    }

    public void internal() {
        log.info("call internal");
    }

}
