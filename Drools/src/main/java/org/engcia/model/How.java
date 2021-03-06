package org.engcia.model;

import java.util.Map;

public class How {
    private final Map<Integer, Justification> justifications;

    public How(Map<Integer, Justification> justifications) {
        this.justifications = justifications;
    }

    public String getHowExplanation(Integer factNumber) {
        return (getHowExplanation(factNumber, 0));
    }

    private String getHowExplanation(Integer factNumber, int level) {
        StringBuilder sb = new StringBuilder();
        Justification j = justifications.get(factNumber);
        if (j != null) { // justification for Fact factNumber was found
            sb.append(getIndentation(level));
            sb.append(j.getConclusion()).append(" was obtained because");
            sb.append('\n');
            sb.append(j.getConclusion().getList());
            sb.append('\n');
            int l = level + 1;
            for (Fact f : j.getLhs()) {
                sb.append(getIndentation(l));
                sb.append(f.toString());
                sb.append('\n');
                if (f instanceof Conclusion) {
                    String s = getHowExplanation(f.getId(), l + 1);
                    sb.append(s);
                }
            }
            sb.append("Suggested Correction: ").append(j.getConclusion().getCorrection());
        }

        return sb.toString();
    }

    private String getIndentation(int level) {
        return "\t".repeat(Math.max(0, level));
    }
}
