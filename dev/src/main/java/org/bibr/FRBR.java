package org.bibr;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.OWL;
import org.apache.jena.vocabulary.RDFS;

/**
 * FRBR Ontology for the Benchmark
 * @author Joffrey
 *
 */
public class FRBR {
	
	public final static String BENCH = "http://research.progilone.fr/benchmark";
	public final static String FRBRER = "http://iflastandards.info/ns/fr/frbr/frbrer";
	public final static String RDA = "http://rdaregistry.info/Elements";
	
	// RDA categories
	public final static String catClass = "c";
	public final static String catAgent = "a";
	public final static String catWork = "w";
	public final static String catExpression = "e";
	public final static String catManifestation = "m";
	public final static String catItem = "i";
	
	// PRELIMINARIES
	
	public static void initializeModel(Model model) throws Exception {
		model.setNsPrefix("frbr", BENCH+"/");
	}
	
	// CLASSES
	
	/**
	 * FRBR Person
	 * @param model
	 * @return a Person entity
	 */
	public static Resource person(Model model, String id){
		Resource person = model.createResource(BENCH +"/"+ "Person"+"#"+id);
		return person;
	}
	public Resource person_ONT(Model model){
		Resource person;
		person = model.createResource(BENCH +"/"+ "Person");
		person.addLiteral(RDFS.label,"Person");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1005");
		Resource rdaeq = model.createResource(RDA+"/"+catClass+"/"+"C10004");
		person.addProperty(OWL.sameAs,frbreq);
		person.addProperty(OWL.sameAs,rdaeq);
		return person;
	}
	// -----------
	
	/**
	 * FRBR Corporate Body
	 * @param model
	 * @return a Corporate Body entity
	 */
	public static Resource corporate(Model model, String id){
		Resource corp = model.createResource(BENCH +"/"+ "CorporateBody"+"#"+id);
		return corp;
	}
	public Resource corporate_ONT(Model model){
		Resource corp = model.createResource(BENCH +"/"+ "CorporateBody");
		corp.addLiteral(RDFS.label,"CorporateBody");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1006");
		Resource rdaeq = model.createResource(RDA+"/"+catClass+"/"+"C10005");
		corp.addProperty(OWL.sameAs,frbreq);
		corp.addProperty(OWL.sameAs,rdaeq);
		return corp;
	}
	// -----------
	
	/**
	 * FRBR Family
	 * @param model
	 * @return a Family entity
	 */
	public static Resource family(Model model, String id){
		Resource family = model.createResource(BENCH +"/"+ "Family"+"#"+id);
		return family;
	}
	public Resource family_ONT(Model model){
		Resource family = model.createResource(BENCH +"/"+ "Family");
		Resource rdaeq = model.createResource(RDA+"/"+catClass+"/"+"C10008");
		family.addLiteral(RDFS.label,"Family");
		family.addProperty(OWL.sameAs,rdaeq);
		return family;
	}
	// -----------
	
	
	/**
	 * FRBR Work
	 * @param model
	 * @return a Work entity
	 */
	public static Resource work(Model model, String id){
		Resource work = model.createResource(BENCH +"/"+ "Work"+"#"+id);
		return work;
	}
	public Resource work_ONT(Model model){
		Resource work = model.createResource(BENCH +"/"+ "Work");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1001");
		Resource rdaeq = model.createResource(RDA+"/"+catClass+"/"+"C10001");
		work.addLiteral(RDFS.label,"Work");
		work.addProperty(OWL.sameAs,frbreq);
		work.addProperty(OWL.sameAs,rdaeq);
		return work;
		
	}
	// -----------
	
	/**
	 * FRBR Expression
	 * @param model
	 * @return an Expression entity
	 */
	public static Resource expression(Model model, String id){
		Resource expr = model.createResource(BENCH +"/"+ "Expression"+"#"+id);
		return expr;
	}
	public Resource expression_ONT(Model model){
		Resource expr = model.createResource(BENCH +"/"+ "Expression");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1002");
		Resource rdaeq = model.createResource(RDA+"/"+catClass+"/"+"C10006");
		expr.addLiteral(RDFS.label,"Expression");
		expr.addProperty(OWL.sameAs,frbreq);
		expr.addProperty(OWL.sameAs,rdaeq);
		return expr;
	}
	// -----------
	
	/**
	 * FRBR Manifestation
	 * @param model
	 * @return a Manifestation entity
	 */
	public static Resource manifestation(Model model, String id){
		Resource manif = model.createResource(BENCH +"/"+ "Manifestation"+"#"+id);
		return manif;
	}
	public Resource manifestation_ONT(Model model){
		Resource manif = model.createResource(BENCH +"/"+ "Manifestation");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1003");
		Resource rdaeq = model.createResource(RDA+"/"+catClass+"/"+"C10007");
		manif.addLiteral(RDFS.label,"Manifestation");
		manif.addProperty(OWL.sameAs,frbreq);
		manif.addProperty(OWL.sameAs,rdaeq);
		return manif;
	}
	// -----------
	
	/**
	 * FRBR Item
	 * @param model
	 * @return an Item entity
	 */
	public static Resource item(Model model, String id){
		Resource item = model.createResource(BENCH +"/"+ "Item"+"#"+id);
		return item;
	}
	public Resource item_ONT(Model model){
		Resource item = model.createResource(BENCH +"/"+ "Item");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1004");
		Resource rdaeq = model.createResource(RDA+"/"+catClass+"/"+"C10003");
		item.addLiteral(RDFS.label,"Item");
		item.addProperty(OWL.sameAs,frbreq);
		item.addProperty(OWL.sameAs,rdaeq);
		return item;
	}
	// -----------
	
