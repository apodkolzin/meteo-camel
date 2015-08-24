/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ru.omega.meteo;

import org.apache.camel.builder.Builder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.xstream.XStreamDataFormat;
import ru.omega.meteo.objects.Rss;


public class MeteoBuilder extends RouteBuilder {

    public void configure() {

        XStreamDataFormat format = XStreamDataFormat.processAnnotations(null, Rss.class);

        from("timer://foo?period={{config.period}}")
            .onException(Exception.class)
                .handled(true)
                .logStackTrace(true)
                .setHeader("subject", constant("Exception from meteo@omega"))
                .setBody(Builder.exceptionStackTrace())
                .to("log:ru.omega.meteo")
                .to("smtps://smtp.yandex.ru?username={{config.smtps.user}}&password={{config.smtps.password}}&to={{config.smtps.to}}&from={{config.smtps.user}}")
                .log("ERRRRRRRR OR - " + constant(body()))
                .end()
            .to("http:weather.yahooapis.com/forecastrss?w=2124024&u=c")
                .unmarshal(format)
                .log("Temp: ${body.getClass}")
                .to("jpa://ru.omega.meteo.objects.Rss?persistenceUnit=meteo")
                .setHeader("subject", constant("Notify from meteo@omega"))
                .to("smtps://smtp.yandex.ru?username={{config.smtps.user}}&password={{config.smtps.password}}&to={{config.smtps.to}}&from={{config.smtps.user}}");

    }
}
