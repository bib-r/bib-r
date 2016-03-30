package org.bibr.eval;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

public class Evaluator {
	
	private Map<String,String> mappings = new HashMap<String,String>();
	
	private List<Entity> collEntities = new ArrayList<Entity>();
	
	public void evaluate(RDFRequest collection, RDFRequest expert){
		
		
		
	}
	
	public void extractCollectionEntities(RDFRequest request){
		
		RDFReader rdf = new RDFReader();
		rdf.read(request);
		rdf.process();
	}
	
	public void readMappings(String path){
		
		String uriSame = "http://www.w3.org/2002/07/owl#sameAs";
		RDFRequest request = new RDFRequest();
		request.setPath(path);
		request.setTypeStategy("definition");
		request.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#about");
		
		RDFReader rdf = new RDFReader();
		rdf.read(request);
		rdf.process();
		
		for (Iterator<String> iterator = rdf.getEntityTypes().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			evaluateMapping(rdf,type,uriSame);
		}
	}
	
	private void evaluateMapping(RDFReader rdf, String type, String uriSame){

		Resource r = rdf.getModel().getResource(type);
		mappings.put(r.toString(), r.toString());
		StmtIterator iterProps = r.listProperties();
		while (iterProps.hasNext()) {
			Statement sp = iterProps.nextStatement();
			if(sp.getPredicate().toString().equals(uriSame)){
				String same = sp.getObject().toString();
				mappings.put(same, r.toString());
			}
		}	
	}

	public Map<String, String> getMappings() {
		return mappings;
	}


	public void setMappings(Map<String, String> mappings) {
		this.mappings = mappings;
	}

}