	/**
	 * FRBR Concept
	 * @param model
	 * @return a Concept entity
	 */
	public static Resource concept(Model model, String id){
		Resource concept = model.createResource(BENCH +"/"+ "Concept"+"#"+id);
		return concept;
	}
	public Resource concept_ONT(Model model){
		Resource concept = model.createResource(BENCH +"/"+ "Concept");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1007");
		concept.addLiteral(RDFS.label,"Concept");
		concept.addProperty(OWL.sameAs,frbreq);
		return concept;
		
	}
	// -----------
	
	/**
	 * FRBR Object
	 * @param model
	 * @return an Object entity
	 */
	public static Resource object(Model model, String id){
		Resource obj = model.createResource(BENCH +"/"+ "Object"+"#"+id);
		return obj;
	}
	public Resource object_ONT(Model model){
		Resource obj = model.createResource(BENCH +"/"+ "Object");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1008");
		obj.addLiteral(RDFS.label,"Object");
		obj.addProperty(OWL.sameAs,frbreq);
		return obj;
	}
	// -----------
	
	/**
	 * FRBR Event
	 * @param model
	 * @return an Event entity
	 */
	public static Resource event(Model model, String id){
		Resource event = model.createResource(BENCH +"/"+ "Event"+"#"+id);
		return event;
	}
	public Resource event_ONT(Model model){
		Resource event = model.createResource(BENCH +"/"+ "Event");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1009");
		event.addLiteral(RDFS.label,"Event");
		event.addProperty(OWL.sameAs,frbreq);
		return event;
	}
	// -----------
	
	
	/**
	 * FRBR Place
	 * @param model
	 * @return a Place entity
	 */
	public static Resource place(Model model, String id){
		Resource place = model.createResource(BENCH +"/"+ "Place"+"#"+id);
		return place;
		
	}
	public Resource place_ONT(Model model){
		Resource place = model.createResource(BENCH +"/"+ "Place");
		Resource frbreq = model.createResource(FRBRER +"/"+ "C1010");
		place.addLiteral(RDFS.label,"Place");
		place.addProperty(OWL.sameAs,frbreq);
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
		Property name = model.createProperty(BENCH +"/"+ "nameOfThePerson");
		return name;
	}
	public Property nameOfThePerson_ONT(Model model){
		Property name = nameOfThePerson(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3039");
		Property rdaeq = model.createProperty(RDA+"/"+catAgent+"/"+"P50111");
		name.addLiteral(RDFS.label,"nameOfThePerson");
		name.addProperty(OWL.sameAs,frbreq);
		name.addProperty(OWL.sameAs,rdaeq);
		return name;
	}
	
	/**
	 * Person Dates
	 * @param model
	 * @return
	 */
	public static Property dateAssociatedWithThePerson(Model model){
		Property name = model.createProperty(BENCH +"/"+ "dateAssociatedWithThePerson");
		return name;
	}
	public Property dateAssociatedWithThePerson_ONT(Model model){
		Property name = dateAssociatedWithThePerson(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3040");
		Property rdaeq = model.createProperty(RDA+"/"+catAgent+"/"+"P50107");
		name.addLiteral(RDFS.label,"dateAssociatedWithThePerson");
		name.addProperty(OWL.sameAs,frbreq);
		name.addProperty(OWL.sameAs,rdaeq);
		return name;
		
	}
	
	/**
	 * Person Name
	 * @param model
	 * @return
	 */
	public static Property identifierForThePerson(Model model){
		Property name = model.createProperty(BENCH +"/"+ "identifierForThePerson");
		return name;
	}
	public Property identifierForThePerson_ONT(Model model){
		Property name = identifierForThePerson(model);
		Property rdaeq = model.createProperty(RDA+"/"+catAgent+"/"+"P50094");
		name.addLiteral(RDFS.label,"identifierForThePerson");
		name.addProperty(OWL.sameAs,rdaeq);
		return name;
	}
	
	
	
	// CORPORATE BODY PROPERTIES
	
	/**
	 * Corporate Body Identifier
	 * @param model
	 * @return
	 */
	public static Property identifierForTheCorporateBody(Model model){
		Property id = model.createProperty(BENCH +"/"+ "identifierForTheCorporateBody");
		return id;
	}
	public Property identifierForTheCorporateBody_ONT(Model model){
		Property id = identifierForTheCorporateBody(model);
		Property rdaeq = model.createProperty(RDA+"/"+catAgent+"/"+"P50032");
		id.addLiteral(RDFS.label,"identifierForTheCorporateBody");
		id.addProperty(OWL.sameAs,rdaeq);
		return id;
	}
	
	/**
	 * Corporate Body Name
	 * @param model
	 * @return
	 */
	public static Property nameOfTheCorporateBody(Model model){
		Property name = model.createProperty(BENCH +"/"+ "nameOfTheCorporateBody");
		return name;
		
	}
	public Property nameOfTheCorporateBody_ONT(Model model){
		Property name = nameOfTheCorporateBody(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3043");
		Property rdaeq = model.createProperty(RDA+"/"+catAgent+"/"+"P50032");
		name.addLiteral(RDFS.label,"nameOfTheCorporateBody");
		name.addProperty(OWL.sameAs,frbreq);
		name.addProperty(OWL.sameAs,rdaeq);
		return name;
		
	}
	
	/**
	 * Corporate Body Other Designation
	 * @param model
	 * @return
	 */
	public static Property otherDesignationAssociatedWithTheCorporateBody(Model model){
		Property odc = model.createProperty(BENCH +"/"+ "otherDesignationAssociatedWithTheCorporateBody");
		return odc;
	}
	public Property otherDesignationAssociatedWithTheCorporateBody_ONT(Model model){
		Property odc = otherDesignationAssociatedWithTheCorporateBody(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3047");
		Property rdaeq = model.createProperty(RDA+"/"+catAgent+"/"+"P50033");
		odc.addLiteral(RDFS.label,"otherDesignationAssociatedWithTheCorporateBody");
		odc.addProperty(OWL.sameAs,frbreq);
		odc.addProperty(OWL.sameAs,rdaeq);
		return odc;
		
	}
	
	
	
	
	// WORK PROPERTIES
	
	/**
	 *  Work Identifier
	 * @param model
	 * @return
	 */
	public static Property identifierForTheWork(Model model){
		Property id = model.createProperty(BENCH +"/"+ "identifierForTheWork");
		return id;
	}
	public Property identifierForTheWork_ONT(Model model){
		Property id = identifierForTheWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10002");
		id.addLiteral(RDFS.label,"identifierForTheWork");
		id.addProperty(OWL.sameAs,rdaeq);
		return id;
	}
	
	/**
	 *  Work Title
	 * @param model
	 * @return
	 */
	public static Property titleOfTheWork(Model model){
		Property title = model.createProperty(BENCH +"/"+ "titleOfTheWork");
		return title;
	}
	public Property titleOfTheWork_ONT(Model model){
		Property title = titleOfTheWork(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3001");
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10088");
		title.addLiteral(RDFS.label,"titleOfTheWork");
		title.addProperty(OWL.sameAs,frbreq);
		title.addProperty(OWL.sameAs,rdaeq);
		return title;
	}
	
	/**
	 *  Augmentation of Work
	 * @param model
	 * @return
	 */
	public static Property augmentedByWork(Model model){
		Property aug = model.createProperty(BENCH +"/"+ "augmentedByWork");
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10108");
		aug.addLiteral(RDFS.label,"augmentedByWork");
		aug.addProperty(OWL.sameAs,rdaeq);
		return aug;
	}
	public Property augmentedByWork_ONT(Model model){
		Property aug = augmentedByWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10108");
		aug.addLiteral(RDFS.label,"augmentedByWork");
		aug.addProperty(OWL.sameAs,rdaeq);
		return aug;
	}
	
	/**
	 *  Artist of Work
	 * @param model
	 * @return
	 */
	public static Property artist(Model model){
		Property art = model.createProperty(BENCH +"/"+ "artist");
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10058");
		art.addLiteral(RDFS.label,"artist");
		art.addProperty(OWL.sameAs,rdaeq);
		return art;
	}
	public Property artist_ONT(Model model){
		Property art = artist(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10058");
		art.addLiteral(RDFS.label,"artist");
		art.addProperty(OWL.sameAs,rdaeq);
		return art;
	}
	
	
	/**
	 *  Adapter of Expression
	 * @param model
	 * @return
	 */
	public static Property adaptor(Model model){
		Property adp = model.createProperty(BENCH +"/"+ "adaptor");
		adp.addLiteral(RDFS.label,"adaptor");
		return adp;
	}
	public Property adaptor_ONT(Model model){
		Property adp = adaptor(model);
		return adp;
	}
	
	/**
	 *  Composer of Work
	 * @param model
	 * @return
	 */
	public static Property composer(Model model){
		Property cmp = model.createProperty(BENCH +"/"+ "composer");
		return cmp;
	}
	public Property composer_ONT(Model model){
		Property cmp = composer(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10053");
		cmp.addLiteral(RDFS.label,"composer");
		cmp.addProperty(OWL.sameAs,rdaeq);
		cmp.addLiteral(RDFS.label,"composer");
		return cmp;
	}
	
	
	/**
	 *  Work Variant Title
	 * @param model
	 * @return
	 */
	public static Property variantTitleForTheWork(Model model){
		Property vtitle = model.createProperty(BENCH +"/"+ "variantTitleForTheWork");
		return vtitle;
	}
	public Property variantTitleForTheWork_ONT(Model model){
		Property vtitle = variantTitleForTheWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10086");
		vtitle.addLiteral(RDFS.label,"variantTitleForTheWork");
		vtitle.addProperty(OWL.sameAs,rdaeq);
		return vtitle;
	}
	
	/**
	 *  Work Supplement
	 * @param model
	 * @return
	 */
	public static Property supplementWork(Model model){
		Property supp = model.createProperty(BENCH +"/"+ "supplementWork");
		return supp;
	}
	public Property supplementWork_ONT(Model model){
		Property supp = supplementWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10172");
		supp.addLiteral(RDFS.label,"supplementWork");
		supp.addProperty(OWL.sameAs,rdaeq);
		return supp;
		
	}
	
	/**
	 * Work Continuation
	 * @param model
	 * @return
	 */
	public static Property continuationOfWork(Model model){
		Property cont = model.createProperty(BENCH +"/"+ "continuationOfWork");
		return cont;
	}
	public Property continuationOfWork_ONT(Model model){
		Property cont = continuationOfWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10226");
		cont.addLiteral(RDFS.label,"continuationOfWork");
		cont.addProperty(OWL.sameAs,rdaeq);
		return cont;
	}
	
	/**
	 * Work Complement 
	 * @param model
	 * @return
	 */
	public static Property complementedByWork(Model model){
		Property comp = model.createProperty(BENCH +"/"+ "complementedByWork");
		return comp;
	}
	public Property complementedByWork_ONT(Model model){
		Property comp = complementedByWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10103");
		comp.addLiteral(RDFS.label,"complementedByWork");
		comp.addProperty(OWL.sameAs,rdaeq);
		return comp;
	}
	
	/**
	 * Parody
	 * @param model
	 * @return
	 */
	public static Property parodyOfWork(Model model){
		Property par = model.createProperty(BENCH +"/"+ "parodyOfWork");
		return par;
	}
	public Property parodyOfWork_ONT(Model model){
		Property par = parodyOfWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10197");
		par.addLiteral(RDFS.label,"parodyOfWork");
		par.addProperty(OWL.sameAs,rdaeq);
		return par;
	}
	
	/**
	 *  Appendix Work
	 * @param model
	 * @return
	 */
	public static Property appendixWork(Model model){
		Property app = model.createProperty(BENCH +"/"+ "appendixWork");
		return app;
	}
	public Property appendixWork_ONT(Model model){
		Property app = appendixWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10123");
		app.addLiteral(RDFS.label,"appendixWork");
		app.addProperty(OWL.sameAs,rdaeq);
		return app;
	}
	
	/**
	 * Motion Picture adaptation Work
	 * @param model
	 * @return
	 */
	public static Property adaptedAsMotionPictureWork(Model model){
		Property amp = model.createProperty(BENCH +"/"+ "adaptedAsMotionPictureWork");
		return amp;
	}
	public Property adaptedAsMotionPictureWork_ONT(Model model){
		Property amp = adaptedAsMotionPictureWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10025");
		amp.addLiteral(RDFS.label,"adaptedAsMotionPictureWork");
		amp.addProperty(OWL.sameAs,rdaeq);
		return amp;
	}
	
	/**
	 * Graphic Novel adaptation Work
	 * @param model
	 * @return
	 */
	public static Property adaptedAsGraphicNovelWork(Model model){
		Property agn = model.createProperty(BENCH +"/"+ "adaptedAsGraphicNovelWork");
		return agn;
	}
	public Property adaptedAsGraphicNovelWork_ONT(Model model){
		Property agn = adaptedAsGraphicNovelWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10251");
		agn.addLiteral(RDFS.label,"adaptedAsGraphicNovelWork");
		agn.addProperty(OWL.sameAs,rdaeq);
		return agn;
	}
	
	/**
	 * Illustration Work
	 * @param model
	 * @return
	 */
	public static Property illustrationsWork(Model model){
		Property ill = model.createProperty(BENCH +"/"+ "illustrationsWork");
		return ill;
	}
	public Property illustrationsWork_ONT(Model model){
		Property ill = illustrationsWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10093");
		ill.addLiteral(RDFS.label,"illustrationsWork");
		ill.addProperty(OWL.sameAs,rdaeq);
		return ill;
	}
	
	/**
	 *  Creator
	 * @param model
	 * @return
	 */
	public static Property creator(Model model){
		Property creator = model.createProperty(BENCH +"/"+ "creator");
		return creator;
	}
	public Property creator_ONT(Model model){
		Property creator = creator(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P2009");
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10065");
		Property rdaeq2 = model.createProperty(RDA+"/"+catWork+"/"+"P10061");
		creator.addLiteral(RDFS.label,"creator");
		creator.addProperty(OWL.sameAs,frbreq);
		creator.addProperty(OWL.sameAs,rdaeq);
		creator.addProperty(OWL.sameAs,rdaeq2);
		return creator;
		
	}
	
	/**
	 *  Compiler
	 * @param model
	 * @return
	 */
	public static Property compiler(Model model){
		Property creator = model.createProperty(BENCH +"/"+ "compiler");
		return creator;
	}
	public Property compiler_ONT(Model model){
		Property creator = compiler(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10055");
		creator.addLiteral(RDFS.label,"compiler");
		creator.addProperty(OWL.sameAs,rdaeq);
		return creator;
	}
	
	/**
	 *  Director
	 * @param model
	 * @return
	 */
	public static Property director(Model model){
		Property creator = model.createProperty(BENCH +"/"+ "director");
		return creator;
	}
	public Property director_ONT(Model model){
		Property creator = director(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10066");
		creator.addLiteral(RDFS.label,"director");
		creator.addProperty(OWL.sameAs,rdaeq);
		return creator;
	}
	
	
	/**
	 * Part Work
	 * @param model
	 * @return
	 */
	public static Property wholePartWorkRelationship(Model model){
		Property pw = model.createProperty(BENCH +"/"+ "wholePartWorkRelationship");
		return pw;
	}
	public Property wholePartWorkRelationship_ONT(Model model){
		Property pw =  wholePartWorkRelationship(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P2057");
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10232");
		pw.addLiteral(RDFS.label,"wholePartWorkRelationship");
		pw.addProperty(OWL.sameAs,frbreq);
		pw.addProperty(OWL.sameAs,rdaeq);
		return pw;
	}
	
	/**
	 * Work Container of
	 * @param model
	 * @return
	 */
	public static Property containerOfWork(Model model){
		Property pw = model.createProperty(BENCH +"/"+ "containerOfWork");
		return pw;
	}
	public Property containerOfWork_ONT(Model model){
		Property pw = containerOfWork(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10147");
		pw.addLiteral(RDFS.label,"containerOfWork");
		pw.addProperty(OWL.sameAs,rdaeq);
		return pw;
	}
	
	/**
	 * Work Series
	 * @param model
	 * @return
	 */
	public static Property seriesContainerOf(Model model){
		Property series = model.createProperty(BENCH +"/"+ "seriesContainerOf");
		return series;
	}
	public Property seriesContainerOf_ONT(Model model){
		Property series = seriesContainerOf(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10141");
		series.addLiteral(RDFS.label,"seriesContainerOf");
		series.addProperty(OWL.sameAs,rdaeq);
		return series;
	}
	
	/**
	 * Work Numbering of Part
	 * @param model
	 * @return
	 */
	public static Property numberingOfPart(Model model){
		Property nbpart = model.createProperty(BENCH +"/"+ "numberingOfPart");
		return nbpart;
	}
	public Property numberingOfPart_ONT(Model model){
		Property nbpart = numberingOfPart(model);
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10012");
		nbpart.addLiteral(RDFS.label,"numberingOfPart");
		nbpart.addProperty(OWL.sameAs,rdaeq);
		return nbpart;
	}
	
	
	/**
	 *  Expression of Work
	 * @param model
	 * @return
	 */
	public static Property expressionOfWork(Model model){
		Property exp = model.createProperty(BENCH +"/"+ "expressionOfWork");
		return exp;
	}
	public Property expressionOfWork_ONT(Model model){
		Property exp = expressionOfWork(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P2001");
		Property rdaeq = model.createProperty(RDA+"/"+catWork+"/"+"P10078");
		exp.addLiteral(RDFS.label,"expressionOfWork");
		exp.addProperty(OWL.sameAs,frbreq);
		exp.addProperty(OWL.sameAs,rdaeq);
		return exp;
		
	}
	
	/**
	 * Concept, Subject of a Work
	 * @param model
	 * @return
	 */
	public static Property hasAsSubjectConcept(Model model){
		Property sub = model.createProperty(BENCH +"/"+ "hasAsSubjectConcept");
		return sub;
	}
	public Property hasAsSubjectConcept_ONT(Model model){
		Property sub = hasAsSubjectConcept(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P2023");
		sub.addLiteral(RDFS.label,"hasAsSubjectConcept");
		sub.addProperty(OWL.sameAs,frbreq);
		return sub;
	}
	
	/**
	 * Place, Subject of a Work
	 * @param model
	 * @return
	 */
	public static Property hasAsSubjectPlace(Model model){
		Property sub = model.createProperty(BENCH +"/"+ "hasAsSubjectPlace");
		return sub;
	}
	public Property hasAsSubjectPlace_ONT(Model model){
		Property sub = hasAsSubjectPlace(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P2029");
		sub.addLiteral(RDFS.label,"hasAsSubjectPlace");
		sub.addProperty(OWL.sameAs,frbreq);
		return sub;
	}
	
	// EXPRESSION PROPERTIES
	
	/**
	 * Title of Expression
	 * @param model
	 * @return
	 */
	public static Property hasTitleOfTheExpression(Model model){
		Property title = model.createProperty(BENCH +"/"+ "hasTitleOfTheExpression");
		return title;
	}
	public Property hasTitleOfTheExpression_ONT(Model model){
		Property title = hasTitleOfTheExpression(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3008");
		title.addLiteral(RDFS.label,"hasTitleOfTheExpression");
		title.addProperty(OWL.sameAs,frbreq);
		return title;
	}
	
	/**
	 * Language of Expression
	 * @param model
	 * @return
	 */
	public static Property languageOfExpression(Model model){
		Property language = model.createProperty(BENCH +"/"+ "languageOfExpression");
		return language;
	}
	public Property languageOfExpression_ONT(Model model){
		Property language = languageOfExpression(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3011");
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20006");
		language.addLiteral(RDFS.label,"languageOfExpression");
		language.addProperty(OWL.sameAs,frbreq);
		language.addProperty(OWL.sameAs,rdaeq);
		return language;
	}
	
	/**
	 * Summarization of Content
	 * @param model
	 * @return
	 */
	public static Property summarizationOfTheContent(Model model){
		Property summary = model.createProperty(BENCH +"/"+ "summarizationOfTheContent");
		return summary;
	}
	public Property summarizationOfTheContent_ONT(Model model){
		Property summary = summarizationOfTheContent(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3016");
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20069");
		summary.addLiteral(RDFS.label,"summarizationOfTheContent");
		summary.addProperty(OWL.sameAs,frbreq);
		summary.addProperty(OWL.sameAs,rdaeq);
		return summary;
	}
	
	/**
	 *  Manifestation of Expression
	 * @param model
	 * @return
	 */
	public static Property manifestationOfExpression(Model model){
		Property manif = model.createProperty(BENCH +"/"+ "manifestationOfExpression");
		return manif;
	}
	public Property manifestationOfExpression_ONT(Model model){
		Property manif = manifestationOfExpression(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P2003");
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20059");
		manif.addLiteral(RDFS.label,"manifestationOfExpression");
		manif.addProperty(OWL.sameAs,frbreq);
		manif.addProperty(OWL.sameAs,rdaeq);
		return manif;
	}
	
	/**
	 * Note on Introduction
	 * @param model
	 * @return
	 */
	public static Property noteOnExpression(Model model){
		Property ne = model.createProperty(BENCH +"/"+ "noteOnExpression");
		return ne;
	}
	public Property noteOnExpression_ONT(Model model){
		Property ne = noteOnExpression(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20071");
		ne.addLiteral(RDFS.label,"noteOnExpression");
		ne.addProperty(OWL.sameAs,rdaeq);
		return ne;
	}
	
	/**
	 * Award
	 * @param model
	 * @return
	 */
	public static Property award(Model model){
		Property award = model.createProperty(BENCH +"/"+ "award");
		return award;
	}
	public Property award_ONT(Model model){
		Property award = award(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20005");
		award.addLiteral(RDFS.label,"award");
		award.addProperty(OWL.sameAs,rdaeq);
		return award;
	}
	
	/**
	 * Illustration Expression
	 * @param model
	 * @return
	 */
	public static Property illustrationsExpression(Model model){
		Property ie = model.createProperty(BENCH +"/"+ "illustrationsExpression");
		return ie;
	}
	public Property illustrationsExpression_ONT(Model model){
		Property ie = illustrationsExpression(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20094");
		ie.addLiteral(RDFS.label,"illustrationsExpression");
		ie.addProperty(OWL.sameAs,rdaeq);
		return ie;
		
	}
	
	/**
	 * Illustrator
	 * @param model
	 * @return
	 */
	public static Property illustrator(Model model){	
		Property ill = model.createProperty(BENCH +"/"+ "illustrator");
		return ill;
	}
	public Property illustrator_ONT(Model model){	
		Property ill = illustrator(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20051");
		ill.addLiteral(RDFS.label,"illustrator");
		ill.addProperty(OWL.sameAs,rdaeq);
		return ill;
	}
	
	/**
	 * Editor
	 * @param model
	 * @return
	 */
	public static Property editor(Model model){
		Property ed = model.createProperty(BENCH +"/"+ "editor");
		return ed;
	}
	public Property editor_ONT(Model model){
		Property ed = editor(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20048");
		ed.addLiteral(RDFS.label,"editor");
		ed.addProperty(OWL.sameAs,rdaeq);
		return ed;
	}
	
	/**
	 * Contributor
	 * @param model
	 * @return
	 */
	public static Property contributor(Model model){
		Property contrib = model.createProperty(BENCH +"/"+ "contributor");
		return contrib;
	}
	public Property contributor_ONT(Model model){
		Property contrib = contributor(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20053");
		contrib.addLiteral(RDFS.label,"contributor");
		contrib.addProperty(OWL.sameAs,rdaeq);
		return contrib;
	}
	
	/**
	 * Translator
	 * @param model
	 * @return
	 */
	public static Property translator(Model model){
		Property trans = model.createProperty(BENCH +"/"+ "translator");
		return trans;
	}
	public Property translator_ONT(Model model){
		Property trans = translator(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20037");
		trans.addLiteral(RDFS.label,"translator");
		trans.addProperty(OWL.sameAs,rdaeq);
		return trans;
	}
	
	/**
	 * Actor
	 * @param model
	 * @return
	 */
	public static Property actor(Model model){
		Property act = model.createProperty(BENCH +"/"+ "actor");
		return act;
	}
	public Property actor_ONT(Model model){
		Property act = actor(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20012");
		act.addLiteral(RDFS.label,"actor");
		act.addProperty(OWL.sameAs,rdaeq);
		return act;
	}
	
	/**
	 * Translation
	 * 
	 * @param model
	 * @return
	 */
	public static Property translatedAs(Model model){
		Property translation = model.createProperty(BENCH +"/"+ "translatedAs");
		return translation;
	}
	public Property translatedAs_ONT(Model model){
		Property translation = translatedAs(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20171");
		translation.addLiteral(RDFS.label,"translatedAs");
		translation.addProperty(OWL.sameAs,rdaeq);
		return translation;
	}
	
	/**
	 * Narrator
	 * @param model
	 * @return
	 */
	public static Property narrator(Model model){
		Property narr = model.createProperty(BENCH +"/"+ "narrator");
		return narr;
	}
	public Property narrator_ONT(Model model){
		Property narr = narrator(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20022");
		narr.addLiteral(RDFS.label,"narrator");
		narr.addProperty(OWL.sameAs,rdaeq);
		return narr;
	}
	
	/**
	 * Writer of Introduction
	 * @param model
	 * @return
	 */
	public static Property writerOfIntroduction(Model model){
		Property wi = model.createProperty(BENCH +"/"+ "writerOfIntroduction");
		return wi;
	}
	public Property writerOfIntroduction_ONT(Model model){
		Property wi = writerOfIntroduction(model);
		Property rdaeq = model.createProperty(RDA+"/"+catExpression+"/"+"P20045");
		wi.addLiteral(RDFS.label,"writerOfIntroduction");
		wi.addProperty(OWL.sameAs,rdaeq);
		return wi;
	}
	
	// 	MANIFESTATION PROPERTIES
	
	/**
	 * Identifier of Manifestation
	 * @param model
	 * @return
	 */
	public static Property identifierForTheManifestation(Model model){
		Property id = model.createProperty(BENCH +"/"+ "identifierForTheManifestation");
		return id;
	}
	public Property identifierForTheManifestation_ONT(Model model){
		Property id = identifierForTheManifestation(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3028");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30004");
		id.addLiteral(RDFS.label,"identifierForTheManifestation");
		id.addProperty(OWL.sameAs,frbreq);
		id.addProperty(OWL.sameAs,rdaeq);
		return id;
	}
	
	/**
	 * Manifestation Title
	 * @param model
	 * @return
	 */
	public static Property titleOfTheManifestation(Model model){
		Property title = model.createProperty(BENCH +"/"+ "title");
		return title;
		
	}
	public Property titleOfTheManifestation_ONT(Model model){
		Property title = titleOfTheManifestation(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3020");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30134");
		title.addLiteral(RDFS.label,"title");
		title.addProperty(OWL.sameAs,frbreq);
		title.addProperty(OWL.sameAs,rdaeq);
		return title;
		
	}
	
	/**
	 * Manifestation Statement of Responsibility
	 * @param model
	 * @return
	 */
	public static Property statementOfResponsibilityRelatingToTitleProper(Model model){
		Property ps = model.createProperty(BENCH +"/"+ "statementOfResponsibilityRelatingToTitleProper");
		return ps;
	}
	
	public Property statementOfResponsibilityRelatingToTitleProper_ONT(Model model){
		Property ps = statementOfResponsibilityRelatingToTitleProper(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30105");
		ps.addLiteral(RDFS.label,"statementOfResponsibilityRelatingToTitleProper");
		ps.addProperty(OWL.sameAs,rdaeq);
		return ps;
		
	}
	
	/**
	 * Manifestation Publication Statement
	 * @param model
	 * @return
	 */
	public static Property publicationStatement(Model model){
		Property ps = model.createProperty(BENCH +"/"+ "publicationStatement");
		return ps;
	}
	public Property publicationStatement_ONT(Model model){
		Property ps = publicationStatement(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30111");
		ps.addLiteral(RDFS.label,"publicationStatement");
		ps.addProperty(OWL.sameAs,rdaeq);
		return ps;
	}
	
	/**
	 * Manifestation designationOfEdition
	 * @param model
	 * @return
	 */
	public static Property designationOfEdition(Model model){
		Property nps = model.createProperty(BENCH +"/"+ "designationOfEdition");
		return nps;
	}
	public Property designationOfEdition_ONT(Model model){
		Property nps = designationOfEdition(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30133");
		nps.addLiteral(RDFS.label,"designationOfEdition");
		nps.addProperty(OWL.sameAs,rdaeq);
		return nps;
	}
	
	/**
	 * Manifestation Note on Publication Statement
	 * @param model
	 * @return
	 */
	public static Property noteOnPublicationStatement(Model model){
		Property nps = model.createProperty(BENCH +"/"+ "noteOnPublicationStatement");
		return nps;
	}
	public Property noteOnPublicationStatement_ONT(Model model){
		Property nps = noteOnPublicationStatement(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30055");
		nps.addLiteral(RDFS.label,"noteOnPublicationStatement");
		nps.addProperty(OWL.sameAs,rdaeq);
		return nps;
	}
	
	/**
	 * Insert
	 * @param model
	 * @return
	 */
	public static Property insert(Model model){
		Property ins = model.createProperty(BENCH +"/"+ "insert");
		return ins;
	}
	public Property insert_ONT(Model model){
		Property ins = insert(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30022");
		ins.addLiteral(RDFS.label,"insert");
		ins.addProperty(OWL.sameAs,rdaeq);
		return ins;
	}
	
	
	/**
	 * Manifestation Frequency
	 * @param model
	 * @return
	 */
	public static Property frequency(Model model){
		Property freq = model.createProperty(BENCH +"/"+ "frequency");
		return freq;
	}
	public Property frequency_ONT(Model model){
		Property freq = frequency(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30168");
		freq.addLiteral(RDFS.label,"frequency");
		freq.addProperty(OWL.sameAs,rdaeq);
		return freq;
	}
	
	/**
	 * Manifestation Serial ISSN
	 * @param model
	 * @return
	 */
	public static Property issnOfSeries(Model model){
		Property issn = model.createProperty(BENCH +"/"+ "issnOfSeries");
		return issn;
	}
	public Property issnOfSeries_ONT(Model model){
		Property issn = issnOfSeries(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30166");
		issn.addLiteral(RDFS.label,"issnOfSeries");
		issn.addProperty(OWL.sameAs,rdaeq);
		return issn;
	}

	/**
	 * Manifestation Dimensions
	 * @param model
	 * @return
	 */
	public static Property dimensions(Model model){
		Property dim = model.createProperty(BENCH +"/"+ "dimensions");
		return dim;
	}
	public Property dimensions_ONT(Model model){
		Property dim = model.createProperty(BENCH +"/"+ "dimensions");
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3027");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30169");
		dim.addLiteral(RDFS.label,"dimensions");
		dim.addProperty(OWL.sameAs,frbreq);
		dim.addProperty(OWL.sameAs,rdaeq);
		return dim;
	}
	
	/**
	 * Manifestation Extent
	 * @param model
	 * @return
	 */
	public static Property extent(Model model){
		Property ext = model.createProperty(BENCH +"/"+ "extent");
		return ext;
	}
	public Property extent_ONT(Model model){
		Property ext = extent(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3024");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30182");
		ext.addLiteral(RDFS.label,"extent");
		ext.addProperty(OWL.sameAs,frbreq);
		ext.addProperty(OWL.sameAs,rdaeq);
		return ext;
	}
	
	/**
	 * Manifestation Note on Carrier
	 * @param model
	 * @return
	 */
	public static Property noteOnCarrier(Model model){
		Property ext = model.createProperty(BENCH +"/"+ "noteOnCarrier");
		return ext;
	}
	public Property noteOnCarrier_ONT(Model model){
		Property ext = noteOnCarrier(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30214");
		ext.addLiteral(RDFS.label,"noteOnCarrier");
		ext.addProperty(OWL.sameAs,rdaeq);
		return ext;
	}
	
	/**
	 * Manifestation Form of Carrier
	 * @param model
	 * @return
	 */
	public static Property carrierType(Model model){
		Property ext = model.createProperty(BENCH +"/"+ "carrierType");
		return ext;
	}
	public Property carrierType_ONT(Model model){
		Property ext = carrierType(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3023");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30001");
		ext.addLiteral(RDFS.label,"carrierType");
		ext.addProperty(OWL.sameAs,rdaeq);
		ext.addProperty(OWL.sameAs,frbreq);
		return ext;
	}
	
	/**
	 * Manifestation Terms of Availability
	 * @param model
	 * @return
	 */
	public static Property termsOfAvailability(Model model){
		Property ta = model.createProperty(BENCH +"/"+ "termsOfAvailability");
		return ta;
	}
	public Property termsOfAvailability_ONT(Model model){
		Property ta = termsOfAvailability(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3029");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30160");
		ta.addLiteral(RDFS.label,"termsOfAvailability");
		ta.addProperty(OWL.sameAs,frbreq);
		ta.addProperty(OWL.sameAs,rdaeq);
		return ta;
		
	}
	
	/**
	 * Manifestation Place of publication
	 * @param model
	 * @return
	 */
	public static Property placeOfpublication(Model model){
		Property pp = model.createProperty(BENCH +"/"+ "placeOfpublication");
		return pp;
	}
	public Property placeOfpublication_ONT(Model model){
		
		Property pp = placeOfpublication(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3057");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30088");
		pp.addLiteral(RDFS.label,"placeOfpublication");
		pp.addProperty(OWL.sameAs,frbreq);
		pp.addProperty(OWL.sameAs,rdaeq);
		return pp;
		
	}
	
	/**
	 * Manifestation Date of publication
	 * @param model
	 * @return
	 */
	public static Property dateOfPublication(Model model){
		Property dp = model.createProperty(BENCH +"/"+ "dateOfPublication");
		return dp;
	}
	public Property dateOfPublication_ONT(Model model){
		Property dp = dateOfPublication(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3055");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30011");
		dp.addLiteral(RDFS.label,"dateOfPublication");
		dp.addProperty(OWL.sameAs,frbreq);
		dp.addProperty(OWL.sameAs,rdaeq);
		return dp;
	}
	
	/**
	 * Container of Manifestation
	 * @param model
	 * @return
	 */
	public static Property containerOfManifestation(Model model){
		Property cm = model.createProperty(BENCH +"/"+ "containerOfManifestation");
		return cm;
	}
	public Property containerOfManifestation_ONT(Model model){
		Property cm = containerOfManifestation(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30033");
		cm.addLiteral(RDFS.label,"containerOfManifestation");
		cm.addProperty(OWL.sameAs,rdaeq);
		return cm;
	}
	
	/**
	 * Publisher of Manifestation
	 * @param model
	 * @return
	 */
	public static Property publisher(Model model){
		Property publisher = model.createProperty(BENCH +"/"+ "publisher");
		return publisher;
	}
	public Property publisher_ONT(Model model){
		Property publisher = publisher(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3056");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30083");
		publisher.addLiteral(RDFS.label,"publisher");
		publisher.addProperty(OWL.sameAs,frbreq);
		publisher.addProperty(OWL.sameAs,rdaeq);
		return publisher;
	}
	
	/**
	 * Other Information of Proper Title
	 * @param model
	 * @return
	 */
	public static Property otherTitleInformation(Model model){
		Property proptitleinfo = model.createProperty(BENCH +"/"+ "otherTitleInformation");
		return proptitleinfo;
	}
	public Property otherTitleInformation_ONT(Model model){
		Property proptitleinfo = otherTitleInformation(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30142");
		proptitleinfo.addLiteral(RDFS.label,"otherTitleInformation");
		proptitleinfo.addProperty(OWL.sameAs,rdaeq);
		return proptitleinfo;
	}
	
	
	/**
	 * Also issues as
	 * @param model
	 * @return
	 */
	public static Property alsoIssuedAs(Model model){
		Property aia = model.createProperty(BENCH +"/"+ "alsoIssuedAs");
		return aia;
	}
	public Property alsoIssuedAs_ONT(Model model){
		Property aia = alsoIssuedAs(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P2083");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30026");
		aia.addLiteral(RDFS.label,"alsoIssuedAs");
		aia.addProperty(OWL.sameAs,rdaeq);
		aia.addProperty(OWL.sameAs,frbreq);
		return aia;
	}
	
	/**
	 * Numbering in Series
	 * @param model
	 * @return
	 */
	public static Property numberingWithinSeries(Model model){
		Property nbs = model.createProperty(BENCH +"/"+ "numberingWithinSeries");
		return nbs;
	}
	public Property numberingWithinSeries_ONT(Model model){
		Property nbs = numberingWithinSeries(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3079");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30014");
		nbs.addLiteral(RDFS.label,"numberingWithinSeries");
		nbs.addProperty(OWL.sameAs,rdaeq);
		nbs.addProperty(OWL.sameAs,frbreq);
		return nbs;

	}
	
	/**
	 * Numbering in SubSeries
	 * @param model
	 * @return
	 */
	public static Property numberingWithinSubseries(Model model){
		Property nbss = model.createProperty(BENCH +"/"+ "numberingWithinSubseries");
		return nbss;
	}
	public Property numberingWithinSubseries_ONT(Model model){
		Property nbss = numberingWithinSubseries(model);
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30015");
		nbss.addLiteral(RDFS.label,"numberingWithinSubseries");
		nbss.addProperty(OWL.sameAs,rdaeq);
		return nbss;
	}
	
	/**
	 * Series Statement
	 * @param model
	 * @return
	 */
	public static Property seriesStatement(Model model){
		Property ss = model.createProperty(BENCH +"/"+ "seriesStatement");
		return ss;
	}
	public Property seriesStatement_ONT(Model model){
		Property ss = seriesStatement(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3022");
		Property rdaeq = model.createProperty(RDA+"/"+catManifestation+"/"+"P30106");
		ss.addLiteral(RDFS.label,"seriesStatement");
		ss.addProperty(OWL.sameAs,rdaeq);
		ss.addProperty(OWL.sameAs,frbreq);
		return ss;
	}
	
	// CONCEPT PROPERTIES
	
	/**
	 * Concept Term
	 * @param model
	 * @return
	 */
	public static Property hasTermForTheConcept(Model model){
		Property conceptTerm = model.createProperty(BENCH +"/"+ "hasTermForTheConcept");
		return conceptTerm;
	}
	public Property hasTermForTheConcept_ONT(Model model){
		Property conceptTerm = hasTermForTheConcept(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3056");
		conceptTerm.addLiteral(RDFS.label,"hasTermForTheConcept");
		conceptTerm.addProperty(OWL.sameAs,frbreq);
		return conceptTerm;
	}
	
	// PLACE PROPERTIES
	
	/**
	 * Place Term
	 * @param model
	 * @return
	 */
	public static Property hasTermForThePlace(Model model){
		Property placeTerm = model.createProperty(BENCH +"/"+ "hasTermForThePlace");
		return placeTerm;
	}
	public Property hasTermForThePlace_ONT(Model model){
		Property placeTerm = hasTermForThePlace(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3051");
		placeTerm.addLiteral(RDFS.label,"hasTermForThePlace");
		placeTerm.addProperty(OWL.sameAs,frbreq);
		return placeTerm;
	}
	
	// 	EVENT PROPERTIES
	
	/**
	 * Event Term
	 * @param model
	 * @return
	 */
	public static Property hasTermForTheEvent(Model model){
		Property eventTerm = model.createProperty(BENCH +"/"+ "hasTermForTheEvent");
		return eventTerm;
	}
	public Property hasTermForTheEvent_ONT(Model model){
		Property eventTerm = hasTermForTheEvent(model);
		Property frbreq = model.createProperty(FRBRER +"/"+ "P3050");
		eventTerm.addLiteral(RDFS.label,"hasTermForTheEvent");
		eventTerm.addProperty(OWL.sameAs,frbreq);
		return eventTerm;
		
	}
}
