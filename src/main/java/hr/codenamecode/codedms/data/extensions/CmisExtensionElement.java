package hr.codenamecode.codedms.data.extensions;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class CmisExtensionElement {

    @Getter
    private final String name;
    @Getter
    private final String namespace;
    @Getter
    private final String value;
    private final List<CmisExtensionElement> children;
    private final Map<String, String> attributes;

    /**
     * Constructor for a leaf.
     */
    public CmisExtensionElement(String namespace, String name, Map<String, String> attributes, String value) {
        if (name == null) {
            throw new IllegalArgumentException("Name must set");
        }

        this.name = name;
        this.namespace = namespace;
        this.value = value;
        children = null;

        if (attributes != null) {
            this.attributes = Map.copyOf(attributes);
        } else {
            this.attributes = null;
        }
    }

    /**
     * Constructor for a node.
     */
    public CmisExtensionElement(String namespace, String name, Map<String, String> attributes,
                                List<CmisExtensionElement> children) {
        if (name == null) {
            throw new IllegalArgumentException("Name must set");
        }

        this.name = name;
        this.namespace = namespace;
        this.value = null;

        if (children != null) {
            this.children = List.copyOf(children);
        } else {
            this.children = null;
        }

        if (attributes != null) {
            this.attributes = Map.copyOf(attributes);
        } else {
            this.attributes = null;
        }
    }

    public List<CmisExtensionElement> getChildren() {
        if (children == null) {
            return Collections.emptyList();
        }

        return children;
    }

    public Map<String, String> getAttributes() {
        if (attributes == null) {
            return Collections.emptyMap();
        }

        return attributes;
    }

    public String toTreeString(int level) {
        StringBuilder sb = new StringBuilder(512);
        nextTreeLevel(sb, level);
        return sb.toString();
    }

    private void nextTreeLevel(StringBuilder sb, int level) {
        sb.append("  ".repeat(Math.max(0, level)));

        sb.append(namespace == null ? "" : "{" + namespace + "}").append(name).append(" ").append(attributes == null
                        ?
                        "[]" :
                        attributes)
                .append(": ");

        if (children == null || children.isEmpty()) {
            sb.append(value);
            sb.append('\n');
        } else {
            sb.append('\n');
            for (CmisExtensionElement element : children) {
                sb.append(element.toTreeString(level + 1));
            }
        }
    }
}