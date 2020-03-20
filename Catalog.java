//@author Moisanu Stefan, having laboratory slides as starting point


package compulsory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * holds documents
 */
public class Catalog implements Serializable {
    private String name;
    private String path;
    private List<Document> documents = new ArrayList<>();

    public Catalog(String name, String path) {
        this.name = name;
        this.path = path;
    }

    /**
     * adds doc to documents list
     *
     * @param doc document to be added to list
     */
    public void add(Document doc) {
        documents.add(doc);
    }

    public String getPath() {
        return this.path;
    }

    /**
     * finds Document object in documents list with given id
     *
     * @param id id to search by
     * @return Document object with given id
     */
    public Document findById(String id) {
        for (Document doc : documents) {
            if (doc.getId().equals(id)) {
                return doc;
            }
        }
        return null;
    }
}