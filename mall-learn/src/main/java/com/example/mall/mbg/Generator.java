package com.example.mall.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: mingjian
 * @create: 2020-04-01 19:15
 * 用于生产MPG的代码
 */
public class Generator {
    public static void main(String[] args) throws Exception{
        //mbg执行过程中的警告信息
        List<String> warnings=new ArrayList<>();
        //当生成的代码重复时，覆盖原代码
        boolean overwrite=true;
        //读取mbg配置文件
        InputStream is = Generator.class.getClassLoader().getResource("generatorConfig.xml").openStream();
        ConfigurationParser cp=new ConfigurationParser(warnings);
        Configuration config=cp.parseConfiguration(is);
        is.close();

        DefaultShellCallback callback=new DefaultShellCallback(overwrite);
        //创建mbg
        MyBatisGenerator myBatisGenerator=new MyBatisGenerator(config,callback,warnings);
        //执行生成代码
        myBatisGenerator.generate(null);
        //输出警告
        for(String warning:warnings)
            System.out.println(warning);
    }
}
