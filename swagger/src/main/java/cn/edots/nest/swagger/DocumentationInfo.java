package cn.edots.nest.swagger;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;

import java.util.ArrayList;

public class DocumentationInfo extends ApiInfo {

    public DocumentationInfo(String title, String description, String version) {
        super(title, description, version, "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
    }

    public DocumentationInfo(String title, String description, String version, String termsOfServiceUrl, String license, String licenseUrl) {
        super(title, description, version, termsOfServiceUrl, DEFAULT_CONTACT, license, licenseUrl, new ArrayList<VendorExtension>());
    }
}
