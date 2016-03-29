package org.bibr.der;

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

public class FRBRizationDer_3_8 {

	private Model model;
	
	@Before
	public void setUp() throws Exception{
		model = ModelFactory.createDefaultModel();
		FRBR.initializeModel(model);
	}
	
	@Test
	public void launch() throws Exception{
		chevalDeGuerre();
		ileAuTresor();
		aventuresTomSawyer();
		sourisEtHommes();
		harryPotterDeathlyHallows();
		strangeCaseOfDrJekyllAndMrHyde();
		lesMiserables();
		valerianEtLaureline();
		
		
	}
	
	@After
	public void tearDown() throws Exception{
		String path = Util.path+"/3_Derivation/3.8/der-missing-relator-code-frbr.xml";
		Writer w1 = new FileWriter(path);
		w1.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		w1.close();
		Writer w2 = new FileWriter(path,true);
		model.write(w2, "RDF/XML");
		w2.close();
	}

	/**
	 * Cheval de guerre
	 * @throws Exception
	 */
	public void chevalDeGuerre() {
		
		// Original Work
		Resource work = FRBR.work(model,"WarHorse");
		work.addProperty(FRBR.titleOfTheWork(model), "War horse");
		
		// Expression
		Resource expression = FRBR.expression(model,"WarHorseOriginal");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Translation
		Resource translation = FRBR.expression(model,"WarHorseTranslated");
		translation.addProperty(FRBR.languageOfExpression(model), "French");
		translation.addProperty(FRBR.hasTitleOfTheExpression(model), "Cheval de guerre");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9782070558902");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-2-07-055890-2");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Cheval de guerre");
		manifestation.addProperty(FRBR.dimensions(model), "22 cm");
		manifestation.addProperty(FRBR.extent(model), "185 pages");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Illustrations, cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "14 euro");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2005");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Cheval de guerre");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Michael Morpurgo; Andre Dupuis");
		
		// Person
		Resource creator = FRBR.person(model,"MichaelMorpurgo");
		creator.addProperty(FRBR.identifierForThePerson(model), "pauth-001");
		creator.addProperty(FRBR.nameOfThePerson(model), "Michael Morpurgo");
		
		// Translator
		Resource translator = FRBR.person(model,"AndreDupuis");
		translator.addProperty(FRBR.identifierForThePerson(model), "pauth-052");
		translator.addProperty(FRBR.nameOfThePerson(model), "Andre Dupuis");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Gallimard");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Gallimard");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.expressionOfWork(model), translation);
		work.addProperty(FRBR.creator(model), creator);
		expression.addProperty(FRBR.translatedAs(model), translation);
		translation.addProperty(FRBR.translator(model), translator);
		translation.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);
	}
	
	/**
	 * Ile au tresor (L')
	 * @throws Exception
	 */
	public void ileAuTresor() {
		
		// Original Work
		Resource work = FRBR.work(model,"TreasureIsland");
		work.addProperty(FRBR.titleOfTheWork(model), "Treasure Island");
		
		// Expression
		Resource expression = FRBR.expression(model,"TreasureIslandOriginal");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Translation
		Resource translation = FRBR.expression(model,"TreasureIslandTranslated");
		translation.addProperty(FRBR.languageOfExpression(model), "French");
		translation.addProperty(FRBR.hasTitleOfTheExpression(model), "Ile au tresor (L')");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9782013223973");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "9782-01-322397-3");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Ile au tresor (L')");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.extent(model), "248 pages");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "4.50 euro");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2010");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Ile au tresor (L')");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Robert Louis Stevenson; Michel Laporte");
		
		// Person
		Resource creator = FRBR.person(model,"RobertLouisStevenson");
		creator.addProperty(FRBR.identifierForThePerson(model), "pauth-003");
		creator.addProperty(FRBR.nameOfThePerson(model), "Robert Louis Stevenson");
		
		// Translator
		Resource translator = FRBR.person(model,"MichelLaporte");
		translator.addProperty(FRBR.identifierForThePerson(model), "pauth-053");
		translator.addProperty(FRBR.nameOfThePerson(model), "Michel Laporte");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Hachette");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Hachette");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.expressionOfWork(model), translation);
		work.addProperty(FRBR.creator(model), creator);
		expression.addProperty(FRBR.translatedAs(model), translation);
		translation.addProperty(FRBR.translator(model), translator);
		translation.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);
	}
	
	
	/**
	 * Aventures de Tom Sawyer (Les)
	 * @throws Exception
	 */
	public void aventuresTomSawyer() {
		
		// Original Work
		Resource work = FRBR.work(model,"AdventuresTomSawyer");
		work.addProperty(FRBR.titleOfTheWork(model), "The Adventures of Tom Sawyer");
		
		// Expression
		Resource expression = FRBR.expression(model,"AdventuresTomSawyerOriginal");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
		// Translation
		Resource translation = FRBR.expression(model,"AdventuresTomSawyerTranslated");
		translation.addProperty(FRBR.languageOfExpression(model), "French");
		translation.addProperty(FRBR.summarizationOfTheContent(model), "Tom n'aime rien tant que l'ecole buissonniere...");
		translation.addProperty(FRBR.hasTitleOfTheExpression(model), "aventures de Tom Sawyer (Les)");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book9782013226554");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "978-2-01-322655-4");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "aventures de Tom Sawyer (Les)");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.extent(model), "411 pages");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "5,90 EUR");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "2008");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "aventures de Tom Sawyer (Les)");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Mark Twain; P. F. Caille; Y. Dubois-Mauvais");
		
		// Person
		Resource creator = FRBR.person(model,"MarkTwain");
		creator.addProperty(FRBR.identifierForThePerson(model), "pauth-002");
		creator.addProperty(FRBR.nameOfThePerson(model), "Mark Twain");
		
		// Translator 1
		Resource translator1 = FRBR.person(model,"PierreFrancoisCaille");
		translator1.addProperty(FRBR.identifierForThePerson(model), "pauth-030");
		translator1.addProperty(FRBR.nameOfThePerson(model), "Pierre-Francois Caille");
		translator1.addProperty(FRBR.nameOfThePerson(model), "Caille, Pierre-Francois");
		
		// Translator 2
		Resource translator2 = FRBR.person(model,"DuboisMauvaisY");
		translator2.addProperty(FRBR.identifierForThePerson(model), "pauth-029");
		translator2.addProperty(FRBR.nameOfThePerson(model), "Dubois-Mauvais Y.");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Hachette");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Hachette");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.expressionOfWork(model), translation);
		work.addProperty(FRBR.creator(model), creator);
		expression.addProperty(FRBR.translatedAs(model), translation);
		translation.addProperty(FRBR.translator(model), translator1);
		translation.addProperty(FRBR.translator(model), translator2);
		translation.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);
	}
	

	/**
	 * Des souris et des hommes
	 * @throws Exception
	 */
	public void sourisEtHommes() {
		
		// Original Work
		Resource work = FRBR.work(model,"OfMiceAndMen");
		work.addProperty(FRBR.titleOfTheWork(model), "Of Mice and men");
		
		// Expression
		Resource expression = FRBR.expression(model,"OfMiceAndMenOriginal");
		
		// Translation
		Resource translation = FRBR.expression(model,"OfMiceAndMenTranslated");
		translation.addProperty(FRBR.languageOfExpression(model), "French");
		translation.addProperty(FRBR.hasTitleOfTheExpression(model), "Des souris et des hommes");
		
		// Manifestation
		Resource manifestation = FRBR.manifestation(model,"Book2070360377");
		manifestation.addProperty(FRBR.identifierForTheManifestation(model), "2-07-036037-7");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Des souris et des hommes");
		manifestation.addProperty(FRBR.dimensions(model), "18 cm");
		manifestation.addProperty(FRBR.extent(model), "189 pages");
		manifestation.addProperty(FRBR.noteOnCarrier(model), "Cover with colorful illustrations");
		manifestation.addProperty(FRBR.termsOfAvailability(model), "39,00 F");
		manifestation.addProperty(FRBR.placeOfPublication(model), "Paris");
		manifestation.addProperty(FRBR.dateOfPublication(model), "1992");
		manifestation.addProperty(FRBR.titleOfTheManifestation(model), "Des souris et des hommes");
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "John Steinbeck; M.E. Coindreau");
		
		// Person
		Resource creator = FRBR.person(model,"JohnSteinbeck");
		creator.addProperty(FRBR.identifierForThePerson(model), "pauth-016");
		creator.addProperty(FRBR.nameOfThePerson(model), "John Steinbeck");
		
		// Translator
		Resource translator = FRBR.person(model,"MECoindreau");
		translator.addProperty(FRBR.identifierForThePerson(model), "pauth-054");
		translator.addProperty(FRBR.nameOfThePerson(model), "M.E. Coindreau");
		
		// Corporate
		Resource publisher = FRBR.corporate(model,"Gallimard");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Gallimard");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.expressionOfWork(model), translation);
		work.addProperty(FRBR.creator(model), creator);
		expression.addProperty(FRBR.translatedAs(model), translation);
		translation.addProperty(FRBR.translator(model), translator);
		translation.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);
	}
	
	
	
	/**
	 * Harry Potter and the Deathly Hallows
	 * @throws Exception
	 */
	public void harryPotterDeathlyHallows() {
		
		// Author
		Resource author = FRBR.person(model,"JKRowling");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-014");
		author.addProperty(FRBR.nameOfThePerson(model), "J.K. Rowling");
		author.addProperty(FRBR.nameOfThePerson(model), "Rowling, Joanne Kathleen");
		author.addProperty(FRBR.nameOfThePerson(model), "Joanne Kathleen Rowling");
		author.addProperty(FRBR.dateAssociatedWithThePerson(model), "1965-....");
		
		// Director
		Resource dir = FRBR.person(model,"DavidYates");
		dir.addProperty(FRBR.identifierForThePerson(model), "pauth-033");
		dir.addProperty(FRBR.nameOfThePerson(model), "David Yates");
		
		// Actor 1
		Resource act1 = FRBR.person(model,"DanielRadcliffe");
		act1.addProperty(FRBR.identifierForThePerson(model), "pauth-036");
		act1.addProperty(FRBR.nameOfThePerson(model), "Daniel Radcliffe");
		
		// Actor 2
		Resource act2 = FRBR.person(model,"EmmaWatson");
		act2.addProperty(FRBR.identifierForThePerson(model), "pauth-037");
		act2.addProperty(FRBR.nameOfThePerson(model), "Emma Watson");
		
		// Corporate1
		Resource publisher1 = FRBR.corporate(model,"Bloomsbury");
		publisher1.addProperty(FRBR.nameOfTheCorporateBody(model), "Bloomsbury");
		
		// Corporate2
		Resource publisher2 = FRBR.corporate(model,"WarnerHomeVideo");
		publisher2.addProperty(FRBR.nameOfTheCorporateBody(model), "Warner Home Video");

		// Book
		Resource work = FRBR.work(model,"HarryPotterandtheDeathlyHallows");
		work.addProperty(FRBR.titleOfTheWork(model), "Harry Potter and the Deathly Hallows");
		
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
		manifestation.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "J.K. Rowling");

		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher1);
		
		// Film 1
		
		Resource film1 = FRBR.work(model,"WorkHarryPotter1DVD");
		work.addProperty(FRBR.titleOfTheWork(model), "Harry Potter and the Deathly Hallows");
		
		Resource expfilm = FRBR.expression(model,"HarryPotterandtheDeathlyHallowsFilm");
		
		Resource manifilm1 = FRBR.manifestation(model,"MP5051889060093");
		manifilm1.addProperty(FRBR.identifierForTheManifestation(model), "5051889060093");
		manifilm1.addProperty(FRBR.placeOfPublication(model), "Neuilly-sur-Seine");
		manifilm1.addProperty(FRBR.dateOfPublication(model), "2011");
		manifilm1.addProperty(FRBR.extent(model), "1 DVD (2 h 20 min)");
		manifilm1.addProperty(FRBR.noteOnCarrier(model), "Colors, Audio (PAL)");
		manifilm1.addProperty(FRBR.titleOfTheManifestation(model), "Harry Potter and the Deathly Hallows Part 1");
		manifilm1.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "David Yates; Daniel Radcliffe; Emma Watson");
		
		// Relationships
		film1.addProperty(FRBR.director(model), dir);
		film1.addProperty(FRBR.expressionOfWork(model), expfilm);
		expfilm.addProperty(FRBR.manifestationOfExpression(model), manifilm1);
		expfilm.addProperty(FRBR.actor(model), act1);
		expfilm.addProperty(FRBR.actor(model), act2);
		manifilm1.addProperty(FRBR.publisher(model), publisher2);
		
		// Film 2
		
		Resource film2 = FRBR.work(model,"WorkHarryPotter2DVD");
		work.addProperty(FRBR.titleOfTheWork(model), "Harry Potter and the Deathly Hallows");
		
		Resource manifilm2 = FRBR.manifestation(model,"MP5051889209546");
		manifilm2.addProperty(FRBR.identifierForTheManifestation(model), "5051889209546");
		manifilm2.addProperty(FRBR.placeOfPublication(model), "Neuilly-sur-Seine");
		manifilm2.addProperty(FRBR.dateOfPublication(model), "2011");
		manifilm2.addProperty(FRBR.extent(model), "1 DVD (2 h 05 min)");
		manifilm2.addProperty(FRBR.noteOnCarrier(model), "Colors, Audio (PAL)");
		manifilm2.addProperty(FRBR.titleOfTheManifestation(model), "Harry Potter and the Deathly Hallows Part 2");
		manifilm2.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "David Yates; Daniel Radcliffe; Emma Watson");
		
		film2.addProperty(FRBR.director(model), dir);
		film2.addProperty(FRBR.expressionOfWork(model), expfilm);
		expfilm.addProperty(FRBR.manifestationOfExpression(model), manifilm2);
		manifilm2.addProperty(FRBR.publisher(model), publisher2);
		
		// Adaptation
		work.addProperty(FRBR.adaptedAsMotionPictureWork(model),film1);
		work.addProperty(FRBR.adaptedAsMotionPictureWork(model),film2);

	}
	
	
	
	/**
	 * The strange case of Dr Jekyll and Mr Hyde
	 * @throws Exception
	 */
	public void strangeCaseOfDrJekyllAndMrHyde() {
		
		// Person
		Resource author = FRBR.person(model,"RobertLouisStevenson");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-003");
		author.addProperty(FRBR.nameOfThePerson(model), "Robert Louis Stevenson");

		// Book
		Resource work = FRBR.work(model,"strangecaseofDrJekyllMrHyde");
		work.addProperty(FRBR.titleOfTheWork(model), "The strange case of Dr Jekyll and Mr Hyde");
		
		Resource expression = FRBR.expression(model,"strangecaseofDrJekyllMrHydeTextEnglish");
		expression.addProperty(FRBR.languageOfExpression(model), "English");
		
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
		
		Resource publisher1 = FRBR.corporate(model,"PulpTheClassics");
		publisher1.addProperty(FRBR.nameOfTheCorporateBody(model), "Pulp! The Classics");
		
		// Relationships
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher1);
		
		// Comic
		Resource comic = FRBR.work(model,"DocteurJekyllMisterHyde");
		comic.addProperty(FRBR.titleOfTheWork(model), "Docteur Jekyll & Mister Hyde");
		
		Resource comicorigexp = FRBR.expression(model,"strangecaseofDrJekyllMrHydeTextItalian");
		comicorigexp.addProperty(FRBR.languageOfExpression(model), "Italian");
		
		Resource comictransexp = FRBR.expression(model,"strangecaseofDrJekyllMrHydeTextFrench");
		comictransexp.addProperty(FRBR.languageOfExpression(model), "French");

		Resource comictransmanif = FRBR.manifestation(model,"Book2203389885");
		comictransmanif.addProperty(FRBR.identifierForTheManifestation(model), "2-203-38988-5");
		comictransmanif.addProperty(FRBR.identifierForTheManifestation(model), "2203389885");
		comictransmanif.addProperty(FRBR.carrierType(model), "Graphic Novel");
		comictransmanif.addProperty(FRBR.dimensions(model), "32 cm");
		comictransmanif.addProperty(FRBR.noteOnCarrier(model), "Colorful illustrations");
		comictransmanif.addProperty(FRBR.extent(model), "64 pages");
		comictransmanif.addProperty(FRBR.placeOfPublication(model), "Paris");
		comictransmanif.addProperty(FRBR.dateOfPublication(model), "2002");
		comictransmanif.addProperty(FRBR.otherTitleInformation(model), "free adapatation from the book of Robert L. Stevenson");
		comictransmanif.addProperty(FRBR.titleOfTheManifestation(model), "Docteur Jekyll & Mister Hyde");
		
		Resource publisher2 = FRBR.corporate(model,"Casterman");
		publisher2.addProperty(FRBR.nameOfTheCorporateBody(model), "Casterman");
		
		Resource author1 = FRBR.person(model,"LorenzoMattotti");
		author1.addProperty(FRBR.identifierForThePerson(model), "pauth-031");
		author1.addProperty(FRBR.nameOfThePerson(model), "Lorenzo Mattottin");
		
		Resource author2 = FRBR.person(model,"JerryKramsky");
		author2.addProperty(FRBR.identifierForThePerson(model), "pauth-032");
		author2.addProperty(FRBR.nameOfThePerson(model), "Jerry Kramsky");
		
		Resource translator = FRBR.person(model,"MarcVoline");
		translator.addProperty(FRBR.identifierForThePerson(model), "pauth-060");
		translator.addProperty(FRBR.nameOfThePerson(model), "Marc Voline");
		
		// Relationships
		comic.addProperty(FRBR.expressionOfWork(model), comicorigexp);
		comic.addProperty(FRBR.expressionOfWork(model), comictransexp);
		comic.addProperty(FRBR.creator(model), author1);
		comic.addProperty(FRBR.creator(model), author2);
		
		comicorigexp.addProperty(FRBR.translatedAs(model), comictransexp);
		comictransexp.addProperty(FRBR.translator(model), translator);
		comictransexp.addProperty(FRBR.manifestationOfExpression(model), comictransmanif);
	
		comictransmanif.addProperty(FRBR.publisher(model), publisher2);
		
		// Adaptation
		work.addProperty(FRBR.adaptedAsGraphicNovelWork(model),comic);

	}
	
	
	/**
	 * Les Miserables
	 */
	public void lesMiserables() {
		
		// Film
		Resource film = FRBR.work(model,"LesMiserablesFilm");
		film.addProperty(FRBR.titleOfTheWork(model), "Les miserables");
		
		Resource award = FRBR.event(model, "GoldenGlobe2012");
		award.addProperty(FRBR.hasTermForTheEvent(model), "Best comedy at Golden Globe");
		award.addProperty(FRBR.hasTermForTheEvent(model), "2012");
		award.addProperty(FRBR.hasTermForTheEvent(model), "United States");
		
		Resource expfilm = FRBR.expression(model,"LesMiserablesFilm");
		
		Resource dir = FRBR.person(model,"TimHooper");
		dir.addProperty(FRBR.identifierForThePerson(model), "pauth-038");
		dir.addProperty(FRBR.nameOfThePerson(model), "Tim Hooper");
		
		Resource act1 = FRBR.person(model,"HughJackman");
		act1.addProperty(FRBR.identifierForThePerson(model), "pauth-041");
		act1.addProperty(FRBR.nameOfThePerson(model), "Hugh Jackman");
		
		Resource act2 = FRBR.person(model,"RussellCrowe");
		act2.addProperty(FRBR.identifierForThePerson(model), "pauth-042");
		act2.addProperty(FRBR.nameOfThePerson(model), "Russell Crowe");
		
		Resource publisher1 = FRBR.corporate(model,"Universal");
		publisher1.addProperty(FRBR.nameOfTheCorporateBody(model), "Universal");
		
		Resource manifilm1 = FRBR.manifestation(model,"MP5050582942156");
		manifilm1.addProperty(FRBR.identifierForTheManifestation(model), "5050582942156");
		manifilm1.addProperty(FRBR.carrierType(model), "Motion Picture");
		manifilm1.addProperty(FRBR.placeOfPublication(model), "Universal city");
		manifilm1.addProperty(FRBR.dateOfPublication(model), "2013");
		manifilm1.addProperty(FRBR.extent(model), "1 DVD monoface area 2 (2 h 31 min)");
		manifilm1.addProperty(FRBR.noteOnCarrier(model), "Colors (PAL), audio");
		manifilm1.addProperty(FRBR.titleOfTheManifestation(model), "Les miserables");
		manifilm1.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Tom Hooper; Victor Hugo; Hugh Jackman; Russell Crowe");
		
		film.addProperty(FRBR.director(model), dir);
		film.addProperty(FRBR.expressionOfWork(model), expfilm);
		expfilm.addProperty(FRBR.manifestationOfExpression(model), manifilm1);
		expfilm.addProperty(FRBR.award(model), award);
		expfilm.addProperty(FRBR.actor(model), act1);
		expfilm.addProperty(FRBR.actor(model), act2);
		manifilm1.addProperty(FRBR.publisher(model), publisher1);
		

		// Manga
		Resource manga = FRBR.work(model,"LesMiserablesManga");
		manga.addProperty(FRBR.titleOfTheWork(model), "miserables (Les )");
		
		Resource mangaexp = FRBR.expression(model,"LesMiserablesMangaFrench");
		mangaexp.addProperty(FRBR.languageOfExpression(model), "French");

		Resource mangamanif = FRBR.manifestation(model,"Book9782302013773");
		mangamanif.addProperty(FRBR.identifierForTheManifestation(model), "9782302013773");
		mangamanif.addProperty(FRBR.carrierType(model), "Manga");
		mangamanif.addProperty(FRBR.dimensions(model), "19 cm");
		mangamanif.addProperty(FRBR.termsOfAvailability(model),"6,95 euro");
		mangamanif.addProperty(FRBR.noteOnCarrier(model), "Illustrations, Cover with illustration");
		mangamanif.addProperty(FRBR.extent(model), "Not paged");
		mangamanif.addProperty(FRBR.placeOfPublication(model), "Paris");
		mangamanif.addProperty(FRBR.dateOfPublication(model), "2011");
		mangamanif.addProperty(FRBR.titleOfTheManifestation(model), "miserables (Les )");
		mangamanif.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "based on writting by Victor Hugo; adapted in manga by studio Variety artworks");
		
		Resource publisher2 = FRBR.corporate(model,"Soleil");
		publisher2.addProperty(FRBR.nameOfTheCorporateBody(model), "Soleil");
		
		Resource cauth = FRBR.corporate(model,"StudioVarietyArtwork");
		cauth.addProperty(FRBR.nameOfTheCorporateBody(model), "Studio Variety Artwork");
		cauth.addProperty(FRBR.identifierForTheCorporateBody(model), "cauth-018");
		
		manga.addProperty(FRBR.creator(model), cauth);
		manga.addProperty(FRBR.expressionOfWork(model), mangaexp);
		expfilm.addProperty(FRBR.manifestationOfExpression(model), mangamanif);
		mangamanif.addProperty(FRBR.publisher(model), publisher2);
		
		// Original
		Resource author = FRBR.person(model,"VictorHugo");
		author.addProperty(FRBR.identifierForThePerson(model), "pauth-039");
		author.addProperty(FRBR.nameOfThePerson(model), "Victor Hugo");

		Resource work = FRBR.work(model,"LesmiserablesOrig");
		work.addProperty(FRBR.titleOfTheWork(model), "Les miserables");
		work.addProperty(FRBR.titleOfTheWork(model), "miserables (Les )");
		
		work.addProperty(FRBR.creator(model), author);
		
		work.addProperty(FRBR.adaptedAsGraphicNovelWork(model), manga);
		work.addProperty(FRBR.adaptedAsMotionPictureWork(model), film);
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
		
		Resource author1 = FRBR.person(model,"PierreChristin");
		author1.addProperty(FRBR.identifierForThePerson(model), "pauth-020");
		author1.addProperty(FRBR.nameOfThePerson(model), "Pierre Christin");
		
		Resource author2 = FRBR.person(model,"JeanClaudeMezieres");
		author2.addProperty(FRBR.identifierForThePerson(model), "pauth-021");
		author2.addProperty(FRBR.nameOfThePerson(model), "Jean-Claude Mezieres");
		
		Resource publisher = FRBR.corporate(model,"Dargaud");
		publisher.addProperty(FRBR.nameOfTheCorporateBody(model), "Dargaud");
		
		work.addProperty(FRBR.expressionOfWork(model), expression);
		work.addProperty(FRBR.creator(model), author1);
		work.addProperty(FRBR.creator(model), author2);
		expression.addProperty(FRBR.manifestationOfExpression(model), manifestation);
		manifestation.addProperty(FRBR.publisher(model), publisher);
		
		
		// Parody
		Resource comic = FRBR.work(model,"ArmureduJakolass");
		comic.addProperty(FRBR.titleOfTheWork(model), "Armure du Jakolass (L')");
		
		Resource comicexp = FRBR.expression(model,"ArmureduJakolassTextFrench");
		comicexp.addProperty(FRBR.languageOfExpression(model), "French");
		comicexp.addProperty(FRBR.noteOnExpression(model), "In this album, the author manages to parody the cult series without dishonoring it.");

		Resource comicmanif = FRBR.manifestation(model,"Comic9782205067583");
		comicmanif.addProperty(FRBR.identifierForTheManifestation(model), "978-2-205-06758-3");
		comicmanif.addProperty(FRBR.identifierForTheManifestation(model), "9782205067583");
		comicmanif.addProperty(FRBR.carrierType(model), "Graphic Novel");
		comicmanif.addProperty(FRBR.placeOfPublication(model), "Paris");
		comicmanif.addProperty(FRBR.dateOfPublication(model), "2011");
		comicmanif.addProperty(FRBR.otherTitleInformation(model), "Valerian par Manu Larcenet");
		comicmanif.addProperty(FRBR.titleOfTheManifestation(model), "Armure du Jakolass (L')");
		comicmanif.addProperty(FRBR.statementOfResponsibilityRelatingToTitleProper(model), "Manu Larcenet; from Christin et Mezieres");
		
		Resource publisher2 = FRBR.corporate(model,"Dargaud");
		publisher2.addProperty(FRBR.nameOfTheCorporateBody(model), "Dargaud");
		
		Resource adapter = FRBR.person(model,"ManuLarcenet");
		adapter.addProperty(FRBR.identifierForThePerson(model), "pauth-043");
		adapter.addProperty(FRBR.nameOfThePerson(model), "Manu Larcenet");
		
		// Relationships
		comic.addProperty(FRBR.expressionOfWork(model), comicexp);
		comic.addProperty(FRBR.creator(model), adapter);
		comicexp.addProperty(FRBR.manifestationOfExpression(model), comicmanif);
		comicmanif.addProperty(FRBR.publisher(model), publisher2);
		
		// Adaptation
		work.addProperty(FRBR.adaptedAsGraphicNovelWork(model),comic);
		work.addProperty(FRBR.parodyOfWork(model),comic);
	}
	

}




