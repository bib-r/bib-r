package org.bibr.eval;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EvaluationTest {
	
	private Evaluator eval;
	
	@Before
	public void initialization(){
		eval = new Evaluator();
		String pathMapping = "C:/Users/Joffrey/Documents/Developpement/BIB-R/mappings.xml";
		eval.readMappings(pathMapping);
		
		//System.out.println(eval.getMappings());
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	public void fullTest(){
		
		// Expert
		String pathExp = "C:/Tests/eval/core-basic-frbr.xml";
		RDFRequest requestExp = new RDFRequest();
		requestExp.setPath(pathExp);
		requestExp.setTypeStategy("property");
		requestExp.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
		
		RDFReader rdfExp = eval.initializeCollection(requestExp);
		
		// -----------
		
		// Coll
		String path = "C:/Tests/eval/frbrml_core_basic.xml";

		RDFRequest request = new RDFRequest();
		request.setPath(path);
		request.setTypeStategy("property");
		request.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#type");
		
		RDFReader rdfColl = eval.initializeCollection(request);
		// -----------
		
		eval.evaluate(rdfColl, rdfExp);

		
	}
}
