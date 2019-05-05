package spring_in_action.beans.autowiring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("spring_in_action.beans.autowiring")  //启用组件扫描  默认扫描类所在的包及其子包
public class CDPlayerConfig {
}
