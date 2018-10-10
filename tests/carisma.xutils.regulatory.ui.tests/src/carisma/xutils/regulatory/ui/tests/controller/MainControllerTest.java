package carisma.xutils.regulatory.ui.tests.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.junit.BeforeClass;
import org.junit.Test;
import org.semanticweb.owlapi.model.OWLNamedIndividual;

import carisma.regulatory.ontology.utils.RegulatoryOntologyHelper;
import carisma.xutils.regulatory.ui.controller.MainController;
import carisma.xutils.regulatory.ui.first.ConfigurationView;
import carisma.xutils.regulatory.ui.first.RegulationsView;
import carisma.xutils.regulatory.ui.model.ConstraintModel;
import carisma.xutils.regulatory.ui.model.CreationException;

/**
 * This JUnit test-class tests the MainController class of the regulatory GUI.
 * @author Klaus Rudack
 *
 */
public class MainControllerTest {
	
	/**
	 * display for the gui.
	 */
	private static Display display = null;
	
	/**
	 * shell for the gui.
	 */
	private static Shell shell = null;
	
	/**
	 * path to a correct ontology.
	 * the ontology in this project is resources/model/Ontology.owl
	 */
	private String ontoPath = "resources" + System.getProperty("file.separator")
			+ "model" + System.getProperty("file.separator") + "Ontology.owl"; //"Entire_Law_Ontology.owl";

	
	/**
	 * initializes the display and the shell before class.
	 */
	@BeforeClass
	public static void init() {
		display = new Display();
		shell = new Shell(display);
	}
	
	/**
	 * This test tests the getInstance() method of the MainController class.
	 */
	@Test
	public final void testGetInstance() {
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
	}
	
//	/**
//	 * This test tests the loadOntology() method of the MainController class with invalid input.
//	 */	
//	@Test
//	public final void testLoadOntologyInvalidInput() {
//		RegulationsView regulationsView = new RegulationsView();
//		ConfigurationView cv = new ConfigurationView();
//		MainController mc = MainController.getInstance();
//		assertNotNull(mc);
//		Display display = new Display();
//		final Shell shell = new Shell(display);
//		shell.setSize(300, 300);
//	    shell.setLayout(new RowLayout());
//		Composite composite = new Composite(shell, 0);
//		cv.createPartControl(shell);
//		regulationsView.createPartControl(composite);
//		assertFalse(mc.loadOntology(null));
//		RegulatoryOntologyHelper roh = mc.getROH();
//		assertNull(roh);
//		assertFalse(mc.loadOntology("absurdFileName"));
//		RegulatoryOntologyHelper roh = mc.getROH();
//		assertNull(roh);
//	}
	
	/**
	 * This test tests the loadOntology() method of the MainController class with valid input.
	 */
	@Test
	public final void testLoadOntology() {
		RegulationsView regulationsView = new RegulationsView();
		ConfigurationView cv = new ConfigurationView();
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
		shell.setSize(300, 300);
	    shell.setLayout(new RowLayout());
		Composite composite = new Composite(shell, 0);
		cv.createPartControl(shell);
		regulationsView.createPartControl(composite);
		mc.loadOntology(ontoPath);
		RegulatoryOntologyHelper roh = mc.getROH();
		assertNotNull(roh);
	}


	/**
	 * This test tests the createNewRuleElement() method of the MainController class.
	 */
	@Test
	public final void testCreateNewRuleElement() {
		String ruleElementType = "Role";
		String ruleElementName = "RuleElementName";
		String expectation = ruleElementType + "_" + ruleElementName;
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
		testLoadOntology();
		mc.createNewRuleElement(ruleElementType, ruleElementName);
		List<String> allElements = mc.getRuleElements();
		assertTrue(allElements.contains(expectation));
		System.out.println(allElements);
	}
	
	/**
	 * This test tests the getTextFromIndividual() method of the MainController class.
	 */
	@Test
	public final void testGetTextFromIndividual() {
		String ruleId = "B_3.204";
		String ruleClazz = "BSIElement";
		String expectation = getTextForTest();
		String result = null;
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
		testLoadOntology();
		result = mc.getTextFromIndividual(ruleId, ruleClazz);
		assertEquals(expectation, result);
	}
	
	/**
	 * This test tests the getTextFromIndividual() method of the MainController class with invalid input.
	 */
	@Test
	public final void testGetTextFromIndividualIndalidInput() {
		String validId = "B_3.204";
		String validClass = "BSIElement";
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
		testLoadOntology();
		try {
			mc.getTextFromIndividual(null, validClass);
			fail("Expected NullPointerException for getTextFromIndividual(null, validClass) hasn't been thrown");
		} catch (NullPointerException e) { }
		try {
			mc.getTextFromIndividual(validId, null);
			fail("Expected NullPointerException for getTextFromIndividual(validId, null) hasn't been thrown");
		} catch (NullPointerException e) { }
		try {
			mc.getTextFromIndividual("blablub", validClass);
			fail("Expected NullPointerException for getTextFromIndividual(\"blablub\", validClass) hasn't been thrown");
		} catch (NullPointerException e) { }
		try {
			mc.getTextFromIndividual(validId, "blablub");
			fail("Expected IllegalArgumentException for getTextFromIndividual(validId, \"blablub\") hasn't been thrown");
		} catch (IllegalArgumentException e) { }
	}
	
