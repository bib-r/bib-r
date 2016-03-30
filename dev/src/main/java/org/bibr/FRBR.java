package org.bibr;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDF;
import org.apache.jena.vocabulary.DCTerms;
import org.apache.jena.vocabulary.RDFS;

/**
 * FRBR Ontology for the Benchmark
 * @author Joffrey
 *
 */
public class FRBR {
	
	public final static String RDA = "http://rdaregistry.info/Elements";
	public final static String FRBRER = "http://iflastandards.info/ns/fr/frbr/frbrer";
	public final static String RDAVOCAB = "http://rdvocab.info/Elements";
	
	// RDA categories
	public final static String catClass = "c";
	public final static String catAgent = "a";
	public final static String catWork = "w";
	public final static String catExpression = "e";
	public final static String catManifestation = "m";
	public final static String catItem = "i";
	
	// PRELIMINARIES
	
	public static void initializeModel(Model model) throws Exception {
		model.setNsPrefix("rda", RDA+"/");
		model.setNsPrefix("rdac", RDA+"/"+catClass+"/");
		model.setNsPrefix("rdaa", RDA+"/"+catAgent+"/");
		model.setNsPrefix("rdaw", RDA+"/"+catWork+"/");
		model.setNsPrefix("rdae", RDA+"/"+catExpression+"/");
		model.setNsPrefix("rdam", RDA+"/"+catManifestation+"/");
		model.setNsPrefix("rdai", RDA+"/"+catItem+"/");
		model.setNsPrefix("frbr", FRBRER+"/");
	}
	
	// CLASSES
	
	/**
	 * FRBR Person
	 * @param model
	 * @return a Person entity
	 */
	public static Resource person(Model model, String id){
		Resource person = model.createResource(RDA+"/"+catClass+"/"+"Person"+"#"+id);
		person.addProperty(RDF.type,RDA+"/"+catClass+"/"+"C10004");
		return person;
	}

	// -----------
	
	/**
	 * FRBR Corporate Body
	 * @param model
	 * @return a Corporate Body entity
	 */
	public static Resource corporate(Model model, String id){
		Resource corp = model.createResource(RDA+"/"+catClass+"/"+"CorporateBody"+"#"+id);
		corp.addProperty(RDF.type,RDA+"/"+catClass+"/"+"C10005");
		return corp;
	}

	// -----------
	
	/**
	 * FRBR Family
	 * @param model
	 * @return a Family entity
	 */
	public static Resource family(Model model, String id){
		Resource family = model.createResource(RDA+"/"+catClass+"/"+"Family"+"#"+id);
		family.addProperty(RDF.type,RDA+"/"+catClass+"/"+"C10008");
		return family;
	}
	// -----------
	
	
	/**
	 * FRBR Work
	 * @param model
	 * @return a Work entity
	 */
	public static Resource work(Model model, String id){
		Resource work = model.createResource(RDA+"/"+catClass+"/"+"Work"+"#"+id);
		work.addProperty(RDF.type,RDA+"/"+catClass+"/"+"C10001");
		return work;
	}

	// -----------
	
	/**
	 * FRBR Expression
	 * @param model
	 * @return an Expression entity
	 */
	public static Resource expression(Model model, String id){
		Resource expr = model.createResource(RDA+"/"+catClass+"/"+"Expression"+"#"+id);
		expr.addProperty(RDF.type,RDA+"/"+catClass+"/"+"C10006");
		return expr;
	}

	// -----------
	
	/**
	 * FRBR Manifestation
	 * @param model
	 * @return a Manifestation entity
	 */
	public static Resource manifestation(Model model, String id){
		Resource manif = model.createResource(RDA+"/"+catClass+"/"+"Manifestation"+"#"+id);
		manif.addProperty(RDF.type,RDA+"/"+catClass+"/"+"C10007");
		return manif;
	}

	// -----------
	
	/**
	 * FRBR Item
	 * @param model
	 * @return an Item entity
	 */
	public static Resource item(Model model, String id){
		Resource item = model.createResource(RDA+"/"+catClass+"/"+"Item"+"#"+id);
		item.addProperty(RDF.type,RDA+"/"+catClass+"/"+"C10003");
		return item;
	}

