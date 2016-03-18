package org.bibr;

import java.io.FileWriter;
import java.io.Writer;
import java.lang.reflect.Method;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MappingGenerator {

	private Model model;

	@Before
	public void setUp() throws Exception {
		model = ModelFactory.createDefaultModel();
	}

	@Test
	public void launch() throws Exception{
		
		FRBR ont = new FRBR();
		Class tClass = ont.getClass();
		Method[] methods = tClass.getMethods();
		for (int i = 0; i < methods.length; i++) {
			
			if(methods[i].getName().contains("_ONT")){
				methods[i].invoke(ont,model);
			}
		}
	}

	@After
	public void tearDown() throws Exception {

		String path = Util.path + "/mappings.xml";
		Writer w1 = new FileWriter(path);
		w1.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		w1.close();
		Writer w2 = new FileWriter(path, true);
		model.write(w2, "RDF/XML-ABBREV");
		w2.close();
	}

}
