ps -ef|grep spring03|grep -v grep |awk '{print "kill -9 " $2}' |sh