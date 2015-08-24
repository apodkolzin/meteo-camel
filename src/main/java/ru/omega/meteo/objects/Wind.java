package ru.omega.meteo.objects;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * User: Andrew F. Podkolzin
 * Date: 04.02.14
 * Time: 11:12
 * Since: 
 *
 */
@Entity
public class Wind
{
    @XStreamAsAttribute
    protected String chill;
    @XStreamAsAttribute
    protected String direction;
    @XStreamAsAttribute
    protected String speed;

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

    public String getChill()
    {
        return chill;
    }

    public void setChill(String chill)
    {
        this.chill = chill;
    }

    public String getDirection()
    {
        return direction;
    }

    public void setDirection(String direction)
    {
        this.direction = direction;
    }

    public String getSpeed()
    {
        return speed;
    }

    public void setSpeed(String speed)
    {
        this.speed = speed;
    }
}
