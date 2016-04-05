package org.bibr.eval;

import info.debatty.java.stringsimilarity.JaroWinkler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;

/**
 * Class to evaluate 2 RDF collections (already initialized).
 * @author Joffrey
 *
 */
public class Evaluator {

	private Map<String, String> mappings = new HashMap<String, String>();
	private Map<String, String> inverses = new HashMap<String, String>();
	private Map<String, Entity> ercol = new HashMap<String, Entity>();
	private Map<String, Entity> erexp = new HashMap<String, Entity>();

	// Statistics
	private Map<String, Set<Match>> toFind = new HashMap<String, Set<Match>>();
	private Set<String> entAlreadyToFind = new HashSet<String>();
	
	// String similarity
	private JaroWinkler jaro = new JaroWinkler();

	// Specific config fro a collection
	private Map<String, Map<String, String>> replacements = new HashMap<String, Map<String, String>>();

	public Evaluator(Map<String, Map<String, String>> replacements) {
		super();
		this.replacements = replacements;
	}

	/**
	 * Main method to evaluate 2 RDF collections already initialized
	 * @param rcol
	 * @param rexp
	 * @param isCollection
	 */
	public void evaluate(RDFReader rcol, RDFReader rexp, Boolean isCollection) {

		// Match the Manifestations
		ercol = rcol.process(mappings);
		erexp = rexp.process(mappings);

		List<Entity> cols = new ArrayList<Entity>(ercol.values());
		List<Entity> exps = new ArrayList<Entity>(erexp.values());

		FRBRTreeProcessing(cols,exps);
		
		// Statistics:
		generateStatistics(isCollection);
		
	}
	
	/**
	 * Method that 
	 * @param cols
	 * @param exps
	 */
	private void FRBRTreeProcessing(List<Entity> cols, List<Entity> exps){
		
		// Basic level
		List<Pair> manifPairs = this.getMatches(cols, exps,
				"http://rdaregistry.info/Elements/c/Manifestation");
		for(Entity e : exps){
			if(e.getType().equals("http://rdaregistry.info/Elements/c/Manifestation")){
				updateStatisticalResults(e, "http://rdaregistry.info/Elements/e/manifestationOfExpression");
			}
		}
		
		
		for (Iterator<Pair> iterator = manifPairs.iterator(); iterator.hasNext();) {
			Pair pair = (Pair) iterator.next();
			computeFoundResults(pair);
		}
		
		// Note: For other levels, the statistical results are computed in the getNextDepthPairs method.
		// Manifestation level
		List<Pair> exprPairs = getNextDepthPairs(manifPairs,
				"http://rdaregistry.info/Elements/c/Expression");
		
		getNextDepthPairs(manifPairs,
						"http://rdaregistry.info/Elements/c/CorporateBody");
		
		// Expression Level
		getNextDepthPairs(exprPairs,
					"http://rdaregistry.info/Elements/c/Person");
		
		List<Pair> workPairs = getNextDepthPairs(exprPairs, "http://rdaregistry.info/Elements/c/Work");
		
		// Work Level
		getNextDepthPairs(workPairs, "http://rdaregistry.info/Elements/c/Person");
		
		List<Pair> superWorkPairs = getNextDepthPairs(workPairs, "http://rdaregistry.info/Elements/c/Work");
		
		getNextDepthPairs(superWorkPairs, "http://rdaregistry.info/Elements/c/Work");
	}
	
	/**
	 * Generate the evaluation results (for the display)
	 * @param isCollection
	 */
	public void generateStatistics(Boolean isCollection){
		if(!isCollection){
			List<String> sortedKeys= new ArrayList<String>(toFind.keySet());
			Collections.sort(sortedKeys);
			for (String key : sortedKeys) { 
			   Set<Match> value = toFind.get(key);
			   
			   String ePart = key.split("#")[0];
			   String entity = ePart.substring(ePart.lastIndexOf("/")+1, ePart.length());
			   
			   String pPart = key.split("#")[1];
			   String prop = pPart.substring(pPart.lastIndexOf("/")+1, pPart.length());
			   
			   System.out.println("To find: " + value.size() + " " + entity+" ("+prop+")");
			}
		}else{
			List<String> sortedKeys= new ArrayList<String>(toFind.keySet());
			Collections.sort(sortedKeys);
			for (String key : sortedKeys) { 
			   Set<Match> value = toFind.get(key);
			   Integer nbMatch = 0;
			   for (Iterator<Match> iterator = value.iterator(); iterator.hasNext();) {
					Match match = (Match) iterator.next();
					if(match.getInfo()){
						nbMatch++;
					}
			   }
			   
			   String ePart = key.split("#")[0];
			   String entity = ePart.substring(ePart.lastIndexOf("/")+1, ePart.length());
			   
			   String pPart = key.split("#")[1];
			   String prop = pPart.substring(pPart.lastIndexOf("/")+1, pPart.length());
			   if(nbMatch > 0){
				   System.out.println("Found: " + nbMatch + " " + entity+" ("+prop+")");
			   }
			}
		}
	}
	
