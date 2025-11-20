package lab.store.decorators;

public class TimedDocument extends AbstractDocumentDecorator {

    public TimedDocument(Document document) {
        super(document);
    }

    @Override
    public String parse() {
        long start = System.currentTimeMillis();

        String parsed = document.parse();

        long end = System.currentTimeMillis();
        System.out.println("Parsing took: " + (end - start) + " ms");

        return parsed;
    }
}
