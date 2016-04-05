package org.bibr.core;

import java.io.FileWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.bibr.FRBR;
import org.bibr.Util;

public class FRBRizationCoreBasic_1_5 {

	private Model model;
	
	@Before
	public void setUp() throws Exception{
		model = ModelFactory.createDefaultModel();
		FRBR.initializeModel(model);
	}
	
	@Test
	public void launch() throws Exception{
		/*warHorse();
		treasureIsland();
		tomSawyer();
		romans();*/
		romanDeRenart();
		essais();
		/*meditationsMetaphysiques();
		emergingTrends();
		handbookofInjectableDrugs();
		harryPotterDeathlyHallows();
		ofMiceAndMen();
		deathOnTheNil();
		strangeCaseOfDrJekyllAndMrHyde();
		valerianEtLaureline();
		whyPhilosophers();*/
	}
	
	@After
	public void tearDown() throws Exception{
		
		String path = Util.path+"/1_Core/1.5/core-missing-uniform-title-frbr.xml";
		Writer w1 = new FileWriter(path);
		w1.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		w1.close();
		Writer w2 = new FileWriter(path,true);
		model.write(w2, "RDF/XML");
		w2.close();
	}

	/**
	 * War Horse
	 * @throws Exception
	 */
	public void warHorse() {
		
		// Work
		Resource work = FRBR.work(model,"WarHorse");
		work.addProperty(FRBR.titleOfTheWork(model), "War horse");
		
		// Expression
		Resource expression = FRBR.expression(model,"WarHorseTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		expression.addProperty(FRBR.summarizationOfTheContent(model), "World War I has started...");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9780439796644");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-0-439-79664-4");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9780439796644");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.extent(model), "165 pages");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "8.00 €");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2010");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "War horse");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Michael Morpurgo");
		
		// Person
		Resource creator = FRBR.person(model,"MichaelMorpurgo");
		creator.addProperty(FRBR.identifierForThePerson(model), "pauth-001");
		creator.addProperty(FRBR.nameOfThePerson(model), "Morpurgo, Michael");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"ScholasticLtd");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Scholastic Ltd");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), creator);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);
	}
	

	/**
	 * Treasure Island
	 * @throws Exception
	 */
	public void treasureIsland() {

		// Work
		Resource work = FRBR.work(model,"TreasureIsland");
		work.addProperty(FRBR.titleOfTheWork(model), "Treasure island");
		
		// Expression
		Resource expression = FRBR.expression(model,"TreasureIslandTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		expression.addProperty(FRBR.summarizationOfTheContent(model), "When an old sailor named Billy Bones...");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9780747587477");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-0-7475-8747-7");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9780747587477");
		manifestation.addProperty(FRBR.dimensions(model), "17 cm");
		manifestation.addProperty(FRBR.extent(model), "204 pages");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "11,00 euro");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Great Britain");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2006");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Treasure island");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Robert Louis Stevenson");
		
		// Person
		Resource author = FRBR.person(model,"RobertLouisStevenson");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-003");
		author.addProperty(FRBR.nameOfThePerson(model), "Stevenson, Robert Louis");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"EditionsRobertLaffont");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Editions Robert Laffont");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}
	
	
	/**
	 * Tom Sawyer
	 * @throws Exception
	 */
	public void tomSawyer() {

		// Work
		Resource work = FRBR.work(model,"TheAdventuresofTomSawyer");
		work.addProperty(FRBR.titleOfTheWork(model), "The Adventures of Tom Sawyer");
		
		// Expression
		Resource expression = FRBR.expression(model,"TheAdventuresofTomSawyerTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book0140390480");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "0-14-039048-0");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "0140390480");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Cover with colorful illustrations");
		manifestation.addProperty(FRBR.extent(model), "226 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "London");
		manifestation.addProperty(FRBR.dateOfPublication(model), "1986");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "The Adventures of Tom Sawyer");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Mark Twain");
		
		// Person
		Resource author = FRBR.person(model,"MarkTwain");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-002");
		author.addProperty(FRBR.nameOfThePerson(model), "Twain, Mark");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Penguinbooks");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Penguin books");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}
	
	
	/**
	 * Romans
	 * @throws Exception
	 */
	public void romans() {

		// Work
		Resource work = FRBR.work(model,"Romans");
		work.addProperty(FRBR.titleOfTheWork(model), "Romans");
		
		// Expression
		Resource expression = FRBR.expression(model,"RomansTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book2253132225");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "2-253-13222-5");
		manifestation.addProperty(FRBR.dimensions(model), "19 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "120,00 F");
		manifestation.addProperty(FRBR.extent(model), "1279 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "1994");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Romans");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Chretien de Troyes");
		
		// Person
		Resource author = FRBR.person(model,"ChretiendeTroyes");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-004");
		author.addProperty(FRBR.nameOfThePerson(model), "Chretien de Troyes");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"LibrairieGeneraleFrancaise");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Librairie Generale Francaise");
		
		// Concept
		Resource concept = FRBR.concept(model,"RomansdelaTableronde");
		concept.addProperty(FRBR.hasTermForTheConcept(model), "Romans de la Table ronde");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}
	
	/**
	 * Le Roman de Renart
	 * @throws Exception
	 */
	public void romanDeRenart() {

		// Work
		Resource work = FRBR.work(model,"RomandeRenart");
		work.addProperty(FRBR.titleOfTheWork(model), "Roman de Renart");
		
		// Expression
		Resource expression = FRBR.expression(model,"RomandeRenartTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9782081209633");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-2-0812-0963-3");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Illustrations, cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "2,70 euro");
		manifestation.addProperty(FRBR.extent(model), "159 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2008");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Roman de Renart (Le)");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Christian Keime; Monique Lachet-Lagarde");
		
		// Person
		Resource author = FRBR.person(model,"ChristianKeime");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-005");
		author.addProperty(FRBR.nameOfThePerson(model), "Christian Keime");
		
		// Contributor
		Resource contrib = FRBR.person(model,"MoniqueLachetLagarde");
		contrib.addProperty(FRBR.identifierForThePerson(model), "pauth-006");
		contrib.addProperty(FRBR.nameOfThePerson(model), "Monique Lachet-Lagarde");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Flammarion");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Flammarion");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		expression.addProperty(FRBR.contributor(model), contrib);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}
	
	
	/**
	 * Essais
	 * @throws Exception
	 */
	public void essais() {

		// Work
		Resource work = FRBR.work(model,"Essais");
		work.addProperty(FRBR.titleOfTheWork(model), "Essais");
		
		// Expression
		Resource expression = FRBR.expression(model,"EssaisTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9782080702104");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-2-08-070210-4");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "5.80 euro");
		manifestation.addProperty(FRBR.extent(model), "443 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "1969");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Essais");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Michel de Montaigne");
		
		// Person
		Resource author = FRBR.person(model,"MicheldeMontaigne");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-007");
		author.addProperty(FRBR.nameOfThePerson(model), "Michel de Montaigne");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"GarnierFlammarion");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Garnier-Flammarion");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}

	/**
	 * Meditations metaphysiques
	 * @throws Exception
	 */
	public void meditationsMetaphysiques() {

		// Work
		Resource work = FRBR.work(model,"MeditationsMetaphysiques");
		work.addProperty(FRBR.titleOfTheWork(model), "Meditations metaphysiques");
		
		// Expression
		Resource expression = FRBR.expression(model,"MeditationsMetaphysiquesTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9782091873053");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-2-09-187305-3");
		manifestation.addProperty(FRBR.dimensions(model), "21 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "On the cover: Texte integral annote, dossier pedagogique");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "7,50 EUR");
		manifestation.addProperty(FRBR.extent(model), "191 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "France");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2009");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Meditations metaphysiques");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Descartes; Christine Thubert");
		
		// Person
		Resource author = FRBR.person(model,"Descartes");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-008");
		author.addProperty(FRBR.nameOfThePerson(model), "Descartes");
		
		// Person
		Resource collab = FRBR.person(model,"ChristineThubert");
		collab.addProperty(FRBR.identifierForThePerson(model), "pauth-010");
		collab.addProperty(FRBR.nameOfThePerson(model), "Christine Thubert");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Nathan");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Nathan");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		expression.addProperty(FRBR.contributor(model), collab);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}

	/**
	 * Emerging trends 
	 * @throws Exception
	 */
	public void emergingTrends() {

		// Work
		Resource work = FRBR.work(model,"Emergingtrendsindruguseanddistribution");
		work.addProperty(FRBR.titleOfTheWork(model), "Emerging trends in drug use and distribution");
		
		// Expression
		Resource expression = FRBR.expression(model,"EmergingtrendsindruguseanddistributionTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book3319035746");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "3319035746");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "doi:10.1007/978-3-319-03575-8");
		manifestation.addProperty(FRBR.extent(model), "99 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Cham");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Heidelberg");
		manifestation.addProperty(FRBR.placeOfPublication(model), "New York");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2014");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Emerging trends in drug use and distribution");
		manifestation.addProperty(FRBR.seriesStatement(model), "Springer briefs in criminology");
		manifestation.addProperty(FRBR.numberingWithinSeries(model), "12");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "David N. Khey; John Stogner");
		
		// Person
		Resource author1 = FRBR.person(model,"DavidNKhey");
		author1.addProperty(FRBR.identifierForThePerson(model), "pauth-011");
		author1.addProperty(FRBR.nameOfThePerson(model), "David N. Khey");
		
		// Person
		Resource author2 = FRBR.person(model,"JohnStogner");
		author2.addProperty(FRBR.identifierForThePerson(model), "pauth-012");
		author2.addProperty(FRBR.nameOfThePerson(model), "John Stogner");
		
		// Person
		Resource author3 = FRBR.person(model,"BryanLeeMiller");
		author3.addProperty(FRBR.identifierForThePerson(model), "pauth-013");
		author3.addProperty(FRBR.nameOfThePerson(model), "Bryan Lee Miller");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Springer");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Springer");
		
		// Concept
		Resource concept1 = FRBR.concept(model,"PsychotropicDrugs");
		concept1.addProperty(FRBR.hasTermForTheConcept(model), "Psychotropic Drugs");
		
		// Concept
		Resource concept2 = FRBR.concept(model,"SubstanceRelatedDisorders");
		concept2.addProperty(FRBR.hasTermForTheConcept(model), "Substance-Related Disorders");
		
		// Concept
		Resource concept3 = FRBR.concept(model,"Marketing");
		concept3.addProperty(FRBR.hasTermForTheConcept(model), "Marketing");
		
		// Concept
		Resource concept4 = FRBR.concept(model,"StreetDrugs");
		concept4.addProperty(FRBR.hasTermForTheConcept(model), "Street Drugs");
		
		// Place
		Resource place = FRBR.place(model,"UnitedStates");
		place.addProperty(FRBR.hasTermForThePlace(model), "United States");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author1);
		work.addProperty(FRBR.creator(model), author2);
		work.addProperty(FRBR.creator(model), author3);
		
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept3);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept4);
		work.addProperty(FRBR.hasAsSubjectPlace(model), place);
		
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}
	
	/**
	 * Handbook of Injectable Drugs
	 * @throws Exception
	 */
	public void handbookofInjectableDrugs() {

		// Work
		Resource work = FRBR.work(model,"HandbookofInjectableDrugs");
		work.addProperty(FRBR.titleOfTheWork(model), "Handbook of Injectable Drugs");
		
		// Expression
		Resource expression = FRBR.expression(model,"HandbookofInjectableDrugsTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9781585281503");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9781585281503");
		manifestation.addProperty(FRBR.extent(model), "1720 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Bethesda");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2006");
		manifestation.addProperty(FRBR.designationOfEdition(model), "14th");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Handbook of Injectable Drugs");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Lawrence A. Trissel");
		
		// Person
		Resource author1 = FRBR.person(model,"LawrenceATrissel");
		author1.addProperty(FRBR.identifierForThePerson(model), "pauth-015");
		author1.addProperty(FRBR.nameOfThePerson(model), "Lawrence A. Trissel");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"AmericanSocietyofHealthSystemPharmacists");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "American Society of Health-System Pharmacists");
		
		// Concept
		Resource concept1 = FRBR.concept(model,"Injectable");
		concept1.addProperty(FRBR.hasTermForTheConcept(model), "Injectable");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author1);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);

		
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}
	
	/**
	 * Harry Potter and the Deathly Hallows
	 * @throws Exception
	 */
	public void harryPotterDeathlyHallows() {

		// Work
		Resource work = FRBR.work(model,"HarryPotterandtheDeathlyHallows");
		work.addProperty(FRBR.titleOfTheWork(model), "Harry Potter and the Deathly Hallows");
		
		// Expression
		Resource expression = FRBR.expression(model,"HarryPotterandtheDeathlyHallowsText");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9781408855713");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-1-4088-5571-3");
		manifestation.addProperty(FRBR.dimensions(model), "20 cm");
		manifestation.addProperty(FRBR.extent(model), "1 volume (619 pages)");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Cover with colorful illustrations");
		manifestation.addProperty(FRBR.placeOfPublication(model), "London");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2014");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Harry Potter and the Deathly Hallows");
		manifestation.addProperty(FRBR.seriesStatement(model), "Harry Potter series");
		manifestation.addProperty(FRBR.numberingWithinSeries(model), "7");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "J.K. Rowling");
		
		// Person
		Resource author = FRBR.person(model,"JKRowling");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-014");
		author.addProperty(FRBR.nameOfThePerson(model), "J.K. Rowling");
		author.addProperty(FRBR.nameOfThePerson(model), "Rowling, Joanne Kathleen");
		author.addProperty(FRBR.dateAssociatedWithThePerson(model), "1965-....");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Bloomsbury");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Bloomsbury");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}

	
	/**
	 * Of mice and men
	 * @throws Exception
	 */
	public void ofMiceAndMen() {

		// Work
		Resource work = FRBR.work(model,"Ofmiceandmen");
		work.addProperty(FRBR.titleOfTheWork(model), "Of mice and men");
		
		// Expression
		Resource expression = FRBR.expression(model,"OfmiceandmenAudioEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9780142429181");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9780142429181");
		manifestation.addProperty(FRBR.dimensions(model), "14 x 13 cm");
		manifestation.addProperty(FRBR.extent(model), "3 CD (21h30)");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "housing with illustrations");
		manifestation.addProperty(FRBR.placeOfPublication(model), "France");
		manifestation.addProperty(FRBR.dateOfPublication(model), "1992");
		manifestation.addProperty(FRBR.carrierType(model), "audio");
		manifestation.addProperty(FRBR.carrierType(model), "book");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Of mice and men");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "John Steinbeck; Gary Sinise");
		
		// Person
		Resource author = FRBR.person(model,"JohnSteinbeck");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-016");
		author.addProperty(FRBR.nameOfThePerson(model), "Steinbeck, John");
		
		// Narrator
		Resource narrator = FRBR.person(model,"GarySinise");
		narrator.addProperty(FRBR.identifierForThePerson(model), "pauth-017");
		narrator.addProperty(FRBR.nameOfThePerson(model), "Gary Sinise");
		narrator.addProperty(FRBR.nameOfThePerson(model), "Sinise, Gary");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Penguinbooks");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Penguin books");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		expression.addProperty(FRBR.narrator(model), narrator);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}


	/**
	 * Death on the Nil
	 * @throws Exception
	 */
	public void deathOnTheNil() {

		// Work
		Resource work = FRBR.work(model,"DeathontheNil");
		work.addProperty(FRBR.titleOfTheWork(model), "Death on the Nil");
		
		// Expression
		Resource expression = FRBR.expression(model,"DeathontheNilAudioEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Audio9780007191154");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9780007191154");
		manifestation.addProperty(FRBR.dimensions(model), "14 x 13 cm");
		manifestation.addProperty(FRBR.extent(model), "7 CD (approx. 8h30)");
		manifestation.addProperty(FRBR.placeOfPublication(model), "France");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2004");
		manifestation.addProperty(FRBR.carrierType(model), "audio");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Death on the Nil");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Agatha Christie; David Suchet");
		
		// Person
		Resource author = FRBR.person(model,"AgathaChristie");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-018");
		author.addProperty(FRBR.nameOfThePerson(model), "Agatha Christie");
		author.addProperty(FRBR.nameOfThePerson(model), "Christie, Agatha");
		
		// Narrator
		Resource narrator = FRBR.person(model,"DavidSuchet");
		narrator.addProperty(FRBR.identifierForThePerson(model), "pauth-019");
		narrator.addProperty(FRBR.nameOfThePerson(model), "David Suchet");
		narrator.addProperty(FRBR.nameOfThePerson(model), "Suchet, David");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"HarperCollinsPublishers");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "HarperCollins Publishers");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		expression.addProperty(FRBR.narrator(model), narrator);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}


	/**
	 * The strange case of Dr Jekyll and Mr Hyde
	 * @throws Exception
	 */
	public void strangeCaseOfDrJekyllAndMrHyde() {

		// Work
		Resource work = FRBR.work(model,"strangecaseofDrJekyllMrHyde");
		work.addProperty(FRBR.titleOfTheWork(model), "The strange case of Dr Jekyll and Mr Hyde");
		
		// Expression
		Resource expression = FRBR.expression(model,"strangecaseofDrJekyllMrHydeTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9781843444848");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-1-84344-484-8");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9781843444848");
		manifestation.addProperty(FRBR.carrierType(model), "book");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Cover with colorful illustrations");
		manifestation.addProperty(FRBR.extent(model), "1 volume (123 pages)");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Harpenden");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2014");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "The strange case of Dr Jekyll and Mr Hyde");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Robert Louis Stevenson");
		
		// Manifestation PDF
		Resource pdf = FRBR.manifestation(model,"PDF9781843444879");
		pdf.addProperty(FRBR.identifierForTheManifestation(model), "978-1-84344-487-9");
		pdf.addProperty(FRBR.identifierForTheManifestation(model), "9781843444879");
		pdf.addProperty(FRBR.carrierType(model), "PDF");
		
		// Manifestation PDF
		Resource kindle = FRBR.manifestation(model,"Kindle9781843444862");
		kindle.addProperty(FRBR.identifierForTheManifestation(model), "978-1-84344-486-2");
		kindle.addProperty(FRBR.identifierForTheManifestation(model), "9781843444862");
		kindle.addProperty(FRBR.carrierType(model), "Kindle");
		
		// Person
		Resource author = FRBR.person(model,"RobertLouisStevenson");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-003");
		author.addProperty(FRBR.nameOfThePerson(model), "Robert Louis Stevenson");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"PulpTheClassics");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Pulp! The Classics");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		expression.addProperty(FRBR.manifestationOfExpression(model), pdf);
		expression.addProperty(FRBR.manifestationOfExpression(model), kindle);
		
		
		manifestation.addProperty(FRBR.publisher(model), publisher);
		manifestation.addProperty(FRBR.alsoIssuedAs(model), pdf);
		manifestation.addProperty(FRBR.alsoIssuedAs(model), kindle);

	}

	/**
	 * Valerian et Laureline
	 * @throws Exception
	 */
	public void valerianEtLaureline() {

		// Work
		Resource work = FRBR.work(model,"ValerianEtLaureline");
		work.addProperty(FRBR.titleOfTheWork(model), "Valerian et Laureline");
		
		// Expression
		Resource expression = FRBR.expression(model,"ValerianEtLaurelineTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Comic9782205060386");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-2205-06038-6");
		manifestation.addProperty(FRBR.dimensions(model), "30 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Colorful illustrations, cover with colorful illustrations");
		manifestation.addProperty(FRBR.extent(model), "1 volume (164 pages)");
		manifestation.addProperty(FRBR.carrierType(model), "Printed Text");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2012");
		manifestation.addProperty(FRBR.otherTitleInformation(model), "l'integrale");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Valerian et Laureline");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Pierre Christin; Jean-Claude Meziere");
		
		// Person
		Resource author1 = FRBR.person(model,"PierreChristin");
		author1.addProperty(FRBR.identifierForThePerson(model), "pauth-020");
		author1.addProperty(FRBR.nameOfThePerson(model), "Pierre Christin");
		
		// Person
		Resource author2 = FRBR.person(model,"JeanClaudeMezieres");
		author2.addProperty(FRBR.identifierForThePerson(model), "pauth-021");
		author2.addProperty(FRBR.nameOfThePerson(model), "Jean-Claude Mezieres");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Dargaud");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Dargaud");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author1);
		work.addProperty(FRBR.creator(model), author2);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);
		
		//subserie.addProperty(FRBR.containerOfWork(model), book1);
	}


	/**
	 * Why philosophers should offer ethics consultations
	 * @throws Exception
	 */
	public void whyPhilosophers() {

		// Work
		Resource work = FRBR.work(model,"Whyphilosophersethicsconsult");
		work.addProperty(FRBR.titleOfTheWork(model), "Why philosophers should offer ethics consultations");
		
		// Expression
		Resource expression = FRBR.expression(model,"WhyphilosopherArticleEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		expression.addProperty(FRBR.summarizationOfTheContent(model), "Considerable debate has occurred...");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"ArticleBF00489793");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "doi:10.1007/BF00489793");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Why philosophers should offer ethics consultations");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "D.C. Thomasma");
		
		// Person
		Resource author = FRBR.person(model,"DCThomasma");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-022");
		author.addProperty(FRBR.nameOfThePerson(model), "D.C. Thomasma");
		
		// Concept
		Resource concept1 = FRBR.concept(model,"Consultants");
		concept1.addProperty(FRBR.hasTermForTheConcept(model), "Consultants");
		
		Resource concept2 = FRBR.concept(model,"EthicsMedical");
		concept2.addProperty(FRBR.hasTermForTheConcept(model), "Ethics, Medical");
		
		Resource concept3 = FRBR.concept(model,"PhilosophyMedical");
		concept3.addProperty(FRBR.hasTermForTheConcept(model), "Philosophy, Medical");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept3);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);

	}

	
	/**
	 * Hart und Sozial<
	 * @throws Exception
	 */
	public void hartUndSozial() {

		// Work
		Resource work = FRBR.work(model,"HartUndSozial");
		work.addProperty(FRBR.titleOfTheWork(model), "Hart und Sozial");
		
		// Expression
		Resource expression = FRBR.expression(model,"HartUndSozialArticleEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "German");
		expression.addProperty(FRBR.summarizationOfTheContent(model), "Wiederholungstater sind haufig noch...");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"ArticleHartUndSozial");
		manifestation.addProperty(FRBR.otherTitleInformation(model), "Das Utrechter Modell");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Hart und Sozial");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Hans Slijpen");
		
		// Person
		Resource author = FRBR.person(model,"HansSlijpen");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-023");
		author.addProperty(FRBR.nameOfThePerson(model), "Hans Slijpen");
		
		// Concept
		Resource concept1 = FRBR.concept(model,"Abhangigkeit");
		concept1.addProperty(FRBR.hasTermForTheConcept(model), "Abhangigkeit");
		
		Resource concept2 = FRBR.concept(model,"Behandlung");
		concept2.addProperty(FRBR.hasTermForTheConcept(model), "Behandlung");
		
		Resource concept3 = FRBR.concept(model,"Klinik");
		concept3.addProperty(FRBR.hasTermForTheConcept(model), "Klinik");
		
		// Place
		Resource place = FRBR.place(model,"Netherlands");
		place.addProperty(FRBR.hasTermForThePlace(model), "Netherlands");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept3);
		work.addProperty(FRBR.hasAsSubjectPlace(model), place);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);

	}



	/**
	 * Could music potentially serve as a functional alternative to alcohol consumption?
	 * @throws Exception
	 */
	public void couldMusic() {

		// Work
		Resource work = FRBR.work(model,"CouldMusicPotentially");
		work.addProperty(FRBR.titleOfTheWork(model), "Could music potentially serve as a functional alternative to alcohol consumption?");
		
		// Expression
		Resource expression = FRBR.expression(model,"CouldMusicPotentiallyArticleEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		expression.addProperty(FRBR.summarizationOfTheContent(model), "This study investigated whether adolescents...");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"ArticleJBA3201443");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "doi:10.1556/JBA.3.2014.4.3");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2014");
		manifestation.addProperty(FRBR.otherTitleInformation(model), "the importance of music motives among drinking and non-drinking adolescents");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Could music potentially serve as a functional alternative to alcohol consumption?");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Anna Jonker; Emmanuel N. Kuntsche");
		
		// Person
		Resource author = FRBR.person(model,"AnnaJonker");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-024");
		author.addProperty(FRBR.nameOfThePerson(model), "Anna Jonker");
		
		// Person
		Resource contrib = FRBR.person(model,"EmmanuelNKuntsche");
		contrib.addProperty(FRBR.identifierForThePerson(model), "pauth-025");
		contrib.addProperty(FRBR.nameOfThePerson(model), "Emmanuel N. Kuntsche");
		
		// Concept
		Resource concept1 = FRBR.concept(model,"Alkohol");
		concept1.addProperty(FRBR.hasTermForTheConcept(model), "Alkohol");
		
		Resource concept2 = FRBR.concept(model,"Epidemiologie");
		concept2.addProperty(FRBR.hasTermForTheConcept(model), "Epidemiologie");
		
		Resource concept3 = FRBR.concept(model,"Musik");
		concept3.addProperty(FRBR.hasTermForTheConcept(model), "Musik");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.contributor(model), contrib);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept3);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);

	}




}



