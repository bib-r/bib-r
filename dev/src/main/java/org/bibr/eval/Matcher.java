package org.bibr.eval;

import info.debatty.java.stringsimilarity.JaroWinkler;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Used to perform a basic entity matching task for RDF extracted entities in
 * the FRBR context. Note that the algorithm was coded to quickly release an
 * example of FRBR RDF evaluation. It does not reflect any real entity matching
 * processes we may use for other purposes and it should not be considered as a
 * reference in any way whatsoever !
 * 
 * @author Joffrey
 *
 */
public class Matcher {

	public static Boolean match(Entity e1, Entity e2, JaroWinkler jaro,
			Map<String, Map<String, String>> replacements) {

		if (e1.getType().equals(e2.getType())) {

			Set<String> propToMatch = new HashSet<String>();
			
			// Keep only properties present in both entities
			for (String p : e1.getProperties().keySet()) {
				if (e2.getProperties().keySet().contains(p)) {
					propToMatch.add(p);
				}
			}

			
			
			// Matching
			Integer singleMatch = 0;
			for (Iterator<String> iterator = propToMatch.iterator(); iterator
					.hasNext();) {
				String prop = (String) iterator.next();
				List<String> vals1 = e1.getProperties().get(prop);
				List<String> vals2 = e2.getProperties().get(prop);
				Set<String> alreadyMatches = new HashSet<String>();

				Boolean loop = true;
				for (Iterator<String> iterator2 = vals1.iterator(); iterator2
						.hasNext();) {
					loop = true;
					String s1 = (String) iterator2.next();
					for (Iterator<String> iterator3 = vals2.iterator(); iterator3
							.hasNext();) {
						String s2 = (String) iterator3.next();

						// Application of specific replacements for the
						// collection
						if (replacements.containsKey(prop)) {
							for (Entry<String, String> entry : replacements
									.get(prop).entrySet()) {
								String regex = entry.getKey();
								String value = entry.getValue();
								s1 = s1.replaceAll(regex, value);
								s2 = s2.replaceAll(regex, value);

							}
						}

						Boolean match = false;

						if (isStringNumeric(s1) && isStringNumeric(s2)) {
							Long ls1 = Long.valueOf(s1.replaceAll("\\D+", ""));
							Long ls2 = Long.valueOf(s2.replaceAll("\\D+", ""));
							if (ls1.compareTo(ls2) == 0) {
								match = true;
							}
						} else {
							Double score = new Double(0);
							Double threashold = new Double(0.98);
							try {
								score = jaro.similarity(s1, s2);
							} catch (java.lang.NullPointerException e) {
								return false;
							}

							int retval = score.compareTo(threashold);
							if (retval >= 0) {
								// System.out.println("Match Text: "+s1+" - "+s2);
								match = true;
							}
						}
						
						if(match){
							e1.getPropMatched().add(prop);
							e2.getPropMatched().add(prop);
							if (!alreadyMatches.contains(s1)) {
								singleMatch++;
								alreadyMatches.add(s1);
							}
							loop = false;
							break;
						}
					}
					if (!loop) {
						break;
					}

				}

			}

			if ((propToMatch.size() > 1 && singleMatch >= propToMatch.size() / 2)
					|| (propToMatch.size() > 0 && singleMatch >= propToMatch
							.size())) {

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}

	public static boolean isStringNumeric(String str) {
		Integer toleratedErrors = (str.length() * 25) / 100;
		Integer errorCount = 0;

		for (char c : str.toCharArray()) {
			if (!Character.isDigit(c)) {
				if (errorCount >= toleratedErrors) {
					return false;
				} else {
					errorCount++;
				}
			}
		}

		return true;
	}

}
