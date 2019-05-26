package xml;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.StAXEventBuilder;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import java.io.FileReader;
import java.io.IOException;

public class StAXParser {
    private static Document getStAXParsedDocument(final String fileName)
    {

        Document document = null;
        try
        {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLEventReader reader = factory.createXMLEventReader(new FileReader(fileName));
            StAXEventBuilder builder = new StAXEventBuilder();
            document = builder.build(reader);
        }
        catch (JDOMException | IOException | XMLStreamException e)
        {
            e.printStackTrace();
        }
        return document;
    }
}
