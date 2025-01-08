package com.gulimall.gen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.gulimall.common.security.annotation.EnableCustomConfig;
import com.gulimall.common.security.annotation.EnableRyFeignClients;

/**
 * 代码生成
 * 
 * @author gulimall
 */
@EnableCustomConfig
@EnableRyFeignClients
@SpringBootApplication
public class GulimallGenApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(GulimallGenApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  代码生成模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
