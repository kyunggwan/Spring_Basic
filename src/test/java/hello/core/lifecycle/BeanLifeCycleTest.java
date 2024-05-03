package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링 빈의 이벤트 라이프 사이클
 * 스프링 컨테이너 생성 -> 스프링 빈 생성 -> 의존관계 개입 -> 초기화 콜백 -> 사용 -> 소멸전 콜백 -> 스프링 종료
 * */
public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        // Bean 등록 초기화 initMethod, 소멸 detryoMethod
//        @Bean(initMethod = "init", destroyMethod = "close") // destroyMethod는 (inferred) 추론 메서드를 사용, 보통 close나 shutdown 같은 메소드가 있으면 자동으로 사용함
        @Bean
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
