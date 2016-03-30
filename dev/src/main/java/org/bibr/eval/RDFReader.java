package org.bibr.eval;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;

public class RDFReader {
	
	private Model model = ModelFactory.createDefaultModel();
	
	private Set<String> entityTypes = new HashSet<String>();
	
	private Set<String> propertyTypes = new HashSet<String>();
	
	private String strategy;
	
	private String strategyData;
	
	public void read(RDFRequest request){
		
		// use the FileManager to find the input file
		InputStream in = FileManager.get().open(request.getPath());
		if (in == null) {
			throw new IllegalArgumentException("File: " + request.getPath() + " not found");
		}

		// read the RDF/XML file
		try {
			model.read(in, null);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
		
		strategy = request.getTypeStategy();
		strategyData = request.getDataStrategy();
	}
	
	public Map<String,Entity> process(){
		
		Map<String,Entity> ents = new HashMap<String,Entity>();
		StmtIterator iter = model.listStatements();
		if (iter.hasNext()) {
			// System.out.println("Results:");
			while (iter.hasNext()) {
				Statement s = iter.nextStatement();
				
				String type = null;
				String property = null;
				String data = null;
				// Get the entity types
				if(strategy.equals("property")){
					StmtIterator iterProps = s.getSubject().listProperties();
					while (iterProps.hasNext()) {
						Statement sp = iterProps.nextStatement();
						if(sp.getPredicate().toString().equals(strategyData)){
							type = sp.getObject().toString();
							if(type.contains(":") && !type.contains("http:")){
								String prefix = type.split(":")[0];
								if(model.getNsPrefixMap().containsKey(prefix)){
									type = model.getNsPrefixMap().get(prefix)+type.split(":")[1];
									entityTypes.add(model.getNsPrefixMap().get(prefix)+type.split(":")[1]);
								}
							}
							break;
						}
					}	
				}
				else if(strategy.equals("definition")){
					type = s.getSubject().toString();
				}
				if(type != null){
					entityTypes.add(type);
				}
				
				
				// Get the predicate types
				if(s.getPredicate().isURIResource() && !s.getPredicate().toString().equals(strategyData)){
					propertyTypes.add(s.getPredicate().toString());
					if(!s.getObject().isURIResource()){
						property = s.getPredicate().toString();
						data = s.getObject().toString();
					}
				}
				
				// Build an entity if not exists
				Entity e = null;
				if(!ents.containsKey(s.getSubject().toString())){
					e = new Entity();
					ents.put(s.getSubject().toString(), e);
				}else{
					e = ents.get(s.getSubject().toString());
				}
				if(e != null && property != null && data != null){
					if(e.getProperties().get(property) == null){
						e.getProperties().put(property, new ArrayList<String>());
					}
					e.getProperties().get(property).add(data);
				}
				
			}
		}
		return ents;
	}


	/*public List<Tree> readExpert(RDFRequest request) throws Exception {
		
		Model model = ModelFactory.createDefaultModel();

		// use the FileManager to find the input file
		InputStream in = FileManager.get().open(request.getPath());
		if (in == null) {
			throw new IllegalArgumentException("File: " + request.getPath() + " not found");
		}

		// read the RDF/XML file
		try {
			model.read(in, null);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		List<String> frbrElement = new ArrayList<String>();
		for (Method method : FRBR.class.getDeclaredMethods()) {
			frbrElement.add(method.getName());
			frbrElement.add(FRBR.BENCH+"/"+method.getName());
		}
		
		// specific cases
		frbrElement.add("http://benchmark.syrtis.progilone.fr/FRBR/title");
		

		Map<String, List<Statement>> orderedData = new HashMap<String, List<Statement>>();

		StmtIterator iter = model.listStatements();
		if (iter.hasNext()) {
			// System.out.println("Results:");
			while (iter.hasNext()) {
				Statement s = iter.nextStatement();
				String lc = s.getSubject().toString();
				//System.out.println("Subject Expert: "+lc);
				if (!frbrElement.contains(lc)) {
					if (!orderedData.containsKey(lc)) {
						orderedData.put(lc, new ArrayList<Statement>());
					}
					orderedData.get(lc).add(s);
				} else {
					// get the same as !!
				}
			}
		}

		// List<Entity> ents = new ArrayList<Entity>();
		Map<FRBREntity, List<Entity>> ents = new HashMap<FRBREntity, List<Entity>>();

		for (Iterator<Map.Entry<String, List<Statement>>> it = orderedData
				.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, List<Statement>> entry = it.next();
			String key = entry.getKey();
			List<Statement> value = entry.getValue();

			// System.out.println("# "+key+":");

			Entity e = EntityRepository.createEntityFromRDF(key, baseURI,
					entry, str, data);

			if (e != null) {
				if (!ents.containsKey(e.getType())) {
					ents.put(e.getType(), new ArrayList<Entity>());
				}
				ents.get(e.getType()).add(e);
			}

		}

		// Building of Trees
		FRBRPropertyTypeRepository pt = new FRBRPropertyTypeRepository();
		List<Tree> trees = new ArrayList<Tree>();
		List<Entity> manifs = ents.get(FRBREntity.MANIFESTATION);
		for (Iterator<Entity> iterator = manifs.iterator(); iterator.hasNext();) {
			Entity e = (Entity) iterator.next();
			Tree t = new Tree(e.getIdentifier());
			configurePattern(t);
			t.build(e, ents,pt);
			trees.add(t);
		}

		return trees;

	}*/
	
	
	/*public List<Entity> readCollection(String path, String baseURI, TYPE_STRATEGY str,
			String data) throws Exception {

		Model model = ModelFactory.createDefaultModel();

		// use the FileManager to find the input file
		InputStream in = FileManager.get().open(path);
		if (in == null) {
			throw new IllegalArgumentException("File: " + path + " not found");
		}

		// read the RDF/XML file
		try {
			model.read(in, null);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

		List<String> frbrElement = new ArrayList<String>();
		for (Method method : FRBR.class.getDeclaredMethods()) {
			frbrElement.add(method.getName());
		}

		Map<String, List<Statement>> orderedData = new HashMap<String, List<Statement>>();

		StmtIterator iter = model.listStatements();
		if (iter.hasNext()) {
			// System.out.println("Results:");
			while (iter.hasNext()) {
				Statement s = iter.nextStatement();
				String lc = s.getSubject().toString();
				//System.out.println("Subject Coll: "+lc);
				//System.out.println("Statement Collection: "+s.toString());
				if (!frbrElement.contains(lc)) {
					if (!orderedData.containsKey(lc)) {
						orderedData.put(lc, new ArrayList<Statement>());
					}
					orderedData.get(lc).add(s);
				} else {
					// get the same as !!
				}
			}
		}

		// List<Entity> ents = new ArrayList<Entity>();
		//Map<FRBREntity, List<Entity>> ents = new HashMap<FRBREntity, List<Entity>>();
		List<Entity> ents = new ArrayList<Entity>();

		for (Iterator<Map.Entry<String, List<Statement>>> it = orderedData
				.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, List<Statement>> entry = it.next();
			String key = entry.getKey();
			List<Statement> value = entry.getValue();
			Entity e = EntityRepository.createEntityFromRDF(key, baseURI,
					entry, str, data);

			if (e != null && e.getIdentifier().startsWith(baseURI)) {
				
				ents.add(e);
			}else{
				//System.out.println("Entity Not Created !");
			}

		}


		return ents;

	}*/
	
	/**
	 * Configure the pattern to be evaluated
	 * @param t
	 */
	/*public void configurePattern(Tree t){
		
		
		// VHC
		
		t.getMainEntities().add("translations");
		t.getMainEntities().add("illustrations");
		t.getMainEntities().add("augmentations");
		t.getMainEntities().add("subjects");
		//t.getMainEntities().add("wholeParts");
		
		
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/translatedAs");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/wholePartWorkRelationship");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/augmentedByWork");
		
		
		t.getSecEntities().add("creators");
		t.getSecEntities().add("actors");
		t.getSecEntities().add("artists");
		
		t.getSecEntities().add("narrators");
		t.getSecEntities().add("adaptors");
		t.getSecEntities().add("translators");
		t.getSecEntities().add("composers");
		
		t.getSecRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/hasAsSubjectConcept");
		t.getSecRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/creator");
		t.getSecRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/adaptor");
		t.getSecRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/artist");
		t.getSecRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/composer");
		
		// core
		t.getMainEntities().add("Work");
		t.getMainEntities().add("Expression");
		t.getMainEntities().add("Manifestation");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/manifestationOfExpression");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/expressionOfWork");
		t.getSecEntities().add("creators");
		t.getSecRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/creator");
		
		// aug
		t.getMainEntities().add("appendixWorks");
		t.getMainEntities().add("illustrations");
		t.getSecEntities().add("Work");
		t.getSecEntities().add("Expression");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/appendixWorks");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/writerOfIntroduction");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/illustrationsExpression");
		
		// der
		t.getMainEntities().add("translations");
		t.getMainEntities().add("motionPictures");
		t.getMainEntities().add("graphicNovels");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/translatedAs");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/adaptedAsMotionPictureWork");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/adaptedAsGraphicNovelWork");
		t.getSecEntities().add("translators");
		t.getSecRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/translator");
		
		//agg
		t.getMainEntities().add("publications");
		t.getMainEntities().add("containers");
		t.getMainEntities().add("wholeParts");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/containerOfManifestation");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/containerOfWork");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/wholePartWorkRelationship");
		
		//comp
		/*t.getMainEntities().add("continuations");
		t.getMainEntities().add("complements");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/continuationOfWork");
		t.getMainRelationships().add("http://benchmark.syrtis.progilone.fr/FRBR/complementedByWork");
		
		

	}*/


	public Model getModel() {
		return model;
	}


	public void setModel(Model model) {
		this.model = model;
	}

	public Set<String> getEntityTypes() {
		return entityTypes;
	}

	public void setEntityTypes(Set<String> entityTypes) {
		this.entityTypes = entityTypes;
	}

	public Set<String> getPropertyTypes() {
		return propertyTypes;
	}

	public void setPropertyTypes(Set<String> propertyTypes) {
		this.propertyTypes = propertyTypes;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getStrategyData() {
		return strategyData;
	}

	public void setStrategyData(String strategyData) {
		this.strategyData = strategyData;
	}

}
