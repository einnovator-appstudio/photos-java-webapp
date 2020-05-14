package com.jsimao71.photos.config;

import org.einnovator.util.model.ObjectBase;
import org.einnovator.util.model.ToStringCreator;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("photos")
public class PhotosConfiguration extends ObjectBase {

    public PhotosConfiguration() {
    }

    @Override
    public ToStringCreator toString(ToStringCreator creator) {
        return creator;
    }
}
