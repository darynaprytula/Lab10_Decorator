package lab.store.decorators;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public abstract class AbstractDocumentDecorator implements Document {

    protected final Document document;

    @Override
    public String getGcsPath() {
        return document.getGcsPath();
    }
}
