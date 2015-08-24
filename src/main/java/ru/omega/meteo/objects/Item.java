package ru.omega.meteo.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import javax.persistence.*;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Andrew F. Podkolzin
 * Date: 03.02.14
 * Time: 17:46
 * Since: 
 *
 */
@Entity
@XStreamAlias("item")
@Access(AccessType.FIELD)
public class Item
{
    protected String title;
    protected String link;
    protected String pubDate;
    protected String description;

    @XStreamAlias("condition")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Condition condition;
    @XStreamImplicit(itemFieldName="forecast")
//    @Transient
    @ManyToMany(targetEntity = Forecast.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY )
//    @JoinTable(name="fore",
//            joinColumns=@JoinColumn(name="demand_id"),
//            inverseJoinColumns=@JoinColumn(name="subprioritylines_id"))
    protected List<Forecast> forecast;

    @XStreamAlias("lat")
    private Double lat;
    @XStreamAlias("long")
    private Double _long;
    private String guid;

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


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getLink()
    {
        return link;
    }

    public void setLink(String link)
    {
        this.link = link;
    }

    public String getPubDate()
    {
        return pubDate;
    }

    public void setPubDate(String pubDate)
    {
        this.pubDate = pubDate;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public Condition getCondition()
    {
        return condition;
    }

    public void setCondition(Condition condition)
    {
        this.condition = condition;
    }

    @Transient
    public List<Forecast> getForecast()
    {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast)
    {
        this.forecast = forecast;
    }

    public Double getLat()
    {
        return lat;
    }

    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Double getLong()
    {
        return _long;
    }

    public void setLong(Double aLong)
    {
        _long = aLong;
    }

    public String getGuid()
    {
        return guid;
    }

    public void setGuid(String guid)
    {
        this.guid = guid;
    }
}