	/**
	 * From a list of Pairs, get the related pairs from initial pairs's
	 * relationship, filtering by an entity type.
	 * 
	 * @param pairs
	 * @param type
	 * @return
	 */
	public List<Pair> getNextDepthPairs(List<Pair> pairs, String type) {

		List<Pair> depth1pairs = new ArrayList<Pair>();
		List<Pair> result = new ArrayList<Pair>();
		Set<String> alreadyVisited = new HashSet<String>();

		for (Iterator<Pair> iterator = pairs.iterator(); iterator.hasNext();) {
			Pair p = (Pair) iterator.next();
			Map<String, List<Entity>> expDepth1 = new HashMap<String, List<Entity>>();
			Map<String, List<Entity>> colDepth1 = new HashMap<String, List<Entity>>();

			// Entities at next depth level of relationship
			for (Iterator<String> iterator2 = p.getExp().getRelationships()
					.keySet().iterator(); iterator2.hasNext();) {

				// common relationships where current entity of the pair is the
				// OUT of relationship

				// [EXP]
				String relType = (String) iterator2.next();
				if (expDepth1.get(relType) == null) {
					expDepth1.put(relType, new ArrayList<Entity>());
				}
				for (Iterator<String> iterator3 = p.getExp().getRelationships()
						.get(relType).iterator(); iterator3.hasNext();) {
					String se1 = (String) iterator3.next();
					expDepth1.get(relType).add(erexp.get(se1));
				}

				// [COL]
				if (p.getCol().getRelationships().get(relType) != null) {
					if (colDepth1.get(relType) == null) {
						colDepth1.put(relType, new ArrayList<Entity>());
					}
					for (Iterator<String> iterator3 = p.getCol()
							.getRelationships().get(relType).iterator(); iterator3
							.hasNext();) {
						String se2 = (String) iterator3.next();
						colDepth1.get(relType).add(ercol.get(se2));
					}
				}

			}

			// common relationships where current entity of the pair is the IN
			// of relationship
			computeOUTRelatedEntities(p.getExp(), erexp, expDepth1);
			computeOUTRelatedEntities(p.getCol(), ercol, colDepth1);

			for (Entry<String, List<Entity>> entry : expDepth1.entrySet()) {
				String key = entry.getKey();
				List<Entity> expents = entry.getValue();
				

				for (Iterator<Entity> iterator2 = expents.iterator(); iterator2
						.hasNext();) {
					Entity ex = (Entity) iterator2.next();
					updateStatisticalResults(ex,key);
				}

				depth1pairs.addAll(this.getMatches(colDepth1.get(key), expents,
						type));
			}

			
			for (Iterator<Pair> iterator2 = depth1pairs.iterator(); iterator2
					.hasNext();) {
				Pair pair = (Pair) iterator2.next();
				if(!alreadyVisited.contains(pair.getExp().getIdentifier())){
					result.add(pair);
					alreadyVisited.add(pair.getExp().getIdentifier());
					
					// Compute results for statistical display
					computeFoundResults(pair);
	
				}
			}
			// break;

		}
		return result;
	}
	
	private void computeFoundResults(Pair pair){
		
		Boolean successMatch = false;
		for (Iterator<Set<Match>> iterator3 = toFind.values().iterator(); iterator3
				.hasNext();) {
			Set<Match> matches = (Set<Match>) iterator3.next();
			for (Iterator<Match> iterator4 = matches.iterator(); iterator4
					.hasNext();) {
				Match match = (Match) iterator4.next();
				if(match.getEntity().equals(pair.getExp().getIdentifier())){
					match.setInfo(true);
					successMatch = true;
					break;
				}
			}
			if(successMatch){
				break;
			}
		}
		
	}
	
	/**
	 * For statistical display
	 * @param e
	 * @param relationType
	 */
	public void updateStatisticalResults(Entity e, String relationType){
		
		if(!entAlreadyToFind.contains(e.getIdentifier())){
			String typeKey = e.getType()+"#"+relationType;
			if (!toFind.containsKey(typeKey)) {
					toFind.put(typeKey, new HashSet<Match>());
			}
			toFind.get(typeKey).add(new Match(e.getIdentifier()));
			entAlreadyToFind.add(e.getIdentifier());
		}
	}

