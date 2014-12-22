package net.v4lproik.phishingplatform.service.impl;

/**
 * Class that provides an easier human syntax when a ressource has not been found
 * <p/>
 * Created by v4lproik on 19/12/14.
 */
public class ResourceNotFound extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final String resource;
    private final Long id;

    public ResourceNotFound(String resource, Long id) {
        super("Resource not found: " + resource + "with id=" + id);
        this.resource = resource;
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public Long getId() {
        return id;
    }

}
