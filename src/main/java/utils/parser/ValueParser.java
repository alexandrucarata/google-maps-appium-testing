package utils.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueParser {
    public static int parseDuration(String duration) {
        // Match given duration to pattern to identify any values for days, hours or minutes
        Pattern pattern = Pattern.compile("(?:(\\d+)\\s*d)?\\s*(?:(\\d+)\\s*hr)?\\s*(?:(\\d+)\\s*min)?");
        Matcher matcher = pattern.matcher(duration);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid duration format: " + duration);
        }

        int days = matcher.group(1) != null ? Integer.parseInt(matcher.group(1)) : 0;
        int hours = matcher.group(2) != null ? Integer.parseInt(matcher.group(2)) : 0;
        int minutes = matcher.group(3) != null ? Integer.parseInt(matcher.group(3)) : 0;

        return days * 24 * 60 + hours * 60 + minutes; // Calculate duration in minutes
    }

    public static double parseDistance(String distance) {
        // Remove commas, spaces, braces, and other whitespace characters
        String distanceValue = distance.replaceAll("[,\\s()\\p{Z}]", "");
        double multiplier = 1.0; // Default multiplier for miles (assuming the distance is in miles)

        if (distanceValue.endsWith("km")) {
            multiplier = 1.60934; // Set the multiplier for kilometers
            distanceValue = distanceValue.replace("km", "");
        } else if (distanceValue.endsWith("m")) {
            multiplier = 0.001; // Set the multiplier for meters
            distanceValue = distanceValue.replace("m", "");
        } else if (distanceValue.endsWith("mi")) {
            distanceValue = distanceValue.replace("mi", "");
        } else {
            throw new IllegalArgumentException("Invalid distance unit. Supported units are mi, km, and m.");
        }

        return Double.parseDouble(distanceValue) * multiplier;
    }
}
