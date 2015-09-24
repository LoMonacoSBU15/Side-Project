import java.util.ArrayList;
import java.util.Scanner;

import AminoAcids.*;
//import AminoAcids.Alanine;
//import AminoAcids.AminoAcids;
//import AminoAcids.Arginine;
//import AminoAcids.Asparagine;
//import AminoAcids.AsparticAcid;
//import AminoAcids.Cysteine;
//import AminoAcids.GlutamicAcid;
//import AminoAcids.Glutamine;
//import AminoAcids.Glycine;
//import AminoAcids.Histidine;
//import AminoAcids.Isoleucine;
//import AminoAcids.Leucine;
//import AminoAcids.Lysine;
//import AminoAcids.Methionine;
//import AminoAcids.Phenylalanine;
//import AminoAcids.Proline;
//import AminoAcids.Serine;
//import AminoAcids.Start;
//import AminoAcids.Stop;
//import AminoAcids.Threonine;
//import AminoAcids.Tryptophan;
//import AminoAcids.Tyrosine;
//import AminoAcids.Valine;

/**
 * Handles the heavy lifting of the program as far as converting elements and
 * creating data structures
 * 
 * (IN FUTURE - Make more universal, several methods are very specific when could be universal
 * with small changes with arguments and semantics)
 * 
 * @author Connor LoMonaco
 * @version 4/03/2015
 */
public class Model {

	private static String bases;
	private static ArrayList<AminoAcids> complimentAcids;
	private static ArrayList<AminoAcids> originalAcids;
	private static ArrayList<AminoAcids> compareAcids1;
	private static ArrayList<AminoAcids> compareAcids2;

	/**
	 * Constructor Not really needed, but may be used in future
	 */
	public Model() {
		bases = "";
	}

	/**
	 * Sets the bases for the original DNA strand and gets the Amino Acid
	 * sequence for that strand
	 * 
	 * @param b
	 */
	public void setOriginalStrand(String b) {
		bases = b;
		originalAcids = this.getAcids(bases);
	}

	/**
	 * Gets the original strand in bases
	 * 
	 * @return the strand in bases
	 */
	public String getOriginal() {
		return bases;
	}

	/**
	 * Finds the compliment base pairs for the original strand
	 * 
	 * IN FUTURE MAKE THIS MORE UNIVERSAL (I.E. SEND IN ORIGINAL STRAND) ...but
	 * fine for now
	 * 
	 * @return the string of complimentary bases
	 */
	public static String makeComplimentaryStrand() {
		String compliments = "";
		for (int i = 0; i < bases.length(); i++) {
			compliments += (convertBase(bases.charAt(i)));
		}
		complimentAcids = getAcids(compliments);
		return compliments;
	}

	/**
	 * gets attributes of original strand
	 * 
	 * @return the string of Attributes in visually pleasing manner
	 */
	public static String getAttributes() {
		String attributes = "";
		for (int i = 0; i < originalAcids.size(); i++) {
			attributes += (originalAcids.get(i).getAttribute() + "-");
		}
		return attributes;
	}

	/**
	 * gets attributes of compliment strand
	 * 
	 * @return string of attributes in visually pleasing manner
	 */
	public static String getComplimentAttributes() {
		String complimentAttributes = "";
		for (int i = 0; i < complimentAcids.size(); i++) {
			complimentAttributes += (complimentAcids.get(i).getAttribute() + "-");
		}
		return complimentAttributes;
	}

	/**
	 * Finds the base pair of argument base
	 * 
	 * @param c
	 *            the char to find compliment
	 * @return the compliment base as string
	 */
	public static String convertBase(char c) {
		if ('C' == c) {
			return "G";
		} else if ('G' == c) {
			return "C";
		} else if ('A' == c) {
			return "T";
		} else if ('T' == c) {
			return "A";
		} else {
			return " ";
		}
	}

	/**
	 * gets the amino acid abbreviation of the original strand
	 * 
	 * @return the abbreviations in a string
	 */
	public static String getAbbreviations() {
		String originalAbbreviations = "";
		for (int i = 0; i < originalAcids.size(); i++) {
			originalAbbreviations += (originalAcids.get(i).getAbbreviation() + "-");
		}
		return originalAbbreviations;
	}

