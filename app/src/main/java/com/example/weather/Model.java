package com.example.weather;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class Model implements Serializable {
    private Integer visibility;

    private Integer timezone;

    private Main main;

    private Clouds clouds;

    private Sys sys;

    private Integer dt;

    private Coord coord;

    private List<Weather> weather;

    private String name;

    private Integer cod;

    private Integer id;

    private String base;

    private Wind wind;

    public Integer getVisibility() {
        return this.visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    public Integer getTimezone() {
        return this.timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Main getMain() {
        return this.main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Clouds getClouds() {
        return this.clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Sys getSys() {
        return this.sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public Integer getDt() {
        return this.dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Coord getCoord() {
        return this.coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public List<Weather> getWeather() {
        return this.weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCod() {
        return this.cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Wind getWind() {
        return this.wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public static class Main implements Serializable {
        private Double temp;

        private Double temp_min;

        private Integer humidity;

        private Integer pressure;

        private Double feels_like;

        private Double temp_max;

        public Double getTemp() {
            return this.temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getTemp_min() {
            return this.temp_min;
        }

        public void setTemp_min(Double temp_min) {
            this.temp_min = temp_min;
        }

        public Integer getHumidity() {
            return this.humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

        public Integer getPressure() {
            return this.pressure;
        }

        public void setPressure(Integer pressure) {
            this.pressure = pressure;
        }

        public Double getFeels_like() {
            return this.feels_like;
        }

        public void setFeels_like(Double feels_like) {
            this.feels_like = feels_like;
        }

        public Double getTemp_max() {
            return this.temp_max;
        }

        public void setTemp_max(Double temp_max) {
            this.temp_max = temp_max;
        }
    }

    public static class Clouds implements Serializable {
        private Integer all;

        public Integer getAll() {
            return this.all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }
    }

    public static class Sys implements Serializable {
        private String country;

        private Integer sunrise;

        private Integer sunset;

        private Integer id;

        private Integer type;

        public String getCountry() {
            return this.country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getSunrise() {
            return this.sunrise;
        }

        public void setSunrise(Integer sunrise) {
            this.sunrise = sunrise;
        }

        public Integer getSunset() {
            return this.sunset;
        }

        public void setSunset(Integer sunset) {
            this.sunset = sunset;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getType() {
            return this.type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }

    public static class Coord implements Serializable {
        private Double lon;

        private Double lat;

        public Double getLon() {
            return this.lon;
        }

        public void setLon(Double lon) {
            this.lon = lon;
        }

        public Double getLat() {
            return this.lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }
    }

    public static class Weather implements Serializable {
        private String icon;

        private String description;

        private String main;

        private Integer id;

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMain() {
            return this.main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public Integer getId() {
            return this.id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }

    public static class Wind implements Serializable {
        private Integer deg;

        private Double speed;

        public Integer getDeg() {
            return this.deg;
        }

        public void setDeg(Integer deg) {
            this.deg = deg;
        }

        public Double getSpeed() {
            return this.speed;
        }

        public void setSpeed(Double speed) {
            this.speed = speed;
        }
    }
}
