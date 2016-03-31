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

	private Map<String, String> mappings = new HashMap<String, String>();
	
	public void evaluate(RDFReader r1, RDFReader r2){
		
		// Match the Manifestations
		List<Entity> cols = new ArrayList<Entity>(r1.process(mappings).values());
		List<Entity> exps = new ArrayList<Entity>(r2.process(mappings).values());
		List<Pair> pairs = this.getMatches(cols, exps, "http://rdaregistry.info/Elements/c/Manifestation");
		
		// Match the related elements
		// TODO manage entity's relationships
		List<Entity> rel1 = new ArrayList<Entity>();
		List<Entity> rel2 = new ArrayList<Entity>();
		
	}
	
	public RDFReader initializeCollection(RDFRequest request){
		
		RDFReader rdf = new RDFReader();
		rdf.read(request);
		return rdf;
	}
	
	

	public List<Pair> getMatches(List<Entity> ls1, List<Entity> ls2, String type) {

		List<Pair> pairs = new ArrayList<Pair>();
		
		// Get only the manifs
		List<Entity> Ents1 = new ArrayList<Entity>();
		List<Entity> Ents2 = new ArrayList<Entity>();

		for (Iterator<Entity> iterator = ls1.iterator(); iterator.hasNext();) {
			Entity e = (Entity) iterator.next();
			if (e.getType().equals(
					type)) {
				Ents1.add(e);
			}
		}

		for (Iterator iterator = ls2.iterator(); iterator.hasNext();) {
			Entity e = (Entity) iterator.next();
			if (e.getType().equals(
					type)) {
				Ents2.add(e);
			}
		}

		Integer nbMatch = 0;
		for (Iterator<Entity> iterator = Ents2.iterator(); iterator
				.hasNext();) {
			Entity exp = (Entity) iterator.next();
			for (Iterator<Entity> iterator2 = Ents1.iterator(); iterator2
					.hasNext();) {
				Entity col = (Entity) iterator2.next();

				if (Matcher.match(col, exp)) {
					nbMatch++;
					Pair p = new Pair(col, exp);
					pairs.add(p);
				}
			}
		}

		System.out.println("Nb "+type+" to find: " + Ents1.size());
		System.out.println("Nb "+type+" found: " + nbMatch);
		
		return pairs;

	}

	public void readMappings(String path) {

		String uriSame = "http://www.w3.org/2002/07/owl#sameAs";
		RDFRequest request = new RDFRequest();
		request.setPath(path);
		request.setTypeStategy("definition");
		request.setDataStrategy("http://www.w3.org/1999/02/22-rdf-syntax-ns#about");

		RDFReader rdf = new RDFReader();
		rdf.read(request);
		rdf.process(this.getMappings());

		for (Iterator<String> iterator = rdf.getEntityTypes().iterator(); iterator
				.hasNext();) {
			String type = (String) iterator.next();
			evaluateMapping(rdf, type, uriSame);
		}
	}

	private void evaluateMapping(RDFReader rdf, String type, String uriSame) {

		Resource r = rdf.getModel().getResource(type);
		mappings.put(r.toString(), r.toString());
		StmtIterator iterProps = r.listProperties();
		while (iterProps.hasNext()) {
			Statement sp = iterProps.nextStatement();
			if (sp.getPredicate().toString().equals(uriSame)) {
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