	// -----------
	
	/**
	 * FRBR Concept
	 * @param model
	 * @return a Concept entity
	 */
	public static Resource concept(Model model, String id){
		Resource concept = model.createResource(FRBRER +"/"+ "Concept"+"#"+id);
		concept.addProperty(RDF.type,FRBRER +"/"+ "C1007");
		return concept;
	}
	// -----------
	
	/**
	 * FRBR Object
	 * @param model
	 * @return an Object entity
	 */
	public static Resource object(Model model, String id){
		Resource obj = model.createResource(FRBRER +"/"+ "Object"+"#"+id);
		obj.addProperty(RDF.type,FRBRER +"/"+ "C1008");
		return obj;
	}
	// -----------
	
	/**
	 * FRBR Event
	 * @param model
	 * @return an Event entity
	 */
	public static Resource event(Model model, String id){
		Resource event = model.createResource(FRBRER +"/"+ "Event"+"#"+id);
		event.addProperty(RDF.type,FRBRER +"/"+ "C1009");
		return event;
	}
	// -----------
	
	
	/**
	 * FRBR Place
	 * @param model
	 * @return a Place entity
	 */
	public static Resource place(Model model, String id){
		Resource place = model.createResource(FRBRER +"/"+ "Place"+"#"+id);
		place.addProperty(RDF.type,FRBRER +"/"+ "C1010");
		return place;
		
	}
	// -----------
	
	// PERSON PROPERTIES
	
	/**
	 * Person Name
	 * @param model
	 * @return
	 */
	public static Property nameOfThePerson(Model model){
		Property name = model.createProperty(RDA+"/"+catAgent+"/"+"nameOfThePerson");
		return name;
	}

	
	/**
	 * Person Dates
	 * @param model
	 * @return
	 */
	public static Property dateAssociatedWithThePerson(Model model){
		Property p = model.createProperty(RDA+"/"+catAgent+"/"+"dateAssociatedWithThePerson");
		return p;
	}

	
	/**
	 * Person Name
	 * @param model
	 * @return
	 */
	public static Property identifierForThePerson(Model model){
		Property p = model.createProperty(RDA+"/"+catAgent+"/"+"identifierForThePerson");
		return p;
	}

	
	
	
	// CORPORATE BODY PROPERTIES
	
	/**
	 * Corporate Body Identifier
	 * @param model
	 * @return
	 */
	public static Property identifierForTheCorporateBody(Model model){
		Property p = model.createProperty(RDA+"/"+catAgent+"/"+"identifierForTheCorporateBody");
		return p;
	}

	
	/**
	 * Corporate Body Name
	 * @param model
	 * @return
	 */
	public static Property nameOfTheCorporateBody(Model model){
		Property p = model.createProperty(RDA+"/"+catAgent+"/"+"nameOfTheCorporateBody");
		return p;
		
	}

	
	/**
	 * Corporate Body Other Designation
	 * @param model
	 * @return
	 */
	public static Property otherDesignationAssociatedWithTheCorporateBody(Model model){
		Property p = model.createProperty(RDA+"/"+catAgent+"/"+"otherDesignationAssociatedWithTheCorporateBody");
		return p;
	}

	
	
	
	
	// WORK PROPERTIES
	
	/**
	 *  Work Identifier
	 * @param model
	 * @return
	 */
	public static Property identifierForTheWork(Model model){
		Property p = model.createProperty(RDA+"/"+catWork+"/"+"identifierForTheWork");
		return p;
	}

	
	/**
	 *  Work Title
	 * @param model
	 * @return
	 */
	public static Property titleOfTheWork(Model model){
		Property title = model.createProperty(RDA+"/"+catWork+"/"+"titleOfTheWork");
		return title;
	}

	
	/**
	 *  Augmentation of Work
	 * @param model
	 * @return
	 */
	public static Property augmentedByWork(Model model){
		Property aug = model.createProperty(RDA+"/"+catWork+"/"+"augmentedByWork");
		return aug;
	}

	
	/**
	 *  Artist of Work
	 * @param model
	 * @return
	 */
	public static Property artist(Model model){
		Property art = model.createProperty(RDA+"/"+catWork+"/"+"artist");
		return art;
	}

	
	/**
	 *  Composer of Work
	 * @param model
	 * @return
	 */
	public static Property composer(Model model){
		Property cmp = model.createProperty(RDA+"/"+catWork+"/"+"composer");
		return cmp;
	}

	
	
