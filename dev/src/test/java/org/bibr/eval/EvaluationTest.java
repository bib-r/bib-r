package org.bibr.eval;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

public class EvaluationTest {

	@Ignore
	public void expertTest() throws Exception{
		
		// Read the mapping
		String pathMapping = "C:/Users/Joffrey/Documents/Developpement/BIB-R/mappings.xml";
		Evaluator eval = new Evaluator();
		eval.readMappings(pathMapping);
		
		String path = "C:/Tests/eval/frbrml_core_basic.xml";

		RDFRequest request = new RDFRequest();
		request.setPath(path);
		request.setTypeStategy("property");
		request.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
		
		RDFReader rdf = new RDFReader();
		rdf.read(request);
		Map<String,Entity> ents = rdf.process();
		
		// show tests results
		
		for (Iterator iterator = rdf.getEntityTypes().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			if(!eval.getMappings().containsKey(type)){
				System.out.println("Unknown entity type: "+type);
			}
		}
		
		
		for (Iterator<Map.Entry<String, Entity>> it = ents.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<String, Entity> entry = it.next();
			String key = entry.getKey();
			Entity e = entry.getValue();
			System.out.println(key+" :: "+e);
		}

	}
	
	@Test
	public void collectionTest() throws Exception{
		
		// Read the mapping
		String pathMapping = "C:/Users/Joffrey/Documents/Developpement/BIB-R/mappings.xml";
		Evaluator eval = new Evaluator();
		eval.readMappings(pathMapping);
		
		String path = "C:/Tests/eval/core-basic-frbr.xml";

		RDFRequest request = new RDFRequest();
		request.setPath(path);
		request.setTypeStategy("property");
		request.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
		
		RDFReader rdf = new RDFReader();
		rdf.read(request);
		Map<String,Entity> ents = rdf.process();
		
		// show tests results
		
		for (Iterator iterator = rdf.getEntityTypes().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			if(!eval.getMappings().containsKey(type)){
				System.out.println("Unknown entity type: "+type);
			}
		}
		
		
		for (Iterator<Map.Entry<String, Entity>> it = ents.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<String, Entity> entry = it.next();
			String key = entry.getKey();
			Entity e = entry.getValue();
			System.out.println(key+" :: "+e);
		}

	}
}
