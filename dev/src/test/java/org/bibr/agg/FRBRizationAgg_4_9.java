package org.bibr.agg;

import java.io.FileWriter;
import java.io.Writer;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.ResIterator;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.bibr.FRBR;
import org.bibr.Util;

public class FRBRizationAgg_4_9 {

	private Model model;

	@Before
	public void setUp() throws Exception {
		model = ModelFactory.createDefaultModel();
		FRBR.initializeModel(model);
	}

	@Test
	public void launch() throws Exception {
		romans();
		romanDeRenart();
		essais();
		meditationsMetaphysiques();
		valerianEtLaureline();
		infectionControlAndHospitalEpidemiology();
		hartUndSozial();
		iLoveEnglish();

	}

	@After
	public void tearDown() throws Exception {

		String path = Util.path+"/4_Aggregation/4.9/agg-missing-authoritative-responsibility-frbr.xml";
		Writer w1 = new FileWriter(path);
		w1.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		w1.close();
		Writer w2 = new FileWriter(path, true);
		model.write(w2, "RDF/XML");

		w2.close();
	}

	/**
	 * Romans
	 * 
	 * @throws Exception
	 */
	public void romans() {

		// Work
		Resource work = FRBR.work(model, "Romans");
		work.addProperty(FRBR.titleOfTheWork(model), "Romans");

		// Part Work 1
		Resource pw1 = FRBR.work(model, "Cliges");
		pw1.addProperty(FRBR.titleOfTheWork(model), "Cliges");
		Resource pw1e = FRBR.expression(model, "CligesText");

		// Part Work 2
		Resource pw2 = FRBR.work(model, "ChevalierdelaCharrette");
		pw2.addProperty(FRBR.titleOfTheWork(model),
				"Chevalier de la Charrette (Le)");
		Resource pw2e = FRBR.expression(model, "ChevalierdelaCharretteText");

		// Part Work 3
		Resource pw3 = FRBR.work(model, "ChevalierauLion");
		pw3.addProperty(FRBR.titleOfTheWork(model), "Chevalier au Lion (Le)");
		Resource pw3e = FRBR.expression(model, "ChevalierauLionText");

		// Part Work 4
		Resource pw4 = FRBR.work(model, "ConteduGraal");
		pw4.addProperty(FRBR.titleOfTheWork(model), "Conte du Graal (Le)");
		Resource pw4e = FRBR.expression(model, "ConteduGraalText");

		// Expression
		Resource expression = FRBR.expression(model, "RomansTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");

		// Manifestation
		Resource manifestation = FRBR.manifestation(model, "Book2253132225");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model),
				"2-253-13222-5");
		manifestation.addProperty(FRBR.dimensions(model), "19 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model),
				"Cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "120,00 F");
		manifestation.addProperty(FRBR.extent(model), "1279 pages");
		manifestation.addProperty(FRBR.placeOfpublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "1994");
		manifestation
				.addProperty(FRBR.titleOfTheManifestation(model), "Romans");
		manifestation.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Chretien de Troyes");

		// Person
		Resource author = FRBR.person(model, "ChretiendeTroyes");
		author.addProperty(FRBR.nameOfThePerson(model), "Chretien de Troyes");

		// Corporate
		Resource publisher = FRBR
				.corporate(model, "LibrairieGeneraleFrancaise");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model),
				"Librairie Generale Francaise");

		// Concept
		Resource concept = FRBR.concept(model, "RomansdelaTableronde");
		concept.addProperty(FRBR.hasTermForTheConcept(model),
				"Romans de la Table ronde");

		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.compiler(model), author);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept);
		work.addProperty(FRBR.containerOfWork(model), pw1);
		work.addProperty(FRBR.containerOfWork(model), pw2);
		work.addProperty(FRBR.containerOfWork(model), pw3);
		work.addProperty(FRBR.containerOfWork(model), pw4);

		expression.addProperty(FRBR.manifestationOfExpression(model),
				manifestation);
		pw1e.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		pw2e.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		pw3e.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		pw4e.addProperty(FRBR.manifestationOfExpression(model), manifestation);

		manifestation.addProperty(FRBR.publisher(model), publisher);

	}

	/**
	 * Le Roman de Renart
	 * 
	 * @throws Exception
	 */
	public void romanDeRenart() {

		// Work
		Resource work = FRBR.work(model, "RomandeRenart");
		work.addProperty(FRBR.titleOfTheWork(model), "Roman de Renart");

		Resource expression = FRBR.expression(model, "RomandeRenartTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");

		Resource manifestation = FRBR.manifestation(model, "Book9782081209633");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2-0812-0963-3");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model),
				"Illustrations, cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "2,70 euro");
		manifestation.addProperty(FRBR.extent(model), "159 pages");
		manifestation.addProperty(FRBR.placeOfpublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2008");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model),
				"Roman de Renart (Le)");
		manifestation.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Christian Keime; Monique Lachet-Lagarde");

		Resource author = FRBR.person(model, "ChristianKeime");
		author.addProperty(FRBR.nameOfThePerson(model), "Christian Keime");

		Resource contrib = FRBR.person(model, "MoniqueLachetLagarde");
		contrib.addProperty(FRBR.nameOfThePerson(model),
				"Monique Lachet-Lagarde");

		Resource publisher = FRBR.corporate(model, "Flammarion");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Flammarion");

		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model),
				manifestation);
		expression.addProperty(FRBR.contributor(model), contrib);
		manifestation.addProperty(FRBR.publisher(model), publisher);

		// Part of the larger work

		Resource part = FRBR.work(model, "JambonsYsengrin");
		part.addProperty(FRBR.titleOfTheWork(model),
				"Jambons d'Ysengrin (Les )");

		Resource partexpr = FRBR
				.expression(model, "JambonsYsengrinComicFrench");
		partexpr.addProperty(FRBR.languageOfExpression(model), "French");

		Resource partmanif = FRBR.manifestation(model, "Book9782756003580");
		partmanif.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2-7560-0358-0");
		partmanif.addProperty(FRBR.dimensions(model), "30 cm");
		partmanif.addProperty(FRBR.noteOnCarrier(model),
				"colorful illustrations");
		partmanif.addProperty(FRBR.termsOfAvailability(model), "8,90 Euros");
		partmanif.addProperty(FRBR.extent(model), "31 pages");
		partmanif.addProperty(FRBR.placeOfpublication(model), "Paris");
		partmanif.addProperty(FRBR.dateOfPublication(model), "2007");
		partmanif.addProperty(FRBR.titleOfTheManifestation(model),
				"Jambons d'Ysengrin (Les )");
		partmanif.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Jean-Marc Mathis; illustrated by Thierry Martin");

		Resource partauthor = FRBR.person(model, "JeanMarcMathis");
		partauthor.addProperty(FRBR.nameOfThePerson(model), "Jean-Marc Mathis");

		Resource publisher2 = FRBR.corporate(model, "Delcourt");
		publisher2.addProperty(FRBR.nameOfTheCorporateBody(model), "Delcourt");

		part.addProperty(FRBR.expressionOfWork(model), partexpr);
		part.addProperty(FRBR.creator(model), partauthor);
		partexpr.addProperty(FRBR.manifestationOfExpression(model), partmanif);
		partmanif.addProperty(FRBR.publisher(model), publisher2);

		// ensemble
		work.addProperty(FRBR.wholePartWorkRelationship(model), part);

	}

	/**
	 * Essais
	 * 
	 * @throws Exception
	 */
	public void essais() {

		// Person
		Resource author = FRBR.person(model, "MicheldeMontaigne");
		author.addProperty(FRBR.nameOfThePerson(model), "Michel de Montaigne");

		Resource publisher = FRBR.corporate(model, "GarnierFlammarion");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model),
				"Garnier-Flammarion");

		// Collection (serie)
		Resource collection = FRBR.work(model, "GF");
		collection.addProperty(FRBR.titleOfTheWork(model), "GF");

		// Work (subserie)
		Resource subserie = FRBR.work(model, "Essais");
		subserie.addProperty(FRBR.titleOfTheWork(model), "Essais");

		// Book 1 (componant)
		Resource book1 = FRBR.work(model, "Essais");
		book1.addProperty(FRBR.titleOfTheWork(model), "Essais");

		Resource expr1 = FRBR.expression(model, "EssaisTextFrench");
		expr1.addProperty(FRBR.languageOfExpression(model), "French");

		Resource manif1 = FRBR.manifestation(model, "Book9782080702104");
		manif1.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2-08-070210-4");
		manif1.addProperty(FRBR.dimensions(model), "18 cm");
		manif1.addProperty(FRBR.noteOnCarrier(model),
				"Cover with colorful illustrations");
		manif1.addProperty(FRBR.termsOfAvailability(model), "5.80 euro");
		manif1.addProperty(FRBR.extent(model), "443 pages");
		manif1.addProperty(FRBR.placeOfpublication(model), "Paris");
		manif1.addProperty(FRBR.dateOfPublication(model), "1969");
		manif1.addProperty(FRBR.numberingWithinSeries(model), "210");
		manif1.addProperty(FRBR.numberingWithinSubseries(model), "1");
		manif1.addProperty(FRBR.otherTitleInformation(model), "Book I");
		manif1.addProperty(FRBR.titleOfTheManifestation(model), "Essais");
		manif1.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Michel de Montaigne");

		// Book 2 (componant)
		Resource book2 = FRBR.work(model, "Essais");
		book2.addProperty(FRBR.titleOfTheWork(model), "Essais");

		Resource expr2 = FRBR.expression(model, "EssaisTextFrench");
		expr2.addProperty(FRBR.languageOfExpression(model), "French");

		Resource manif2 = FRBR.manifestation(model, "Book9782080702111");
		manif2.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2-08-070211-1");
		manif2.addProperty(FRBR.dimensions(model), "18 cm");
		manif2.addProperty(FRBR.noteOnCarrier(model),
				"Cover with colorful illustrations");
		manif2.addProperty(FRBR.termsOfAvailability(model), "6.80euro");
		manif2.addProperty(FRBR.extent(model), "510 pages");
		manif2.addProperty(FRBR.placeOfpublication(model), "Paris");
		manif2.addProperty(FRBR.dateOfPublication(model), "1969");
		manif2.addProperty(FRBR.numberingWithinSeries(model), "211");
		manif2.addProperty(FRBR.numberingWithinSubseries(model), "2");
		manif2.addProperty(FRBR.otherTitleInformation(model), "Book II");
		manif2.addProperty(FRBR.titleOfTheManifestation(model), "Essais");
		manif2.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Michel de Montaigne");

		// Relationships

		book1.addProperty(FRBR.expressionOfWork(model), expr1);
		book1.addProperty(FRBR.creator(model), author);
		expr1.addProperty(FRBR.manifestationOfExpression(model), manif1);
		manif1.addProperty(FRBR.publisher(model), publisher);
		manif1.addProperty(FRBR.seriesStatement(model), collection);

		book2.addProperty(FRBR.expressionOfWork(model), expr2);
		book2.addProperty(FRBR.creator(model), author);
		expr2.addProperty(FRBR.manifestationOfExpression(model), manif2);
		manif2.addProperty(FRBR.publisher(model), publisher);
		manif2.addProperty(FRBR.seriesStatement(model), collection);

		subserie.addProperty(FRBR.containerOfWork(model), book1);
		subserie.addProperty(FRBR.containerOfWork(model), book2);

	}

	/**
	 * Meditations metaphysiques
	 * 
	 * @throws Exception
	 */
	public void meditationsMetaphysiques() {

		// Common

		// Collection (serie)
		Resource collection = FRBR.work(model, "LesIntegralesphilo");
		collection.addProperty(FRBR.titleOfTheWork(model),
				"Les Integrales de philo");
		collection.addProperty(FRBR.identifierForTheWork(model), "colauth-001");

		Resource author = FRBR.person(model, "Descartes");
		author.addProperty(FRBR.nameOfThePerson(model), "Descartes");

		Resource publisher = FRBR.corporate(model, "Nathan");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Nathan");

		// Collection Element 1
		Resource work1 = FRBR.work(model, "MeditationsMetaphysiques");
		work1.addProperty(FRBR.titleOfTheWork(model),
				"Meditations metaphysiques");

		Resource expression1 = FRBR.expression(model,
				"MeditationsMetaphysiquesTextFrench");
		expression1.addProperty(FRBR.languageOfExpression(model), "French");

		Resource manifestation1 = FRBR
				.manifestation(model, "Book9782091873053");
		manifestation1.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2-09-187305-3");
		manifestation1.addProperty(FRBR.dimensions(model), "21 cm");
		manifestation1.addProperty(FRBR.noteOnCarrier(model),
				"On the cover: Texte integral annote, dossier pedagogique");
		manifestation1.addProperty(FRBR.termsOfAvailability(model), "7,50 EUR");
		manifestation1.addProperty(FRBR.extent(model), "191 pages");
		manifestation1.addProperty(FRBR.placeOfpublication(model), "France");
		manifestation1.addProperty(FRBR.dateOfPublication(model), "2009");
		manifestation1.addProperty(FRBR.seriesStatement(model), collection);
		manifestation1.addProperty(FRBR.titleOfTheManifestation(model),
				"Meditations metaphysiques");
		manifestation1.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Descartes; Andre Vergez; Christine Thubert");

		Resource collab1 = FRBR.person(model, "ChristineThubert");
		collab1.addProperty(FRBR.nameOfThePerson(model), "Christine Thubert");

		work1.addProperty(FRBR.expressionOfWork(model), expression1);
		work1.addProperty(FRBR.creator(model), author);
		expression1.addProperty(FRBR.manifestationOfExpression(model),
				manifestation1);
		expression1.addProperty(FRBR.contributor(model), collab1);
		manifestation1.addProperty(FRBR.publisher(model), publisher);

		// Collection Element 2
		Resource work2 = FRBR.work(model, "DiscoursdelaMethode");
		work2.addProperty(FRBR.titleOfTheWork(model), "Discours de la methode");

		Resource expression2 = FRBR.expression(model,
				"MeditationsMetaphysiquesTextFrench");
		expression2.addProperty(FRBR.languageOfExpression(model), "French");
		expression2.addProperty(FRBR.noteOnExpression(model),
				"Bibliography pages 142-143");

		Resource manifestation2 = FRBR
				.manifestation(model, "Book9782091873022");
		manifestation2.addProperty(FRBR.identifierForTheManifestation(model),
				"9782091873022");
		manifestation2.addProperty(FRBR.dimensions(model), "21 cm");
		manifestation2.addProperty(FRBR.termsOfAvailability(model), "6,50 EUR");
		manifestation2.addProperty(FRBR.extent(model), "143 pages");
		manifestation2.addProperty(FRBR.dateOfPublication(model), "2009");
		manifestation2.addProperty(FRBR.seriesStatement(model), collection);
		manifestation1.addProperty(FRBR.titleOfTheManifestation(model),
				"Discours de la methode");
		manifestation1.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Descartes; Denis Huisman");

		Resource collab2 = FRBR.person(model, "DenisHuisman");
		collab2.addProperty(FRBR.nameOfThePerson(model), "Denis Huisman");

		work2.addProperty(FRBR.expressionOfWork(model), expression2);
		work2.addProperty(FRBR.creator(model), author);
		expression2.addProperty(FRBR.manifestationOfExpression(model),
				manifestation2);
		expression2.addProperty(FRBR.contributor(model), collab2);
		manifestation2.addProperty(FRBR.publisher(model), publisher);

	}

	/**
	 * Valerian et Laureline
	 * 
	 * @throws Exception
	 */
	public void valerianEtLaureline() {

		// Work
		Resource work = FRBR.work(model, "ValerianEtLaureline");
		work.addProperty(FRBR.titleOfTheWork(model), "Valerian et Laureline");

		// Expression
		Resource expression = FRBR.expression(model,
				"ValerianEtLaurelineTextFrench");
		expression.addProperty(FRBR.languageOfExpression(model), "French");

		// Manifestation
		Resource manifestation = FRBR
				.manifestation(model, "Comic9782205060386");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2205-06038-6");
		manifestation.addProperty(FRBR.dimensions(model), "30 cm");
		manifestation.addProperty(FRBR.noteOnCarrier(model),
				"Colorful illustrations, cover with colorful illustrations");
		manifestation.addProperty(FRBR.extent(model), "1 volume (173 pages)");
		manifestation.addProperty(FRBR.carrierType(model), "Printed Text");
		manifestation.addProperty(FRBR.placeOfpublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2012");
		manifestation.addProperty(FRBR.otherTitleInformation(model),
				"l'integrale Volume 7");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model),
				"Valerian et Laureline");
		manifestation.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Pierre Christin; Jean-Claude Mezieres");

		// Person
		Resource author1 = FRBR.person(model, "PierreChristin");
		author1.addProperty(FRBR.nameOfThePerson(model), "Pierre Christin");

		// Person
		Resource author2 = FRBR.person(model, "JeanClaudeMezieres");
		author2.addProperty(FRBR.nameOfThePerson(model), "Jean-Claude Mezieres");

		// Corporate
		Resource publisher = FRBR.corporate(model, "Dargaud");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Dargaud");

		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author1);
		work.addProperty(FRBR.creator(model), author2);
		expression.addProperty(FRBR.manifestationOfExpression(model),
				manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

		// Part Work 1
		Resource pw1 = FRBR.work(model, "Auborddugouffre");
		pw1.addProperty(FRBR.titleOfTheWork(model), "Au bord du gouffre");
		pw1.addProperty(FRBR.identifierForTheWork(model), "tauth-007");
		Resource apw1 = FRBR.person(model, "VictorMargueritte");
		apw1.addProperty(FRBR.nameOfThePerson(model), "Victor Margueritte");
		pw1.addProperty(FRBR.creator(model), apw1);

		// Part Work 2
		Resource pw2 = FRBR.work(model, "Lordredespierres");
		pw2.addProperty(FRBR.titleOfTheWork(model), "L'ordre des pierres");
		pw2.addProperty(FRBR.identifierForTheWork(model), "tauth-006");
		Resource apw21 = FRBR.person(model, "JeanClaudeMezieres");
		apw21.addProperty(FRBR.nameOfThePerson(model), "Jean-Claude Mezieres");
		Resource apw22 = FRBR.person(model, "PierreChristin");
		apw22.addProperty(FRBR.nameOfThePerson(model), "Pierre Christin");
		pw2.addProperty(FRBR.creator(model), apw21);
		pw2.addProperty(FRBR.creator(model), apw22);

		// Part Work 3
		Resource pw3 = FRBR.work(model, "ValerianetLaureline");
		pw3.addProperty(FRBR.titleOfTheWork(model), "Valerian et Laureline");
		pw3.addProperty(FRBR.identifierForTheWork(model), "tauth-005");
		Resource apw31 = FRBR.person(model, "JeanClaudeMezieres");
		apw31.addProperty(FRBR.nameOfThePerson(model), "Jean-Claude Mezieres");
		Resource apw32 = FRBR.person(model, "PierreChristin");
		apw32.addProperty(FRBR.nameOfThePerson(model), "Pierre Christin");
		pw3.addProperty(FRBR.creator(model), apw31);
		pw3.addProperty(FRBR.creator(model), apw32);

		work.addProperty(FRBR.containerOfWork(model), pw1);
		work.addProperty(FRBR.containerOfWork(model), pw2);
		work.addProperty(FRBR.containerOfWork(model), pw3);

	}

	/**
	 * Infection control and hospital epidemiology
	 * 
	 * @throws Exception
	 */
	public void infectionControlAndHospitalEpidemiology() {

		// Work
		Resource work = FRBR.work(model,
				"InfectionControlAndHospitalEpidemiology");
		work.addProperty(FRBR.identifierForTheWork(model), "tauth-014");
		work.addProperty(FRBR.titleOfTheWork(model),
				"Infection control and hospital epidemiology");
		work.addProperty(FRBR.variantTitleForTheWork(model),
				"Official journal of The SHEA");
		work.addProperty(FRBR.variantTitleForTheWork(model), "ICHE");
		work.addProperty(FRBR.variantTitleForTheWork(model),
				"Infect Control Hosp Epidemiol");
		work.addProperty(FRBR.variantTitleForTheWork(model),
				"Infect Control Hosp Epidemiol");
		Resource director1 = FRBR.person(model, "RichardPWenzel");
		director1.addProperty(FRBR.nameOfThePerson(model), "Richard P. Wenzel");
		Resource director2 = FRBR.person(model, "BarryFarr");
		director2.addProperty(FRBR.nameOfThePerson(model), "Barry Farr");
		work.addProperty(FRBR.director(model), director1);
		work.addProperty(FRBR.director(model), director2);
		Resource concept1 = FRBR.concept(model, "CrossInfection");
		concept1.addProperty(FRBR.hasTermForTheConcept(model),
				"Cross Infection");
		Resource concept2 = FRBR.concept(model, "Epidemiology");
		concept2.addProperty(FRBR.hasTermForTheConcept(model), "Epidemiology");
		Resource concept3 = FRBR.concept(model, "Hospitals");
		concept3.addProperty(FRBR.hasTermForTheConcept(model), "Hospitals");
		Resource concept4 = FRBR.concept(model, "InfectionControl");
		concept4.addProperty(FRBR.hasTermForTheConcept(model),
				"Infection Control");
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept3);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept4);

		// Expression
		Resource expression = FRBR.expression(model,
				"InfectionControlAndHospitalEpidemiologyJournal");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		expression.addProperty(FRBR.noteOnExpression(model), "Serial");
		expression.addProperty(FRBR.summarizationOfTheContent(model),
				"Infection Control and Hospital Epidemiology...");
		Resource editor = FRBR.corporate(model,
				"SocietyHospitalEpidemiologistsAmerica");
		editor.addProperty(FRBR.nameOfTheCorporateBody(model),
				"Society of Hospital Epidemiologists of America");
		expression.addProperty(FRBR.editor(model), editor);

		// Manifestation
		Resource manifestation = FRBR.manifestation(model, "Journal0899823X");
		manifestation.addProperty(FRBR.issnOfSeries(model), "0899-823X");
		manifestation.addProperty(FRBR.publicationStatement(model),
				"Volume 9, number 1 (January 1988)-");
		manifestation.addProperty(FRBR.noteOnPublicationStatement(model),
				"Published by University chicago press in 2006");
		manifestation.addProperty(FRBR.frequency(model), "Monthly");
		manifestation
				.addProperty(FRBR.otherTitleInformation(model),
						"An official journal of the Society of Hospital Epidemiologists of America");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model),
				"Infection control and hospital epidemiology");
		manifestation.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Richard P. Wenzel; Barry Farr");

		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		expression.addProperty(FRBR.manifestationOfExpression(model),
				manifestation);

		// Publication 1
		Resource publication1 = FRBR
				.manifestation(model, "Journal0899823XPub1");
		publication1.addProperty(FRBR.dateOfPublication(model), "1988-");
		publication1.addProperty(FRBR.placeOfpublication(model),
				"Thorofare, NJ");
		Resource publisher1 = FRBR.corporate(model, "SLACKInc");
		publisher1
				.addProperty(FRBR.nameOfTheCorporateBody(model), "SLACK Inc.");
		publication1.addProperty(FRBR.publisher(model), publisher1);

		// Publication 2
		Resource publication2 = FRBR
				.manifestation(model, "Journal0899823XPub2");
		publication2.addProperty(FRBR.dateOfPublication(model), "2006-");
		publication2.addProperty(FRBR.placeOfpublication(model), "Chicago, IL");
		Resource publisher2 = FRBR.corporate(model, "UniversityofChicagoPress");
		publisher2.addProperty(FRBR.nameOfTheCorporateBody(model),
				"University of Chicago Press");
		publication2.addProperty(FRBR.publisher(model), publisher2);

		// Publication
		Resource pub = FRBR.expression(model,
				"InfectionControlAndHospitalEpidemiologyPublication");
		work.addProperty(FRBR.expressionOfWork(model), pub);
		pub.addProperty(FRBR.manifestationOfExpression(model), publication1);
		pub.addProperty(FRBR.manifestationOfExpression(model), publication2);

		manifestation.addProperty(FRBR.containerOfManifestation(model),
				publication1);
		manifestation.addProperty(FRBR.containerOfManifestation(model),
				publication2);

	}

	/**
	 * Hart und Sozial<
	 * 
	 * @throws Exception
	 */
	public void hartUndSozial() {

		// ## Article

		// Work
		Resource work = FRBR.work(model, "HartUndSozial");
		work.addProperty(FRBR.titleOfTheWork(model), "Hart und Sozial");

		// Expression
		Resource expression = FRBR.expression(model,
				"HartUndSozialArticleEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "German");
		expression.addProperty(FRBR.summarizationOfTheContent(model),
				"Wiederholungstater sind haufig noch...");

		// Manifestation
		Resource manifestation = FRBR.manifestation(model,
				"ArticleHartUndSozial");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2008");
		manifestation.addProperty(FRBR.publicationStatement(model),
				"volume 14, number 3");
		manifestation.addProperty(FRBR.extent(model), "pages 40-46");
		manifestation.addProperty(FRBR.otherTitleInformation(model),
				"Das Utrechter Modell");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model),
				"Hart und Sozial");
		manifestation.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Hans Slijpen");

		// Person
		Resource author = FRBR.person(model, "HansSlijpen");
		author.addProperty(FRBR.nameOfThePerson(model), "Hans Slijpen");

		// Concept
		Resource concept1 = FRBR.concept(model, "Abhangigkeit");
		concept1.addProperty(FRBR.hasTermForTheConcept(model), "Abhangigkeit");

		Resource concept2 = FRBR.concept(model, "Behandlung");
		concept2.addProperty(FRBR.hasTermForTheConcept(model), "Behandlung");

		Resource concept3 = FRBR.concept(model, "Klinik");
		concept3.addProperty(FRBR.hasTermForTheConcept(model), "Klinik");

		// Place
		Resource place = FRBR.place(model, "Netherlands");
		place.addProperty(FRBR.hasTermForTheConcept(model), "Netherlands");

		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept3);
		work.addProperty(FRBR.hasAsSubjectPlace(model), place);
		expression.addProperty(FRBR.manifestationOfExpression(model),
				manifestation);

		// ## Journal

		// Work
		Resource journal = FRBR.work(model, "Abhangigkeiten");
		journal.addProperty(FRBR.titleOfTheWork(model), "Abhangigkeiten");
		journal.addProperty(FRBR.identifierForTheWork(model), "jauth-001");
		journal.addProperty(FRBR.wholePartWorkRelationship(model), work);

	}

	/**
	 * I love english
	 * 
	 * @throws Exception
	 */
	public void iLoveEnglish() {

		Resource work = FRBR.work(model, "Iloveenglish");
		work.addProperty(FRBR.identifierForTheWork(model), "tauth-013");
		work.addProperty(FRBR.titleOfTheWork(model), "I love english");

		// Expression
		Resource expression = FRBR.expression(model, "IloveenglishJournal");
		expression.addProperty(FRBR.noteOnExpression(model), "Serial");
		Resource publisher = FRBR.corporate(model, "BayardPresse");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model),
				"Bayard Presse");
		expression.addProperty(FRBR.publisher(model), publisher);

		Resource audio = FRBR.expression(model, "IloveenglishAudio");
		audio.addProperty(FRBR.noteOnExpression(model), "1 CD audio");

		Resource manifestation = FRBR.manifestation(model,
				"JournalIloveenglish");
		manifestation.addProperty(FRBR.dimensions(model), "28 cm");
		manifestation.addProperty(FRBR.frequency(model), "Monthly");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2002-");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model),
				"I love english");

		Resource concept1 = FRBR.concept(model, "LearningEnglish");
		concept1.addProperty(FRBR.hasTermForTheConcept(model),
				"Learning English");

		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.expressionOfWork(model), audio);
		work.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		expression.addProperty(FRBR.manifestationOfExpression(model),
				manifestation);
		audio.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);

		// publication 1
		Resource pub1 = FRBR.work(model, "Iloveenglish208");
		pub1.addProperty(FRBR.titleOfTheWork(model), "I love english");
		Resource exppub1 = FRBR.expression(model, "Iloveenglish208");
		Resource manifpub1 = FRBR.manifestation(model, "Iloveenglish208");
		manifpub1
				.addProperty(FRBR.titleOfTheManifestation(model), "May-1-2013");
		manifpub1.addProperty(FRBR.dateOfPublication(model), "2013");
		manifpub1.addProperty(FRBR.numberingWithinSeries(model), "208");
		manifpub1.addProperty(FRBR.otherTitleInformation(model), "208");
		pub1.addProperty(FRBR.expressionOfWork(model), exppub1);
		exppub1.addProperty(FRBR.manifestationOfExpression(model), manifpub1);

		// publication 2
		Resource pub2 = FRBR.work(model, "Iloveenglish209");
		pub2.addProperty(FRBR.titleOfTheWork(model), "I love english");
		Resource exppub2 = FRBR.expression(model, "Iloveenglish209");
		Resource manifpub2 = FRBR.manifestation(model, "Iloveenglish209");
		manifpub2.addProperty(FRBR.titleOfTheManifestation(model),
				"June-1-2013");
		manifpub2.addProperty(FRBR.dateOfPublication(model), "2013");
		manifpub2.addProperty(FRBR.numberingWithinSeries(model), "209");
		manifpub2.addProperty(FRBR.otherTitleInformation(model), "209");
		pub2.addProperty(FRBR.expressionOfWork(model), exppub2);
		exppub2.addProperty(FRBR.manifestationOfExpression(model), manifpub2);

		work.addProperty(FRBR.wholePartWorkRelationship(model), pub1);
		work.addProperty(FRBR.wholePartWorkRelationship(model), pub2);

	}

}
