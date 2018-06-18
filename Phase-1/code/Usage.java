// This class represents usage data at the sequence or sequence set level.
public class Usage {
	private SequenceSet ss = new SequenceSet();
	private LinkedList <Pair<String,Integer>>l= new LinkedList<Pair<String,Integer>>();;
	// Constructor.
	public Usage(){
		
		
	}
	// Add a kmer with the corresponding number of occurrences.
	public void add(String kmer, int count){
		Pair<String, Integer> p = new Pair<String,Integer>(kmer,count);
		l.insert(p);
		
	}
	// Return the number of occurrences of kmer.
	public int getCount(String kmer){
//		return l.retrieve().second;
		
		
		
		int count = 0;
		
		for (int i = 0; i<ss.getSequences().retrieve().getSeq().length()-2;i++){
			if ( kmer.equals(ss.getSequences().retrieve().getSeq().substring(i, i+kmer.length())) )
				count++;
		}
		return count;
	}
	// Return all kmers with their count.
	public LinkedList<Pair<String, Integer>> getCounts(){
		return l;
	}
}
