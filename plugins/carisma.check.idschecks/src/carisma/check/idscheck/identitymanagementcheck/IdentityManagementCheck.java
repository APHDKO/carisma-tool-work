package carisma.check.idscheck.identitymanagementcheck;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime; 
import java.time.format.DateTimeFormatter;  
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Node;
import org.eclipse.uml2.uml.Package;
import carisma.core.analysis.AnalysisHost;
import carisma.core.analysis.DummyHost;
import carisma.core.analysis.result.AnalysisResultMessage;
import carisma.core.analysis.result.StatusType;
import carisma.core.checks.CarismaCheckWithID;
import carisma.core.checks.CheckParameter;
import carisma.profile.umlsec.umlsec4ids.UMLsec;
import carisma.profile.umlsec.umlsec4ids.UMLsecUtil;
import carisma.modeltype.uml2.UMLHelper;


public class IdentityManagementCheck implements CarismaCheckWithID {

	public static final String CHECK_ID = "carisma.check.idscheck.identitymanagementcheck";
	public static final String CHECK_NAME = "UMLsec4ids Identity Management Check";

	/**
	 * the model to check.
	 */
	private Package model = null;
	
	/**
	 * AnalysisHost for report.
	 */
    private AnalysisHost analysisHost;

	public IdentityManagementCheck() {
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public final boolean perform(final Map<String, CheckParameter> parameters, final AnalysisHost newHost) {
	    if (newHost != null) {
	        this.analysisHost = newHost;
	    } else {
	        this.analysisHost = new DummyHost(true);
	    }
		Resource currentModel = this.analysisHost.getAnalyzedModel();
		if (currentModel.getContents().isEmpty()) {
			this.analysisHost.addResultMessage(new AnalysisResultMessage(StatusType.WARNING, "Empty model"));
			this.analysisHost.appendLineToReport("Empty model");
			return false;
		}
		if (currentModel.getContents().get(0) instanceof Package) {
			this.model = (Package) currentModel.getContents().get(0);
			return startCheck();
		}
		this.analysisHost.addResultMessage(new AnalysisResultMessage(StatusType.WARNING, "Content is not a model!"));
		this.analysisHost.appendLineToReport("Content is not a model!");
		return false;
	}	

	
	private boolean startCheck() {
		ArrayList<Node> nodeList = (ArrayList<Node>) UMLHelper.getAllElementsOfType(model, Node.class);
		ArrayList<Element> x509List = (ArrayList<Element>) UMLsecUtil.getStereotypedElements(this.model, UMLsec.X509);
		ArrayList<Element> x509TLSList = (ArrayList<Element>) UMLsecUtil.getStereotypedElements(this.model, UMLsec.X509TLS);
		//-----------------------------------------------------------------
		//PrintsOnly
		System.out.println("-----------x509-----------" + x509List.size());
		System.out.println("-----------x509TLS--------" + x509TLSList.size());
		System.out.println("-----------Node-----------" + nodeList.size());
		ListIterator<Element>
        iterator = x509List.listIterator();
		int elemX509 = 0;

		// Printing the iterated value
		System.out.println("\nUsing ListIterator:\n");
		while (iterator.hasNext()) {
			elemX509 ++;
			System.out.println("Value is : " + iterator.next());
		}
		System.out.println("------------elem:" + elemX509);
		for (int i = 0; i < nodeList.size();i++) 
	      { 		      
	          System.out.println("----------------------" + nodeList.get(i)); 		
	      } 
		//--------------------------------------------------------------------------
		if ((x509List.size() < nodeList.size()) && x509TLSList.size() == nodeList.size()) {
			this.analysisHost.addResultMessage(new AnalysisResultMessage(StatusType.INFO, "Nodes miss the <<X509>> Stereotype"));
			this.analysisHost.appendLineToReport("Nodes miss the <<X509>> Stereotype");
			return false;
		}
		
		if ((x509List.size() == nodeList.size()) && x509TLSList.size() < nodeList.size()) {
			this.analysisHost.addResultMessage(new AnalysisResultMessage(StatusType.INFO, "Nodes miss the <<X509TLS>> Stereotype"));
			this.analysisHost.appendLineToReport("Nodes miss the <<X509TLS>> Stereotype");
			return false;
		}
		
		if ((x509List.size() < nodeList.size()) && x509TLSList.size() < nodeList.size()) {
			this.analysisHost.addResultMessage(new AnalysisResultMessage(StatusType.INFO, "Nodes miss the <<X509TLS>> and <<X509>> Stereotype"));
			this.analysisHost.appendLineToReport("Nodes miss the <<X509TLS>> and <<X509>> Stereotype");
			return false;
		}
		//hier den date vergleich, iterieren über alle zertifikate und vgl date mit date.now
		
		LocalDate today = LocalDate.now();

		String formattedDate = today.format(DateTimeFormatter.ofPattern("yyyyMMdd"));

		System.out.println("formatted day " + formattedDate);
		

		
		int intDay = 0;
        try{
        	intDay = Integer.parseInt(formattedDate);
            System.out.println("number date " + intDay); // output = 25
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
        /*
         
			String str = "1234 56 78";
			int fullInt = Integer.parseInt(str);
			String first4char = str.substring(0,4);
			int intForFirst4Char = Integer.parseInt(first4char);
         */
        boolean dateNotExpired = true;
        int intX509 = 0;
        for(int i = 0; i < nodeList.size(); i++) {
			List<Object> dayX509 = UMLsecUtil.getTaggedValues("expiration_date_yyyy_mm_dd", UMLsec.X509, nodeList.get(i));
				for(int z = 0; z < dayX509.size(); z++) {
					String strX509 = dayX509.get(z).toString();
					if(strX509.length() != 8) {
						 System.out.println("ungültiges datum des X.509 Zertifikates in " + nodeList.get(i).getName());
					 }
					if(strX509.length() == 8) {
						String monthChar = strX509.substring(5, 6);
						String dayChar = strX509.substring(7, 8);
						int intMonthChar = Integer.parseInt(monthChar);
						int intDayChar = Integer.parseInt(dayChar);
						if( (intMonthChar < 1 || intMonthChar > 12) || (intDayChar < 1 || intDayChar > 31) ) {
							 System.out.println("ungültiges datum des X.509 Zertifikates in " + nodeList.get(i).getName());
						}
						if((intMonthChar == 4 || intMonthChar == 6 || intMonthChar == 9 || intMonthChar == 11) && intDayChar > 30) {
							 System.out.println("ungültiges datum des X.509 Zertifikates in " + nodeList.get(i).getName());
						}
						if(intMonthChar == 2 && intDayChar > 29) {
							 System.out.println("ungültiges datum des X.509 Zertifikates in " + nodeList.get(i).getName());
						}
					}
					 try{
				        	intX509 = Integer.parseInt(dayX509.get(z).toString());
				            System.out.println("number date " + intX509); // output = 25
				        }
				        catch (NumberFormatException ex){
				            ex.printStackTrace();
				        }
					 if(intX509 < intDay) {
						 System.out.println("X.509 certificate expired in " + nodeList.get(i).getName());
						 dateNotExpired = false;
					}
				}
		}
        int intX509TLS = 0;
        for(int i = 0; i < nodeList.size(); i++) {
			List<Object> dayX509TLS = UMLsecUtil.getTaggedValues("expiration_date_yyyy_mm_dd", UMLsec.X509TLS, nodeList.get(i));
				for(int z = 0; z < dayX509TLS.size(); z++) {
					String strX509TLS = dayX509TLS.get(z).toString();
					if(strX509TLS.length() != 8) {
						 System.out.println("ungültiges datum des X.509TLS Zertifikates in " + nodeList.get(i).getName());
					 }
					if(strX509TLS.length() == 8) {
						String monthCharTLS = strX509TLS.substring(5, 6);
						String dayCharTLS = strX509TLS.substring(7, 8);
						int intMonthCharTLS = Integer.parseInt(monthCharTLS);
						int intDayCharTLS = Integer.parseInt(dayCharTLS);
						if( (intMonthCharTLS < 1 || intMonthCharTLS > 12) || (intDayCharTLS < 1 || intDayCharTLS > 31) ) {
							 System.out.println("ungültiges datum des X.509TLS Zertifikates in " + nodeList.get(i).getName());
						}
						if((intMonthCharTLS == 4 || intMonthCharTLS == 6 || intMonthCharTLS == 9 || intMonthCharTLS == 11) && intDayCharTLS > 30) {
							 System.out.println("ungültiges datum des X.509TLS Zertifikates in " + nodeList.get(i).getName());
						}
						if(intMonthCharTLS == 2 && intDayCharTLS > 29) {
							 System.out.println("ungültiges datum des X.509TLS Zertifikates in " + nodeList.get(i).getName());
						}
					}
					 try{
				        	intX509TLS = Integer.parseInt(dayX509TLS.get(z).toString());
				            System.out.println("number date " + intX509TLS); // output = 25
				        }
				        catch (NumberFormatException ex){
				            ex.printStackTrace();
				        }
					 if(intX509TLS < intDay) {
						 System.out.println("X.509TLS certificate expired in " + nodeList.get(i).getName());
						 dateNotExpired = false;
					}
				}
		}
        
		return dateNotExpired;
	}
		
	
	@Override
	public String getCheckID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}