	/**
	 *  Work Variant Title
	 * @param model
	 * @return
	 */
	public static Property variantTitleForTheWork(Model model){
		Property vtitle = model.createProperty(RDA+"/"+catWork+"/"+"variantTitleForTheWork");
		return vtitle;
	}

	
	/**
	 *  Work Supplement
	 * @param model
	 * @return
	 */
	public static Property supplementWork(Model model){
		Property supp = model.createProperty(RDA+"/"+catWork+"/"+"supplementWork");
		return supp;
	}

	
	/**
	 * Work Continuation
	 * @param model
	 * @return
	 */
	public static Property continuationOfWork(Model model){
		Property cont = model.createProperty(RDA+"/"+catWork+"/"+"continuationOfWork");
		return cont;
	}

	
	/**
	 * Work Complement 
	 * @param model
	 * @return
	 */
	public static Property complementedByWork(Model model){
		Property comp = model.createProperty(RDA+"/"+catWork+"/"+"complementedByWork");
		return comp;
	}

	
	/**
	 * Parody
	 * @param model
	 * @return
	 */
	public static Property parodyOfWork(Model model){
		Property par = model.createProperty(RDA+"/"+catWork+"/"+"parodyOfWork");
		return par;
	}

	
	/**
	 *  Appendix Work
	 * @param model
	 * @return
	 */
	public static Property appendixWork(Model model){
		Property app = model.createProperty(RDA+"/"+catWork+"/"+"appendixWork");
		return app;
	}

	
	/**
	 * Motion Picture adaptation Work
	 * @param model
	 * @return
	 */
	public static Property adaptedAsMotionPictureWork(Model model){
		Property amp = model.createProperty(RDA+"/"+catWork+"/"+"adaptedAsMotionPictureWork");
		return amp;
	}

	
	/**
	 * Graphic Novel adaptation Work
	 * @param model
	 * @return
	 */
	public static Property adaptedAsGraphicNovelWork(Model model){
		Property agn = model.createProperty(RDA+"/"+catWork+"/"+"adaptedAsGraphicNovelWork");
		return agn;
	}

	
	/**
	 * Illustration Work
	 * @param model
	 * @return
	 */
	public static Property illustrationsWork(Model model){
		Property ill = model.createProperty(RDA+"/"+catWork+"/"+"illustrationsWork");
		return ill;
	}

	
	/**
	 *  Creator
	 * @param model
	 * @return
	 */
	public static Property creator(Model model){
		Property creator = model.createProperty(RDA+"/"+catWork+"/"+"creator");
		return creator;
	}

	
	/**
	 *  Compiler
	 * @param model
	 * @return
	 */
	public static Property compiler(Model model){
		Property creator = model.createProperty(RDA+"/"+catWork+"/"+"compiler");
		return creator;
	}

	
	/**
	 *  Director
	 * @param model
	 * @return
	 */
	public static Property director(Model model){
		Property creator = model.createProperty(RDA+"/"+catWork+"/"+"director");
		return creator;
	}

	
	
