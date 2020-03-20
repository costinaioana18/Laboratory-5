//@author Moisanu Stefan, having laboratory slides as starting point

package compulsory;

import com.sun.jndi.toolkit.url.Uri;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * a file that can be found at a specific path or URL
 * Observation: If I had enough time I would have made Document an interface and create objects like Book, Article to implement it
 */
public class Document implements Serializable {
    private String id;
    private String name;
    private String location;
    private Map<String, Object> tags = new HashMap<>();

    public Document(String id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;

    }

    /**
     * stores information about document in the map
     *
     * @param key key in map
     * @param obj key value in map
     */
    public void addTag(String key, Object obj) {
        tags.put(key, obj);
    }

    public String getId() {
        return id;
    }

    /**
     * converts the string this.location to a URI object
     *
     * @return the converted URI
     */
    public URI getLocationAsURI() {
        return URI.create(location);
    }

}
