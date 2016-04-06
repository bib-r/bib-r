package org.bibr.aug;

import java.io.FileWriter;
import java.io.Writer;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.bibr.FRBR;
import org.bibr.Util;

public class FRBRizationAug_2_10 {

	private Model model;
	
	@Before
	public void setUp() throws Exception{
		model = ModelFactory.createDefaultModel();
		FRBR.initializeModel(model);
	}
	
	@Test
	public void launch() throws Exception{
		romans();
		essais();
		ofMiceAndMen();
		etrangeDrJekyllMHyde();
	}
	
	@After
	public void tearDown() throws Exception{
		String path = Util.path+"/2_Augmentation/2.10/aug-cataloguing-practicies-frbr.xml";
		Writer w1 = new FileWriter(path);
		w1.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		w1.close();
		Writer w2 = new FileWriter(path,true);
		model.write(w2, "RDF/XML");
		w2.close();
	}
	
	/**
	 * Romans
	 * @throws Exception
	 */
	public void romans() {

		// Work
		Resource work = FRBR.work(model,"Romans");
		work.addProperty(FRBR.titleOfTheWork(model), "Romans");
		
		// Augmentation
		Resource aug = FRBR.work(model,"Philomena");
		aug.addProperty(FRBR.titleOfTheWork(model), "Philomena");
		aug.addProperty(FRBR.identifierForTheWork(model), "tauth-003");
		
		// Augmented Expression
		Resource augExpr = FRBR.expression(model,"PhilomenaExpr");
		augExpr.addProperty(FRBR.noteOnExpression(model), "[Philomena]");
		
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
		manifestation.addProperty(FRBR.otherTitleInformation(model), "in appendice, Philomena");
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
		
		work.addProperty(FRBR.appendixWork(model), aug);
		aug.addProperty(FRBR.expressionOfWork(model), augExpr);
		
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		augExpr.addProperty(FRBR.manifestationOfExpression(model), manifestation);
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

		Resource introduction = FRBR.work(model,"EssaisIntroduction");
		introduction.addProperty(FRBR.titleOfTheWork(model), "[Introduction]");
		Resource introExpr = FRBR.expression(model,"EssaisTextIntro");
		introExpr.addProperty(FRBR.noteOnExpression(model), "[Introduction]");
		
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
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Michel de Montaigne; Introduction by Alexandre Micha");
		
		// Person
		Resource author = FRBR.person(model,"MicheldeMontaigne");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-007");
		author.addProperty(FRBR.nameOfThePerson(model), "Michel de Montaigne");
		
		// Author of Introduction
		Resource authorintro = FRBR.person(model,"AlexandreMicha");
		authorintro.addProperty(FRBR.identifierForThePerson(model), "pauth-028");
		authorintro.addProperty(FRBR.nameOfThePerson(model), "Alexandre Micha");
		authorintro.addProperty(FRBR.nameOfThePerson(model), "Micha, Alexandre");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"GarnierFlammarion");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Garnier-Flammarion");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		
		work.addProperty(FRBR.augmentedByWork(model), introduction);
		introduction.addProperty(FRBR.expressionOfWork(model), introExpr);
		
		introExpr.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		introExpr.addProperty(FRBR.writerOfIntroduction(model), authorintro);
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
		
		// Introduction
		Resource introduction = FRBR.work(model,"OfmiceandmenIntroduction");
		introduction.addProperty(FRBR.titleOfTheWork(model), "[Introduction]");
		
		// Expression
		Resource expression = FRBR.expression(model,"OfmiceandmenTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Introduction Expression
		Resource expIntroduction = FRBR.expression(model,"OfmiceandmenExprIntroduction");
		expIntroduction.addProperty(FRBR.noteOnExpression(model), "[Introduction]");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9780141185101");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9780141185101");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-0-14-118510-1");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "10 euro");
		manifestation.addProperty(FRBR.dimensions(model), "20 cm");
		manifestation.addProperty(FRBR.extent(model), "105 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Harmondsworth");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Great Britain");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2010");
		manifestation.addProperty(FRBR.carrierType(model), "book");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Of mice and men");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "John Steinbeck; Susan Shillinglaw");
		
		// Person
		Resource author = FRBR.person(model,"JohnSteinbeck");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-016");
		author.addProperty(FRBR.nameOfThePerson(model), "John Steinbeck");
		author.addProperty(FRBR.nameOfThePerson(model), "Steinbeck, John");
		
		// Author of Introduction
		Resource authorintro = FRBR.person(model,"SusanShillinglaw");
		authorintro.addProperty(FRBR.identifierForThePerson(model), "pauth-050");
		authorintro.addProperty(FRBR.nameOfThePerson(model), "Susan Shillinglaw");
		authorintro.addProperty(FRBR.nameOfThePerson(model), "Shillinglaw, Susan");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Penguinbooks");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Penguin books");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		introduction.addProperty(FRBR.expressionOfWork(model), expIntroduction);
		work.addProperty(FRBR.augmentedByWork(model), introduction);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		expIntroduction.addProperty(FRBR.writerOfIntroduction(model), authorintro);
		expIntroduction.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}
	
	
	
	/**
	 * Etrange cas du Dr Jekyll et de M. Hyde
	 * @throws Exception
	 */
	public void etrangeDrJekyllMHyde() {

		// Work
		Resource work = FRBR.work(model,"EtrangeDrJekyllMHyde");
		work.addProperty(FRBR.titleOfTheWork(model), "Etrange cas du Dr Jekyll et de M. Hyde (L')");
		
		// Expression
		Resource expression = FRBR.expression(model,"EtrangeDrJekyllMHydeTextFrench");
		expression.addProperty(FRBR.noteOnExpression(model), "[Text]");
		
		// Illustrations
		Resource illustrations = FRBR.work(model,"EtrangeDrJekyllMHydeIllustrations");
		illustrations.addProperty(FRBR.titleOfTheWork(model), "[Illustrations]");
		Resource exprIll = FRBR.expression(model,"EtrangeDrJekyllMHydeExprIllustrations");
		exprIll.addProperty(FRBR.noteOnExpression(model), "[Illustrations]");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9782070622313");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-2-07-062231-3");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Illustrations, cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "5.80 euro");
		manifestation.addProperty(FRBR.extent(model), "144 pages");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2008");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Etrange cas du Dr Jekyll et de M. Hyde (L')");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Robert Louis Stevenson; illustrations by Francois Place");
		
		// Person
		Resource author = FRBR.person(model,"RobertLouisStevenson");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-003");
		author.addProperty(FRBR.nameOfThePerson(model), "Robert Louis Stevenson");
		
		// Illustrator
		Resource ill = FRBR.person(model,"FrancoisPlace");
		ill.addProperty(FRBR.identifierForThePerson(model), "pauth-051");
		ill.addProperty(FRBR.nameOfThePerson(model), "Francois Place");
		ill.addProperty(FRBR.nameOfThePerson(model), "Place, Francois");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Gallimard");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Gallimard");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		work.addProperty(FRBR.augmentedByWork(model), illustrations);
		
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		expression.addProperty(FRBR.illustrationsExpression(model), exprIll);
		
		illustrations.addProperty(FRBR.expressionOfWork(model), exprIll);

		exprIll.addProperty(FRBR.illustrator(model), ill);
		exprIll.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		
		manifestation.addProperty(FRBR.publisher(model), publisher);

	}

}



