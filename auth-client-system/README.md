# 子默云计算机管理系统

# 各环境地址
开发环境: http://csm.zimocloud.com/api/
测试环境: http://t-csm.zimocloud.com/api/
生产环境: http://csm.zimocloud.com/api/

## 镜像构建
docker build -t registry.cn-hangzhou.aliyuncs.com/zimocloud/csm:latest .
docker push registry.cn-hangzhou.aliyuncs.com/zimocloud/csm:latest

## 开发环境
docker pull registry.cn-hangzhou.aliyuncs.com/zimocloud/csm:latest
docker stop csm
docker rm csm
docker run --name csm --restart=always -p 21000:21000 -dit -v /storage/logs/zimo:/storage/logs/zimo registry.cn-hangzhou.aliyuncs.com/zimocloud/customer-service-manager-system:latest java -Xms256m -Xmx256m -jar app.jar --spring.profiles.active=dev
docker logs -f csm

## 测试环境
docker pull registry.cn-hangzhou.aliyuncs.com/zimocloud/csm:latest
docker stop csm
docker rm csm
docker run --name csm --restart=always -p 21000:21000 -dit -v /storage/logs/zimo:/storage/logs/zimo registry.cn-hangzhou.aliyuncs.com/zimocloud/customer-service-manager-system:latest java -Xms256m -Xmx256m -jar app.jar --spring.profiles.active=test
docker logs -f csm


## 生产环境
docker pull registry.cn-hangzhou.aliyuncs.com/zimocloud/csm:1.3.1-release
docker stop csm
docker rm csm
docker run --name csm --restart=always -p 21000:21000 -dit -v /storage/logs/zimo:/storage/logs/zimo registry.cn-hangzhou.aliyuncs.com/zimocloud/customer-service-manager-system:1.3.1-release java -Xms1g -Xmx1g -jar app.jar --spring.profiles.active=prod
docker logs -f csm