	/**
	 * Part Work
	 * @param model
	 * @return
	 */
	public static Property wholePartWorkRelationship(Model model){
		Property pw = model.createProperty(RDA+"/"+catWork+"/"+"wholePartWorkRelationship");
		return pw;
	}

	
	/**
	 * Work Container of
	 * @param model
	 * @return
	 */
	public static Property containerOfWork(Model model){
		Property pw = model.createProperty(RDA+"/"+catWork +"/"+ "containerOfWork");
		return pw;
	}

	
	/**
	 * Work Series
	 * @param model
	 * @return
	 */
	public static Property seriesContainerOf(Model model){
		Property series = model.createProperty(RDA+"/"+catWork +"/"+ "seriesContainerOf");
		return series;
	}

	
	/**
	 * Work Numbering of Part
	 * @param model
	 * @return
	 */
	public static Property numberingOfPart(Model model){
		Property nbpart = model.createProperty(RDA+"/"+catWork +"/"+ "numberingOfPart");
		return nbpart;
	}

	
	
	/**
	 *  Expression of Work
	 * @param model
	 * @return
	 */
	public static Property expressionOfWork(Model model){
		Property exp = model.createProperty(RDA+"/"+catWork +"/"+ "expressionOfWork");
		return exp;
	}

	
	/**
	 * Concept, Subject of a Work
	 * @param model
	 * @return
	 */
	public static Property hasAsSubjectConcept(Model model){
		Property sub = model.createProperty(FRBRER +"/"+ "hasAsSubjectConcept");
		return sub;
	}

	
	/**
	 * Place, Subject of a Work
	 * @param model
	 * @return
	 */
	public static Property hasAsSubjectPlace(Model model){
		Property sub = model.createProperty(FRBRER +"/"+ "hasAsSubjectPlace");
		return sub;
	}

	
	// EXPRESSION PROPERTIES
	
	/**
	 * Title of Expression
	 * @param model
	 * @return
	 */
	public static Property hasTitleOfTheExpression(Model model){
		Property title = model.createProperty(FRBRER +"/"+ "hasTitleOfTheExpression");
		return title;
	}

	
	/**
	 * Language of Expression
	 * @param model
	 * @return
	 */
	public static Property languageOfExpression(Model model){
		Property language = model.createProperty(RDA+"/"+catExpression +"/"+ "languageOfExpression");
		return language;
	}

	
	/**
	 * Summarization of Content
	 * @param model
	 * @return
	 */
	public static Property summarizationOfTheContent(Model model){
		Property summary = model.createProperty(FRBRER +"/"+ "summarizationOfTheContent");
		return summary;
	}

	
	/**
	 *  Manifestation of Expression
	 * @param model
	 * @return
	 */
	public static Property manifestationOfExpression(Model model){
		Property manif = model.createProperty(RDA+"/"+catExpression +"/"+ "manifestationOfExpression");
		return manif;
	}

	
	/**
	 * Note on Introduction
	 * @param model
	 * @return
	 */
	public static Property noteOnExpression(Model model){
		Property ne = model.createProperty(RDA+"/"+catExpression +"/"+ "noteOnExpression");
		return ne;
	}

	
	/**
	 * Award
	 * @param model
	 * @return
	 */
	public static Property award(Model model){
		Property award = model.createProperty(RDA+"/"+catExpression +"/"+ "award");
		return award;
	}

	
	/**
	 * Illustration Expression
	 * @param model
	 * @return
	 */
	public static Property illustrationsExpression(Model model){
		Property ie = model.createProperty(RDA+"/"+catExpression +"/"+ "illustrationsExpression");
		return ie;
	}

	
	/**
	 * Illustrator
	 * @param model
	 * @return
	 */
	public static Property illustrator(Model model){	
		Property ill = model.createProperty(RDA+"/"+catExpression +"/"+ "illustrator");
		return ill;
	}

	
	/**
	 * Editor
	 * @param model
	 * @return
	 */
	public static Property editor(Model model){
		Property ed = model.createProperty(RDA+"/"+catExpression +"/"+ "editor");
		return ed;
	}

	
	/**
	 * Contributor
	 * @param model
	 * @return
	 */
	public static Property contributor(Model model){
		Property contrib = model.createProperty(RDA+"/"+catExpression +"/"+ "contributor");
		return contrib;
	}

	
	/**
	 * Translator
	 * @param model
	 * @return
	 */
	public static Property translator(Model model){
		Property trans = model.createProperty(RDA+"/"+catExpression +"/"+ "translator");
		return trans;
	}

	
	/**
	 * Actor
	 * @param model
	 * @return
	 */
	public static Property actor(Model model){
		Property act = model.createProperty(RDA+"/"+catExpression +"/"+ "actor");
		return act;
	}

	
	/**
	 * Translation
	 * 
	 * @param model
	 * @return
	 */
	public static Property translatedAs(Model model){
		Property translation = model.createProperty(RDA+"/"+catExpression +"/"+ "translatedAs");
		return translation;
	}

	
	/**
	 * Narrator
	 * @param model
	 * @return
	 */
	public static Property narrator(Model model){
		Property narr = model.createProperty(RDA+"/"+catExpression +"/"+ "narrator");
		return narr;
	}

	
	/**
	 * Writer of Introduction
	 * @param model
	 * @return
	 */
	public static Property writerOfIntroduction(Model model){
		Property wi = model.createProperty(RDA+"/"+catExpression +"/"+ "writerOfIntroduction");
		return wi;
	}

	
	// 	MANIFESTATION PROPERTIES
	
