package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) // @Component가 있는 모든 class를 빈으로 등록, Configuration어노테이션 붙은 class는 제외
// basePackages는 경로 시작 위치
// basePackageClasses는 지정한 클래스의 패키지를 탐색 시작 위치로 지정
// 지정하지 않으면 현재 경로 (hello.core) 부터 탐색 시작
public class AutoAppConfig {

}