	/**
	 * gets the amino acid abbreviations of the compliment strand
	 * 
	 * @return string of abbreviations
	 */
	public static String getComplimentAbbreviations() {
		String complimentAbbreviations = "";
		for (int i = 0; i < complimentAcids.size(); i++) {
			complimentAbbreviations += (complimentAcids.get(i)
					.getAbbreviation() + "-");
		}
		return complimentAbbreviations;
	}

	/**
	 * Gets the abbreviation of the amino acids for the 1st strand in the
	 * comparison
	 * 
	 * @return the amino acid abbreviations
	 */
	public static ArrayList<String> getCompare1() {

		ArrayList<String> toStringAbbrAcids = new ArrayList<String>();
		for (int i = 0; i < compareAcids1.size(); i++) {
			toStringAbbrAcids.add(compareAcids1.get(i).getAbbreviation());
		}
		return toStringAbbrAcids;
	}

	/**
	 * Gets the abbreviation of the amino acids for the 1st strand in the
	 * comparison
	 * 
	 * @return the amino acid abbreviations
	 */
	public static ArrayList<String> getCompare2() {
		ArrayList<String> toStringAbbrAcids = new ArrayList<String>();
		for (int i = 0; i < compareAcids2.size(); i++) {
			toStringAbbrAcids.add(compareAcids2.get(i).getAbbreviation());
		}
		return toStringAbbrAcids;
	}

	/**
	 * Compares the attributes of 2 dna base strands for differences in AA
	 * polarity
	 * 
	 * @param strand1
	 *            first strand
	 * @param strand2
	 *            second strand
	 * @return amino acid position where they are differences in polarity
	 */
	public static ArrayList<Integer> compareAttributes(String strand1,
			String strand2) {

		ArrayList<Integer> spots = new ArrayList<Integer>();
		int acid1Size = compareAcids1.size();
		int acid2Size = compareAcids2.size();

		if (acid1Size <= acid2Size) {
			for (int i = 0; i < acid1Size; i++) {
				if (!(compareAcids1.get(i).getAttribute().equals(compareAcids2
						.get(i).getAttribute()))) {
					spots.add(i + 1);
				}
			}
		} else {
			for (int i = 0; i < acid2Size; i++) {
				if (!(compareAcids1.get(i).getAttribute().equals(compareAcids2
						.get(i).getAttribute()))) {
					spots.add(i + 1);
				}
			}
		}
		return spots;
	}

	/**
	 * Compares the attributes of 2 dna base strands for differences in Amino
	 * Acids
	 * 
	 * @param strand1
	 *            first strand
	 * @param strand2
	 *            second strand
	 * @return amino acid position where the strands are differences in AA
	 */
	public static ArrayList<Integer> compareAcids(String strand1, String strand2) {
	//	System.out.println("hur" + strand1 + "     " + strand2);
		compareAcids1 = new ArrayList<AminoAcids>();
		compareAcids2 = new ArrayList<AminoAcids>();
		ArrayList<Integer> spots = new ArrayList<Integer>();
		int differences = 0;
		compareAcids1 = getAcids(strand1);
		compareAcids2 = getAcids(strand2);
		int acid1Size = compareAcids1.size();
		int acid2Size = compareAcids2.size();
	//	System.out.println("1: " + compareAcids1);
	//	System.out.println("2: " + compareAcids2);

		if (acid1Size <= acid2Size) {
			for (int i = 0; i < acid1Size; i++) {
			//	System.out.println("one");
				if (!(compareAcids1.get(i).getAbbreviation()
						.equals(compareAcids2.get(i).getAbbreviation()))) {
					spots.add(i + 1);
				}
			}
		} else {
			for (int i = 0; i < acid2Size; i++) {
			//	System.out.println("two");
				if (!(compareAcids1.get(i).getAbbreviation()
						.equals(compareAcids2.get(i).getAbbreviation()))) {
					spots.add(i + 1);
				}
			}
		}
	//	System.out.println(compareAcids1);
		return spots;
	}

