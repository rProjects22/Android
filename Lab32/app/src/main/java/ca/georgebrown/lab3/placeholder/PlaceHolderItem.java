package ca.georgebrown.lab3.placeholder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PlaceHolderItem {

    /**
     * An array of sample (placeholder) items.
     */
    public static final List<Movie> ITEMS = new ArrayList<Movie>();

    /**
     * A map of sample (placeholder) items, by ID.
     */
    public static final Map<String, Movie> ITEM_MAP = new HashMap<String, Movie>();

    private static final int COUNT = 5;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createPlaceHolderItem(i));
        }
    }

    private static void addItem(Movie item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static Movie createPlaceHolderItem(int position) {
        return new Movie(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    /**
     * A placeholder item representing a piece of content.
     */
    public static class Movie {
        public final String id;
        public final String content;
        public final String details;

        public Movie(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}