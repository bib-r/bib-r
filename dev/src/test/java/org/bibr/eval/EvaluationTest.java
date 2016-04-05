package org.bibr.eval;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class EvaluationTest {
	
	private Evaluation eval;
	
	@Before
	public void initialization(){
		
		eval = new Evaluation();
	}
	
	@Test
	public void fullTest(){
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = null;
		
		// Specific operations for the input collection
		Map<String,Map<String,String>> replacements = new HashMap<String,Map<String,String>>();
		String workTitle = "http://rdaregistry.info/Elements/w/titleOfTheWork";
		replacements.put(workTitle, new HashMap<String,String>());
		replacements.get(workTitle).put(" : .*", "");
		
		String title = "http://rdaregistry.info/Elements/m/title";
		replacements.put(title, new HashMap<String,String>());
		replacements.get(title).put(" : .*", "");
		
		String manifId = "http://rdaregistry.info/Elements/m/identifierForTheManifestation";
		replacements.put(manifId, new HashMap<String,String>());
		replacements.get(manifId).put("^urn:isbn:", "");
		
		// -----------
		
		// Expert
		file = new File(getClass().getResource("/exp-frbr.xml").getFile());
		String pathExp = file.getAbsolutePath();
		
		RDFRequest requestExp = new RDFRequest();
		requestExp.setPath(pathExp);
		requestExp.setTypeStategy("property");
		requestExp.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");

		// -----------
		
		// Coll
		file = new File(getClass().getResource("/test-frbr.xml").getFile());
		String path = file.getAbsolutePath();

		RDFRequest request = new RDFRequest();
		request.setPath(path);
		request.setTypeStategy("property");
		request.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
		
		// -----------
		
		
        file = new File(getClass().getResource("/mappings.xml").getFile());
		String pathMapping = file.getAbsolutePath();
		eval.process(request, requestExp, pathMapping, replacements);
		
	}
}
