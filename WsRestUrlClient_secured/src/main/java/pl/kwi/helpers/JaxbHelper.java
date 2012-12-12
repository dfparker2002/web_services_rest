package pl.kwi.helpers;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JaxbHelper {
	
	public static void setObjectToOutputStream(Class<? extends Object> clazz, Object obj, OutputStream os){
		
		try {
			
			JAXBContext context = JAXBContext.newInstance(clazz);

		    Marshaller m = context.createMarshaller();
		    m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		    
		    m.marshal(obj, os);
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
	}
	
	public static Object getObjectFromInputStream(Class<? extends Object> clazz, InputStream is){
		
		try {
			
			JAXBContext context = JAXBContext.newInstance(clazz);
			
			Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
			return jaxbUnmarshaller.unmarshal(is);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}

}
