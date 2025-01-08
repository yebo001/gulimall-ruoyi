#!/bin/sh

# 复制项目的文件到对应docker路径，便于一键生成镜像。
usage() {
	echo "Usage: sh copy.sh"
	exit 1
}


# copy sql
echo "begin copy sql "
cp ../sql/ry_20240629.sql ./mysql/db
cp ../sql/ry_config_20240902.sql ./mysql/db

# copy html
echo "begin copy html "
cp -r ../gulimall-ui/dist/** ./nginx/html/dist


# copy jar
echo "begin copy gulimall-gateway "
cp ../gulimall-gateway/target/gulimall-gateway.jar ./gulimall/gateway/jar

echo "begin copy gulimall-auth "
cp ../gulimall-auth/target/gulimall-auth.jar ./gulimall/auth/jar

echo "begin copy gulimall-visual "
cp ../gulimall-visual/gulimall-monitor/target/gulimall-visual-monitor.jar  ./gulimall/visual/monitor/jar

echo "begin copy gulimall-modules-system "
cp ../gulimall-modules/gulimall-system/target/gulimall-modules-system.jar ./gulimall/modules/system/jar

echo "begin copy gulimall-modules-file "
cp ../gulimall-modules/gulimall-file/target/gulimall-modules-file.jar ./gulimall/modules/file/jar

echo "begin copy gulimall-modules-job "
cp ../gulimall-modules/gulimall-job/target/gulimall-modules-job.jar ./gulimall/modules/job/jar

echo "begin copy gulimall-modules-gen "
cp ../gulimall-modules/gulimall-gen/target/gulimall-modules-gen.jar ./gulimall/modules/gen/jar

