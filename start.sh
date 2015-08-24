#!/bin/bash

if [ -e pid.file ] ; then
    application_pid=($(/bin/cat pid.file))
    echo "Stopping application with pid ${application_pid}"
    ps aux | grep ${application_pid}
    kill -9 $application_pid
    rm pid.file
fi

mvn camel:run > ./application.log&
application_pid=$!

echo $application_pid >> pid.file
tail -f ./application.log