	/**
	 * Get the relationships where the evaluated entity is the IN element in
	 * relationship
	 * 
	 * @param eval
	 * @param map
	 * @param data
	 */
	public void computeOUTRelatedEntities(Entity eval, Map<String, Entity> map,
			Map<String, List<Entity>> data) {
		for (Iterator<Map.Entry<String, Entity>> it = map.entrySet().iterator(); it
				.hasNext();) {
			Map.Entry<String, Entity> entry = it.next();
			String id = entry.getKey();
			Entity e = entry.getValue();

			for (Iterator<Map.Entry<String, List<String>>> it1 = e
					.getRelationships().entrySet().iterator(); it1.hasNext();) {
				Map.Entry<String, List<String>> entry1 = it1.next();
				String key = entry1.getKey();
				List<String> value = entry1.getValue();

				for (Iterator<String> iterator2 = value.iterator(); iterator2
						.hasNext();) {
					String dest = (String) iterator2.next();
					if (eval.getIdentifier().equals(dest)) {

						String inv = inverses.get(key);
						String rel = null;
						if (data.get(key) == null && data.get(inv) == null) {
							data.put(key, new ArrayList<Entity>());
						}

						if (data.get(key) == null && data.get(inv) != null) {
							rel = inv;
						} else {
							rel = key;
						}
						data.get(rel).add(map.get(id));
					}
				}
			}
		}
	}

	public RDFReader initializeCollection(RDFRequest request) {

		RDFReader rdf = new RDFReader();
		rdf.read(request);
		return rdf;
	}

	/**
	 * Return the pairs of correspondences from two distinct list of entities, filtering a specific type of entity.
	 * @param lsCol
	 * @param lsExp
	 * @param type
	 * @param level
	 * @return
	 */
	public List<Pair> getMatches(List<Entity> lsCol, List<Entity> lsExp, String type) {

		List<Pair> pairs = new ArrayList<Pair>();
		
		List<Entity> EntsCol = new ArrayList<Entity>();
		List<Entity> EntsExp = new ArrayList<Entity>();

		if (lsCol != null) {
			for (Iterator<Entity> iterator = lsCol.iterator(); iterator.hasNext();) {
				Entity e = (Entity) iterator.next();
				if (e.getType().equals(type)) {
					EntsCol.add(e);
				}
			}
		}

		if (lsExp != null) {
			for (Iterator<Entity> iterator = lsExp.iterator(); iterator.hasNext();) {
				Entity e = (Entity) iterator.next();
				if (e.getType().equals(type)) {
					EntsExp.add(e);
				}
			}
		}

		Integer nbMatch = 0;
		Set<String> matchedPairs = new HashSet<String>(); // save the pairs matched using the similarity function

		for (Iterator<Entity> iterator = EntsExp.iterator(); iterator.hasNext();) {
			Entity exp = (Entity) iterator.next();
			for (Iterator<Entity> iterator2 = EntsCol.iterator(); iterator2
					.hasNext();) {
				Entity col = (Entity) iterator2.next();

				Pair p = new Pair(col, exp);
				String idPair = col.getIdentifier() + exp.getIdentifier();
				Boolean match = Matcher.match(col, exp, jaro, replacements);

				if (EntsCol.size() == EntsExp.size()
						&& !matchedPairs.contains(idPair)) {
					match = true;
				}
				
				if (match && !matchedPairs.contains(idPair)) {
					pairs.add(p);
					matchedPairs.add(idPair);
					nbMatch++;
					break;
				}
			}
		}
		return pairs;

	}

	/**
	 * Read a RDF/XML mapping file to create Maps of same and inverse ontology concepts
	 * @param path
	 */
	public void readMappings(String path) {

		String uriSame = "http://www.w3.org/2002/07/owl#sameAs";
		String uriInverse = "http://www.w3.org/2002/07/owl#inverseOf";
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
			evaluateMapping(mappings, rdf, type, uriSame);
			evaluateMapping(inverses, rdf, type, uriInverse);
		}
	}
	
	/**
	 * @see readMappings
	 * @param mappings
	 * @param rdf
	 * @param type
	 * @param uri
	 */
	private void evaluateMapping(Map<String, String> mappings, RDFReader rdf,
			String type, String uri) {

		Resource r = rdf.getModel().getResource(type);
		mappings.put(r.toString(), r.toString());
		StmtIterator iterProps = r.listProperties();
		while (iterProps.hasNext()) {
			Statement sp = iterProps.nextStatement();
			if (sp.getPredicate().toString().equals(uri)) {
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

	public Map<String, String> getInverses() {
		return inverses;
	}

	public void setInverses(Map<String, String> inverses) {
		this.inverses = inverses;
	}

}
