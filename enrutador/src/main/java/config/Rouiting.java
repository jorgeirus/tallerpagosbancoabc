package config;

public class Rouiting {

    private String idConvenio;
    private String endpoint;
    private String typeService;
    
    
	public Rouiting(String idConvenio, String endpoint, String typeService) {
		super();
		this.idConvenio = idConvenio;
		this.endpoint = endpoint;
		this.typeService = typeService;
	}
	
	
	
	public String getIdConvenio() {
		return idConvenio;
	}
	public void setIdConvenio(String idConvenio) {
		this.idConvenio = idConvenio;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	public String getTypeService() {
		return typeService;
	}
	public void setTypeService(String typeService) {
		this.typeService = typeService;
	}
    
    
   
}
