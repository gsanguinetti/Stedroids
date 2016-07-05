package com.stedroids.stedroids.couchdbfragment.domain;

import com.stedroids.framework.domain.DomainBase;

/**
 * Created by gastonsanguinetti on 04/07/16.
 */
public class LastEpisode extends DomainBase {

    String name;
    String img;

    public LastEpisode(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