	/**
	 * This test tests the checkSelectedRuleElements() method of the MainController class.
	 */
	@Test
	public final void testCheckSelectedRuleElements() {
		String firstRuleElement = "Role_Wartungspersonal";
		String secondRuleElement = "Role_Telearbeiter";
		String thirdRuleElement = "Activity_funktionierendes";
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
		testLoadOntology();
		assertFalse(mc.checkSelectedRuleElements(firstRuleElement, secondRuleElement));
		assertTrue(mc.checkSelectedRuleElements(firstRuleElement, thirdRuleElement));
	}
	
//	/**
//	 * This test tests the createNewRelation() and getRuleElementRelations() methods of the MainController class.
//	 */
//	@Test
//	public final void testCreateNewRelation() {
//		String firstIdString = "B_3.204";
//		String firstClassString = "BSIElement";
//		String secondIdString = "M_2.212";
//		String secondClassString = "BSIMeasure";
//		String description = "Example description";
//		OWLNamedIndividual firstRuleElement = null;
//		OWLNamedIndividual secondRuleElement = null;
//		MainController mc = MainController.getInstance();
//		assertNotNull(mc);
//		testLoadOntology();
//		firstRuleElement = mc.getIndividual(firstIdString, firstClassString);
//		assertNotNull(firstRuleElement);
//		secondRuleElement = mc.getIndividual(secondIdString, secondClassString);
//		assertNotNull(secondRuleElement);
//		System.out.println("Erstes: " + firstRuleElement.getIRI().getFragment() + "|| Zweites: " + secondRuleElement.getIRI().getFragment());
//		assertTrue(mc.checkSelectedRuleElements(firstRuleElement.toString(), secondRuleElement.toString()));
//		try {
//			mc.createNewRelation(firstRuleElement, secondRuleElement, description);
//		} catch (CreationException e) {
//			fail("CreationException has been thrown!");
//		}
//		System.out.println(mc.getRuleElementRelations(firstIdString, firstClassString).size());
//	}
	
	/**
	 * This test tests the getConstraints() method of the MainController class.
	 */
	@Test
	public final void testGetConstraints() {
		List<ConstraintModel> results;
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
		testLoadOntology();
		results = mc.getConstraints();
		assertEquals(3, results.size());
//		TODO sinvoller test
	}
	
	/**
	 * This test tests the createSituation() and getSituation() methods of the MainController class.
	 */
	@Test
	public final void testCreateSituation() {
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
//		testLoadOntology();
//		TODO sinvoller test
	}
	
	/**
	 * This test tests the getSubElementsOfRe() method of the MainController class.
	 */
	@Test
	public final void testgetSubElementsOfRe() {
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
//		testLoadOntology();
//		TODO sinvoller test
	}
	
