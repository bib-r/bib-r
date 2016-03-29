package org.bibr.com;

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

public class FRBRizationCom_5_1 {

	private Model model;

	@Before
	public void setUp() throws Exception {
		model = ModelFactory.createDefaultModel();
		FRBR.initializeModel(model);
	}

	@Test
	public void launch() throws Exception {
		dCGEpreuve10();
		infectionControlAndHospitalEpidemiology();
		aStudyInContinualImprovement();
	}

	@After
	public void tearDown() throws Exception {

		String path = Util.path+"/5_Complementary/5.1/comp-missing-publication-date-frbr.xml";
		Writer w1 = new FileWriter(path);
		w1.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		w1.close();
		Writer w2 = new FileWriter(path, true);
		model.write(w2, "RDF/XML");
		w2.close();
	}

	/**
	 * DCG epreuve 10
	 * 
	 * @throws Exception
	 */
	public void dCGEpreuve10() {

		Resource collection = FRBR.work(model, "DGC");
		collection.addProperty(FRBR.titleOfTheWork(model), "DGC");

		// work 1

		Resource work1 = FRBR.work(model, "DCGepreuve10manuel");
		work1.addProperty(FRBR.titleOfTheWork(model), "DCG epreuve 10");

		Resource expression1 = FRBR.expression(model, "DCGepreuve10Bookmanuel");
		expression1.addProperty(FRBR.noteOnExpression(model), "2015-2016");

		Resource manifestation1 = FRBR.manifestation(model,
				"DCGepreuve109782091638669");
		manifestation1.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2-09-163866-9");
		manifestation1.addProperty(FRBR.extent(model), "1 volume (763 pages)");
		manifestation1.addProperty(FRBR.dimensions(model), "24 cm");
		manifestation1.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation1.addProperty(FRBR.otherTitleInformation(model),
				"comptabilite approfondie; manuel et applications");
		manifestation1.addProperty(FRBR.titleOfTheManifestation(model),
				"DCG epreuve 10");
		manifestation1.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Odile Barbe; Laurent Didelot; Jean-Luc Siegwart");

		Resource publisher1 = FRBR.corporate(model, "Nathan");
		publisher1.addProperty(FRBR.nameOfTheCorporateBody(model), "Nathan");
		publisher1.addProperty(
				FRBR.otherDesignationAssociatedWithTheCorporateBody(model),
				"Groupe Revue fiduciaire");

		Resource author1 = FRBR.person(model, "OdileBarbe");
		author1.addProperty(FRBR.identifierForThePerson(model), "pauth-046");
		author1.addProperty(FRBR.nameOfThePerson(model), "Odile Barbe-Dandon");

		Resource author2 = FRBR.person(model, "LaurentDidelot");
		author2.addProperty(FRBR.identifierForThePerson(model), "pauth-047");
		author2.addProperty(FRBR.nameOfThePerson(model), "Laurent Didelot");

		Resource author3 = FRBR.person(model, "JeanLucSiegwart");
		author3.addProperty(FRBR.identifierForThePerson(model), "pauth-048");
		author3.addProperty(FRBR.nameOfThePerson(model), "Jean-Luc Siegwart");

		work1.addProperty(FRBR.expressionOfWork(model), expression1);
		work1.addProperty(FRBR.creator(model), author1);
		work1.addProperty(FRBR.creator(model), author2);
		work1.addProperty(FRBR.creator(model), author3);
		expression1.addProperty(FRBR.manifestationOfExpression(model),
				manifestation1);
		manifestation1.addProperty(FRBR.publisher(model), publisher1);

		// work 2

		Resource work2 = FRBR.work(model, "DCGepreuve10corrige");
		work2.addProperty(FRBR.titleOfTheWork(model), "DCG epreuve 10");

		Resource expression2 = FRBR
				.expression(model, "DCGepreuve10Bookcorrige");
		expression2.addProperty(FRBR.noteOnExpression(model), "2015-2016");

		Resource manifestation2 = FRBR.manifestation(model,
				"DCGepreuve9782091638676");
		manifestation2.addProperty(FRBR.identifierForTheManifestation(model),
				"978-2-09-163867-6");
		manifestation2.addProperty(FRBR.extent(model), "1 volume (271 pages)");
		manifestation2.addProperty(FRBR.dimensions(model), "24 cm");
		manifestation2.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation2.addProperty(FRBR.otherTitleInformation(model),
				"comptabilite approfondie; corriges des applications");
		manifestation1.addProperty(FRBR.titleOfTheManifestation(model),
				"DCG epreuve 10");
		manifestation1.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Odile Barbe; Laurent Didelot; Laurence Cassio");

		Resource author4 = FRBR.person(model, "LaurenceCassio");
		author4.addProperty(FRBR.identifierForThePerson(model), "pauth-049");
		author4.addProperty(FRBR.nameOfThePerson(model), "Laurence Cassio");

		work2.addProperty(FRBR.expressionOfWork(model), expression2);
		expression2.addProperty(FRBR.editor(model), author1);
		work2.addProperty(FRBR.creator(model), author2);
		work2.addProperty(FRBR.creator(model), author4);
		expression2.addProperty(FRBR.manifestationOfExpression(model),
				manifestation2);
		manifestation2.addProperty(FRBR.publisher(model), publisher1);

		// collection
		collection.addProperty(FRBR.containerOfWork(model), work1);
		collection.addProperty(FRBR.containerOfWork(model), work2);

		// complement
		work1.addProperty(FRBR.complementedByWork(model), work2);

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
		director1.addProperty(FRBR.identifierForThePerson(model), "pauth-044");
		director1.addProperty(FRBR.nameOfThePerson(model), "Richard P. Wenzel");
		Resource director2 = FRBR.person(model, "BarryFarr");
		director2.addProperty(FRBR.identifierForThePerson(model), "pauth-045");
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
		manifestation.addProperty(FRBR.titleOfTheManifestation(model),
				"Infection control and hospital epidemiology");
		manifestation
				.addProperty(FRBR.otherTitleInformation(model),
						"An official journal of the Society of Hospital Epidemiologists of America");
		manifestation.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Richard P. Wenzel; Barry Farr");

		// Publication 1
		Resource publication1 = FRBR
				.manifestation(model, "Journal0899823XPub1");
		publication1.addProperty(FRBR.placeOfPublication(model),
				"Thorofare, NJ");
		Resource publisher1 = FRBR.corporate(model, "SLACKInc");
		publisher1
				.addProperty(FRBR.nameOfTheCorporateBody(model), "SLACK Inc.");
		publication1.addProperty(FRBR.publisher(model), publisher1);

		// Publication 2
		Resource publication2 = FRBR
				.manifestation(model, "Journal0899823XPub2");
		publication2.addProperty(FRBR.placeOfPublication(model), "Chicago, IL");
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

		// Infection Control

		// Work
		Resource work2 = FRBR.work(model, "Infectioncontrol");
		work2.addProperty(FRBR.identifierForTheWork(model), "tauth-019");
		work2.addProperty(FRBR.titleOfTheWork(model), "Infection control");

		Resource concept2_1 = FRBR.concept(model, "Infection");
		concept2_1.addProperty(FRBR.hasTermForTheConcept(model), "Infection");
		Resource concept2_2 = FRBR.concept(model, "InfectionControl");
		concept2_2.addProperty(FRBR.hasTermForTheConcept(model),
				"Infection Control");
		work2.addProperty(FRBR.hasAsSubjectConcept(model), concept2_1);
		work2.addProperty(FRBR.hasAsSubjectConcept(model), concept2_2);

		// Expression
		Resource expression2 = FRBR
				.expression(model, "InfectioncontrolJournal");
		expression2.addProperty(FRBR.languageOfExpression(model), "English");
		expression2.addProperty(FRBR.noteOnExpression(model), "Serial");

		// Manifestation
		Resource manifestation2 = FRBR.manifestation(model, "Journal0195-9417");
		manifestation2.addProperty(FRBR.issnOfSeries(model), "0195-9417");
		manifestation2.addProperty(FRBR.frequency(model), "Monthly");
		manifestation2.addProperty(FRBR.publisher(model), publisher1);
		manifestation2.addProperty(FRBR.titleOfTheManifestation(model),
				"Infection control");

		// following
		work2.addProperty(FRBR.expressionOfWork(model), expression2);
		expression2.addProperty(FRBR.manifestationOfExpression(model),
				manifestation2);
		work.addProperty(FRBR.continuationOfWork(model), work2);
	}

