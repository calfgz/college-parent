package cn.calfgz.college.canal;

import cn.calfgz.college.canal.client.CanalClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

/**
 * @author zhongwm
 * @description:
 * @date 2020-04-08 13:53
 */
@SpringBootApplication
public class CanalApplication implements CommandLineRunner {

    @Resource
    private CanalClient canalClient;

    @Override
    public void run(String... args) throws Exception {
        //项目启动，执行canal客户端监听
        canalClient.run();
    }

    public static void main(String[] args) {
        SpringApplication.run(CanalApplication.class, args);
    }
}
