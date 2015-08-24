package ru.omega.meteo.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * Created by IntelliJ IDEA.
 * User: Andrew F. Podkolzin
 * Date: 03.02.14
 * Time: 17:43
 * Since: 
 *
 */
@Entity
@Access(AccessType.FIELD)
@XStreamAlias("channel")
public class Channel
{
    @Id
    @GeneratedValue
    private Long id;

    protected String title;
    protected String link;
    protected String description;
    protected String language;
    protected String lastBuildDate;
    protected String ttl;

    @XStreamAlias("units")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Units units;
    @XStreamAlias("location")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Location location;
    @XStreamAlias("wind")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Wind wind;
    @XStreamAlias("atmosphere")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Atmosphere atmosphere;
    @XStreamAlias("astronomy")
    @ManyToOne(cascade = CascadeType.ALL)
    protected Astronomy astronomy;

    @ManyToOne(cascade = CascadeType.ALL)
    protected Image image;
    @ManyToOne(cascade = CascadeType.ALL)
    protected Item item;


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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getLastBuildDate()
    {
        return lastBuildDate;
    }

    public void setLastBuildDate(String lastBuildDate)
    {
        this.lastBuildDate = lastBuildDate;
    }

    public String getTtl()
    {
        return ttl;
    }

    public void setTtl(String ttl)
    {
        this.ttl = ttl;
    }

    @ManyToOne
    @Transient
    public Units getUnits()
    {
        return units;
    }

    public void setUnits(Units units)
    {
        this.units = units;
    }

    @ManyToOne
    @Transient
    public Location getLocation()
    {
        return location;
    }

    public void setLocation(Location location)
    {
        this.location = location;
    }

    @ManyToOne
    @Transient
    public Wind getWind()
    {
        return wind;
    }

    public void setWind(Wind wind)
    {
        this.wind = wind;
    }

    @ManyToOne
    @Transient
    public Atmosphere getAtmosphere()
    {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere)
    {
        this.atmosphere = atmosphere;
    }

    @ManyToOne
    @Transient
    public Astronomy getAstronomy()
    {
        return astronomy;
    }

    public void setAstronomy(Astronomy astronomy)
    {
        this.astronomy = astronomy;
    }

    @ManyToOne
    @Transient
    public Image getImage()
    {
        return image;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    public Item getItem()
    {
        return item;
    }

    public void setItem(Item item)
    {
        this.item = item;
    }
}
