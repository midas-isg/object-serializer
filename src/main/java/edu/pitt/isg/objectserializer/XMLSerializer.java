package edu.pitt.isg.objectserializer;



import edu.pitt.isg.objectserializer.exceptions.SerializationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import java.io.StringWriter;
import java.util.List;

/**
 *
 * @author nem41
 */
public class XMLSerializer extends Serializer {

	private final List<Class> classList;

	public XMLSerializer(List<Class> classList) {
		super(SerializationFormat.XML); this.classList = classList;
	}

	public String serializeObject(Object obj) throws SerializationException {
		String xml = "";
		try {
			JAXBContext context = JAXBContext.newInstance(classList.toArray(new Class[0]));
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			final StringWriter stringWriter = new StringWriter();

			String namespace = convertNamespaceFromJavaToXSD(obj.getClass().getPackage().getName());
			marshaller.marshal(new JAXBElement(
					new QName(namespace, obj.getClass().getSimpleName(), Serializer.APOLLO_NAMESPACE_TNS_PREFIX), obj.getClass(), obj), stringWriter);

			xml = stringWriter.toString();
		} catch (JAXBException e) {
			throw new SerializationException("JAXBException: " + e.getMessage());
		}
		return xml;
	}

}
