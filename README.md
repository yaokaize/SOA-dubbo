# SOA-dubbo
springboot2.4 + dubbo + zookeeper + mybatis + dubbo-admin
模块功能
1. scripts: 项目搭建、版本升级脚本文件
2. common: 公共模块
3. consumer: 消费者 -> 可以作为api接口
4. provider: 生产者 -> 相当于实现service的serviceImpl

环境配置需要注意：
1. 需要下载插件 lombok 以及配置 Compiler -> annotation processors -> 勾选 enable annotation processing
2. （非必须 如grable环境无法build） gradle 需要配置成idea 打包环境启动 https://blog.csdn.net/qq_43519310/article/details/89598394

gradle打包简单部署:
1. clean -> build 
2. 复制每个服务下的jar包 
3. java -jar xx.jar 启动jar 