echo 'docker start zookeeper. doc is https://registry.hub.docker.com/_/zookeeper'
docker stop cp-zookeeper
docker rm cp-zookeeper
docker run --name cp-zookeeper -p 2181:2181 --restart always -d zookeeper
sleep 5

echo 'docker start memcached. doc is https://registry.hub.docker.com/_/memcached'
docker stop wawa-memcached
docker rm wawa-memcached
# 没有设置内存使用率
docker run --name wawa-memcached -p 11211:11211 -d memcached
# 设置内存使用率
# docker run --name wawa-memcached -d memcached memcached -m 64
sleep 5

echo 'docker start redis doc is https://registry.hub.docker.com/_/redis'
docker stop wawa-redis
docker rm wawa-redis
docker run -itd --name wawa-redis -p 6379:6379 redis
# 查看redis数据命令
# docker exec -it wawa-redis /bin/bash
sleep 5

echo 'docker start elasticsearch doc is https://hub.docker.com/_/elasticsearch'
docker network rm wawanetwork
docker network create wawanetwork
sleep 5
docker stop wawa-elasticsearch
docker rm wawa-elasticsearch
docker run -d --name wawa-elasticsearch --net wawanetwork -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" -e ES_JAVA_OPTS="-Xms64m -Xmx128m" elasticsearch:7.10.1
sleep 10
docker stop wawa-kibana
docker rm wawa-kibana
# 需要改成自己的需要的映射地址
docker run -d --name wawa-kibana --net wawanetwork -e ELASTICSEARCH_HOSTS=http://192.168.105.126:9200 -p 5601:5601 kibana:7.10.1
# 进入容器修改 host port
# docker exec -it wawa-kibana /bin/bash -> cd config -> vi kibana.yml -> host -> 0.0.0.0 -> port -> 5601