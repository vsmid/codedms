package hr.codenamecode.codedms.http.control;

import jakarta.servlet.http.Part;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MultipartControlParser extends ControlParser {

    public MultipartControlParser(List<Part> parts) {
        super(null);
        getParameterMap().putAll(toParameterMap(parts));
        if (!parts.isEmpty()) {
            parse();
        }
    }

    private Map<String, String[]> toParameterMap(Collection<Part> parts) {
        Map<String, List<String>> tempMap = new LinkedHashMap<>();

        for (Part part : parts) {
            if ("content".equals(part.getName())) {
                continue;
            }

            String value;
            try (var in = part.getInputStream()) {
                value = new String(in.readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException("failed to read multipart field: " + part.getName(), e);
            }

            tempMap.computeIfAbsent(part.getName(), k -> new ArrayList<>(1)).add(value);
        }

        Map<String, String[]> parameterMap = new LinkedHashMap<>(tempMap.size());
        for (Map.Entry<String, List<String>> entry : tempMap.entrySet()) {
            List<String> values = entry.getValue();
            parameterMap.put(entry.getKey(), values.toArray(new String[0]));
        }

        return parameterMap;
    }


}