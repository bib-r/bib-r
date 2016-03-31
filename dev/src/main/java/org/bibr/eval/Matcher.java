package org.bibr.eval;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Matcher {

	public static Boolean match(Entity e1, Entity e2) {

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
						if (!alreadyMatches.contains(s1) && s1.equals(s2)) {
							singleMatch++;
							alreadyMatches.add(s1);
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
			System.out.println("Not Match: " + e1.getType() + " "
					+ e2.getType());
			return false;
		}

	}

}