	/**
	 * Meat and potatoes method Takes string of base pairs and find the amino
	 * acid conversion of the 3 base codons
	 * 
	 * @param strand
	 *            the bases to be converted
	 * @return an arraylist of Amino Acid objects which correspond to the codons
	 *         inputed
	 */
	public static ArrayList<AminoAcids> getAcids(String strand) {

		Leucine leucy = new Leucine();
		Lysine lys = new Lysine();
		Isoleucine iso = new Isoleucine();
		Alanine ally = new Alanine();
		Arginine argy = new Arginine();
		Asparagine aspy = new Asparagine();
		AsparticAcid aspAcid = new AsparticAcid();
		Cysteine cys = new Cysteine();
		GlutamicAcid gutAcid = new GlutamicAcid();
		Glutamine glut = new Glutamine();
		Glycine glyc = new Glycine();
		Histidine histy = new Histidine();
		Methionine meth = new Methionine();
		Phenylalanine phenyl = new Phenylalanine();
		Proline pro = new Proline();
		Serine ser = new Serine();
		Stop sto = new Stop();
		Threonine thre = new Threonine();
		Tryptophan trypt = new Tryptophan();
		Tyrosine tyr = new Tyrosine();
		Valine val = new Valine();
		Start star = new Start();

		ArrayList<AminoAcids> acids = new ArrayList<AminoAcids>();
		String codon = "";
		boolean isStart = true;
		for (int i = 0; i < strand.length(); i += 3) {
			if (i + 3 <= strand.length()) {
				codon = strand.substring(i, i + 3);

				if (codon.equals("ATG") && isStart) {
					isStart = false;
					acids.add(star);
				} else if (codon.equals("TTT") || codon.equals("TTC")) {

					acids.add(phenyl);
				} else if (codon.equals("TTA") || codon.equals("TTG")
						|| codon.equals("CTT") || codon.equals("CTC")
						|| codon.equals("CTA") || codon.equals("CTG")) {
					acids.add(leucy);
				} else if (codon.equals("ATT") || codon.equals("ATC")
						|| codon.equals("ATA")) {
					acids.add(iso);
				} else if (codon.equals("ATG")) {
					acids.add(meth);
				} else if (codon.equals("GTT") || codon.equals("GTC")
						|| codon.equals("GTA") || codon.equals("GTG")) {
					acids.add(val);
				} else if (codon.equals("TCT") || codon.equals("TCC")
						|| codon.equals("TCA") || codon.equals("TCG")
						|| codon.equals("AGT") || codon.equals("AGC")) {
					acids.add(ser);
				} else if (codon.equals("CCT") || codon.equals("CCC")
						|| codon.equals("CCA") || codon.equals("CCG")) {
					acids.add(pro);
				} else if (codon.equals("ACT") || codon.equals("ACC")
						|| codon.equals("ACA") || codon.equals("ACG")) {
					acids.add(thre);
				} else if (codon.equals("GCT") || codon.equals("GCC")
						|| codon.equals("GCA") || codon.equals("GCG")) {
					acids.add(ally);
				} else if (codon.equals("TAT") || codon.equals("TAC")) {
					acids.add(tyr);
				} else if (codon.equals("TAA") || codon.equals("TAG")
						|| codon.equals("TGA")) {
					acids.add(sto);
				} else if (codon.equals("CAT") || codon.equals("CAC")) {
					acids.add(histy);
				} else if (codon.equals("CAA") || codon.equals("CAG")) {
					acids.add(glut);
				} else if (codon.equals("AAT") || codon.equals("AAC")) {
					acids.add(aspy);
				} else if (codon.equals("AAA") || codon.equals("AAG")) {
					acids.add(lys);
				} else if (codon.equals("GAT") || codon.equals("GAC")) {
					acids.add(aspAcid);
				} else if (codon.equals("GAA") || codon.equals("GAG")) {
					acids.add(gutAcid);
				} else if (codon.equals("TGT") || codon.equals("TGC")) {
					acids.add(cys);
				} else if (codon.equals("TGG")) {
					acids.add(trypt);
				} else if (codon.equals("AGA") || codon.equals("AGG")
						|| codon.equals("CGA") || codon.equals("CGG")
						|| codon.equals("CGT") || codon.equals("CGC")) {
					acids.add(argy);
				} else if (codon.equals("GGT") || codon.equals("GGC")
						|| codon.equals("GGA") || codon.equals("GGG")) {
					acids.add(glyc);
				}
			}
		}
		return acids;
	}
}
