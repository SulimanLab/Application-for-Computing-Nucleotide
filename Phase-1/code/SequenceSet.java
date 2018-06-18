import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// This class represents a set of sequences.
public class SequenceSet {
	private Usage u;
	private static LinkedList<Sequence> l = new LinkedList<Sequence>();;
	private static SequenceSet ss = new SequenceSet();
	static Scanner x;

	// Constructor.
	public SequenceSet() {

	}

	// Load sequences from FASTA file.
	public static SequenceSet load(String fileName) throws Exception {

		String firstSeq = "", header = "", gar = "";
		File f = new File(fileName);

		x = new Scanner(new File(fileName));
		try {
			while (true) {
				header = x.nextLine();
				firstSeq = x.nextLine();
				
				SequenceSet.l.insert(new Sequence(header, firstSeq));
			}
		} catch (Exception e) {

		}

		return ss;
	}

	// Return the global usage over all sequences in the set.
	// The word length is k and window step size is w.
	public Usage getUsage(int k, int w) {
		u = new Usage();
		l.findNext();
		System.out.println(l.retrieve().getSeq());
		l.findFirst();
		while (!l.last()) {
			System.out.println(l.retrieve().getSeq());
			for (int i = 0; i < l.retrieve().getSeq().length(); i += w)
				u.add(l.retrieve().getSeq().substring(i, i + k), u.getCount(l.retrieve().getSeq().substring(i, i + k)));
			l.findNext();
		}
		l.findFirst();
		return u;
	}

	// Return all sequences in the set in the same order they appear in the
	// file.
	public LinkedList<Sequence> getSequences() {
		return l;
	}
}
