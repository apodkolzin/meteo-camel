package ru.omega.meteo.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Andrew F. Podkolzin
 * Date: 03.02.14
 * Time: 17:47
 * Since: 
 *
 */
@Entity
@XStreamAlias("yweather:atmosphere")
public class Atmosphere
{
    @XStreamAsAttribute
    protected String humidity;
    @XStreamAsAttribute
    protected String visibility;
    @XStreamAsAttribute
    protected String pressure;
    @XStreamAsAttribute
    protected String rising;

    @Id
    @GeneratedValue
    private Long id;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getHumidity()
    {
        return humidity;
    }

    public void setHumidity(String humidity)
    {
        this.humidity = humidity;
    }

    public String getVisibility()
    {
        return visibility;
    }

    public void setVisibility(String visibility)
    {
        this.visibility = visibility;
    }

    public String getPressure()
    {
        return pressure;
    }

    public void setPressure(String pressure)
    {
        this.pressure = pressure;
    }

    public String getRising()
    {
        return rising;
    }

    public void setRising(String rising)
    {
        this.rising = rising;
    }
}
