package org.bibr.eval;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is the orchestrator of the whole evaluation process of 2 RDF
 * collection. The matching of elements is done in the Evaluator class/
 * @see Evaluator.class
 * @author Joffrey
 *
 */
public class Evaluation {

	private Evaluator initial;

	private Evaluator eval;

	public Evaluation() {
		super();
	}

	/**
	 * Main method that launch the whole process of evaluation for two RDF collections
	 * @param rcol
	 * @param rexp
	 * @param pathMapping
	 * @param replacements
	 */
	public void process(RDFRequest rcol, RDFRequest rexp, String pathMapping,
			Map<String, Map<String, String>> replacements) {

		// First round evaluate expertise with itself to detect the components
		// to check
		initial = new Evaluator(new HashMap<String, Map<String, String>>());
		initial.readMappings(pathMapping);
		RDFReader initRdfExp1 = initial.initializeCollection(rexp);
		RDFReader initRdfExp2 = initial.initializeCollection(rexp);
		initial.evaluate(initRdfExp1, initRdfExp2, false);

		// Second round for the true evaluation with input collection
		eval = new Evaluator(replacements);
		eval.readMappings(pathMapping);
		RDFReader rdfExp = eval.initializeCollection(rexp);
		RDFReader rdfColl = eval.initializeCollection(rcol);
		eval.evaluate(rdfColl, rdfExp, true);

	}

}
