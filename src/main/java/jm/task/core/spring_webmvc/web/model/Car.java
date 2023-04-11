package jm.task.core.spring_webmvc.web.model;

import org.springframework.stereotype.Component;

@Component
public class Car {
    private String model;
    private int series;
    private String licensePlate;

    public Car(){}
    public Car(String model, int series, String licensePlate) {
        this.model = model;
        this.series = series;
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