	/**
	 * A study in continual improvement
	 */
	public void aStudyInContinualImprovement() {

		// work 1

		Resource work1 = FRBR.work(model, "StudyContinualImprovement1");
		work1.addProperty(FRBR.titleOfTheWork(model),
				"A study in continual improvement");

		Resource expression1 = FRBR.expression(model,
				"StudyContinualImprovementVideo1");
		expression1
				.addProperty(FRBR.summarizationOfTheContent(model),
						"Reston Hospital Center's 14 guiding principles and their relationship...");

		Resource manifestation1 = FRBR.manifestation(model,
				"StudyContinualImprovementVideo1");
		manifestation1.addProperty(FRBR.extent(model),
				"1 videocassette (27 min)");
		manifestation1.addProperty(FRBR.noteOnCarrier(model), "PAL");
		manifestation1.addProperty(FRBR.placeOfPublication(model),
				"Chicago, Ill.");
		manifestation1.addProperty(FRBR.titleOfTheManifestation(model),
				"A study in continual improvement");
		manifestation1.addProperty(FRBR.otherTitleInformation(model), "Part 1");
		manifestation1.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Clare Crawford-Mason; W. Edwards Deming; Lloyd Dobyns");

		Resource publisher1 = FRBR.corporate(model, "FilmsIncorporated");
		publisher1.addProperty(FRBR.nameOfTheCorporateBody(model),
				"Films Incorporated");

		Resource author1 = FRBR.person(model, "ClareCrawfordMason");
		author1.addProperty(FRBR.identifierForThePerson(model), "pauth-057");
		author1.addProperty(FRBR.nameOfThePerson(model), "Clare Crawford-Mason");

		Resource author2 = FRBR.person(model, "WilliamEdwardsDeming");
		author2.addProperty(FRBR.identifierForThePerson(model), "pauth-058");
		author2.addProperty(FRBR.nameOfThePerson(model),
				"William Edwards Deming");

		Resource author3 = FRBR.person(model, "LloydDobyns");
		author3.addProperty(FRBR.identifierForThePerson(model), "pauth-059");
		author3.addProperty(FRBR.nameOfThePerson(model), "Lloyd Dobyns");

		// Concept
		Resource concept1 = FRBR.concept(model, "Hospitals");
		concept1.addProperty(FRBR.hasTermForTheConcept(model), "Hospitals");

		Resource concept2 = FRBR.concept(model, "TotalQualityManagement");
		concept2.addProperty(FRBR.hasTermForTheConcept(model),
				"Total Quality Management");

		// Place
		Resource place = FRBR.place(model, "Virginia");
		place.addProperty(FRBR.hasTermForTheConcept(model), "Virginia");

		work1.addProperty(FRBR.expressionOfWork(model), expression1);
		work1.addProperty(FRBR.creator(model), author1);
		expression1.addProperty(FRBR.contributor(model), author2);
		expression1.addProperty(FRBR.narrator(model), author3);
		work1.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work1.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work1.addProperty(FRBR.hasAsSubjectPlace(model), place);
		expression1.addProperty(FRBR.manifestationOfExpression(model),
				manifestation1);
		manifestation1.addProperty(FRBR.publisher(model), publisher1);

		// work 2

		Resource work2 = FRBR.work(model, "StudyContinualImprovement2");
		work2.addProperty(FRBR.titleOfTheWork(model),
				"A study in continual improvement");

		Resource expression2 = FRBR.expression(model,
				"StudyContinualImprovementVideo2");
		expression2
				.addProperty(
						FRBR.summarizationOfTheContent(model),
						"how an understanding of systems, variation, psychology, and the theory of knowledge underpins the transformation of American business...");

		Resource manifestation2 = FRBR.manifestation(model,
				"StudyContinualImprovementVideo2");
		manifestation2.addProperty(FRBR.extent(model),
				"1 videocassette (27 min)");
		manifestation2.addProperty(FRBR.noteOnCarrier(model), "PAL");
		manifestation2.addProperty(FRBR.placeOfPublication(model),
				"Chicago, Ill.");
		manifestation2.addProperty(FRBR.titleOfTheManifestation(model),
				"A study in continual improvement");
		manifestation2.addProperty(FRBR.otherTitleInformation(model), "Part 2");
		manifestation2.addProperty(
				FRBR.statementOfResponsibilityRelatingToTitleProper(model),
				"Clare Crawford-Mason; W. Edwards Deming; Lloyd Dobyns");

		work2.addProperty(FRBR.expressionOfWork(model), expression2);
		expression2.addProperty(FRBR.editor(model), author1);
		expression2.addProperty(FRBR.contributor(model), author2);
		expression2.addProperty(FRBR.narrator(model), author3);
		work2.addProperty(FRBR.hasAsSubjectConcept(model), concept1);
		work2.addProperty(FRBR.hasAsSubjectConcept(model), concept2);
		work2.addProperty(FRBR.hasAsSubjectPlace(model), place);
		expression2.addProperty(FRBR.manifestationOfExpression(model),
				manifestation2);
		manifestation2.addProperty(FRBR.publisher(model), publisher1);

		// complement

		work1.addProperty(FRBR.complementedByWork(model), work2);

	}

}