	/**
	 * Identifier of Manifestation
	 * @param model
	 * @return
	 */
	public static Property identifierForTheManifestation(Model model){
		Property id = model.createProperty(RDA+"/"+catManifestation +"/"+ "identifierForTheManifestation");
		return id;
	}

	
	/**
	 * Manifestation Title
	 * @param model
	 * @return
	 */
	public static Property titleOfTheManifestation(Model model){
		Property title = model.createProperty(RDA+"/"+catManifestation +"/"+ "title");
		return title;
		
	}

	
	/**
	 * Manifestation Statement of Responsibility
	 * @param model
	 * @return
	 */
	public static Property statementOfResponsibilityRelatingToTitleProper(Model model){
		Property ps = model.createProperty(RDA+"/"+catManifestation +"/"+ "statementOfResponsibilityRelatingToTitleProper");
		return ps;
	}
	

	
	/**
	 * Manifestation Publication Statement
	 * @param model
	 * @return
	 */
	public static Property publicationStatement(Model model){
		Property ps = model.createProperty(RDA+"/"+catManifestation +"/"+ "publicationStatement");
		return ps;
	}

	
	/**
	 * Manifestation designationOfEdition
	 * @param model
	 * @return
	 */
	public static Property designationOfEdition(Model model){
		Property nps = model.createProperty(RDA+"/"+catManifestation +"/"+ "designationOfEdition");
		return nps;
	}

	
	/**
	 * Manifestation Note on Publication Statement
	 * @param model
	 * @return
	 */
	public static Property noteOnPublicationStatement(Model model){
		Property nps = model.createProperty(RDA+"/"+catManifestation +"/"+ "noteOnPublicationStatement");
		return nps;
	}

	
	/**
	 * Insert
	 * @param model
	 * @return
	 */
	public static Property insert(Model model){
		Property ins = model.createProperty(RDA+"/"+catManifestation +"/"+ "insert");
		return ins;
	}

	
	
	/**
	 * Manifestation Frequency
	 * @param model
	 * @return
	 */
	public static Property frequency(Model model){
		Property freq = model.createProperty(RDA+"/"+catManifestation +"/"+ "frequency");
		return freq;
	}

	
	/**
	 * Manifestation Serial ISSN
	 * @param model
	 * @return
	 */
	public static Property issnOfSeries(Model model){
		Property issn = model.createProperty(RDA+"/"+catManifestation +"/"+ "issnOfSeries");
		return issn;
	}

