package hr.codenamecode.codedms.data.extensions;

import java.util.Map;

public final class ExtensionFeatures {
    
    public static final ExtensionFeature EXTENDED_DATETIME_FORMAT = new ExtensionFeature() {
        @Override
        public String getId() {
            return "http://docs.oasis-open.org/ns/cmis/extension/datetimeformat";
        }
        
        @Override
        public String getUrl() {
            return "https://www.oasis-open.org/committees/tc_home.php?wg_abbrev=cmis";
        }
        
        @Override
        public String getCommonName() {
            return "Browser Binding DateTime Format";
        }
        
        @Override
        public String getVersionLabel() {
            return "1.0";
        }
        
        @Override
        public String getDescription() {
            return "Adds an additional DateTime format for the Browser Binding.";
        }
        
        @Override
        public Map<String, String> getFeatureData() {
            return null;
        }
    };
    
    public static final ExtensionFeature CONTENT_STREAM_HASH = new ExtensionFeature() {
        
        @Override
        public String getId() {
            return "http://docs.oasis-open.org/ns/cmis/extension/contentstreamhash";
        }
        
        @Override
        public String getUrl() {
            return "https://www.oasis-open.org/committees/tc_home.php?wg_abbrev=cmis";
        }
        
        @Override
        public String getCommonName() {
            return "Content Stream Hash";
        }
        
        @Override
        public String getVersionLabel() {
            return "1.0";
        }
        
        @Override
        public String getDescription() {
            return "Adds the property cmis:contentStreamHash, which represents the hash of the document content.";
        }
        
        @Override
        public Map<String, String> getFeatureData() {
            return null;
        }
    };
    
    public static final ExtensionFeature LATEST_ACCESSIBLE_STATE = new ExtensionFeature() {
        
        @Override
        public String getId() {
            return "http://docs.oasis-open.org/ns/cmis/extension/latestAccessibleState/1.1";
        }
        
        @Override
        public String getUrl() {
            return "https://www.oasis-open.org/committees/tc_home.php?wg_abbrev=cmis";
        }
        
        @Override
        public String getCommonName() {
            return "Latest Accessible State";
        }
        
        @Override
        public String getVersionLabel() {
            return "1.1";
        }
        
        @Override
        public String getDescription() {
            return "This extension provides for an identifier of each cmis:document that retrieves " + "the latest " +
                           "accessible state of the document whether the document is versioned or not.";
        }
        
        @Override
        public Map<String, String> getFeatureData() {
            return null;
        }
        
    };
}