# SOA-dubbo
springboot2.4 + dubbo + zookeeper + mybatis + dubbo-admin
模块功能
1. scripts: 项目搭建、版本升级脚本文件
2. common: 公共模块
3. consumer: 消费者 -> 可以作为api接口
4. provider: 生产者 -> 相当于实现service的serviceImpl
5. mongodb: 操作mongodb数据库
6. redis: 操作redis

环境配置需要注意：
1. 需要下载插件 lombok 以及配置 Compiler -> annotation processors -> 勾选 enable annotation processing
2. （非必须 如grable环境无法build） gradle 需要配置成idea 打包环境启动 https://blog.csdn.net/qq_43519310/article/details/89598394

gradle打包简单部署:
1. clean -> build 
2. 复制每个服务下的jar包 
3. java -jar xx.jar 启动jar
4. nohup java -jar xx.jar -> xx.log & 后台启动部署jar输出日志到xx.log文件

pm2部署: 官方文档 https://pm2.keymetrics.io/docs/usage/quick-start/
1. 安装node 检验是否成功 node -v npm -v
2. 为node添加环境变量
    1. vim /etc/profile
    2. export NODE_HOME=/usr/local/node
    3. export PATH=$NODE_HOME/bin:$PATH
    4. source /etc/profile
3. 安装pm2 必须使用root用户 不然没有创建文件夹权限
    1. npm install pm2 -g
4. pm2 启动 项目
    1. pm2 start xxx.json  (xxx.json文件在scripts文件中)
