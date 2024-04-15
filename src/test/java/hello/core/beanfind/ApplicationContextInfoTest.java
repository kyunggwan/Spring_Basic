package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {

            // 빈 이르믕로 빈 객체(인스턴스)를 조회
            Object bean = ac.getBean(s);
            System.out.println("name = " + s + ", bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {

            // 스프링에 등록된 모든 빈 이름을 조회
            BeanDefinition beanDefinition = ac.getBeanDefinition(s);

            // ROLE_APPLICATION: 내가 등록한 Bean만 출력 (외부 라이브러리,기초 Bean 제외)
            // ROLE_INFRASTRUCTURE:  스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(s);
                System.out.println("name = " + s + ", bean = " + bean);
            }
        }
    }
}
