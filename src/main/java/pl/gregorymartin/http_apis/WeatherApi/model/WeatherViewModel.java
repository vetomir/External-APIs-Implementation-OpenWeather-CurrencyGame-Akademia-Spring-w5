package pl.gregorymartin.http_apis.WeatherApi.model;

public
class WeatherViewModel {

    private String cityName;
    private String country;
    private String mainType;
    private String description;

    public WeatherViewModel() {
    }

    public WeatherViewModel(Weather source) {
        this.cityName = source.getName();
        this.country = source.getSys().getCountry();
        this.mainType = source.getWeather().get(0).getMain();
        this.description = source.getWeather().get(0).getDescription();
    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(final String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getMainType() {
        return mainType;
    }

    public void setMainType(final String mainType) {
        this.mainType = mainType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherDatabaseModel{" +
                ", cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", mainType='" + mainType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