	/**
	 * Manifestation Dimensions
	 * @param model
	 * @return
	 */
	public static Property dimensions(Model model){
		Property dim = model.createProperty(RDA+"/"+catManifestation +"/"+ "dimensions");
		return dim;
	}

	
	/**
	 * Manifestation Extent
	 * @param model
	 * @return
	 */
	public static Property extent(Model model){
		Property ext = model.createProperty(RDA+"/"+catManifestation +"/"+ "extent");
		return ext;
	}

	
	/**
	 * Manifestation Note on Carrier
	 * @param model
	 * @return
	 */
	public static Property noteOnCarrier(Model model){
		Property ext = model.createProperty(RDA+"/"+catManifestation +"/"+ "noteOnCarrier");
		return ext;
	}

	
	/**
	 * Manifestation Form of Carrier
	 * @param model
	 * @return
	 */
	public static Property carrierType(Model model){
		Property ext = model.createProperty(RDA+"/"+catManifestation +"/"+ "carrierType");
		return ext;
	}

	
	/**
	 * Manifestation Terms of Availability
	 * @param model
	 * @return
	 */
	public static Property termsOfAvailability(Model model){
		Property ta = model.createProperty(RDA+"/"+catManifestation +"/"+ "termsOfAvailability");
		return ta;
	}

	
	/**
	 * Manifestation Place of publication
	 * @param model
	 * @return
	 */
	public static Property placeOfPublication(Model model){
		Property pp = model.createProperty(RDA+"/"+catManifestation +"/"+ "placeOfPublication");
		return pp;
	}

	
	/**
	 * Manifestation Date of publication
	 * @param model
	 * @return
	 */
	public static Property dateOfPublication(Model model){
		Property dp = model.createProperty(RDA+"/"+catManifestation +"/"+ "dateOfPublication");
		return dp;
	}

	
	/**
	 * Container of Manifestation
	 * @param model
	 * @return
	 */
	public static Property containerOfManifestation(Model model){
		Property cm = model.createProperty(RDA+"/"+catManifestation +"/"+ "containerOfManifestation");
		return cm;
	}

	
	/**
	 * Publisher of Manifestation
	 * @param model
	 * @return
	 */
	public static Property publisher(Model model){
		Property publisher = model.createProperty(RDA+"/"+catManifestation +"/"+ "publisher");
		return publisher;
	}

	
	/**
	 * Other Information of Proper Title
	 * @param model
	 * @return
	 */
	public static Property otherTitleInformation(Model model){
		Property proptitleinfo = model.createProperty(RDA+"/"+catManifestation +"/"+ "otherTitleInformation");
		return proptitleinfo;
	}

	
	
	/**
	 * Also issues as
	 * @param model
	 * @return
	 */
	public static Property alsoIssuedAs(Model model){
		Property aia = model.createProperty(RDA+"/"+catManifestation +"/"+ "alsoIssuedAs");
		return aia;
	}

	
	/**
	 * Numbering in Series
	 * @param model
	 * @return
	 */
	public static Property numberingWithinSeries(Model model){
		Property nbs = model.createProperty(RDA+"/"+catManifestation +"/"+ "numberingWithinSeries");
		return nbs;
	}

	
	/**
	 * Numbering in SubSeries
	 * @param model
	 * @return
	 */
	public static Property numberingWithinSubseries(Model model){
		Property nbss = model.createProperty(RDA+"/"+catManifestation +"/"+ "numberingWithinSubseries");
		return nbss;
	}

	
	/**
	 * Series Statement
	 * @param model
	 * @return
	 */
	public static Property seriesStatement(Model model){
		Property ss = model.createProperty(RDA+"/"+catManifestation +"/"+ "seriesStatement");
		return ss;
	}

	
	// CONCEPT PROPERTIES
	
	/**
	 * Concept Term
	 * @param model
	 * @return
	 */
	public static Property hasTermForTheConcept(Model model){
		Property conceptTerm = model.createProperty(FRBRER +"/"+ "hasTermForTheConcept");
		return conceptTerm;
	}

	
	// PLACE PROPERTIES
	
	/**
	 * Place Term
	 * @param model
	 * @return
	 */
	public static Property hasTermForThePlace(Model model){
		Property placeTerm = model.createProperty(FRBRER +"/"+ "hasTermForThePlace");
		return placeTerm;
	}

	
	// 	EVENT PROPERTIES
	
	/**
	 * Event Term
	 * @param model
	 * @return
	 */
	public static Property hasTermForTheEvent(Model model){
		Property eventTerm = model.createProperty(FRBRER +"/"+ "hasTermForTheEvent");
		return eventTerm;
	}

}
