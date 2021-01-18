echo 'docker start zookeeper. doc is https://registry.hub.docker.com/_/zookeeper'
docker stop cp-zookeeper
docker run --name cp-zookeeper -p 2181:2181 --restart always -d zookeeper
sleep 5

echo 'docker start zookeeper. doc is https://registry.hub.docker.com/_/memcached'
docker stop wawa-memcached
# 没有设置内存使用率
docker run --name wawa-memcached -d memcached
# 设置内存使用率
# docker run --name wawa-memcached -d memcached memcached -m 64
sleep 5