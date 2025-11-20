package lab.store.decorators;

public class CachedDocument extends AbstractDocumentDecorator {

    public CachedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse() {
        String path = document.getGcsPath();      // unique key
        DBConnection db = DBConnection.getInstance();

        String cached = db.getParsedByPath(path);
        if (cached != null) {
            System.out.println("Loaded from SQLite cache");
            return cached;
        }
        String parsed = document.parse();

        db.createDocument(path, parsed);

        return parsed;
    }
}
