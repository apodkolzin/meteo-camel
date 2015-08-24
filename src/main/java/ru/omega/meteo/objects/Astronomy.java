package ru.omega.meteo.objects;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Andrew F. Podkolzin
 * Date: 04.02.14
 * Time: 11:09
 * Since: 
 *
 */
@Entity
public class Astronomy
{
    @XStreamAsAttribute
    protected String sunrise;
    @XStreamAsAttribute
    protected String sunset;

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


    public String getSunrise()
    {
        return sunrise;
    }

    public void setSunrise(String sunrise)
    {
        this.sunrise = sunrise;
    }

    public String getSunset()
    {
        return sunset;
    }

    public void setSunset(String sunset)
    {
        this.sunset = sunset;
    }
}
