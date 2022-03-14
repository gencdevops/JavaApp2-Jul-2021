package org.csystem.app.service.sensor.data.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sensors")
public class Sensor { //POJO
    public String name;
    public double data;
    public String host;
    public int port;

}