	/**
	 * This test tests the createNewRuleElementInstance() method of the MainController class.
	 */
	@Test
	public final void testcreateNewRuleElementInstance() {
		MainController mc = MainController.getInstance();
		assertNotNull(mc);
//		testLoadOntology();
//		TODO sinvoller test
	}

	
	/**
	 * Method that returns the text that it expected in the testGetTextFromIndividual() method.
	 * @return - the expectation of the testGetTextFromIndividual() method.
	 */
	private String getTextForTest() {
		return "\nB 3.204 Client unter Unix\n"
			+ "Beschreibung\n\n"
			
			+ "Betrachtet wird ein Unix-System, das entweder im Stand-Alone-Betrieb oder als Client in einem Netz genutzt wird. Es k�nnen Terminals, Laufwerke"
			+ ", Drucker und andere Ger�te angeschlossen sein. Weiterhin kann eine graphische Benutzeroberfl�che wie X-Window eingesetzt sein. Entsprechend"
			+ " k�nnen dann auch X-Terminals und graphische Eingabeger�te angeschlossen sein. Bei den weiteren Betrachtungen wird davon ausgegangen, dass ein"
			+ " Unix-System �blicherweise von mehreren Personen benutzt wird.\n\n"
			
			+ "Beispiele f�r klassische Unix-Systeme sind die BSD-Reihe (FreeBSD, OpenBSD und NetBSD), Solaris und AIX. Obwohl Linux kein klassisches, sondern"
			+ " ein funktionelles Unix ist (der Kernel basiert nicht auf dem urspr�nglichen Quelltext, aus dem sich die verschiedenen Unix-Derivate entwickelt"
			+ " haben), wird Linux ebenfalls in diesem Baustein betrachtet.\n"
			+ "Gef�hrdungslage\n\n"
			
			+ "F�r den IT-Grundschutz eines Unix-Systems werden folgende typische Gef�hrdungen angenommen:\n"
			+ "H�here Gewalt\n"
			+ "G 1.1PersonalausfallG 1.2Ausfall von IT-SystemenG 1.8Staub, VerschmutzungOrganisatorische M�ngel\n"
			+ "G 2.7Unerlaubte Aus�bung von RechtenG 2.9Mangelhafte Anpassung an Ver�nderungen beim IT-EinsatzG 2.15Vertraulichkeitsverlust schutzbed�rftiger"
			+ " Daten im Unix-SystemMenschliche Fehlhandlungen\n"
			+ "G 3.2Fahrl�ssige Zerst�rung von Ger�t oder DatenG 3.3Nichtbeachtung von Sicherheitsma�nahmenG 3.6Gef�hrdung durch Reinigungs- oder Fremdpersonal"
			+ "G 3.8Fehlerhafte Nutzung von IT-SystemenG 3.9Fehlerhafte Administration von IT-SystemenTechnisches Versagen\n"
			+ "G 4.8Bekanntwerden von SoftwareschwachstellenG 4.11Fehlende Authentisierungsm�glichkeit zwischen NIS-Server und NIS-ClientG 4.12Fehlende"
			+ " Authentisierungsm�glichkeit zwischen X-Server und X-ClientVors�tzliche Handlungen\n"
			+ "G 5.1Manipulation oder Zerst�rung von Ger�ten oder Zubeh�rG 5.2Manipulation an Informationen oder SoftwareG 5.4DiebstahlG 5.7Abh�ren von"
			+ " LeitungenG 5.8Manipulation an LeitungenG 5.9Unberechtigte IT-NutzungG 5.18Systematisches Ausprobieren von Passw�rternG 5.19Missbrauch von"
			+ " BenutzerrechtenG 5.20Missbrauch von AdministratorrechtenG 5.21Trojanische PferdeG 5.23SchadprogrammeG 5.41Mi�br�uchliche Nutzung eines"
			+ " Unix-Systems mit Hilfe von uucpG 5.89Hijacking von Netz-VerbindungenMa�nahmenempfehlungen\n\n"
			
			+ "Um den betrachteten Informationsverbund abzusichern, m�ssen zus�tzlich zu diesem Baustein noch weitere Bausteine umgesetzt werden, gem�� den"
			+ " Ergebnissen der Modellierung nach IT-Grundschutz.\n\n"
			
			+ "F�r Clients unter Unix sind eine Reihe von Ma�nahmen umzusetzen, beginnend mit der Planung des Einsatzes �ber den Betrieb bis zur"
			+ " Notfallvorsorge. Die Schritte, die dabei durchlaufen werden sollten, sowie die Ma�nahmen, die in den jeweiligen Schritten beachtet werden"
			+ " sollten, sind im folgenden aufgef�hrt.\n"
			+ "Planung und Konzeption\n\n"
			
			+ "Schon vor dem erstmaligen Einsatz eines Unix-Systems, gleichg�ltig ob es als Client, als Terminal- oder Anwendungsserver oder als Einzelplatz-"
			+ "System eingesetzt werden soll, sind eine Reihe von Festlegungen zu treffen, die die Grundlage eines geordneten, sicheren Betriebs bilden. Werden"
			+ " hier Fehler gemacht, so lassen sich diese im Nachhinein oft nur mit sehr hohem Aufwand korrigieren.\n\n"
			
			+ "Es ist ein Verfahren f�r die Vergabe von User-IDs festzulegen, durch das gew�hrleistet wird, dass privilegierte und unprivilegierte"
			+ " Benutzerkennungen klar getrennt sind. Weiterhin ist sicherzustellen, dass kein unkontrollierter Zugang zum Single-User-Modus m�glich ist, da"
			+ " sonst alle f�r die Laufzeit des Systems festgelegten Sicherheitsma�nahmen unterlaufen werden k�nnen.\n"
			+ "Umsetzung\n\n"
			
			+ "Bei der Einrichtung eines Unix-Systems sind eine Reihe von Ma�nahmen (siehe vor allem dazu die Ma�nahme, M 4.105 Erste Ma�nahmen nach einer Unix"
			+ "-Standardinstallation zu treffen, die die Sicherheit dieses Systems \"h�rten\", also L�cken schlie�en, die nach einer Standardinstallation in"
			+ " der Regel vorhanden sind. Dazu geh�rt auch, dass nur die wirklich ben�tigten Netzdienste aktiviert werden (siehe Ma�nahme M 5.72 Deaktivieren"
			+ " nicht ben�tigter Netzdienste ) und dass die Systemprotokollierung aktiviert wird.\n\n"
			
			+ "Ferner sind die Zugriffsrechte auf Benutzer- und Systemdateien und -verzeichnisse so nach einem �bergreifenden Schema zu vergeben, dass nur"
			+ " diejenigen Benutzer und Prozesse Zugriff erhalten, die diesen wirklich ben�tigen, wobei insbesondere auf die durch setuid und setgid bestimmten"
			+ " Rechte zu achten ist (siehe dazu die Ma�nahme M 4.19 Restriktive Attributvergabe bei Unix-Systemdateien und -verzeichnissen ).\n"
			+ "Betrieb\n\n"
			
			+ "Um den �berblick �ber die Sicherheit eines Unix-Systems zu behalten, ist es unabdingbar, die vorhandenen Benutzerprofile und ihre Rechte zeitnah"
			+ " zu dokumentieren, diese Dokumentation immer auf dem aktuellen Stand zu halten und durch regelm��ige �berpr�fungen mit der Realit�t abzugleichen"
			+ ". Die Sicherheit des Systems ist regelm��ig zu �berpr�fen, wobei auch die vom System erzeugten Protokolle auf eventuelle Unregelm��igkeiten hin"
			+ " zu betrachten sind.\n"
			+ "Notfallvorsorge\n\n"
			
			+ "Da Unix-Systeme aufgrund ihrer Komplexit�t nach einem erfolgreichen Angriff oft auf schwer durchschaubare Weise kompromittiert sind, ist es"
			+ " wichtig, schon im Vorfeld Regeln festzulegen, nach denen bei einem echten oder vermuteten Verlust der Systemintegrit�t zu verfahren ist.\n\n"
			
			+ "Nachfolgend wird das Ma�nahmenb�ndel f�r den Bereich \"Client unter Unix\" vorgestellt.\n\n"
			
			+ "F�r eventuell angeschlossene Rechner (z.�B. Clients unter Windows) sind die in den entsprechenden Bausteinen beschriebenen Ma�nahmen zu"
			+ " realisieren.\n\n"
			
			+ "Dar�ber hinaus sind folgende weitere Ma�nahmen umzusetzen:\n"
			+ "Planung und Konzeption\n"
			+ "M 2.33(Z)Aufteilung der Administrationst�tigkeiten unter UnixM 4.13(A)Sorgf�ltige Vergabe von IDsM 4.18(A)Administrative und technische"
			+ " Absicherung des Zugangs zum Monitor- und Single-User-ModusM 5.34(Z)Einsatz von Einmalpassw�rternM 5.64(Z)Secure ShellUmsetzung\n"
			+ "M 2.32(Z)Einrichtung einer eingeschr�nkten BenutzerumgebungM 4.9(A)Einsatz der Sicherheitsmechanismen von X-WindowM 4.14(A)Obligatorischer"
			+ " Passwortschutz unter UnixM 4.16(C)Zugangsbeschr�nkungen f�r Accounts und / oder TerminalsM 4.17(A)Sperren und L�schen nicht ben�tigter"
			+ " Accounts und TerminalsM 4.19(A)Restriktive Attributvergabe bei Unix-Systemdateien und -verzeichnissenM 4.20(B)Restriktive Attributvergabe bei"
			+ " Unix-Benutzerdateien und -verzeichnissenM 4.21(A)Verhinderung des unautorisierten Erlangens von AdministratorrechtenM 4.22(Z)Verhinderung des"
			+ " Vertraulichkeitsverlusts schutzbed�rftiger Daten im Unix-SystemM 4.23(B)Sicherer Aufruf ausf�hrbarer DateienM 4.105(A)Erste Ma�nahmen nach"
			+ " einer Unix-StandardinstallationM 4.106(A)Aktivieren der SystemprotokollierungM 5.17(A)Einsatz der Sicherheitsmechanismen von NFSM 5.18(A)"
			+ "Einsatz der Sicherheitsmechanismen von NISM 5.19(A)Einsatz der Sicherheitsmechanismen von sendmailM 5.20(A)Einsatz der Sicherheitsmechanismen"
			+ " von rlogin, rsh und rcpM 5.21(A)Sicherer Einsatz von telnet, ftp, tftp und rexecM 5.35(A)Einsatz der Sicherheitsmechanismen von UUCPM 5.72(A)"
			+ "Deaktivieren nicht ben�tigter NetzdiensteBetrieb\n"
			+ "M 4.25(A)Einsatz der Protokollierung im Unix-SystemM 4.26(C)Regelm��iger Sicherheitscheck des Unix-SystemsNotfallvorsorge\n"
			+ "M 6.31(A)Verhaltensregeln nach Verlust der Systemintegrit�t\n";
	}
	
}
