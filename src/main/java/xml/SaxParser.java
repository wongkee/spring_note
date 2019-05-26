package xml;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;

public class SaxParser {
    public static Document getSAXParsedDocument(final String fileName)
    {
        SAXBuilder builder = new SAXBuilder();
        Document document = null;
        try
        {
            document = builder.build(fileName);
        }
        catch (JDOMException | IOException e)
        {
            e.printStackTrace();
        }
        return document;
    }
}
