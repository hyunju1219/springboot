package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

    //컨테이너에 객체를 생성하는 방법
    //Component 가 붙은 클래스 찾아서 객체를 자동해줌

    //컨테이너는 객체의 생성 초기화 생명주기 관리를 담당하고 필요한 의존성을 자동으로 주입해줌
    //IOC 컨테이너에서 타입에 맞게 객체를 가져와 변수에 주소를 대입한다.
    @Autowired(required = false) //주입대상이 없으면 실행안함
    private D d;

    public void cCall() {
        System.out.println(d);
        System.out.println("C 객체에서 메소드 호출");
        d.dCall();
    }
}
