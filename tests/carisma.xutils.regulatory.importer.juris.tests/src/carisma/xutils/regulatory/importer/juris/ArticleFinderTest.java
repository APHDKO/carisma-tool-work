package carisma.xutils.regulatory.importer.juris;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class ArticleFinderTest {

	@Test
	public void testRegexParagraph() {
		Pattern p = Pattern.compile(ArticleFinder.PARAGRAHP);
		Matcher m = p.matcher("Absatz 24");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Absatz 24", m.group());
			}
		}
		m = p.matcher("Absatz 2222");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Absatz 2222", m.group());
			}
		}
		m = p.matcher("Abs 2222");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Abs 2222", m.group());
			}
		}
		m = p.matcher("Abs. 2222");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Abs. 2222", m.group());
			}
		}
	}
	
	@Test
	public void testRegexSentenceNumber() {
		Pattern p = Pattern.compile(ArticleFinder.SENTENCENUMBER);
		Matcher m = p.matcher("Nr. 4");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Nr. 4", m.group());
			}
		}
		m = p.matcher("Nummer 172");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Nummer 172", m.group());
			}
		}
		m = p.matcher("Nr 777");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Nr 777", m.group());
			}
		}
	}
	
	@Test
	public void testRegexLaw() {
		Pattern p = Pattern.compile(ArticleFinder.LAW);
		Matcher m = p.matcher("Ordnung ");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Ordnung ", m.group());
			}
		}
		m = p.matcher("gesetzes");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("gesetzes", m.group());
			}
		}
		m = p.matcher("Gesetz");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Gesetz", m.group());
			}
		}
		m = p.matcher("ordnung ");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("ordnung ", m.group());
			}
		}
		m = p.matcher("Artikel");
		while(m.find()) { 
			if (!m.group().equals("")) {
				assertEquals("Artikel", m.group());
			}
		}
	}
	
	@Test
	public void textGetLawCrossConnections() {
		String law1 =  	"(1) Die Vorschriften dieses Abschnittes gelten f�r �ffentliche Stellen des Bundes, soweit sie nicht als �ffentlich-rechtliche Unternehmen am Wettbewerb teilnehmen."
						+ "(2) Soweit der Datenschutz nicht durch Landesgesetz geregelt ist, gelten die �� 12 bis 16, 19 bis 20 auch f�r die �ffentlichen Stellen der L�nder, soweit sie"
						+ "1. Bundesrecht ausf�hren und nicht als �ffentlich-rechtliche Unternehmen am Wettbewerb teilnehmen oder"
						+ "2. als Organe der Rechtspflege t�tig werden und es sich nicht um Verwaltungsangelegenheiten handelt."
						+ "(3) F�r Landesbeauftragte f�r den Datenschutz gilt � 23 Abs. 4 entsprechend."
						+ "(4) Werden personenbezogene Daten f�r fr�here, bestehende oder zuk�nftige Besch�ftigungsverh�ltnisse erhoben, verarbeitet oder genutzt, gelten � 28 Absatz 2 Nummer 2 und die �� 32 bis 35 anstelle der �� 13 bis 16 und 19 bis 20.";
		ArticleFinder finder = new ArticleFinder();
			// only 13 because the text contains duplicated entries
		assertEquals(13, finder.getLawCrossConnections(law1).size());
		String law2 = 	"(1) Die Aufsichtsbeh�rde kontrolliert die Ausf�hrung dieses Gesetzes sowie anderer Vorschriften �ber den Datenschutz, soweit diese die automatisierte Verarbeitung personenbezogener Daten oder die Verarbeitung oder Nutzung personenbezogener Daten in oder aus nicht automatisierten Dateien regeln einschlie�lich des Rechts der Mitgliedstaaten in den F�llen des � 1 Abs. 5. Sie ber�t und unterst�tzt die Beauftragten f�r den Datenschutz und die verantwortlichen Stellen mit R�cksicht auf deren typische Bed�rfnisse. Die Aufsichtsbeh�rde darf die von ihr gespeicherten Daten nur f�r Zwecke der Aufsicht verarbeiten und nutzen; � 14 Abs. 2 Nr. 1 bis 3, 6 und 7 gilt entsprechend. Insbesondere darf die Aufsichtsbeh�rde zum Zweck der Aufsicht Daten an andere Aufsichtsbeh�rden �bermitteln. Sie leistet den Aufsichtsbeh�rden anderer Mitgliedstaaten der Europ�ischen Union auf Ersuchen erg�nzende Hilfe (Amtshilfe). Stellt die Aufsichtsbeh�rde einen Versto� gegen dieses Gesetz oder andere Vorschriften �ber den Datenschutz fest, so ist sie befugt, die Betroffenen hier�ber zu unterrichten, den Versto� bei den f�r die Verfolgung oder Ahndung zust�ndigen Stellen anzuzeigen sowie bei schwerwiegenden Verst��en die Gewerbeaufsichtsbeh�rde zur Durchf�hrung gewerberechtlicher Ma�nahmen zu unterrichten. Sie ver�ffentlicht regelm��ig, sp�testens alle zwei Jahre, einen T�tigkeitsbericht. � 21 Satz 1 und � 23 Abs. 5 Satz 4 bis 7 gelten entsprechend."
						+ "(2) Die Aufsichtsbeh�rde f�hrt ein Register der nach � 4d meldepflichtigen automatisierten Verarbeitungen mit den Angaben nach � 4e Satz 1. Das Register kann von jedem eingesehen werden. Das Einsichtsrecht erstreckt sich nicht auf die Angaben nach � 4e Satz 1 Nr. 9 sowie auf die Angabe der zugriffsberechtigten Personen."
						+ "(3) Die der Kontrolle unterliegenden Stellen sowie die mit deren Leitung beauftragten Personen haben der Aufsichtsbeh�rde auf Verlangen die f�r die Erf�llung ihrer Aufgaben erforderlichen Ausk�nfte unverz�glich zu erteilen. Der Auskunftspflichtige kann die Auskunft auf solche Fragen verweigern, deren Beantwortung ihn selbst oder einen der in � 383 Abs. 1 Nr. 1 bis 3 der Zivilprozessordnung bezeichneten Angeh�rigen der Gefahr strafgerichtlicher Verfolgung oder eines Verfahrens nach dem Gesetz �ber Ordnungswidrigkeiten aussetzen w�rde. Der Auskunftspflichtige ist darauf hinzuweisen."
						+ "(4) Die von der Aufsichtsbeh�rde mit der Kontrolle beauftragten Personen sind befugt, soweit es zur Erf�llung der der Aufsichtsbeh�rde �bertragenen Aufgaben erforderlich ist, w�hrend der Betriebs- und Gesch�ftszeiten Grundst�cke und Gesch�ftsr�ume der Stelle zu betreten und dort Pr�fungen und Besichtigungen vorzunehmen. Sie k�nnen gesch�ftliche Unterlagen, insbesondere die �bersicht nach � 4g Abs. 2 Satz 1 sowie die gespeicherten personenbezogenen Daten und die Datenverarbeitungsprogramme, einsehen. � 24 Abs. 6 gilt entsprechend. Der Auskunftspflichtige hat diese Ma�nahmen zu dulden."
						+ "(5) Zur Gew�hrleistung der Einhaltung dieses Gesetzes und anderer Vorschriften �ber den Datenschutz kann die Aufsichtsbeh�rde Ma�nahmen zur Beseitigung festgestellter Verst��e bei der Erhebung, Verarbeitung oder Nutzung personenbezogener Daten oder technischer oder organisatorischer M�ngel anordnen. Bei schwerwiegenden Verst��en oder M�ngeln, insbesondere solchen, die mit einer besonderen Gef�hrdung des Pers�nlichkeitsrechts verbunden sind, kann sie die Erhebung, Verarbeitung oder Nutzung oder den Einsatz einzelner Verfahren untersagen, wenn die Verst��e oder M�ngel entgegen der Anordnung nach Satz 1 und trotz der Verh�ngung eines Zwangsgeldes nicht in angemessener Zeit beseitigt werden. Sie kann die Abberufung des Beauftragten f�r den Datenschutz verlangen, wenn er die zur Erf�llung seiner Aufgaben erforderliche Fachkunde und Zuverl�ssigkeit nicht besitzt."
						+ "(6) Die Landesregierungen oder die von ihnen erm�chtigten Stellen bestimmen die f�r die Kontrolle der Durchf�hrung des Datenschutzes im Anwendungsbereich dieses Abschnittes zust�ndigen Aufsichtsbeh�rden."
						+ "(7) Die Anwendung der Gewerbeordnung auf die den Vorschriften dieses Abschnittes unterliegenden Gewerbebetriebe bleibt unber�hrt.";
//		for(LawCrossConnection lcc : finder.getLawCrossConnections(law2)) {
//			lcc.printLawCrossConnection();
//		}
			// only 9 because the sentences have been ignored
		assertEquals(9, finder.getLawCrossConnections(law2).size());
		
	}
}
