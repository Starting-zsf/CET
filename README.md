# CETEvaluation

#### CET程序评估后端项目地址
https://gitee.com/stating/cetevaluation

#### CET程序评估前端项目地址
https://gitee.com/stating/cetevaluation-web

## Mongodb
### Mongodb启动
```
mongod --dbpath /var/lib/mongo --logpath /var/log/mongodb/mongod.log  --bind_ip=120.95.133.8 --port=27017 --fork
```

### Mongodb 连接
```
mongodb://120.95.133.8:27017/?compressors=zlib&readPreference=primary&gssapiServiceName=mongodb&appname=MongoDB%20Compass&ssl=false
```


## 使用说明
### 1. 先导入数据库脚本
在`./db/`中，分别导入即可

### 2. 导入pom.xml中的包
然后运行即可,默认后端端口号8083