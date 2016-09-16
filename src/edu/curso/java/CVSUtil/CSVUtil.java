package edu.curso.java.CVSUtil;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.asm.ClassWriter;

public class CSVUtil {
	 private static final char DEFAULT_SEPARATOR = ',';

	    public static void writeLine(Writer w, List<String> values) throws IOException {
	        writeLine(w, values, DEFAULT_SEPARATOR, ' ');
	    }

	    public static void writeLine(Writer w, List<String> values, char separators) throws IOException {
	        writeLine(w, values, separators, ' ');
	    }

	    //https://tools.ietf.org/html/rfc4180
	    private static String followCVSformat(String value) {

	        String result = value;
	        if (result.contains("\"")) {
	            result = result.replace("\"", "\"\"");
	        }
	        return result;

	    }
	    
	    public static void writeLine(Writer w, List<String> values, char separators, char customQuote) throws IOException {

	        boolean first = true;

	        //default customQuote is empty

	        if (separators == ' ') {
	            separators = DEFAULT_SEPARATOR;
	        }

	        for (String value : values) {
	            if (!first) {
	                w.append(separators);
	            }
	            if (customQuote == ' ') {
	                w.append(followCVSformat(value));
	            } else {
	                w.append(customQuote).append(followCVSformat(value)).append(customQuote);
	            }

	            first = false;
	        }
	        w.append("\n");

	    }
}
