package ru.omega.meteo.objects;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Andrew F. Podkolzin
 * Date: 03.02.14
 * Time: 17:40
 * Since: 
 *
 */
@Entity(name = "rss")
@Access(AccessType.FIELD)
@XStreamAlias("rss")
public class Rss
{
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    protected Channel channel;
    @XStreamAsAttribute
    protected String version;

    public Channel getChannel()
    {
        return channel;
    }

    public void setChannel(Channel channel)
    {
        this.channel = channel;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        try
        {
            Item item = getChannel().getItem();
            Condition condition = item.getCondition();
            return item.getTitle() + " is " + condition.getText() + " and " + condition.getTemp() + "C";
        }
        catch (Exception e)
        {
            return super.toString() + " is empty";
        }
    }
}
