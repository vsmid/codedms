package hr.codenamecode.codedms.http.json.serializers;

import hr.codenamecode.codedms.data.enums.Cardinality;
import hr.codenamecode.codedms.data.objects.*;
import jakarta.inject.Inject;
import jakarta.inject.Provider;
import jakarta.json.bind.serializer.JsonbSerializer;
import jakarta.json.bind.serializer.SerializationContext;
import jakarta.json.stream.JsonGenerator;
import jakarta.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.function.Supplier;

public class ObjectDataSerializer implements JsonbSerializer<ObjectData> {

    private final Supplier<Boolean> succinct;

    @Inject
    public ObjectDataSerializer(Provider<HttpServletRequest> request) {
        this.succinct = () -> request != null && Boolean.parseBoolean(request.get().getParameter("succinct"));
    }

    public ObjectDataSerializer(boolean succinct) {
        this.succinct = () -> succinct;
    }

    @Override
    public void serialize(ObjectData obj, JsonGenerator gen, SerializationContext ctx) {
        gen.writeStartObject();

        if (obj.getAcl() != null) {
            ctx.serialize("acl", obj.getAcl(), gen);
        }

        if (obj.getRelationships() != null) {
            ctx.serialize("relationships", obj.getRelationships(), gen);
        }

        if (obj.getRenditions() != null) {
            ctx.serialize("renditions", obj.getRenditions(), gen);
        }

        if (obj.getChangeEventInfo() != null) {
            ctx.serialize("changeEventInfo", obj.getChangeEventInfo(), gen);
        }

        if (obj.getExactACL() != null) {
            gen.write("exactACL", obj.getExactACL());
        }

        if (succinct.get()) {
            gen.writeKey("succinctProperties");
        } else {
            gen.writeKey("properties");
        }

        JsonGenerator props = gen.writeStartObject();

        for (Map.Entry<String, PropertyData<?>> entry : obj.getProperties().entrySet()) {
            if (succinct.get()) {
                props.writeKey(entry.getKey());
                writeValues(entry.getKey(), entry.getValue(), props);
            } else {
                props.writeKey(entry.getKey());
                JsonGenerator propDef = props.writeStartObject();
                PropertyData<?> value = entry.getValue();
                propDef.write("id", value.getId());
                if (value.getLocalName() != null) {
                    propDef.write("localName", value.getLocalName());
                }
                if (value.getDisplayName() != null) {
                    propDef.write("displayName", value.getDisplayName());
                }
                if (value.getQueryName() != null) {
                    propDef.write("queryName", value.getQueryName());
                }
                propDef.write("cardinality", value.getPropertyDefinition().getCardinality().value());
                propDef.write("type", value.getPropertyDefinition().getPropertyType().value());
                propDef.writeKey("value");
                writeValues("value", value, propDef);
                propDef.writeEnd();
            }
        }

        props.writeEnd();
        gen.writeEnd();
    }

    private void writeValues(String name, PropertyData<?> data, JsonGenerator gen) {
        if (data.getValue().isEmpty()) {
            gen.writeNull();
            return;
        }

        if (Cardinality.MULTI == data.getPropertyDefinition().getCardinality()) {
            gen.writeStartArray();
        }

        switch (data) {
            case StringPropertyData str -> {
                for (String strValue : str.getValue()) {
                    gen.write(strValue);
                }
            }
            case IdPropertyData id -> {
                for (String strValue : id.getValue()) {
                    gen.write(strValue);
                }
            }
            case HtmlPropertyData html -> {
                for (String strValue : html.getValue()) {
                    gen.write(strValue);
                }
            }
            case UriPropertyData uri -> {
                for (String strValue : uri.getValue()) {
                    gen.write(strValue);
                }
            }
            case BooleanPropertyData b -> {
                for (Boolean bValue : b.getValue()) {
                    gen.write(bValue);
                }
            }
            case IntegerPropertyData i -> {
                for (BigInteger binValue : i.getValue()) {
                    gen.write(binValue);
                }
            }
            case DecimalPropertyData d -> {
                for (BigDecimal bdValue : d.getValue()) {
                    gen.write(bdValue);
                }
            }
            case DateTimePropertyData dt -> {
                for (OffsetDateTime ostValue : dt.getValue()) {
                    gen.write(ostValue.format(DateTimeFormatter.ISO_DATE_TIME));
                }
            }
            default -> throw new IllegalStateException("Unexpected value: " + data);
        }

        if (data.getPropertyDefinition().getCardinality() == Cardinality.MULTI) {
            gen.writeEnd();
        }
    }

}
